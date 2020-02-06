/* TrustListPane.java 
 *
 * Copyright (C) 2020
 * Copyright (C) DTU(Technical University of Denmark) 2020
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the Apache license.  See the LICENSE.txt file for details.
 */
package eu.lightest.gtpl.datatype;

import javafx.scene.layout.GridPane;

/**
 *
 * @author bnia
 */
public class TrustListPane {
  public GridPane claimPane;
  public TrustListContent trustListContent;

  public TrustListPane() {}
  public TrustListPane(GridPane claimPane, TrustListContent trustListContent) {
    this.claimPane = claimPane;
    this.trustListContent = trustListContent;
  }

}
