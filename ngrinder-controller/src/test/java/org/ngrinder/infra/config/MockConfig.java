/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ngrinder.infra.config;

import org.ngrinder.common.util.PropertiesWrapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Profile("unit-test")
@Component
public class MockConfig extends Config {
	private PropertiesWrapper wrapper = new PropertiesWrapper(new Properties(), controllerPropertiesKeyMapper);

	public boolean cluster;
	public boolean doRealOnRegion = false;

	@Override
	public PropertiesWrapper getControllerProperties() {
		return wrapper;
	}

	public void setControllerProperties(PropertiesWrapper wrapper) {
		this.wrapper = wrapper;
	}

	@Override
	public void loadProperties() {
		super.loadProperties();
		setControllerProperties(super.getControllerProperties());
	}

	@Override
	public boolean isClustered() {
		return cluster;
	}

	@Override
	public String getRegion() {
		return isClustered() ? (doRealOnRegion == true ? super.getRegion() : "TestRegion") : NONE_REGION;
	}

	@Override
	public String getCurrentIP() {
		return "127.0.0.1";
	}

}
