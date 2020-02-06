/* TabPaneWrapper.java
 *
 * Copyright (C) 2020
 * Copyright (C) DTU(Technical University of Denmark) 2020
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the Apache license.  See the LICENSE.txt file for details.
 */
package eu.lightest.gtpl.gtpl;

import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.SplitPane;

/**
 *
 * @author bnia
 */
public class TabPaneWrapper{
  SplitPane split;
  public TabPaneWrapper(Orientation o, double splitLocation){
    split = new SplitPane();
    split.setOrientation(o);
    split.setDividerPosition(0, splitLocation);
  }
  public void addNodes(final Node node1, final Node node2){
    //Add to the split pane
    split.getItems().addAll(node1, node2);
  }
  public Parent getNode(){
    return split;
  }
} 
