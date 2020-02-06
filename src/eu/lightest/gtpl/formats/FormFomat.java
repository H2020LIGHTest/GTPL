/* FormFormat.java 
 *
 * Copyright (C) 2020
 * Copyright (C) DTU(Technical University of Denmark) 2020
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the Apache license.  See the LICENSE.txt file for details.
 */
package eu.lightest.gtpl.formats;

import eu.lightest.gtpl.datatype.AddableField;
import eu.lightest.gtpl.datatype.AttributeNamePair;
import eu.lightest.gtpl.datatype.AttributeValuePair;
import eu.lightest.gtpl.datatype.Blank;
import eu.lightest.gtpl.datatype.ClaimTrustList;
import eu.lightest.gtpl.datatype.Form;
import eu.lightest.gtpl.datatype.Identifier;
import eu.lightest.gtpl.datatype.Valuetype;

import java.util.ArrayList;

/**
 *
 * @author bnia, samo
 */
public class FormFomat implements Format{

  // formats
  // formats
  public Form testuniapplication() {
    Identifier identifier = new Identifier("Test University Application","testuniapplication");
    Form TestUniApplication = new Form(identifier);

    AttributeNamePair name = new AttributeNamePair("Applicant Name","bearername");
    Valuetype value_name = new Blank();

    AttributeNamePair line = new AttributeNamePair("Study Line","studyline");
    Valuetype value_line = new Blank();

    AttributeNamePair certificate = new AttributeNamePair("High School Diploma","certificate");
    Valuetype variable_certificate = new AddableField();

    AttributeNamePair namePair_signature = new AttributeNamePair("Applicant Signature","signature");
    Valuetype variable_signature = new Blank();

    AttributeValuePair attValuePairs_name = new AttributeValuePair(name,value_name);
    AttributeValuePair attValuePairs_line = new AttributeValuePair(line,value_line);
    AttributeValuePair attValuePairs_certificate = new AttributeValuePair(certificate,variable_certificate);
    AttributeValuePair attValuePairs_signature = new AttributeValuePair(namePair_signature,variable_signature);

    TestUniApplication.attributes.add(attValuePairs_name);
    TestUniApplication.attributes.add(attValuePairs_line);

    TestUniApplication.attributes.add(attValuePairs_signature);
    TestUniApplication.attributes.add(attValuePairs_certificate);

    return TestUniApplication;

  }

  public Form unhcrdemo() {
    Identifier identifier = new Identifier("UNHCR Edu Certificate (Draft/Proposal)","unhcrCert");
    Form formUNHCRdemo = new Form(identifier);

    AttributeNamePair name = new AttributeNamePair("Bearer Name","bearername");
    Valuetype value_name = new Blank();

    AttributeNamePair ident = new AttributeNamePair("Unique Identifier","identifier");
    Valuetype value_ident = new Blank();

    AttributeNamePair identLoA = new AttributeNamePair("Identity LoA","identLoA");
    Valuetype value_identLoA = new Blank();


    AttributeNamePair scan = new AttributeNamePair("Diploma Scan","scan");
    Valuetype value_scan = new AddableField();
    AttributeNamePair diplomaLoA = new AttributeNamePair("Level of Assurance","LoA");
    Valuetype value_diplomaLoA = new Blank();

    AttributeNamePair userLevel = new AttributeNamePair("User Level","userlevel");
    Valuetype value_userLevel = new Blank();

    AttributeNamePair certificate = new AttributeNamePair("Certificate","certificate");
    Valuetype variable_certificate = new Blank();



    AttributeValuePair attValuePairs_name = new AttributeValuePair(name,value_name);
    AttributeValuePair attValuePairs_ident = new AttributeValuePair(ident,value_ident);
    AttributeValuePair attValuePairs_identLoA = new AttributeValuePair(identLoA,value_identLoA);
    //AttributeValuePair attValuePairs_userLevel = new AttributeValuePair(userLevel,value_userLevel);

    AttributeValuePair attValuePairs_certificate = new AttributeValuePair(certificate,variable_certificate);

    AttributeValuePair attValuePairs_scan = new AttributeValuePair(scan,value_scan);
    AttributeValuePair attValuePairs_diplomaLoA = new AttributeValuePair(diplomaLoA,value_diplomaLoA);

    formUNHCRdemo.attributes.add(attValuePairs_name);
    formUNHCRdemo.attributes.add(attValuePairs_ident);
    formUNHCRdemo.attributes.add(attValuePairs_identLoA);

    formUNHCRdemo.attributes.add(attValuePairs_scan);
    formUNHCRdemo.attributes.add(attValuePairs_diplomaLoA);
    //formUNHCRdemo.attributes.add(attValuePairs_userLevel);
    formUNHCRdemo.attributes.add(attValuePairs_certificate);

    return formUNHCRdemo;
  }

