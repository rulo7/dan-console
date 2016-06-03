package es.raul.app.presentation.ui.example.views;

import android.support.annotation.Nullable;
import es.raul.app.domain.exception.ErrorBundle;
import es.raul.app.domain.model.Example;
import es.raul.app.presentation.ui.base.BaseFragment;
import es.raul.app.presentation.ui.base.BasePresenter;
import es.raul.app.presentation.ui.example.presenters.ExamplePresenter;
import java.util.ArrayList;
import javax.inject.Inject;

/**
 * Created by raulcobos on 31/5/16.
 */
public class ExampleFragment extends BaseFragment implements ExampleView {

    @Inject
    ExamplePresenter testPresenter;

    @Nullable
    @Override
    protected BasePresenter getPresenter() {
        return testPresenter;
    }

    @Override
    public void showError(ErrorBundle errorBundle) {
        // show an error information
    }

    @Override
    public void hideEmpty() {
        // hide the empty placeholder
    }

    @Override
    public void showLoading() {
        // show the normal loading progress
    }

    @Override
    public void hideLoading() {
        // hide the normal loading progress
    }

    @Override
    public void showEmpty() {
        // show the empty placeholder
    }

    @Override
    public void hideLoadMore() {
        // hide the loading progress in the bottom of the list
    }

    @Override
    public void showModels(ArrayList<Example> examples) {
        // show the examples in the list
    }

    @Override
    public void showDetail(Example example) {
        // call to navigator and show the example
    }

    @Override
    public void showLoadMore() {
        // show the loading progress in the bottom of the list
    }
}
