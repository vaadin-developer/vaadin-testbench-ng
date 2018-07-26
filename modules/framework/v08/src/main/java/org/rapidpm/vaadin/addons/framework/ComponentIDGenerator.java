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
package org.rapidpm.vaadin.addons.framework;

import com.vaadin.ui.*;
import org.rapidpm.frp.functions.TriFunction;

import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;


public interface ComponentIDGenerator {

  static TriFunction<Class, Class, String, String> genericID() {
    return (uiClass, componentClass, label)
        -> (uiClass.getSimpleName()
            + "-" + componentClass.getSimpleName()
            + "-" + label.replace(" ", "-"))
        .toLowerCase(Locale.US);
  }

  static Function<String, String> caption() {
    return (id) -> id + "." + "caption";
  }

  static Function<String, String> placeholder() {
    return (id) -> id + "." + "placeholder";
  }

  static BiFunction<Class, String, String> gridID() {
    return (uiClass, label) -> genericID().apply(uiClass, Grid.class, label);
  }

  static BiFunction<Class, String, String> buttonID() {
    return (uiClass, label) -> genericID().apply(uiClass, Button.class, label);
  }

  static BiFunction<Class, String, String> comboBoxID() {
    return (uiClass, label) -> genericID().apply(uiClass, ComboBox.class, label);
  }

  static BiFunction<Class, String, String> dateFieldID() {
    return (uiClass, label) -> genericID().apply(uiClass, DateField.class, label);
  }


  static BiFunction<Class, String, String> labelID() {
    return (uiClass, label) -> genericID().apply(uiClass, Label.class, label);
  }

  static BiFunction<Class, String, String> textfieldID() {
    return (uiClass, label) -> genericID().apply(uiClass, TextField.class, label);
  }

  static BiFunction<Class, String, String> passwordID() {
    return (uiClass, label) -> genericID().apply(uiClass, PasswordField.class, label);
  }


//  Layouts

  static BiFunction<Class, String, String> cssLayoutID() {
    return (uiClass, label) -> genericID().apply(uiClass, CssLayout.class, label);
  }

  static BiFunction<Class, String, String> verticalLayoutID() {
    return (uiClass, label) -> genericID().apply(uiClass, VerticalLayout.class, label);
  }

  static BiFunction<Class, String, String> horizontalLayoutID() {
    return (uiClass, label) -> genericID().apply(uiClass, HorizontalLayout.class, label);
  }
}
