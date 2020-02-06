/* ClaimTrustList.java 
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
public class ClaimTrustList extends Valuetype implements Serializable{
  public Valuetype trustListValue;
  public Form form;
  public ArrayList<Form> trustListEntry = new ArrayList<>();

  public ClaimTrustList(Valuetype trustListValue) {
    this.trustListValue = trustListValue;
  }
  public ClaimTrustList() {

  }
  public ClaimTrustList(Valuetype trustListValue, Form form) {
    this.trustListValue = trustListValue;
    this.form = form;
  }
  public ClaimTrustList(Valuetype trustListValue, ArrayList<Form> trustListEntry) {
    this.trustListValue = trustListValue;
    this.trustListEntry = trustListEntry;
  }

  @Override
  public ArrayList<String> getVars() {
    ArrayList<String> vars = new ArrayList<>();
    if (form == null){
      return new ArrayList<>();
    }
    vars.addAll(form.getVars());
    for(Form f : trustListEntry){
      vars.addAll(f.getVars());
    }
    return vars;
  }

  @Override
  public String toDebugString() {
    String s = "ClaimTrustList(" + trustListValue.toDebugString() + "," + form + "," + "[";
    for (Form f : trustListEntry){
      s+= f + ",";
    }
    return s + "])";
  }
}

