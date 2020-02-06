/* Form.java 
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
import java.util.Comparator;

/**
 *
 * @author bnia
 */
public class Form extends Valuetype implements Serializable{
  public Identifier identifier = new Identifier();
  public ArrayList<AttributeValuePair> attributes = new ArrayList<>();
  public boolean genericFormat = false;

  public Form(){

  }

  public Form(Identifier identifier){
    this.identifier = identifier;
  }

  public Form(Identifier identifier, ArrayList<AttributeValuePair> attributes) {
    this.identifier = identifier;
    this.attributes = attributes;
  }

  /*Comparator for sorting the list by dispalyName*/

  public static Comparator<Form> FormatNameComparator = (Form f1, Form f2) -> {
    String f1DisplayName = f1.identifier.dispalyName.toUpperCase();
    String f2DisplayName = f2.identifier.dispalyName.toUpperCase();

    //ascending order
    return f1DisplayName.compareTo(f2DisplayName);

    //descending order
    //return f2DisplayName.compareTo(f1DisplayName);
  };

  public ArrayList<String> getVars(){
    ArrayList<String> vars = new ArrayList<>();
    for(AttributeValuePair att : attributes){
      vars.addAll(att.getVars());
    }
    return vars;
  }

  @Override
  public String toDebugString() {
    return this + "";
  }

  @Override
  public String toString() {
    String s = "Form(" + identifier.tplIdentifier + "," + "[";
    for (AttributeValuePair p : attributes) {
      s += p + ",";
    }
    return s + "])";
  }
}
