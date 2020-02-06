/* FormPaneContent.java 
 *
 * Copyright (C) 2020
 * Copyright (C) DTU(Technical University of Denmark) 2020
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the Apache license.  See the LICENSE.txt file for details.
 */
package eu.lightest.gtpl.datatype;

import java.util.ArrayList;
import javafx.scene.layout.GridPane;

/**
 *
 * @author bnia
 */
public class FormPaneContent {
  public int attributeCounter;
  public GridPane claimPane;
  public ArrayList<Object> textFieldList;

  public FormPaneContent() {}

  public FormPaneContent(int attributeCounter) {
    this.attributeCounter = attributeCounter;
  }

  public FormPaneContent(int attributeCounter, ArrayList<Object> textFieldList) {
    this.attributeCounter = attributeCounter;
    this.textFieldList = textFieldList;
  }

  public FormPaneContent(int attributeCounter, GridPane claimPane, ArrayList<Object> textFieldList) {
    this.attributeCounter = attributeCounter;
    this.claimPane = claimPane;
    this.textFieldList = textFieldList;
  }
}
