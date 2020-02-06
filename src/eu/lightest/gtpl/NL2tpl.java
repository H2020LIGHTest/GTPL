/* NL2tpl.java
 *
 * Copyright (C) 2020
 * Copyright (C) DTU(Technical University of Denmark) 2020
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the Apache license.  See the LICENSE.txt file for details.
 */
package eu.lightest.gtpl;

import eu.lightest.gtpl.parser.*;
import eu.lightest.gtpl.tools.NL2TPLTools;
import org.antlr.v4.runtime.*;

public class NL2tpl {
  public static void main(String[] args) throws nlException{

    // we expect exactly one argument: the name of the input file
    if (args.length != 1) {
      System.err.println("\n");
      System.err.println("Natural Language\n");
      System.err.println("=================\n\n");
      System.err.println("Please give as input argument a filename\n");
      System.err.println("Executing in directory: " + System.getProperty("user.dir"));
      System.exit(-1);
    }
    String filename = args[0];

    // open the input file
    CharStream input = null;
    try {
      input = CharStreams.fromFileName(filename);
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
      System.err.println("Executing in directory: " + System.getProperty("user.dir"));
      System.exit(-1);
    }
    String tpl = NL2TPLTools.translateCharStreamWithLibrary(input);
    System.out.println(tpl);

  }

}
