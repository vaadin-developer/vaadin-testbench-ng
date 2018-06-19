package junit.org.rapidpm.vaadin.addons.testbench.junit5.extensions.basic.demo;


import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.rapidpm.dependencies.core.logger.HasLogger;
import org.rapidpm.vaadin.addons.testbench.junit5.pageobject.PageObject;

public class PageObjectConfigExtension implements BeforeAllCallback, BeforeEachCallback,
    AfterEachCallback, AfterAllCallback, HasLogger {


  @Override
  public void afterAll(ExtensionContext context) throws Exception {

  }

  @Override
  public void afterEach(ExtensionContext context) throws Exception {

  }

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {

  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {

    System.setProperty(PageObject.SERVER_WEBAPP, "/" + DemoUI.class.getName());
//    System.setProperty(PageObject.SERVER_PORT, "9998");
//    System.setProperty(PageObject.SERVER_IP, NetworkFunctions.localeIP().get());

  }
}