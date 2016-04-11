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
package es.raul.app.presentation;

import android.app.Application;
import android.content.Context;
import com.karumi.dexter.Dexter;
import es.raul.app.presentation.internal.di.components.ApplicationComponent;
import es.raul.app.presentation.internal.di.components.DaggerApplicationComponent;
import es.raul.app.presentation.internal.di.modules.ApplicationModule;
import es.sepla.app.presentation.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Android Main Application
 */
public class AndroidApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    public static AndroidApplication get(Context context) {
        return (AndroidApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initInjector();
        initCaligraphy();
        initDexter();
    }

    private void initDexter() {
        Dexter.initialize(this);
    }


    private void initCaligraphy() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setDefaultFontPath(getString(R.string.font_type))
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

    private void initInjector() {
        mApplicationComponent =
                DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
