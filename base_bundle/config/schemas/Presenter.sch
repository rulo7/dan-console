package _app_package_name_.presentation.ui._uiNamePackage_.presenters;

import _app_package_name_.presentation.internal.di.scope.PerFragment;
import _app_package_name_.presentation.ui.base.BasePresenter;
import _app_package_name_.presentation.ui._uiNamePackage_.views._ViewName_View;
import javax.inject.Inject;

@PerFragment
public class _ViewName_Presenter extends BasePresenter<_ViewName_View> {
    @Inject
    public _ViewName_Presenter() {
        // see examplePresenter
    }
}