  public Form theAuctionHouse2019format() {
    Identifier identifier = new Identifier("The Auction House 2020","theActionHouse2020format");
    Form formAuctionHouse2019 = new Form(identifier);

    AttributeNamePair namePair_bidderName = new AttributeNamePair("Bidder Name","biddername");
    Valuetype value_bidderName = new Blank();
    AttributeNamePair namePair_userLevel = new AttributeNamePair("User Level","userlevel");
    Valuetype value_userLevel = new Blank();
    AttributeNamePair namePair_street = new AttributeNamePair("Street","street");
    Valuetype value_street = new Blank();
    AttributeNamePair namePair_city = new AttributeNamePair("City","city");
    Valuetype value_city = new Blank();
    AttributeNamePair namePair_country = new AttributeNamePair("Country","country");
    Valuetype value_country = new Blank();
    AttributeNamePair namePair_lotnumber = new AttributeNamePair("Lot Number","lotnumber");
    Valuetype value_lotnumber = new Blank();
    AttributeNamePair namePair_bid = new AttributeNamePair("Bid","bid");
    Valuetype compValue_bid = new Blank();
    AttributeNamePair namePair_signature = new AttributeNamePair("Signature","signature");
    Valuetype variable_signature = new Blank();
    AttributeNamePair namePair_certificate = new AttributeNamePair("Certificate","certificate");
    Valuetype variable_certificate = new AddableField();

    AttributeValuePair attValuePairs_biddername = new AttributeValuePair(namePair_bidderName,value_bidderName);
    AttributeValuePair attValuePairs_userLevel = new AttributeValuePair(namePair_userLevel,value_userLevel);
    AttributeValuePair attValuePairs_street = new AttributeValuePair(namePair_street,value_street);
    AttributeValuePair attValuePairs_city = new AttributeValuePair(namePair_city,value_city);
    AttributeValuePair attValuePairs_country = new AttributeValuePair(namePair_country,value_country);
    AttributeValuePair attValuePairs_lotnumber = new AttributeValuePair(namePair_lotnumber,value_lotnumber);
    AttributeValuePair attValuePairs_bid = new AttributeValuePair(namePair_bid,compValue_bid);
    AttributeValuePair attValuePairs_signature = new AttributeValuePair(namePair_signature,variable_signature);
    AttributeValuePair attValuePairs_certificate = new AttributeValuePair(namePair_certificate,variable_certificate);

    formAuctionHouse2019.attributes.add(attValuePairs_biddername);
    formAuctionHouse2019.attributes.add(attValuePairs_userLevel);
    formAuctionHouse2019.attributes.add(attValuePairs_street);
    formAuctionHouse2019.attributes.add(attValuePairs_city);
    formAuctionHouse2019.attributes.add(attValuePairs_country);
    formAuctionHouse2019.attributes.add(attValuePairs_lotnumber);
    formAuctionHouse2019.attributes.add(attValuePairs_bid);
    formAuctionHouse2019.attributes.add(attValuePairs_signature);
    formAuctionHouse2019.attributes.add(attValuePairs_certificate);

    return formAuctionHouse2019;
  }

