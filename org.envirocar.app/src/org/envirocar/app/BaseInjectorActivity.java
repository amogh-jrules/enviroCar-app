package org.envirocar.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.common.base.Preconditions;
import com.squareup.otto.Bus;

import org.envirocar.app.logging.Logger;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * Created by Peter on 02.06.2015.
 */
public abstract class BaseInjectorActivity extends AppCompatActivity implements Injector,
        InjectionModuleProvider{
    private static final Logger LOGGER = Logger.getLogger(BaseInjectorActivity.class);

    private ObjectGraph mObjectGraph;

    // Injected variables.
    @Inject
    protected Bus mBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LOGGER.debug("onCreate()");
        super.onCreate(savedInstanceState);

        mObjectGraph = ((Injector) getApplicationContext()).getObjectGraph().plus
                (getInjectionModules().toArray());

        // Inject all variables in this object.
        injectObjects(this);

        // Register on the bus.
        mBus.register(this);
    }

    @Override
    public List<Object> getInjectionModules() {
        return Arrays.<Object>asList(new InjectionActivityModule(this));
    }

    @Override
    public ObjectGraph getObjectGraph() {
        return mObjectGraph;
    }

    @Override
    public void injectObjects(Object instance) {
        Preconditions.checkNotNull(instance, "Cannot inject into Null objects.");
        Preconditions.checkNotNull(mObjectGraph, "The ObjectGraph must be initialized before use.");
        mObjectGraph.inject(instance);
    }
}
