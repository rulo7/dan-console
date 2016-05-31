package es.raul.app.presentation.ui.example.views;

import es.raul.app.presentation.ui.base.BaseLoadDataView;

/**
 * Created by raulcobos on 31/5/16.
 */
public interface ExampleView extends BaseLoadDataView {

    void showModels();

    void showLoadMore();

    void hideLoadMore();
}
