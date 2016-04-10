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

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import es.raul.app.presentation.AndroidApplication;
import es.raul.app.presentation.internal.di.modules.ApplicationModule;
import es.raul.app.domain.executor.PostExecutionThread;
import es.raul.app.domain.executor.ThreadExecutor;
import es.raul.app.presentation.navigation.Navigator;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(
        modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(AndroidApplication androidApplication);

    AndroidApplication getAndroidApplication();

    Context context();

    Navigator navigator();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();
}
