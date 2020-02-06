/* Constrains.java
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

public class Constrains extends Valuetype implements Serializable {
  public ArrayList<AttributeValuePair> constrains = new ArrayList<>();
  public Constrains(){}

  @Override
  public ArrayList<String> getVars() {
    ArrayList<String> vars = new ArrayList<>();
    for(AttributeValuePair att : constrains){
      vars.addAll(att.getVars());
    }
    return vars;
  }

  @Override
  public String toDebugString() {
    String s = "Constrains([";
    for (AttributeValuePair p : constrains){
      s+=p + ",";
    }
    return s + "])";
  }


}
