/* FormFormat.java 
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

/**
 *
 * @author bnia
 */
public class FormFormat implements Serializable{
  public Form format;

  public FormFormat(){}
  public FormFormat(Form format){
    this.format = format;
  }

  @Override
  public String toString() {
    return format.identifier.dispalyName;
  }
}
