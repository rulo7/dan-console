package _app_package_name_.presentation.internal.di.components;

import dagger.Component;
import _app_package_name_.presentation.internal.di.modules.FragmentModule;
import _app_package_name_.presentation.internal.di.scope.PerFragment;
import _app_package_name_.presentation.ui.example.views.ExampleFragment;

@PerFragment
@Component(
        dependencies = ApplicationComponent.class,
        modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(ExampleActivity exampleActivity);
}
