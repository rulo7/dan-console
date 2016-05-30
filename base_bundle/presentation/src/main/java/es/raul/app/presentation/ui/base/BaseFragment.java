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
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import es.raul.app.presentation.AndroidApplication;
import es.raul.app.presentation.R;
import es.raul.app.presentation.internal.di.ComponentReflectionInjector;
import es.raul.app.presentation.internal.di.components.DaggerFragmentComponent;
import es.raul.app.presentation.internal.di.components.FragmentComponent;
import es.raul.app.presentation.internal.di.modules.FragmentModule;
import es.raul.app.presentation.ui.LoadDataView;
import es.raul.app.presentation.ui.Presenter;
import icepick.Icepick;
import java.util.List;

/**
 * Base {@link Fragment} class for every fragment in this application.
 */
public abstract class BaseFragment extends Fragment implements LoadDataView {

    public static final String TAG = BaseFragment.class.getSimpleName();

    protected boolean isTablet;

    @Nullable
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    @Nullable
    @BindView(R.id.progress)
    protected RelativeLayout progress;
    @Nullable
    @BindView(R.id.empty)
    protected RelativeLayout empty;
    protected Snackbar snackbarRetry;
    protected Snackbar snackbarUpdatedNotification;
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
        setupView();
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
        setupUi();
        if (savedInstanceState == null) {
            init();
            if (getPresenter() != null) {
                getPresenter().onInit();
            }
        } else {
            afterConfigChange();
        }
        if (getPresenter() != null) {
            getPresenter().onInit();
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
            getPresenter().onDestroy();
        }
        if (unbinder != null) {
            unbinder.unbind();   
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

    protected void bindToolbar() {
        if (toolbar != null) {
            toolbar.setTitle("");
            ((BaseActivity) getActivity()).setSupportActionBar(toolbar);
            setToolbar(toolbar);
        }
    }

    protected void showToastMessage(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    protected void showSnackMessage(String message) {
        try {
            Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
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
    protected abstract Presenter getPresenter();

    protected void setToolbar(Toolbar toolbar) {
    }

    protected void setupView() {
    }

    protected void init() {
    }

    protected void setupUi() {
    }

    protected void afterConfigChange() {
    }

    public String getFragmentTitle() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void showLoading() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void showRetry(String msg) {
        snackbarRetry = Snackbar.make(getView(), msg, Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.retry).toUpperCase(), view -> {
                    if (getPresenter() != null) {
                        getPresenter().retry();
                    }
                });
        snackbarRetry.setDuration(Snackbar.LENGTH_LONG);
        snackbarRetry.show();
    }

    @Override
    public void hideRetry() {
        if (snackbarRetry != null && snackbarRetry.isShown()) {
            snackbarRetry.dismiss();
        }
    }

    @Override
    public void showUpdatedNotification() {
        snackbarUpdatedNotification = Snackbar.make(getView(), R.string.updated_notification, Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.hide).toUpperCase(), view -> hideUdpatedNotification());
        snackbarUpdatedNotification.setDuration(Snackbar.LENGTH_LONG);
        snackbarUpdatedNotification.show();
    }

    @Override
    public void hideUdpatedNotification() {
        if (snackbarUpdatedNotification != null && snackbarUpdatedNotification.isShown()) {
            snackbarUpdatedNotification.dismiss();
        }
    }

    @Override
    public void showEmptyList() {
        empty.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyList() {
        empty.setVisibility(View.GONE);
    }
}