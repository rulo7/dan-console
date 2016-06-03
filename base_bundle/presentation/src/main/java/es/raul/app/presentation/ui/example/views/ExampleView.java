package es.raul.app.presentation.ui.example.views;

import es.raul.app.domain.model.Example;
import es.raul.app.presentation.ui.base.BaseLoadDataView;
import java.util.ArrayList;

/**
 * Created by raulcobos on 31/5/16.
 */
public interface ExampleView extends BaseLoadDataView {

    void showModels(ArrayList<Example> examples);

    void showDetail(Example example);

    void showLoadMore();

    void hideLoadMore();
}
