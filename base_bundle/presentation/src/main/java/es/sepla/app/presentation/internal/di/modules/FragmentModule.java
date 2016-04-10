package es.sepla.app.presentation.internal.di.modules;

import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import es.sepla.app.presentation.internal.di.scope.PerFragment;

@Module
public class FragmentModule {
    private final Fragment baseFragment;

    public FragmentModule(Fragment baseFragment) {
        this.baseFragment = baseFragment;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerFragment
    Fragment provideFragment() {
        return this.baseFragment;
    }
}