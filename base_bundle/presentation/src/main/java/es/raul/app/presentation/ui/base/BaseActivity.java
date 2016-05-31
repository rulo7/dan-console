package es.raul.app.presentation.ui.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import es.raul.app.presentation.AndroidApplication;
import es.raul.app.presentation.R;
import es.raul.app.presentation.internal.di.ComponentReflectionInjector;
import es.raul.app.presentation.internal.di.components.ActivityComponent;
import es.raul.app.presentation.internal.di.components.DaggerActivityComponent;
import es.raul.app.presentation.internal.di.modules.ActivityModule;
import es.raul.app.presentation.navigation.Navigator;
import icepick.Icepick;
import icepick.State;
import java.util.List;
import javax.inject.Inject;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Base {@link AppCompatActivity} class for every Activity in this application.
 */
public abstract class BaseActivity extends AppCompatActivity {

    public static final String TAG = BaseActivity.class.getSimpleName();

    @Nullable
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    @Inject
    protected Navigator navigator;
    @Inject
    protected AndroidApplication androidApplication;
    protected boolean isTablet;
    @State
    Intent resultIntent;
    @State
    int resultCode = Activity.RESULT_CANCELED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isTablet = getResources().getBoolean(R.bool.is_tablet);
        ActivityComponent component = DaggerActivityComponent.builder()
                .applicationComponent(((AndroidApplication) getApplication()).getComponent())
                .activityModule(new ActivityModule(this))
                .build();
        ComponentReflectionInjector<ActivityComponent> injector =
                new ComponentReflectionInjector<>(ActivityComponent.class, component);
        injector.inject(this);
        Icepick.restoreInstanceState(this, savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (resultCode != Activity.RESULT_CANCELED) {
            if (resultIntent != null) {
                setResultCode(resultCode, resultIntent);
            } else {
                setResultCode(resultCode);
            }
        }
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
        resultIntent = null;
        setResult(resultCode);
    }

    public void setResultCode(int resultCode, Intent resultIntent) {
        this.resultCode = resultCode;
        this.resultIntent = resultIntent;
        setResult(resultCode, resultIntent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
            getSupportFragmentManager().popBackStack();
        } else if (NavUtils.getParentActivityIntent(this) != null && isTaskRoot()) {
            Intent upIntent = NavUtils.getParentActivityIntent(this);
            if (supportShouldUpRecreateTask(upIntent)) {
                TaskStackBuilder.create(this).addNextIntentWithParentStack(upIntent).startActivities();
            } else {
                NavUtils.navigateUpTo(this, upIntent);
            }
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null) {
                    fragment.onActivityResult(requestCode, resultCode, data);
                }
            }
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    protected void replaceFragment(int containerViewId, Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment, fragment.getClass().getSimpleName());
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    protected void changeColorBackButton(int colorId) {
        try {
            Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_mtrl_am_alpha);
            upArrow.setColorFilter(ContextCompat.getColor(this, colorId), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(upArrow);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setStatusBarColor(int colorId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, colorId));
        }
    }
}