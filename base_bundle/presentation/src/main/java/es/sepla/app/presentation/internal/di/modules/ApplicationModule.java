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
package es.sepla.app.presentation.internal.di.modules;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.sepla.app.data.executor.JobExecutor;
import es.sepla.app.domain.executor.PostExecutionThread;
import es.sepla.app.domain.executor.ThreadExecutor;
import es.sepla.app.presentation.AndroidApplication;
import es.sepla.app.presentation.UIThread;

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

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences() {
        return androidApplication.getSharedPreferences("SEPLA", Context.MODE_APPEND);
    }
}
