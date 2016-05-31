/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 *
 * @author Fernando Cejas (the android10 coder)
 */
package es.raul.app.presentation.ui.base;

public interface BaseLoadDataView extends BaseView {
    void showLoading();

    void hideLoading();

    void showEmpty();

    void hideEmpty();
}