  public Form theAuctionHouse2018format() {
    Identifier identifier = new Identifier("The Auction House 2018","theActionHouse2018format");
    Form formAuctionHouse2018 = new Form(identifier);

    AttributeNamePair namePair_bidderName = new AttributeNamePair("Bidder Name","biddername");
    Valuetype value_bidderName = new Blank();
    AttributeNamePair namePair_street = new AttributeNamePair("Street","street");
    Valuetype value_street = new Blank();
    AttributeNamePair namePair_city = new AttributeNamePair("City","city");
    Valuetype value_city = new Blank();
    AttributeNamePair namePair_country = new AttributeNamePair("Country","country");
    Valuetype value_country = new Blank();
    AttributeNamePair namePair_lotnumber = new AttributeNamePair("Lot Number","lotnumber");
    Valuetype value_lotnumber = new Blank();
    AttributeNamePair namePair_bid = new AttributeNamePair("Bid","bid");
    Valuetype compValue_bid = new Blank();
    AttributeNamePair namePair_signature = new AttributeNamePair("Signature","signature");
    Valuetype variable_signature = new Blank();
    AttributeNamePair namePair_certificate = new AttributeNamePair("Certificate","certificate");
    Valuetype variable_certificate = new AddableField();

    AttributeValuePair attValuePairs_biddername = new AttributeValuePair(namePair_bidderName,value_bidderName);
    AttributeValuePair attValuePairs_street = new AttributeValuePair(namePair_street,value_street);
    AttributeValuePair attValuePairs_city = new AttributeValuePair(namePair_city,value_city);
    AttributeValuePair attValuePairs_country = new AttributeValuePair(namePair_country,value_country);
    AttributeValuePair attValuePairs_lotnumber = new AttributeValuePair(namePair_lotnumber,value_lotnumber);
    AttributeValuePair attValuePairs_bid = new AttributeValuePair(namePair_bid,compValue_bid);
    AttributeValuePair attValuePairs_signature = new AttributeValuePair(namePair_signature,variable_signature);
    AttributeValuePair attValuePairs_certificate = new AttributeValuePair(namePair_certificate,variable_certificate);

    formAuctionHouse2018.attributes.add(attValuePairs_biddername);
    formAuctionHouse2018.attributes.add(attValuePairs_street);
    formAuctionHouse2018.attributes.add(attValuePairs_city);
    formAuctionHouse2018.attributes.add(attValuePairs_country);
    formAuctionHouse2018.attributes.add(attValuePairs_lotnumber);
    formAuctionHouse2018.attributes.add(attValuePairs_bid);
    formAuctionHouse2018.attributes.add(attValuePairs_signature);
    formAuctionHouse2018.attributes.add(attValuePairs_certificate);

    return formAuctionHouse2018;
  }

  public Form theAuctionHousePlatformformat() {
    Identifier identifier = new Identifier("The Auction House Platform","theActionHousePlatformformat");
    Form formAuctionHousePlatform = new Form(identifier);

    AttributeNamePair namePair_userName = new AttributeNamePair("User Name","username");
    Valuetype value_userName = new Blank();
    AttributeNamePair namePair_userLevel = new AttributeNamePair("User Level","userLevel");
    Valuetype value_userLevel = new Blank();
    AttributeNamePair namePair_street = new AttributeNamePair("Street","street");
    Valuetype value_street = new Blank();
    AttributeNamePair namePair_city = new AttributeNamePair("City","city");
    Valuetype value_city = new Blank();
    AttributeNamePair namePair_country = new AttributeNamePair("Country","country");
    Valuetype value_country = new Blank();
    AttributeNamePair namePair_auctionID = new AttributeNamePair("AuctionID","auctionID");
    Valuetype value_auctionID = new Blank();
    AttributeNamePair namePair_lotnumber = new AttributeNamePair("Lot Number","lotnumber");
    Valuetype value_lotnumber = new Blank();
    AttributeNamePair namePair_bid = new AttributeNamePair("Bid","bid");
    Valuetype compValue_bid = new Blank();
    AttributeNamePair namePair_signature = new AttributeNamePair("Signature","signature");
    Valuetype variable_signature = new Blank();

    AttributeValuePair attValuePairs_username = new AttributeValuePair(namePair_userName,value_userName);
    AttributeValuePair attValuePairs_userlevel = new AttributeValuePair(namePair_userLevel,value_userLevel);
    AttributeValuePair attValuePairs_street = new AttributeValuePair(namePair_street,value_street);
    AttributeValuePair attValuePairs_city = new AttributeValuePair(namePair_city,value_city);
    AttributeValuePair attValuePairs_country = new AttributeValuePair(namePair_country,value_country);
    AttributeValuePair attValuePairs_auctionid = new AttributeValuePair(namePair_auctionID,value_auctionID);
    AttributeValuePair attValuePairs_lotnumber = new AttributeValuePair(namePair_lotnumber,value_lotnumber);
    AttributeValuePair attValuePairs_bid = new AttributeValuePair(namePair_bid,compValue_bid);
    AttributeValuePair attValuePairs_signature = new AttributeValuePair(namePair_signature,variable_signature);

    formAuctionHousePlatform.attributes.add(attValuePairs_username);
    formAuctionHousePlatform.attributes.add(attValuePairs_userlevel);
    formAuctionHousePlatform.attributes.add(attValuePairs_street);
    formAuctionHousePlatform.attributes.add(attValuePairs_city);
    formAuctionHousePlatform.attributes.add(attValuePairs_country);
    formAuctionHousePlatform.attributes.add(attValuePairs_auctionid);
    formAuctionHousePlatform.attributes.add(attValuePairs_lotnumber);
    formAuctionHousePlatform.attributes.add(attValuePairs_bid);
    formAuctionHousePlatform.attributes.add(attValuePairs_signature);

    return formAuctionHousePlatform;
  }


