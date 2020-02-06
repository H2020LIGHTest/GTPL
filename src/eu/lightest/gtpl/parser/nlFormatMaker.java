/* nlFormatMaker.java
 *
 * Copyright (C) 2020
 * Copyright (C) DTU(Technical University of Denmark) 2020
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the Apache license.  See the LICENSE.txt file for details.
 */
package eu.lightest.gtpl.parser;

import eu.lightest.gtpl.datatype.*;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bnia, andschl
 */
public class nlFormatMaker extends AbstractParseTreeVisitor<AST> implements nlVisitor<AST>{

  @Override
  public AST visitNl(nlParser.NlContext ctx) {
    return visit(ctx.policyrules());
  }

  @Override
  public AST visitPolicyRule(nlParser.PolicyRuleContext ctx) {
    Forms formats = new Forms();
    for(int i = 0; i < ctx.inputformat().size(); i++ ){
      Form format = new Form();
      format.identifier.dispalyName = ((Value)visit(ctx.concreteformat(i))).value;
      format.identifier.tplIdentifier = ((Value)visit(ctx.concreteformat(i))).value;
      format.attributes.addAll(((Constrains)visit(ctx.constraints(i))).constrains);
      formats.forms.add(format);
    }
    return formats;
  }

  @Override
  public AST visitInput(nlParser.InputContext ctx) {
    Variable input = new Variable(ctx.CONC().getText());
    return input;
  }

  @Override
  public AST visitFormatName(nlParser.FormatNameContext ctx) {
    Value formatName = new Value("'" + ctx.CONC().getText() + "'");
    return formatName;
  }

  @Override
  public AST visitConstraint(nlParser.ConstraintContext ctx) {
    Constrains cons = new Constrains();
    for(int i = 0; i < ctx.attribute().size(); i++){
      ArrayList<String> attName = extractAttribute((nlParser.AttributeNameContext) ctx.attribute(i));
      AttributeValuePair attPair = visitConstraintAux(ctx, i, attName);
      cons.constrains.add(attPair);
    }
    return cons;
  }

  private AttributeValuePair visitConstraintAux(nlParser.ConstraintContext ctx, int i, ArrayList<String> attName) {
    AttributeValuePair attPair = new AttributeValuePair();
    if(attName.size() == 1) {
      attPair.attributeNamePair.attributename = attName.get(0);
      attPair.attributeNamePair.displayname = attName.get(0);
      AST conditional = visit(ctx.conditional(i));
      if (conditional instanceof Operator) {
        String comp = ((Operator) visit(ctx.conditional(i))).op;
        AST compValue = visit(ctx.value(i));
        if (compValue instanceof Value && comp.equals("==")){
          attPair.value = (Value) compValue;
        } else {
          CompValue opValue = new CompValue();
          opValue.comp = comp;
          if (compValue instanceof Variable) {
            opValue.value = ((Variable) compValue);
          } else if (compValue instanceof Int) {
            opValue.value = ((Int) compValue);
          } else {
            opValue.value = ((Value) compValue);
          }
          attPair.value = opValue;
        }
      } else if (conditional instanceof Is) {
        if (attName.get(0).equals("certificate")) {
          attPair.attributeNamePair.attributename = "signature";
          attPair.value = new Trustscheme(((Value) visit(ctx.value(i))).value);
        } else {
          AST value = visit(ctx.value(i));
          if (value instanceof Variable) {
            attPair.value = null;
          } else if(value instanceof Int){
            attPair.value = (Int) value;
          } else if (value instanceof Value){
            attPair.value = (Value) value;
          }
        }
      } else if (conditional instanceof Equivalent) {
        if (attName.get(0).equals("certificate")) {
          attPair.attributeNamePair.attributename = "signature";
          attPair.value = new TrustschemeX(((Value) visit(ctx.value(i))).value);
        } else {
          AST value = visit(ctx.value(i));
          if (value instanceof Variable) {
            attPair.value = new Value(((Variable) value).variable.toLowerCase());
          } else {
            attPair.value = (Value) value;
          }
        }
      } else if (conditional instanceof DelegationFrom) {
        if (attName.get(0).equals("delegation")) {
          attPair.value = new Trustscheme(((Value) visit(ctx.value(i))).value);
        } else {
          AST value = visit(ctx.value(i));
          if (value instanceof Variable) {
            attPair.value = new Value(((Variable) value).variable.toLowerCase());
          } else {
            attPair.value = (Value) value;
          }
        }
      }
    } else {
      String x = attName.remove(0);
      AttributeValuePair y = visitConstraintAux(ctx, i, attName);
      Form z = new Form();
      z.genericFormat = true;
      z.identifier.dispalyName = "genericFormat";
      z.identifier.tplIdentifier = "genericFormat";
      ArrayList<AttributeValuePair> attributes = new ArrayList<AttributeValuePair>();
      attributes.add(y);
      z.attributes = attributes;
      attPair.attributeNamePair.displayname = x;
      attPair.attributeNamePair.attributename = x;
      attPair.value = z;
    }
    return attPair;
  }

  public ArrayList<String> extractAttribute(nlParser.AttributeNameContext ctx) {
    ArrayList<String> strs = new ArrayList<>();
    List<TerminalNode> ctx_CONC = ctx.CONC();
    for (int i = 0; i < ctx_CONC.size(); i++) {
      strs.add(ctx_CONC.get(i).toString());
    }

    return strs;
  }

  @Override
  public AST visitAttributeName(nlParser.AttributeNameContext ctx) {
    //Value attName = new Value(ctx.CONC().getText());
    //return attName;
    return null;
  }

  @Override
  public AST visitEquals(nlParser.EqualsContext ctx) {
    return new Operator("==");
  }

  @Override
  public AST visitNotEqual(nlParser.NotEqualContext ctx) {
    return new Operator("!=");
  }

  @Override
  public AST visitLessThan(nlParser.LessThanContext ctx) {
    return new Operator("<");
  }

  @Override
  public AST visitLessThanOrEqual(nlParser.LessThanOrEqualContext ctx) {
    return new Operator("<=");
  }

  @Override
  public AST visitGreaterThan(nlParser.GreaterThanContext ctx) {
    return new Operator(">");
  }

  @Override
  public AST visitGreaterThanOrEqual(nlParser.GreaterThanOrEqualContext ctx) {
    return new Operator(">=");
  }

  @Override
  public AST visitIs(nlParser.IsContext ctx) {
    return new Is();
  }

  @Override
  public AST visitIsEquivalent(nlParser.IsEquivalentContext ctx) {
    return new Equivalent();
  }

  @Override
  public AST visitIsDelegationFrom(nlParser.IsDelegationFromContext ctx) {
    return new DelegationFrom();
  }

  @Override
  public AST visitNumber(nlParser.NumberContext ctx) {
    return new Int(Integer.parseInt(ctx.NUM().getText()));
  }

  @Override
  public AST visitVariable(nlParser.VariableContext ctx) {
    return new Variable(ctx.ID().getText());
  }

  @Override
  public AST visitConcrete(nlParser.ConcreteContext ctx) {
    return new Value("'" + ctx.CONC().getText() + "'");
  }

}
