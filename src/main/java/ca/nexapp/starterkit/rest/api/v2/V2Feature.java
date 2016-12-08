package ca.nexapp.starterkit.rest.api.v2;

import ca.nexapp.starterkit.rest.contexts.ProductionContextBinder;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class V2Feature implements Feature {

    @Override
    public boolean configure(FeatureContext context) {
        context.register(new ProductionContextBinder());
        return true;
    }

}
