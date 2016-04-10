/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.raul.app.presentation.internal.di.components;

import dagger.Component;
import es.raul.app.presentation.ui.main.MainActivity;
import es.raul.app.presentation.internal.di.modules.ActivityModule;
import es.raul.app.presentation.internal.di.scope.PerActivity;

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
    void inject(MainActivity mainActivity);
}
