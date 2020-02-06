/* CompValue.java 
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
public class CompValue extends Valuetype implements Serializable{
  public String comp;
  public Valuetype value;

  public CompValue(){

  }

  public CompValue(String comp, Variable value) {
    this.comp = comp;
    this.value = value;
  }

  public CompValue(String comp, Int value) {
    this.comp = comp;
    this.value = value;
  }

  @Override
  public String toString() {
    return comp + value;
  }


  @Override
  public ArrayList<String> getVars() {
    return value.getVars();
  }

  @Override
  public String toDebugString() {
    return "CompValue(" + value + ")";
  }
}