  // Certificates
  public Form eIDASformat() {
    Identifier identifierCertificate = new Identifier("eIDAS Certificate","eIDAS_qualified_certificate");
    Form certificate_eIDAS = new Form(identifierCertificate);

    AttributeNamePair namePair_issuer_name = new AttributeNamePair("issuer name","issuer_name");
    Blank value_issuer_name = new Blank();
    AttributeNamePair namePair_bearer = new AttributeNamePair("bearer","bearer");
    Blank value_bearer = new Blank();
    AttributeNamePair namePair_pubKey = new AttributeNamePair("pubKey","pubKey");
    Blank value_pubKey = new Blank();

    AttributeNamePair namePair_trustScheme = new AttributeNamePair("trustScheme","trustScheme");
    ArrayList<Form> trustListEntry = new ArrayList<>();
    trustListEntry.add(eIDASformatClaim());
    AttributeNamePair namePair_issuer = new AttributeNamePair("issuer","issuer");
    ClaimTrustList value_issuer = new ClaimTrustList(new Blank(),trustListEntry);

    AttributeNamePair namePair_signature = new AttributeNamePair("Signature","signature");
    Blank value_signature = new Blank();

    AttributeValuePair attValuePairs_issuer_name = new AttributeValuePair(namePair_issuer_name,value_issuer_name);
    AttributeValuePair attValuePairs_bearer = new AttributeValuePair(namePair_bearer,value_bearer);
    AttributeValuePair attValuePairs_pubKey = new AttributeValuePair(namePair_pubKey,value_pubKey);
    AttributeValuePair attValuePairs_issuer = new AttributeValuePair(namePair_issuer,value_issuer);
    AttributeValuePair attValuePairs_signature = new AttributeValuePair(namePair_signature,value_signature);

    certificate_eIDAS.attributes.add(attValuePairs_issuer_name);
    certificate_eIDAS.attributes.add(attValuePairs_bearer);
    certificate_eIDAS.attributes.add(attValuePairs_pubKey);
    certificate_eIDAS.attributes.add(attValuePairs_issuer);
    certificate_eIDAS.attributes.add(attValuePairs_signature);

    return certificate_eIDAS;
  }


