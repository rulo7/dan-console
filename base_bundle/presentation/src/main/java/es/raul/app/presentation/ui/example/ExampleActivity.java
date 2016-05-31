package es.raul.app.presentation.ui.example;

import android.os.Bundle;
import es.raul.app.presentation.R;
import es.raul.app.presentation.ui.base.BaseActivity;
import es.raul.app.presentation.ui.example.views.ExampleFragment;

/**
 * Created by raulcobos on 31/5/16.
 */
public class ExampleActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        if(savedInstanceState == null) {
            replaceFragment(R.id.fl_fragment, new ExampleFragment(), false);
        }
    }
}
