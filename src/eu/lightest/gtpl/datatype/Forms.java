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

import java.io.Serializable;
import java.util.ArrayList;

public class Forms extends Valuetype implements Serializable {
  public ArrayList<Form> forms = new ArrayList<>();
  public Forms(){

  }

  @Override
  public ArrayList<String> getVars() {
    return new ArrayList<>();
  }

  @Override
  public String toDebugString() {
    return this + "";
  }

  @Override
  public String toString() {
    String s = "Forms([";
    for (Form f:forms) {
      s += f + ",";
    }
    return s + "])";
  }
}