  public Form platformUserCertificate() {
    Identifier identifier = new Identifier("Platform User Certificate","theActionHousePlatformformat");
    Form formPlatformUserCertificate = new Form(identifier);

    AttributeNamePair namePair_userName = new AttributeNamePair("User Name","biddername");
    Valuetype value_userName = new Blank();
    AttributeNamePair namePair_userLevel = new AttributeNamePair("User Level","userLevel");
    Valuetype value_userLevel = new Blank();
    AttributeNamePair namePair_street = new AttributeNamePair("Street","street");
    Valuetype value_street = new Blank();
    AttributeNamePair namePair_city = new AttributeNamePair("City","city");
    Valuetype value_city = new Blank();
    AttributeNamePair namePair_country = new AttributeNamePair("Country","country");
    Valuetype value_country = new Blank();
    AttributeNamePair namePair_publicKey = new AttributeNamePair("Publickey","publickey");
    Valuetype compValue_publicKey = new Blank();
    AttributeNamePair namePair_signature = new AttributeNamePair("Signature","signature");
    Valuetype variable_signature = new Blank();

    AttributeValuePair attValuePairs_username = new AttributeValuePair(namePair_userName,value_userName);
    AttributeValuePair attValuePairs_userlevel = new AttributeValuePair(namePair_userLevel,value_userLevel);
    AttributeValuePair attValuePairs_street = new AttributeValuePair(namePair_street,value_street);
    AttributeValuePair attValuePairs_city = new AttributeValuePair(namePair_city,value_city);
    AttributeValuePair attValuePairs_country = new AttributeValuePair(namePair_country,value_country);
    AttributeValuePair attValuePairs_publicKey = new AttributeValuePair(namePair_publicKey,compValue_publicKey);
    AttributeValuePair attValuePairs_signature = new AttributeValuePair(namePair_signature,variable_signature);

    formPlatformUserCertificate.attributes.add(attValuePairs_username);
    formPlatformUserCertificate.attributes.add(attValuePairs_userlevel);
    formPlatformUserCertificate.attributes.add(attValuePairs_street);
    formPlatformUserCertificate.attributes.add(attValuePairs_city);
    formPlatformUserCertificate.attributes.add(attValuePairs_country);
    formPlatformUserCertificate.attributes.add(attValuePairs_publicKey);
    formPlatformUserCertificate.attributes.add(attValuePairs_signature);

    return formPlatformUserCertificate;
  }


  public Form generalCertificateformat() {
    Identifier identifierCertificate = new Identifier("Certificate","generic_certificate");
    Form certificate_eIDAS = new Form(identifierCertificate);

    AttributeNamePair namePair_issuer_name = new AttributeNamePair("issuer name","issuer_name");
    Blank value_issuer_name = new Blank();
    AttributeNamePair namePair_bearer = new AttributeNamePair("bearer","bearer");
    Blank value_bearer = new Blank();
    AttributeNamePair namePair_pubKey = new AttributeNamePair("pubKey","pubKey");
    Blank value_pubKey = new Blank();
    AttributeNamePair namePair_userLevel = new AttributeNamePair("User level","userLevel");
    Blank value_userLevel = new Blank();

    ArrayList<Form> trustListEntry = new ArrayList<>();
    trustListEntry.add(eIDASformatClaim());
    AttributeNamePair namePair_issuer = new AttributeNamePair("issuer","issuer");
    ClaimTrustList value_issuer = new ClaimTrustList(new Blank(),trustListEntry);

    AttributeNamePair namePair_signature = new AttributeNamePair("Signature","signature");
    Blank value_signature = new Blank();

    AttributeValuePair attValuePairs_issuer_name = new AttributeValuePair(namePair_issuer_name,value_issuer_name);
    AttributeValuePair attValuePairs_bearer = new AttributeValuePair(namePair_bearer,value_bearer);
    AttributeValuePair attValuePairs_pubKey = new AttributeValuePair(namePair_pubKey,value_pubKey);
    AttributeValuePair attValuePairs_userLevel = new AttributeValuePair(namePair_userLevel,value_userLevel);
    AttributeValuePair attValuePairs_issuer = new AttributeValuePair(namePair_issuer,value_issuer);
    AttributeValuePair attValuePairs_signature = new AttributeValuePair(namePair_signature,value_signature);

    certificate_eIDAS.attributes.add(attValuePairs_issuer_name);
    certificate_eIDAS.attributes.add(attValuePairs_bearer);
    certificate_eIDAS.attributes.add(attValuePairs_pubKey);
    certificate_eIDAS.attributes.add(attValuePairs_userLevel);
    certificate_eIDAS.attributes.add(attValuePairs_issuer);
    certificate_eIDAS.attributes.add(attValuePairs_signature);

    return certificate_eIDAS;
  }

