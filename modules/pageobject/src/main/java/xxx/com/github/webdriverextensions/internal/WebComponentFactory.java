/*
 * Copyright
 * 2018 WebDriverExtensions Team - https://github.com/webdriverextensions/webdriverextensions
 * 2018 Daniel Nordhoff-Vergien
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package xxx.com.github.webdriverextensions.internal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import xxx.com.github.webdriverextensions.WebComponent;

public interface WebComponentFactory {

  <T extends WebComponent> T create(Class<T> webComponentClass, WebElement webElement,
      WebDriver webDriver);
}
