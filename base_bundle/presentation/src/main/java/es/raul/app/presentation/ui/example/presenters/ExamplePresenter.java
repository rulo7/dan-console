package es.raul.app.presentation.ui.example.presenters;

import android.os.Bundle;
import es.raul.app.domain.exception.DefaultErrorBundle;
import es.raul.app.domain.model.Example;
import es.raul.app.presentation.internal.di.scope.PerFragment;
import es.raul.app.presentation.ui.base.BasePresenter;
import es.raul.app.presentation.ui.example.interactors.ExampleInteractor;
import es.raul.app.presentation.ui.example.views.ExampleView;
import icepick.State;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import rx.Subscriber;

/**
 * Created by raulcobos on 31/5/16.
 */
@PerFragment
public class ExamplePresenter extends BasePresenter<ExampleView> {
    private final int PER_PAGE = 10;
    @State
    ArrayList<Example> models;
    @State
    int currentPage;
    @State
    int selectedExampleId;
    @State
    HashMap<String, RequestType> requestList;
    private ExampleInteractor exampleInteractor;

    @Inject
    public ExamplePresenter(ExampleInteractor exampleInteractor) {
        this.exampleInteractor = exampleInteractor;
    }

    @Override
    public void onViewCreated(Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        if (savedInstanceState == null) {
            init();
        }
        for (Map.Entry<String, RequestType> request : requestList.entrySet()) {
            switch (request.getValue()) {
                case INIT:
                    init();
                    break;
                case LOAD_MORE:
                    loadMore();
                    break;
                case LOAD_DETAIL:
                    printDetail(selectedExampleId);
                    break;
            }
        }
    }

    public void init() {
        currentPage = 0;
        models = new ArrayList<>();
        String requestId = generateUniqueId();
        requestList.put(requestId, RequestType.INIT);
        getView().showLoading();
        loadExamples(requestId);
    }

    public void loadMore() {
        String requestId = generateUniqueId();
        requestList.put(requestId, RequestType.LOAD_MORE);
        getView().showLoadMore();
        loadExamples(requestId);
    }

    public void printDetail(int id) {
        this.selectedExampleId = id;
        String requestId = generateUniqueId();
        requestList.put(requestId, RequestType.LOAD_DETAIL);
        getView().showLoading();
        exampleInteractor.getExample(id, new Subscriber<Example>() {
            @Override
            public void onCompleted() {
                finishRequest(requestId);
            }

            @Override
            public void onError(Throwable e) {
                getView().showError(new DefaultErrorBundle(new Exception(e)));
                finishRequest(requestId);
            }

            @Override
            public void onNext(Example example) {
                getView().showDetail(example);
            }
        });
    }

    private void loadExamples(String requestId) {
        exampleInteractor.getExamples(new Subscriber<List<Example>>() {
            @Override
            public void onCompleted() {
                currentPage++;
                finishRequest(requestId);
            }

            @Override
            public void onError(Throwable e) {
                getView().showError(new DefaultErrorBundle(new Exception(e)));
                finishRequest(requestId);
            }

            @Override
            public void onNext(List<Example> examples) {
                models.addAll(examples);
            }
        }, currentPage, PER_PAGE);
    }

    public void finishRequest(String id) {
        requestList.remove(id);
        if (models.isEmpty()) {
            getView().showEmpty();
        } else {
            getView().hideEmpty();
            getView().showModels(models);
        }
        getView().hideLoading();
        getView().hideLoadMore();
    }

    enum RequestType {INIT, LOAD_MORE, LOAD_DETAIL}
}

