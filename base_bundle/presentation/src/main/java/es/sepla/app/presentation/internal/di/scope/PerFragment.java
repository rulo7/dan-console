package es.sepla.app.presentation.internal.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by raulcobos on 10/3/16.
 */
@Scope
@Retention(RUNTIME)
public @interface PerFragment {
}
