package es.raul.app.presentation.ui.example.presenters;

import android.os.Bundle;
import android.os.Handler;
import es.raul.app.presentation.internal.di.scope.PerFragment;
import es.raul.app.presentation.ui.base.BasePresenter;
import es.raul.app.presentation.ui.example.views.ExampleView;
import icepick.State;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by raulcobos on 31/5/16.
 */
@PerFragment
public class ExamplePresenter extends BasePresenter<ExampleView> {

    enum RequestType {INIT, LOAD_MORE, NONE}

    @State
    ArrayList<? extends Serializable> models = new ArrayList<>();
    @State
    int currentPage;
    @State
    RequestType requestType;

    Handler handler = new Handler();

    Runnable runnable = () -> finishAsync();

    @Inject
    public ExamplePresenter() {
        //Empty constructor
    }

    @Override
    public void onViewCreated(Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        if (savedInstanceState == null) {
            requestType = RequestType.INIT;
        }
        switch (requestType) {
            case INIT:
                load();
                return;
            case LOAD_MORE:
                loadMore();
                showModels();
                return;
            case NONE:
                if (!models.isEmpty()) {
                    showModels();
                } else {
                    showEmpty();
                }
        }
    }

    private void showModels() {
        if (getView() != null) {
            getView().hideLoadMore();
            getView().hideLoading();
            getView().showModels();
        }
    }

    private void showEmpty() {
        Timber.i("[showEmpty]");
        getView().hideLoading();
        getView().showEmpty();
    }

    public void load() {
        Timber.i("[load]");
        getView().showLoading();
        currentPage = 0;
        models.clear();
        requestType = RequestType.INIT;
        async();
    }

    public void loadMore() {
        Timber.i("[loadMore]");
        getView().showLoadMore();
        requestType = RequestType.LOAD_MORE;
        async();
    }

    private void async() {
        Timber.i("[async]");
        handler.postDelayed(runnable, 10000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

    public void finishAsync() {
        Timber.i("[finishAsync]");
        requestType = RequestType.NONE;
        currentPage++;
        //add(? extends Serializable);
        showModels();
    }
}

