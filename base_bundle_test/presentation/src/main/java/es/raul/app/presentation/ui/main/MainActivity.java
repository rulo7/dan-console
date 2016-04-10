package es.raul.app.presentation.ui.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import es.raul.app.presentation.ui.Presenter;
import es.raul.app.presentation.ui.base.BaseActivity;
import es.raul.app.presentation.navigation.Navigator;

public class MainActivity extends BaseActivity {

    @Inject
    Navigator navigator;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Nullable
    @Override
    protected Presenter getPresenter() {
        return null;
    }
}