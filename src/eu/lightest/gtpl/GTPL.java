/* GTPL.java
 *
 * Copyright (C) 2020
 * Copyright (C) DTU(Technical University of Denmark) 2020
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the Apache license.  See the LICENSE.txt file for details.
 */
package eu.lightest.gtpl;

import eu.lightest.gtpl.gtpl.GTPLgui;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author bnia
 */
public class GTPL extends Application{

  @Override
  public void start(Stage primaryStage){
    GTPLgui gtplUI = new GTPLgui();
    gtplUI.homePane(primaryStage);
  }

  public static void main(String[] args) {
    launch(args);
  }
}

