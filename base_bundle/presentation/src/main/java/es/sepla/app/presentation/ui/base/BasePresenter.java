package es.sepla.app.presentation.ui.base;

import android.content.Intent;
import android.os.Bundle;

import es.sepla.app.presentation.ui.Presenter;

/**
 * Created by guillermoguerrero on 2/3/16.
 */
public abstract class BasePresenter implements Presenter {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    }

    @Override
    public void onInit() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    @Override
    public void retry() {
    }

    @Override
    public void onDestroy() {
    }
}
