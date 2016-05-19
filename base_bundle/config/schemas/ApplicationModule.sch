package _app_package_name_._packagename_;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import _app_package_name_.data.executor.JobExecutor;
import _app_package_name_.domain.executor.PostExecutionThread;
import _app_package_name_.domain.executor.ThreadExecutor;
import _app_package_name_.presentation.UIThread;
import _app_package_name_.presentation.AndroidApplication;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final AndroidApplication androidApplication;

    public ApplicationModule(AndroidApplication application) {
        this.androidApplication = application;
    }

    @Provides
    @Singleton
    AndroidApplication application() {
        return androidApplication;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return androidApplication;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }
}

