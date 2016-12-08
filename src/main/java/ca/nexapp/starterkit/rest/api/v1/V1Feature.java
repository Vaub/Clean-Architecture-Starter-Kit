package ca.nexapp.starterkit.rest.api.v1;

import ca.nexapp.starterkit.rest.contexts.ProductionContextBinder;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class V1Feature implements Feature {

    @Override
    public boolean configure(FeatureContext context) {
        context.register(new ProductionContextBinder());
        return true;
    }

}
