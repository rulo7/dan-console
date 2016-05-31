package es.raul.app.presentation.ui.base;

import android.content.Intent;
import android.os.Bundle;
import timber.log.Timber;

/**
 * Created by guillermoguerrero on 2/3/16.
 */
public abstract class BasePresenter<T extends BaseView> {

    private T view;

    public void onCreate(Bundle savedInstanceState) {
        Timber.i("[onCreate]");
    }

    public void onResume() {
        Timber.i("[onResume]");
    }

    public void onPause() {
        Timber.i("[onPause]");
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Timber.i("[onActivityResult]");
    }

    public void onViewCreated(Bundle savedInstanceState) {
        Timber.i("[onViewCreated]");
    }

    public void onDestroy() {
        Timber.i("[onDestroy]");
    }

    public void setView(T view) {
        this.view = view;
    }

    public T getView() {
        return view;
    }
}
