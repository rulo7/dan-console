package es.raul.app.presentation.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import es.raul.app.presentation.AndroidApplication;
import es.raul.app.presentation.internal.di.ComponentReflectionInjector;
import es.raul.app.presentation.internal.di.modules.FragmentModule;
import es.raul.app.presentation.ui.Presenter;
import es.raul.app.presentation.internal.di.components.DaggerFragmentComponent;
import es.raul.app.presentation.internal.di.components.FragmentComponent;
import icepick.Icepick;

public abstract class BaseDialogFragment extends DialogFragment {

    @Inject
    protected AndroidApplication androidApplication;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentComponent component = DaggerFragmentComponent.builder()
                .applicationComponent(((AndroidApplication) getActivity().getApplication()).getComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
        ComponentReflectionInjector<FragmentComponent> injector =
                new ComponentReflectionInjector<>(FragmentComponent.class, component);
        injector.inject(this);
        setupComponent();
        Icepick.restoreInstanceState(this, savedInstanceState);
        if (getPresenter() != null) {
            Icepick.restoreInstanceState(getPresenter(), savedInstanceState);
            getPresenter().onCreate(savedInstanceState);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getPresenter() != null) {
            getPresenter().onResume();
        }
        if (getDialog() != null) {
            setDialogSize();
        }
    }

    protected void setDialogSize() {
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
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
        ButterKnife.unbind(this);
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

    @Nullable
    protected abstract Presenter getPresenter();

    protected void setupComponent() {
    }
}