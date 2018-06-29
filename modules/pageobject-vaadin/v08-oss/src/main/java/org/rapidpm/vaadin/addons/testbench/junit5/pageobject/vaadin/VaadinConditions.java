/**
 * Copyright © 2017 Sven Ruppert (sven.ruppert@gmail.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.rapidpm.vaadin.addons.testbench.junit5.pageobject.vaadin;

import com.google.common.base.Predicate;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VaadinConditions {
  private static final long BROWSER_RENDERING_MS = 10;

  private VaadinConditions() {
    throw new IllegalAccessError("Utitility class!");
  }

  /**
   * Waiting condition for selenium webdriver. Uses the vaadin js-api to see if rendering is done.
   * <p>
   * Taken, and fixed, from the (german) book "Vaadin".
   *
   * @see <a href="https://www.dpunkt.de/buecher/4526/vaadin.html">(german) Book: Vaadin</a>
   */
  public static Predicate<WebDriver> ajaxCallsCompleted() {
    return driver -> {
      if (isVaadinActive(driver)) {
        return true;
      } else {
        ensureBrowserRenderingTookPlace();
        return false;
      }
    };
  }

  private static boolean isVaadinActive(WebDriver driver) {
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    return (Boolean) executor.executeScript(//
                                            "if (window.vaadin) { " + //
                                            " for (var client in window.vaadin.clients) { " + //
                                            "  if (window.vaadin.clients[client].isActive()) { " + //
                                            "   return false;" + //
                                            "  }" + //
                                            " }" + //
                                            " return true;" + //
                                            "} else {" + //
                                            " return false;" + //
                                            "}");
  }

  private static void ensureBrowserRenderingTookPlace() {
    try {
      Thread.sleep(BROWSER_RENDERING_MS);
    } catch (InterruptedException e) {
      // ignore
    }
  }

  public static void waitForVaadin(int timeoutInSeconds, WebDriver webDriver) {
    new WebDriverWait(webDriver, timeoutInSeconds)
        .until(driver -> ajaxCallsCompleted().test(driver));
  }
}