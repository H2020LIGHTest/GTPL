/* TranslationFormat2Tpl.java
 *
 * Copyright (C) 2020
 * Copyright (C) DTU(Technical University of Denmark) 2020
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the Apache license.  See the LICENSE.txt file for details.
 */
package eu.lightest.gtpl.tools;

import eu.lightest.gtpl.datatype.*;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author bnia, andschl
 */
public class TranslationFormat2Tpl {
  private boolean isToplevel = true;
  private VariableFactory varFactory = new VariableFactory();
  private ArrayList<String> signatureVerification_ = new ArrayList<String>();

  public TranslationFormat2Tpl() {
  }

  public String createNewVariable(String suggestion) {
    return varFactory.createVariable(suggestion);
  }

  public String translationToplevel(Form form) {
    varFactory = new VariableFactory();
    varFactory.registerVariables(form.getVars());

    isToplevel = true;
    signatureVerification_.clear();
    String newVariable = createNewVariable("Form");
    String tpl = "accept(" + newVariable + "):-\n";
    tpl += fAttlistFormlevel(form, newVariable);
    for (String s : signatureVerification_) {
      tpl += s;
    }
    tpl += "    .\n\n";
    return tpl;
  }

  public String fAttlistFormlevel(Form form, String formvar) {
    varFactory.registerVariable(formvar);

    String tpl;
    if (isToplevel) {
      isToplevel = false;
      tpl = "    extract(" + formvar + ",format," + form.identifier.tplIdentifier + ")\n";
    } else {
      if (form.genericFormat) {
        tpl = "";
      } else {
        tpl = "    ,extract(" + formvar + ",format," + form.identifier.tplIdentifier + ")\n";
      }
    }
    Stack<AttributeValuePair> atts = createStack(form.attributes);
    tpl += fAttlistAttlevel(atts, formvar);
    return tpl;
  }

