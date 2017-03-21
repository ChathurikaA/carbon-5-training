/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.wso2.carbon.training.config;

import org.wso2.carbon.kernel.annotations.Configuration;
import org.wso2.carbon.kernel.annotations.Element;
import org.wso2.carbon.kernel.annotations.Ignore;

/**
 * ExampleConfiguration class for wso2.example.config.yaml file.
 *
 */
@Configuration(namespace = "wso2.example.config", description = "Example parent level configuration")
public class RootConfiguration {

    @Element(description = "An example element for this configuration")
    private String name = "example";

    @Element(description = "Another example element in the config", required = true)
    private int value = 10;

    @Ignore
    private String ignored;

    @Element(description = "Second level configuration")
    private ChildConfiguration childConfiguration = new ChildConfiguration();

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public ChildConfiguration getChildConfiguration() {
        return childConfiguration;
    }

    @Override
    public String toString() {
        return "name : " + name + ", value : " + value + ", childConfiguration - " + childConfiguration;
    }
}
