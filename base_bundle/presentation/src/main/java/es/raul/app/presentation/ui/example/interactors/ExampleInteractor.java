package es.raul.app.presentation.ui.example.interactors;

import es.raul.app.domain.model.Example;
import es.raul.app.presentation.internal.di.scope.PerFragment;
import es.raul.app.presentation.ui.base.BasePresenter;
import es.raul.app.presentation.ui.example.views.ExampleView;
import java.util.List;
import javax.inject.Inject;
import rx.Subscriber;

/**
 * Created by raulcobos on 31/5/16.
 */
@PerFragment
public class ExampleInteractor extends BasePresenter<ExampleView> {

    @Inject
    public ExampleInteractor() {
        //inject here using cases
    }

    public void getExample(int id, Subscriber<Example> subscriber) {
        // use here usingcases build execute method
    }

    public void getExamples(Subscriber<List<Example>> subscriber, int page, int perPage) {
        // use here usingcases build execute method
    }
}