  public Form delegationMandate() {
    Identifier identifierProxy = new Identifier("Mandate","delegation");
    Form delegation_Proxy = new Form(identifierProxy);

    AttributeNamePair namePair_proxyKey = new AttributeNamePair("Proxy Key","proxyKey");
    Blank value_proxyKey = new Blank();
    AttributeNamePair namePair_purpose = new AttributeNamePair("Purpose","purpose");
    Blank value_purpose = new Blank();
    AttributeNamePair namePair_issuer = new AttributeNamePair("Issuer","issuer");
    //Blank value_issuer = new Blank();
    ArrayList<Form> trustListEntry_issuer = new ArrayList<>();
    trustListEntry_issuer.add(eIDASformatClaim());
    ClaimTrustList value_trustLis_issuer = new ClaimTrustList(new Blank(),trustListEntry_issuer);
    AttributeNamePair namePair_signature = new AttributeNamePair("Signature","signature");
    Blank value_signature = new Blank();
    AttributeNamePair namePair_delegaionProvider = new AttributeNamePair("Delegation Provider","delegationProvider");
    ArrayList<Form> trustListEntry_delegationProvider = new ArrayList<>();
    trustListEntry_delegationProvider.add(delegationProviderClaim());
    ClaimTrustList value_trustLis_delegationProvidert = new ClaimTrustList(new Blank(),trustListEntry_delegationProvider);
    //AttributeNamePair namePair_hash_mandate = new AttributeNamePair("Hash Mandate","hash_mandate");
    //Blank value_hash_mandate = new Blank();

    // AttributeNamePair namePair_certificate = new AttributeNamePair("Certificate","certificate");
    // Valuetype variable_certificate = new AddableField();

    AttributeValuePair attValuePairs_proxyKey = new AttributeValuePair(namePair_proxyKey,value_proxyKey);
    AttributeValuePair attValuePairs_issuer = new AttributeValuePair(namePair_issuer,value_trustLis_issuer);
    AttributeValuePair attValuePairs_purpose = new AttributeValuePair(namePair_purpose,value_purpose);
    AttributeValuePair attValuePairs_signature = new AttributeValuePair(namePair_signature,value_signature);
    AttributeValuePair attValuePairs_delegaionProvider = new AttributeValuePair(namePair_delegaionProvider,value_trustLis_delegationProvidert);
    //AttributeValuePair attValuePairs_hash_mandate = new AttributeValuePair(namePair_hash_mandate,value_hash_mandate);

    //AttributeValuePair attValuePairs_value_certificate = new AttributeValuePair(namePair_certificate,variable_certificate);

    delegation_Proxy.attributes.add(attValuePairs_proxyKey);
    delegation_Proxy.attributes.add(attValuePairs_purpose);
    delegation_Proxy.attributes.add(attValuePairs_issuer);
    delegation_Proxy.attributes.add(attValuePairs_signature);
    delegation_Proxy.attributes.add(attValuePairs_delegaionProvider);
    //delegation_Proxy.attributes.add(attValuePairs_hash_mandate);

    //delegation_Proxy.attributes.add(attValuePairs_value_certificate);

    return delegation_Proxy;
  }

  public Form generalCertificateformat2() {
    Identifier identifierCertificate = new Identifier("Certificate2","generic_certificate");
    Form certificate_eIDAS = new Form(identifierCertificate);

    AttributeNamePair namePair_issuer_name = new AttributeNamePair("issuer name","issuer_name");
    Blank value_issuer_name = new Blank();
    AttributeNamePair namePair_bearer = new AttributeNamePair("bearer","bearer");
    Blank value_bearer = new Blank();
    AttributeNamePair namePair_pubKey = new AttributeNamePair("pubKey","pubKey");
    Blank value_pubKey = new Blank();
    AttributeNamePair namePair_userLevel = new AttributeNamePair("User level","userLevel");
    Blank value_userLevel = new Blank();

    ArrayList<Form> trustListEntry = new ArrayList<>();
    trustListEntry.add(eIDASformatClaim());
    AttributeNamePair namePair_issuer = new AttributeNamePair("issuer","issuer");
    ClaimTrustList value_issuer = new ClaimTrustList(new Blank(),trustListEntry);

    AttributeNamePair namePair_signature = new AttributeNamePair("Signature","signature");
    Blank value_signature = new Blank();
    AttributeNamePair namePair_certificate = new AttributeNamePair("Certificate","certificate");
    Valuetype variable_certificate = new AddableField();

    AttributeValuePair attValuePairs_issuer_name = new AttributeValuePair(namePair_issuer_name,value_issuer_name);
    AttributeValuePair attValuePairs_bearer = new AttributeValuePair(namePair_bearer,value_bearer);
    AttributeValuePair attValuePairs_pubKey = new AttributeValuePair(namePair_pubKey,value_pubKey);
    AttributeValuePair attValuePairs_userLevel = new AttributeValuePair(namePair_userLevel,value_userLevel);
    AttributeValuePair attValuePairs_issuer = new AttributeValuePair(namePair_issuer,value_issuer);
    AttributeValuePair attValuePairs_signature = new AttributeValuePair(namePair_signature,value_signature);
    AttributeValuePair attValuePairs_certificate = new AttributeValuePair(namePair_certificate,variable_certificate);

    certificate_eIDAS.attributes.add(attValuePairs_issuer_name);
    certificate_eIDAS.attributes.add(attValuePairs_bearer);
    certificate_eIDAS.attributes.add(attValuePairs_pubKey);
    certificate_eIDAS.attributes.add(attValuePairs_userLevel);
    certificate_eIDAS.attributes.add(attValuePairs_issuer);
    certificate_eIDAS.attributes.add(attValuePairs_signature);
    certificate_eIDAS.attributes.add(attValuePairs_certificate);

    return certificate_eIDAS;
  }


