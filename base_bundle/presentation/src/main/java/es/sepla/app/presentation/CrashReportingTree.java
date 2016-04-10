package es.sepla.app.presentation;
/**
 * Created by guillermoguerrero on 1/3/16.
 */

import android.util.Log;

import timber.log.Timber;

/**
 * A tree which logs important information for crash reporting.
 */
public class CrashReportingTree extends Timber.Tree {
    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return;
        }
        if (t != null) {
            if (priority == Log.ERROR) {
                // TODO
                // report error
                Log.e(tag, message);
            } else if (priority == Log.WARN) {
                // TODO
                // report warn
                Log.w(tag, message);
            }
        }
    }
}