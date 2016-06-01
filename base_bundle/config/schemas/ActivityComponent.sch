package _app_package_name_.presentation.internal.di.components;

import dagger.Component;
import _app_package_name_.presentation.internal.di.modules.ActivityModule;
import _app_package_name_.presentation.internal.di.scope.PerActivity;
import _app_package_name_.presentation.ui.example.ExampleActivity;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 * <p>
 * Subtypes of ActivityComponent should be decorated with annotation:
 * {@link PerActivity}
 */
@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(ExampleActivity exampleActivity);
}
