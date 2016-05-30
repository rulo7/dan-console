package es.raul.app.presentation.navigation;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class used to navigate through the application.
 */
@Singleton
public class Navigator {

    @Inject
    public Navigator() {
        //empty because of dagger
    }


    /*public void navigateToDetailEvent(Activity activity) {
        if (activity != null) {
            Intent intentToLaunch = ActivityExample.getCallingIntent(activity);
            activity.startActivity(intentToLaunch);
        }
    }*/
}
