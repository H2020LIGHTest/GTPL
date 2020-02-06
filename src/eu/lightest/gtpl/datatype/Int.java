/* Value.java 
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

/**
 *
 * @author bnia
 */
public class Int extends Valuetype implements Serializable{
  public int value;

  public Int(){

  }
  public Int(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "" + value;
  }

  @Override
  public ArrayList<String> getVars() {
    return new ArrayList();
  }

  @Override
  public String toDebugString() {
    return "Int(" + value + ")";
  }
}
