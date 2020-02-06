/* MyGTPLRules.java
 *
 * Copyright (C) 2020
 * Copyright (C) DTU(Technical University of Denmark) 2020
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the Apache license.  See the LICENSE.txt file for details.
 */
package eu.lightest.gtpl.gtpl;

import eu.lightest.gtpl.datatype.TrustPolicy;
import javafx.collections.ObservableList;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ListCell;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.TransferMode;

/**
 *
 * @author bnia
 */
public class MyGTPLRules extends ListCell<TrustPolicy> {
  public MyGTPLRules() {
    setOnDragDetected(event -> {
      if (getItem() == null) {
        return;
      }
      if (event.getButton() == MouseButton.PRIMARY) {
        WritableImage image = snapshot(new SnapshotParameters(), null);
        Dragboard dragboard = startDragAndDrop(TransferMode.MOVE);
        ClipboardContent content = new ClipboardContent();
        content.putString("rule_name");
        dragboard.setDragView(image);
        dragboard.setContent(content);
        event.consume();
      }
    });

    setOnDragOver(event -> {
      if (event.getGestureSource() != this && event.getDragboard().hasString() && event.getDragboard().getString().equals("rule_name")) {
        event.acceptTransferModes(TransferMode.MOVE);
      }
      event.consume();
    });

    setOnDragEntered(event -> {
      if (event.getGestureSource() != this && event.getDragboard().hasString() && event.getDragboard().getString().equals("rule_name")) {
        setOpacity(0.3);
      }
    });

    setOnDragExited(event -> {
      if (event.getGestureSource() != this && event.getDragboard().hasString()) {
        setOpacity(1);
      }
    });

    setOnDragDropped(event -> {
      if (getItem() == null) {
        return;
      }
      Dragboard db = event.getDragboard();
      boolean success = false;
      if (db.hasString() && db.getString().equals("rule_name")) {
        ObservableList<TrustPolicy> items = getListView().getItems();
        TrustPolicy source = ((MyGTPLRules) event.getGestureSource()).getItem();
        TrustPolicy target = ((MyGTPLRules) event.getGestureTarget()).getItem();
        int sourceIdx = items.indexOf(source);
        int targetIdx = items.indexOf(target);
        //change the order
        if(sourceIdx > targetIdx){
          items.add(targetIdx, source);
          items.remove(sourceIdx+1);
        }else{
          items.add(targetIdx+1, source);
          items.remove(sourceIdx);
        }

        success = true;
      }
      event.setDropCompleted(success);
      event.consume();
    });
    setOnDragDone(DragEvent::consume);
  }

  @Override
  protected void updateItem(TrustPolicy item, boolean empty) {
    super.updateItem(item, empty);
    if (empty || item == null) {
      setText(null);
    } else {
      setText(item.ruleName);
    }
  }
}