  public String fAttlistAttlevel(Stack<AttributeValuePair> attributes, String formvar) {
    if (attributes.empty()) {
      return "";
    }
    AttributeValuePair pair = attributes.pop();
    String attribute = pair.attributeNamePair.attributename;
    Valuetype value = pair.value;
    String tpl = "";

    if (value == null || attribute == null) {
      throw new NullPointerException();

    } else if (value instanceof Blank) {
      return fAttlistAttlevel(attributes, formvar);

    } else if (attribute.equals("signature") && value instanceof Variable) {
      tpl += fAttlistAttlevel(attributes, formvar);
      String verify_signature = "    ,verify_signature(" + formvar + "," + ((Variable) value).variable + ")\n";
      signatureVerification_.add(verify_signature);
      return tpl;

    } else if (attribute.equals("signature") && value instanceof Value) {
      tpl += fAttlistAttlevel(attributes, formvar);
      String verify_signature = "    ,verify_signature(" + formvar + "," + ((Value) value).value + ")\n";
      signatureVerification_.add(verify_signature);
      return tpl;

    } else if (attribute.equals("signature") && value instanceof Trustscheme) {
      AttributeValuePair issuerTrustScheme = new AttributeValuePair(new AttributeNamePair("issuer"), new ClaimTrustList(value));

      Variable PKvar = new Variable(createNewVariable("PK"));
      AttributeValuePair pubKeyPK = new AttributeValuePair(new AttributeNamePair("pubKey"), PKvar);

      Form genericformat = new Form(new Identifier("genericFormat"), new ArrayList<>());
      genericformat.genericFormat = true;
      genericformat.attributes.add(pubKeyPK);
      genericformat.attributes.add(issuerTrustScheme);

      AttributeValuePair certificateGenericformat = new AttributeValuePair(new AttributeNamePair("certificate"), genericformat);
      AttributeValuePair signaturePK = new AttributeValuePair(new AttributeNamePair("signature"), PKvar);

      attributes.push(certificateGenericformat);
      attributes.push(signaturePK);

      String tpl2 = fAttlistAttlevel(attributes, formvar);
      tpl += tpl2;
      return tpl;

    } else if (attribute.equals("signature") && value instanceof TrustschemeX) {
      AttributeValuePair issuerTrustScheme = new AttributeValuePair(new AttributeNamePair("issuer"), new ClaimTrustList(value));

      Variable PKvar = new Variable(createNewVariable("PK"));
      AttributeValuePair pubKeyPK = new AttributeValuePair(new AttributeNamePair("pubKey"), PKvar);

      Form genericformat = new Form(new Identifier("genericFormat"), new ArrayList<>());
      genericformat.genericFormat = true;
      genericformat.attributes.add(pubKeyPK);
      genericformat.attributes.add(issuerTrustScheme);

      AttributeValuePair certificateGenericformat = new AttributeValuePair(new AttributeNamePair("certificate"), genericformat);
      AttributeValuePair signaturePK = new AttributeValuePair(new AttributeNamePair("signature"), PKvar);

      attributes.push(certificateGenericformat);
      attributes.push(signaturePK);

      String tpl2 = fAttlistAttlevel(attributes, formvar);
      tpl += tpl2;
      return tpl;

    } else if (attribute.equals("issuer") && value instanceof ClaimTrustList
        && ((ClaimTrustList) value).trustListValue instanceof Trustscheme
        && ((ClaimTrustList) value).form == null) {
      Variable PKvar = new Variable(createNewVariable("PKIss"));

      ArrayList<AttributeValuePair> genericFormatAttributes = new ArrayList<>();
      genericFormatAttributes.add(new AttributeValuePair(new AttributeNamePair("pubKey"), PKvar));
      Form genericFormat = new Form(new Identifier("genericFormat"), genericFormatAttributes);
      genericFormat.genericFormat = true;
      Valuetype trustscheme = ((ClaimTrustList) value).trustListValue;
      ClaimTrustList valueGenericFormat = new ClaimTrustList(trustscheme, genericFormat);
      AttributeValuePair trustSchemeValueGenericFormat = new AttributeValuePair(new AttributeNamePair("issuer"), valueGenericFormat);
      AttributeValuePair signaturePK = new AttributeValuePair(new AttributeNamePair("signature"), PKvar);
      attributes.push(signaturePK);
      attributes.push(trustSchemeValueGenericFormat);
      tpl += fAttlistAttlevel(attributes, formvar);
      return tpl;

    } else if (attribute.equals("issuer") && value instanceof ClaimTrustList
        && ((ClaimTrustList) value).trustListValue instanceof TrustschemeX
        && ((ClaimTrustList) value).form == null) {
      Variable PKvar = new Variable(createNewVariable("PKIss"));

      ArrayList<AttributeValuePair> genericFormatAttributes = new ArrayList<>();
      genericFormatAttributes.add(new AttributeValuePair(new AttributeNamePair("pubKey"), PKvar));
      Form genericFormat = new Form(new Identifier("genericFormat"), genericFormatAttributes);
      genericFormat.genericFormat = true;
      Valuetype trustscheme = ((ClaimTrustList) value).trustListValue;
      ClaimTrustList valueGenericFormat = new ClaimTrustList(trustscheme, genericFormat);
      AttributeValuePair trustSchemeValueGenericFormat = new AttributeValuePair(new AttributeNamePair("issuer"), valueGenericFormat);
      AttributeValuePair signaturePK = new AttributeValuePair(new AttributeNamePair("signature"), PKvar);
      attributes.push(signaturePK);
      attributes.push(trustSchemeValueGenericFormat);
      tpl += fAttlistAttlevel(attributes, formvar);
      return tpl;

    } else if (attribute.equals("issuer") && value instanceof ClaimTrustList
        && ((ClaimTrustList) value).trustListValue instanceof Trustscheme
        && ((ClaimTrustList) value).form != null) {
      String TrustMemClaim = createNewVariable("TrustMemClaim");
      String TrustListEntry = createNewVariable("TrustListEntry");
      String IssuerCertificate = createNewVariable("Issuer");

      tpl += "    ,extract(" + formvar + ",issuer," + IssuerCertificate + ")\n";
      tpl += "    ,extract(" + IssuerCertificate + ",trustScheme," + TrustMemClaim + ")\n";
      tpl += "    ,trustscheme(" + TrustMemClaim + "," + ((Trustscheme) ((ClaimTrustList) value).trustListValue).value + ")\n";
      tpl += "    ,trustlist(" + TrustMemClaim + "," + IssuerCertificate + "," + TrustListEntry + ")\n";
      tpl += fAttlistFormlevel(((ClaimTrustList) value).form, TrustListEntry);
      tpl += fAttlistAttlevel(attributes, formvar);
      return tpl;

    } else if (attribute.equals("issuer") && value instanceof ClaimTrustList
        && ((ClaimTrustList) value).trustListValue instanceof TrustschemeX
        && ((ClaimTrustList) value).form != null) {
      String TrustMemClaim = createNewVariable("TrustMemClaim");
      String TrustListEntry = createNewVariable("TrustListEntry");
      String IssuerCertificate = createNewVariable("Issuer");

      tpl += "    ,extract(" + formvar + ",issuer," + IssuerCertificate + ")\n";
      tpl += "    ,extract(" + IssuerCertificate + ",trustScheme," + TrustMemClaim + ")\n";
      tpl += "    ,trustschemeX(" + IssuerCertificate + "," + ((TrustschemeX) ((ClaimTrustList) value).trustListValue).value + "," + TrustListEntry + ")\n";
      tpl += fAttlistFormlevel(((ClaimTrustList) value).form, TrustListEntry);
      tpl += fAttlistAttlevel(attributes, formvar);
      return tpl;
    } else if (attribute.equals("delegation") && value instanceof Trustscheme) {
      String Delegation = createNewVariable("Delegation");
      tpl += "    ,extract(" + formvar + ",delegation," + Delegation + ")\n";
      tpl += "    ,extract(" + Delegation + ",format," + "'delegationxml'" + ")\n";
      tpl += "    ,checkMandate(" + Delegation + "," + formvar + ")\n";
      tpl += "    ,checkMandatorKey(" + Delegation + "," + ((Trustscheme) value).value + ")\n";
      tpl += "    ,validDelegation(" + Delegation + ")\n";
      tpl += fAttlistAttlevel(attributes, formvar);
      return tpl;

    } else if (value instanceof Variable) {
      tpl += "    ,extract(" + formvar + "," + attribute + "," + ((Variable) value).variable + ")\n";
      tpl += fAttlistAttlevel(attributes, formvar);
      return tpl;

    } else if (value instanceof Value) {
      tpl += "    ,extract(" + formvar + "," + attribute + "," + ((Value) value).value + ")\n";
      tpl += fAttlistAttlevel(attributes, formvar);
      return tpl;

    } else if (value instanceof Int) {
      tpl += "    ,extract(" + formvar + "," + attribute + "," + ((Int) value).value + ")\n";
      tpl += fAttlistAttlevel(attributes, formvar);
      return tpl;

    } else if (value instanceof CompValue) {
      String newVariable = createNewVariable(capitalize(attribute));
      tpl += "    ,extract(" + formvar + "," + attribute + "," + newVariable + "),"
          + newVariable + ((CompValue) value).comp + ((CompValue) value).value + "\n";
      tpl += fAttlistAttlevel(attributes, formvar);
      return tpl;

    } else if (value instanceof Form) {
      String subForm = createNewVariable(capitalize(attribute));
      tpl += "    ,extract(" + formvar + "," + attribute + "," + subForm + ")\n";
      tpl += fAttlistFormlevel((Form) value, subForm);
      tpl += fAttlistAttlevel(attributes, formvar);
      return tpl;

    } else if (value instanceof ClaimTrustList && ((ClaimTrustList) value).trustListValue instanceof Blank) {
      tpl += fAttlistAttlevel(attributes, formvar);
      return tpl;

    } else if (value instanceof AddableField){
      tpl += fAttlistAttlevel(attributes, formvar);
      return tpl;
    }
    throw new RuntimeException("Attribute value pair was not expected. Attribute: " + attribute + " Value: " + value.getClass());
  }

  private static ArrayList<AttributeValuePair> singleton(AttributeValuePair e) {
    ArrayList<AttributeValuePair> l = new ArrayList<>();
    l.add(e);
    return l;
  }

  private static String capitalize(String s) {
    if (s.length() == 0) {
      return s;
    } else if (s.length() == 1) {
      return s.toUpperCase();
    }
    return s.substring(0, 1).toUpperCase() + s.substring(1);
  }

  private Stack<AttributeValuePair> createStack(ArrayList<AttributeValuePair> attributes) {
    Stack<AttributeValuePair> atts = new Stack<>();
    for (int i = attributes.size() - 1; i > -1; i--) {
      atts.add(attributes.get(i));
    }
    return atts;
  }
}
