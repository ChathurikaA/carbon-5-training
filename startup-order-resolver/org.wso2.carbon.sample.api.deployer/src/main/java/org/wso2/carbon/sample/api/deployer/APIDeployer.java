package org.wso2.carbon.sample.api.deployer;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A sample implementation od Deployer interface.
 */
@Component(
        name = "org.wso2.carbon.sample.api.deployer.APIDeployer",
        immediate = true
)
public class APIDeployer implements org.wso2.carbon.sample.deployer.mgt.Deployer {
    private static final Logger logger = LoggerFactory.getLogger(APIDeployer.class);

    @Activate
    protected void activate(BundleContext bundleContext) {

    }
    @Deactivate
    protected void deactivate(BundleContext bundleContext) {

    }

    @Override
    public void start() {
        logger.info("Starting API Deployer");
    }

    @Override
    public void stop() {
        logger.info("Stopping API Deployer");
    }
}
