/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 *
 * @author Fernando Cejas (the android10 coder)
 */
package es.raul.app.presentation.ui;

import es.raul.app.domain.exception.ErrorBundle;

/**
 * Interface representing a View that will use to load data.
 */
public interface LoadDataView {
    /**
     * Show a view with a progress bar indicating a loading process.
     */
    void showLoading();

    /**
     * Hide a loading view.
     */
    void hideLoading();

    /**
     * Show a retry view in case of an error when retrieving data.
     */
    void showRetry(String msg);

    /**
     * Hide a retry view shown if there was an error when retrieving data.
     */
    void hideRetry();

    /**
     * Show a updated view in case of an error when retrieving data.
     */
    void showUpdatedNotification();

    /**
     * Hide a updated notification view shown if there was an error when retrieving data.
     */
    void hideUdpatedNotification();

    /**
     * Show a empty view in case of no receiving results when retrieving data.
     */
    void showEmptyList();

    /**
     * Hide a empty view in case of no receiving results when retrieving data.
     */
    void hideEmptyList();

    /**
     * Show an error message
     *
     * @param errorBundle A string representing an error.
     */
    void showError(ErrorBundle errorBundle);
}
