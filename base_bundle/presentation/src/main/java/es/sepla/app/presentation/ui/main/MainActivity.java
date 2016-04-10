package es.sepla.app.presentation.ui.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import es.sepla.app.presentation.navigation.Navigator;
import es.sepla.app.presentation.ui.Presenter;
import es.sepla.app.presentation.ui.base.BaseActivity;

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