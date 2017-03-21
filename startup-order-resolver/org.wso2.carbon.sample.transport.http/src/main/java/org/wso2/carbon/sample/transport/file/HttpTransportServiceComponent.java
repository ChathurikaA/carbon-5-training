package org.wso2.carbon.sample.transport.file;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.wso2.carbon.sample.transport.mgt.Transport;

import java.util.stream.IntStream;

/**
 * JMS TransportServiceCapabilityProvider class that registers JMSTransport as a service multiple times to test
 * the startup order resolver implementation.
 *
 * @since 5.0.0
 */
@Component(
        name = "org.wso2.carbon.sample.transport.file.HttpTransportServiceComponent",
        immediate = true
)
public class HttpTransportServiceComponent {
    private static final int httpTransportServiceCount = 3;

    @Activate
    protected void start(BundleContext bundleContext) {
        IntStream.range(0, httpTransportServiceCount).forEach(
                count -> bundleContext.registerService(Transport.class, new HttpTransport(), null)
        );
    }
}
