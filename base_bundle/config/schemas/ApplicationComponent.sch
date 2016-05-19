package _app_package_name_._packagename_;

import android.content.Context;
import dagger.Component;
import javax.inject.Singleton;
import _app_package_name_.domain.executor.PostExecutionThread;
import _app_package_name_.domain.executor.ThreadExecutor;
import _app_package_name_.presentation.AndroidApplication;
import _app_package_name_.presentation.internal.di.modules.ApplicationModule;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton
@Component(
        modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(AndroidApplication androidApplication);

    AndroidApplication getAndroidApplication();

    Context context();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();
}