  // Certificates claim
  public Form eIDASformatClaim() {
    Identifier identifiereIDASentry = new Identifier("eIDAS trust list entry","eIDAS_trust_list_entry");
    Form certificate_eIDASentry = new Form(identifiereIDASentry);

    AttributeNamePair namePair_pubKey = new AttributeNamePair("pubKey","pubKey");
    Blank value_pubKey = new Blank();

    AttributeValuePair attValuePairs_pubKey = new AttributeValuePair(namePair_pubKey,value_pubKey);

    certificate_eIDASentry.attributes.add(attValuePairs_pubKey);

    return certificate_eIDASentry;
  }

  public Form genericfomatClaim() {
    Identifier identifierGenericClaim = new Identifier("Trust list entry","generic_trust_list_entry");
    Form certificate_genericClaim = new Form(identifierGenericClaim);

    AttributeNamePair namePair_pubKey = new AttributeNamePair("pubKey","pubKey");
    Blank value_pubKey = new Blank();
    AttributeNamePair namePair_userLevel = new AttributeNamePair("User Level","userLevel");
    Blank value_userLevel = new Blank();

    AttributeValuePair attValuePairs_pubKey = new AttributeValuePair(namePair_pubKey,value_pubKey);
    AttributeValuePair attValuePairs_userLevel = new AttributeValuePair(namePair_userLevel,value_userLevel);

    certificate_genericClaim.attributes.add(attValuePairs_pubKey);
    certificate_genericClaim.attributes.add(attValuePairs_userLevel);

    return certificate_genericClaim;
  }

  public Form delegationProviderClaim() {
    Identifier identifierDelegationProvider= new Identifier("Delegation Provider Entry","delegation_provider_entry");
    Form certificate_delegationProvider = new Form(identifierDelegationProvider);

    AttributeNamePair namePair_fingerprint = new AttributeNamePair("Finger Print","fingerprint");
    Blank value_fingerprint = new Blank();

    AttributeValuePair attValuePairs_fingerprint = new AttributeValuePair(namePair_fingerprint,value_fingerprint);

    certificate_delegationProvider.attributes.add(attValuePairs_fingerprint);

    return certificate_delegationProvider;
  }

  //...............................................
  @Override
  public ArrayList<Form> allFormats() {
    ArrayList<Form> formats = new ArrayList<>();
    formats.add(unhcrdemo());
    formats.add(theAuctionHouse2019format());
    //    formats.add(theAuctionHouse2018format());
    formats.add(theAuctionHousePlatformformat());
    formats.add(testuniapplication());
    return formats;
  }

  @Override
  public ArrayList<Form> allCertificate() {
    ArrayList<Form> formats = new ArrayList<>();
    formats.add(eIDASformat());
    formats.add(generalCertificateformat());
    formats.add(platformUserCertificate());
    formats.add(generalCertificateformat2());
    formats.add(delegationMandate());
    return formats;
  }

}
