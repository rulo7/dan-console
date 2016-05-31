package es.raul.app.presentation.ui.base;

import es.raul.app.domain.exception.ErrorBundle;

public interface BaseView {
    void showError(ErrorBundle errorBundle);
}
