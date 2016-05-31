/**
 * Copyright (C) 2014 manhattan.org. All rights reserved.
 *
 * @author Fernando Cejas (the manhattan coder)
 */
package es.raul.app.presentation.ui.base;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import es.raul.app.presentation.AndroidApplication;
import es.raul.app.presentation.R;
import es.raul.app.presentation.internal.di.ComponentReflectionInjector;
import es.raul.app.presentation.internal.di.components.DaggerFragmentComponent;
import es.raul.app.presentation.internal.di.components.FragmentComponent;
import es.raul.app.presentation.internal.di.modules.FragmentModule;
import icepick.Icepick;
import java.util.List;

/**
 * Base {@link Fragment} class for every fragment in this application.
 */
public abstract class BaseFragment extends Fragment implements BaseView {

    public static final String TAG = BaseFragment.class.getSimpleName();

    protected boolean isTablet;

    @Nullable
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isTablet = getResources().getBoolean(R.bool.isTablet);
        FragmentComponent component = DaggerFragmentComponent.builder()
                .applicationComponent(((AndroidApplication) getActivity().getApplication()).getComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
        ComponentReflectionInjector<FragmentComponent> injector =
                new ComponentReflectionInjector<>(FragmentComponent.class, component);
        injector.inject(this);
        Icepick.restoreInstanceState(this, savedInstanceState);
        if (getPresenter() != null) {
            getPresenter().onCreate(savedInstanceState);
            Icepick.restoreInstanceState(getPresenter(), savedInstanceState);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getPresenter() != null) {
            getPresenter().onResume();
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        bindToolbar();
        if (getPresenter() != null) {
            getPresenter().setView(this);
            getPresenter().onViewCreated(savedInstanceState);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
        if (getPresenter() != null) {
            Icepick.saveInstanceState(getPresenter(), outState);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (getPresenter() != null) {
            getPresenter().onPause();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (getPresenter() != null) {
            getPresenter().setView(null);
        }
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (getPresenter() != null) {
            getPresenter().onDestroy();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (getPresenter() != null) {
            getPresenter().onActivityResult(requestCode, resultCode, data);
        }
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null) {
                    fragment.onActivityResult(requestCode, resultCode, data);
                }
            }
        }
    }

    private void bindToolbar() {
        if (toolbar != null) {
            toolbar.setTitle("");
            ((BaseActivity) getActivity()).setSupportActionBar(toolbar);
            setupToolbar(toolbar);
        }
    }

    protected void changeColorBackButton(int colorId) {
        try {
            Drawable upArrow = ContextCompat.getDrawable(getContext(), R.drawable.abc_ic_ab_back_mtrl_am_alpha);
            upArrow.setColorFilter(ContextCompat.getColor(getContext(), colorId), PorterDuff.Mode.SRC_ATOP);
            ((BaseActivity) getActivity()).getSupportActionBar().setHomeAsUpIndicator(upArrow);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Nullable
    protected abstract BasePresenter getPresenter();

    protected void setupToolbar(Toolbar toolbar) {
    }
}