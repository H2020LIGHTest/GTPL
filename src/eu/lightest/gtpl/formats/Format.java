/* Format.java 
 *
 * Copyright (C) 2020
 * Copyright (C) DTU(Technical University of Denmark) 2020
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the Apache license.  See the LICENSE.txt file for details.
 */
package eu.lightest.gtpl.formats;

import eu.lightest.gtpl.datatype.Form;
import java.util.ArrayList;

/**
 *
 * @author bnia
 */
public interface Format {
  ArrayList<Form> allFormats();
  ArrayList<Form>allCertificate();
}
