package es.sepla.app.data.exception;

/**
 * Created by djuarez on 17/3/16.
 */
public class NotStoreException extends Exception {

    public NotStoreException() {
        super();
    }

    public NotStoreException(final String message) {
        super(message);
    }

    public NotStoreException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NotStoreException(final Throwable cause) {
        super(cause);
    }
}

