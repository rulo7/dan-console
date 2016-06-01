package _app_package_name_.presentation.ui._uiNamePackage_.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import _app_package_name_.domain.exception.ErrorBundle;
import _app_package_name_.presentation.ui.base.BaseFragment;
import _app_package_name_.presentation.ui.base.BasePresenter;
import _app_package_name_.presentation.ui._uiNamePackage_.presenters._ViewName_Presenter;
import javax.inject.Inject;

public class _ViewName_Fragment extends BaseFragment implements _ViewName_View {

    @Inject
    _ViewName_Presenter _viewName_Presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        //see ExampleFragment
        return null;
    }


    @Nullable
    @Override
    protected BasePresenter getPresenter() {
        return _viewName_Presenter;
    }

    @Override
    public void showError(ErrorBundle errorBundle) {
    }

    @Override
    public void hideEmpty() {
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void showEmpty() {
    }
}