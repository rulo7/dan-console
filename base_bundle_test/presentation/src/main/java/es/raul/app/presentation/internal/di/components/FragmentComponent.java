package es.raul.app.presentation.internal.di.components;

import dagger.Component;
import es.raul.app.presentation.internal.di.modules.FragmentModule;
import es.raul.app.presentation.internal.di.scope.PerFragment;

@PerFragment
@Component(
        dependencies = {ApplicationComponent.class},
        modules = {FragmentModule.class})
public interface FragmentComponent {
}
