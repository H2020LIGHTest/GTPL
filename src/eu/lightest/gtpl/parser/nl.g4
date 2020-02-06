/* nl.g4
 *
 * Copyright (C) 2020
 * Copyright (C) DTU(Technical University of Denmark) 2020
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the Apache license.  See the LICENSE.txt file for details.
 */
grammar nl;

ID              : '?'('A'..'Z')('A'..'Z'|'a'..'z'|'_'|'0'..'9')* ;
CONC            : ('a'..'z'|'A'..'Z')('A'..'Z'|'a'..'z'|'_'|'0'..'9')* ;
NUM             : ('1'..'9')('0'..'9')* ;
WHITESPACE      : [ \n\t\r]+ -> skip;
COMMENT         : '//'~[\n]+'\n' -> skip;

nl              : policyrules EOF ;

policyrules     : ('if' inputformat 'is' 'format' 'of' concreteformat constraints 'then' 'accept' 'it' ';')*    # PolicyRule
                ;

inputformat     : CONC                          # Input
                ;

concreteformat  : CONC                          # FormatName
                ;

constraints     : (','? 'and'? attribute conditional value)*    #Constraint
                ;

attribute       : CONC ('.' CONC)*                         # AttributeName
                ;

conditional     : 'equals'                      # Equals
                | 'does not equal'              # NotEqual
                | 'less than'                   # LessThan
                | 'less than or equal to'       # LessThanOrEqual
                | 'greater than'                # GreaterThan
                | 'greater than or equal to'    # GreaterThanOrEqual
                | 'is'                          # Is
                | 'is equivalent to'            # IsEquivalent
                | 'is from'                     # IsDelegationFrom
                ;

value           : NUM                           # Number
                | ID                            # Variable
                | CONC                          # Concrete
                ;