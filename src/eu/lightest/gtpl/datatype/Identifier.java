/* Identifier.java 
 *
 * Copyright (C) 2020
 * Copyright (C) DTU(Technical University of Denmark) 2020
 * All rights reserved 
 *
 * This software may be modified and distributed under the terms
 * of the Apache license.  See the LICENSE.txt file for details.
 */
package eu.lightest.gtpl.datatype;

import java.io.Serializable;

/**
 *
 * @author bnia
 */
public class Identifier implements Serializable{
  public String dispalyName;
  public String tplIdentifier;

  public Identifier(){}

  public Identifier(String tplIdentifier){
    this.dispalyName = tplIdentifier;
    this.tplIdentifier = tplIdentifier;
  }

  public Identifier(String dispalyName, String tplIdentifier) {
    this.dispalyName = dispalyName;
    this.tplIdentifier = tplIdentifier;
  }
}
