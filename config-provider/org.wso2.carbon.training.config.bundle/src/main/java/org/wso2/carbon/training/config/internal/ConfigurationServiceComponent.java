/*
 *  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.wso2.carbon.training.config.internal;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.kernel.configprovider.ConfigProvider;
import org.wso2.carbon.training.config.RootConfiguration;

/**
 * Declarative service component used with the example configuration bundle.
 */
@Component(
        name = "org.wso2.carbon.deployment.engine.internal.DeploymentEngineListenerComponent",
        immediate = true
)
public class ConfigurationServiceComponent {
    private static final Logger logger = LoggerFactory.getLogger(ConfigurationServiceComponent.class);

    private ConfigProvider configProvider;

    @Activate
    public void start() throws Exception {
        RootConfiguration rootConfiguration = configProvider.getConfigurationObject(RootConfiguration.class);
        logger.info("Example configuration - {}", rootConfiguration);
    }

    @Deactivate
    public void stop() throws Exception {

    }

    @Reference(
            name = "carbon.config.provider",
            service = ConfigProvider.class,
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unregisterConfigProvider"
    )
    protected void registerConfigProvider(ConfigProvider configProvider) {
        this.configProvider = configProvider;
    }

    protected void unregisterConfigProvider(ConfigProvider configProvider) {
        this.configProvider = null;
    }

}
