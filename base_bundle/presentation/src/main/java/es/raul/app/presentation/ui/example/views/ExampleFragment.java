package es.raul.app.presentation.ui.example.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.OnClick;
import es.raul.app.domain.exception.ErrorBundle;
import es.raul.app.presentation.R;
import es.raul.app.presentation.ui.base.BaseFragment;
import es.raul.app.presentation.ui.base.BasePresenter;
import es.raul.app.presentation.ui.example.presenters.ExamplePresenter;
import javax.inject.Inject;

/**
 * Created by raulcobos on 31/5/16.
 */
public class ExampleFragment extends BaseFragment implements ExampleView {

    @Inject
    ExamplePresenter testPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }


    @Nullable
    @Override
    protected BasePresenter getPresenter() {
        return testPresenter;
    }

    @Override
    public void showError(ErrorBundle errorBundle) {
    }

    @OnClick(R.id.start_async)
    void onLoadAsync() {
        testPresenter.load();
    }


    @OnClick(R.id.load_more_async)
    void onLoadMoreAsync() {
        testPresenter.loadMore();
    }

    @Override
    public void showModels() {
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

    @Override
    public void hideLoadMore() {
    }

    @Override
    public void showLoadMore() {
    }
}
