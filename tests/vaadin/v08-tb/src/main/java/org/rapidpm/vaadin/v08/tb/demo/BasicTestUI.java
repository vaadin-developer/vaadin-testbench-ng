package org.rapidpm.vaadin.v08.tb.demo;

import com.vaadin.ui.Button;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import static java.lang.String.valueOf;
import static org.rapidpm.vaadin.addons.framework.ComponentIDGenerator.buttonID;

public class BasicTestUI extends Composite {


  public static final String BUTTON_ID = buttonID().apply(BasicTestUI.class, "buttonID");
  public static final String LABEL_ID  = buttonID().apply(BasicTestUI.class, "labelID");


  private final Button button = new Button();
  private final Label  label  = new Label();

  private int counter = 0;

  public BasicTestUI() {
    label.setId(LABEL_ID);
    label.setValue(valueOf(counter));

    button.setId(BUTTON_ID);
    button.setCaption(BUTTON_ID);
    button.addClickListener(e -> label.setValue(valueOf(++counter)));

    setCompositionRoot(new VerticalLayout(button, label));
  }


}