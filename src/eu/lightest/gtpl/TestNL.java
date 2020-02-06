package eu.lightest.gtpl;

import eu.lightest.gtpl.parser.nlException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static eu.lightest.gtpl.tools.NL2TPLTools.translateCharStream;

/**
 *
 * @author bnia, andschl
 */
public class TestNL {
  private String testFolder = "src/test/testdata/";

  private String runTest(String filepath) throws IOException {
    //String filename="/Users/bnia/Documents/FM/projects/lightest/NL2tpl/src/main/java/eu/lightest/gtpl/NaturalLanguage.txt";

    // open the input file
    CharStream input = CharStreams.fromFileName(filepath);
    //new ANTLRFileStream (filename); // depricated
    String s = "";
    try{
      s = translateCharStream(input);
    } catch (nlException e) {
      System.out.println("Error when translating to nl: " + e.getMessage());
    }
    return s;
  }

  @Test
  public void testPolicy_onlyFormat(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_onlyFormat.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }

    String expect_tpl = "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'danskebank')\n";
    expect_tpl += "    .\n\n";

    Assert.assertEquals(expect_tpl,outcome);
  }

  @Test
  public void testPolicyTwoPolicies(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_twoPolicies.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }

    String expect_tpl = "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'danskebank')\n";
    expect_tpl += "    ,extract(Form,amount,Amount),Amount>100\n";
    expect_tpl += "    .\n\n";
    expect_tpl += "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'danskebank')\n";
    expect_tpl += "    ,extract(Form,amount,Amount),Amount<10\n";
    expect_tpl += "    .\n\n";

    Assert.assertEquals(expect_tpl,outcome);
  }

  @Test
  public void testPolicy_equals(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_equals.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }

    String expect_tpl = "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'danskebank')\n";
    expect_tpl += "    ,extract(Form,amount,Amount),Amount==100\n";
    expect_tpl += "    .\n\n";

    Assert.assertEquals(expect_tpl,outcome);
  }

  @Test
  public void testPolicy_equals2(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_equals2.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }

    String expect_tpl = "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'danskebank')\n";
    expect_tpl += "    ,extract(Form,name,'Bob')\n";
    expect_tpl += "    .\n\n";

    Assert.assertEquals(expect_tpl,outcome);
  }

  @Test
  public void testPolicy_doesNotEqual(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_doesNotEqual.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }

    String expect_tpl = "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'danskebank')\n";
    expect_tpl += "    ,extract(Form,amount,Amount),Amount!=100\n";
    expect_tpl += "    .\n\n";

    Assert.assertEquals(expect_tpl,outcome);
  }

  @Test
  public void testPolicy_lessThan(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_lessThan.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }

    String expect_tpl = "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'danskebank')\n";
    expect_tpl += "    ,extract(Form,amount,Amount),Amount<100\n";
    expect_tpl += "    .\n\n";

    Assert.assertEquals(expect_tpl,outcome);
  }

  @Test
  public void testPolicy_lessThanOrEqualTo(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_lessThanOrEqualTo.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }

    String expect_tpl = "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'danskebank')\n";
    expect_tpl += "    ,extract(Form,amount,Amount),Amount<=100\n";
    expect_tpl += "    .\n\n";

    Assert.assertEquals(expect_tpl,outcome);
  }

  @Test
  public void testPolicy_GreaterThan(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_greaterThan.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }

    String expect_tpl = "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'danskebank')\n";
    expect_tpl += "    ,extract(Form,amount,Amount),Amount>100\n";
    expect_tpl += "    .\n\n";

    Assert.assertEquals(expect_tpl,outcome);
  }

  @Test
  public void testPolicy_GreaterThanOrEqualTo(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_greaterThanOrEqualTo.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }

    String expect_tpl = "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'danskebank')\n";
    expect_tpl += "    ,extract(Form,amount,Amount),Amount>=100\n";
    expect_tpl += "    .\n\n";

    Assert.assertEquals(expect_tpl,outcome);
  }

  @Test
  public void testPolicy_is(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_is.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }


    String expect_tpl = "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'danskebank')\n";
    expect_tpl += "    ,extract(Form,amount,Amount),Amount<=100\n";
    expect_tpl += "    ,extract(Form,certificate,Certificate)\n";
    expect_tpl += "    ,extract(Certificate,pubKey,PK)\n";
    expect_tpl += "    ,extract(Certificate,issuer,Issuer)\n";
    expect_tpl += "    ,extract(Issuer,trustScheme,TrustMemClaim)\n";
    expect_tpl += "    ,trustscheme(TrustMemClaim,'eIDAS_qualified')\n";
    expect_tpl += "    ,trustlist(TrustMemClaim,Issuer,TrustListEntry)\n";
    expect_tpl += "    ,extract(TrustListEntry,pubKey,PKIss)\n";
    expect_tpl += "    ,verify_signature(Certificate,PKIss)\n";
    expect_tpl += "    ,verify_signature(Form,PK)\n";
    expect_tpl += "    .\n\n";

    Assert.assertEquals(expect_tpl,outcome);
  }

  @Test
  public void testPolicy_is2(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_is2.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }


    String expect_tpl = "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'auctionhouse2018')\n";
    expect_tpl += "    ,extract(Form,bid,Bid),Bid<=100\n";
    expect_tpl += "    ,extract(Form,certificate,Certificate)\n";
    expect_tpl += "    ,extract(Certificate,pubKey,PK)\n";
    expect_tpl += "    ,extract(Certificate,issuer,Issuer)\n";
    expect_tpl += "    ,extract(Issuer,trustScheme,TrustMemClaim)\n";
    expect_tpl += "    ,trustscheme(TrustMemClaim,'eIDAS_qualified')\n";
    expect_tpl += "    ,trustlist(TrustMemClaim,Issuer,TrustListEntry)\n";
    expect_tpl += "    ,extract(TrustListEntry,pubKey,PKIss)\n";
    expect_tpl += "    ,verify_signature(Certificate,PKIss)\n";
    expect_tpl += "    ,verify_signature(Form,PK)\n";
    expect_tpl += "    .\n\n";

    Assert.assertEquals(expect_tpl,outcome);
  }


  @Test
  public void testPolicy_isEquivalentTo(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_isEquivalentTo.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }

    String expect_tpl = "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'danskebank')\n";
    expect_tpl += "    ,extract(Form,amount,Amount),Amount<=100\n";
    expect_tpl += "    ,extract(Form,certificate,Certificate)\n";
    expect_tpl += "    ,extract(Certificate,pubKey,PK)\n";

    expect_tpl += "    ,extract(Certificate,issuer,Issuer)\n";
    expect_tpl += "    ,extract(Issuer,trustScheme,TrustMemClaim)\n";
    expect_tpl += "    ,trustschemeX(Issuer,'eIDAS_qualified',TrustListEntry)\n";
    expect_tpl += "    ,extract(TrustListEntry,pubKey,PKIss)\n";
    expect_tpl += "    ,verify_signature(Certificate,PKIss)\n";
    expect_tpl += "    ,verify_signature(Form,PK)\n";
    expect_tpl += "    .\n\n";

    Assert.assertEquals(expect_tpl,outcome);
  }

  @Test
  public void testPolicy_isEquivalentTo2(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_isEquivalentTo2.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }

    String expect_tpl = "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'danskebank')\n";
    expect_tpl += "    ,extract(Form,certificate,Certificate)\n";
    expect_tpl += "    ,extract(Certificate,pubKey,PK)\n";
    expect_tpl += "    ,extract(Certificate,issuer,Issuer)\n";
    expect_tpl += "    ,extract(Issuer,trustScheme,TrustMemClaim)\n";
    expect_tpl += "    ,trustschemeX(Issuer,'eIDAS_qualified',TrustListEntry)\n";
    expect_tpl += "    ,extract(TrustListEntry,pubKey,PKIss)\n";
    expect_tpl += "    ,verify_signature(Certificate,PKIss)\n";
    expect_tpl += "    ,verify_signature(Form,PK)\n";
    expect_tpl += "    .\n\n";

    Assert.assertEquals(expect_tpl,outcome);

  }

  @Test
  public void testPolicy_isEquivalentTo3(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_isEquivalentTo3.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }

    String expect_tpl = "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'olamFormat2_0')\n";
    expect_tpl += "    ,extract(Form,certificate,Certificate)\n";
    expect_tpl += "    ,extract(Certificate,pubKey,PK)\n";
    expect_tpl += "    ,extract(Certificate,issuer,Issuer)\n";
    expect_tpl += "    ,extract(Issuer,trustScheme,TrustMemClaim)\n";
    expect_tpl += "    ,trustschemeX(Issuer,'eIDAS',TrustListEntry)\n";
    expect_tpl += "    ,extract(TrustListEntry,pubKey,PKIss)\n";
    expect_tpl += "    ,verify_signature(Certificate,PKIss)\n";
    expect_tpl += "    ,verify_signature(Form,PK)\n";
    expect_tpl += "    .\n\n";

    Assert.assertEquals(expect_tpl,outcome);

  }

  @Test
  public void testPolicy_twoConstrainsAndIs(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_twoConstrainsAndIs.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }

    String expect_tpl = "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'danskebank')\n";
    expect_tpl += "    ,extract(Form,amount,Amount),Amount<100\n";
    expect_tpl += "    ,extract(Form,name,'Bob')\n";
    expect_tpl += "    ,extract(Form,certificate,Certificate)\n";
    expect_tpl += "    ,extract(Certificate,pubKey,PK)\n";

    expect_tpl += "    ,extract(Certificate,issuer,Issuer)\n";
    expect_tpl += "    ,extract(Issuer,trustScheme,TrustMemClaim)\n";
    expect_tpl += "    ,trustscheme(TrustMemClaim,'eIDAS_qualified')\n";
    expect_tpl += "    ,trustlist(TrustMemClaim,Issuer,TrustListEntry)\n";
    expect_tpl += "    ,extract(TrustListEntry,pubKey,PKIss)\n";
    expect_tpl += "    ,verify_signature(Certificate,PKIss)\n";
    expect_tpl += "    ,verify_signature(Form,PK)\n";
    expect_tpl += "    .\n\n";

    Assert.assertEquals(expect_tpl,outcome);
  }

  @Test
  public void testPolicy_subform(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_subform.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }

    String expect_tpl = "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'danskebank')\n";
    expect_tpl += "    ,extract(Form,banknote,Banknote)\n";
    expect_tpl += "    ,extract(Banknote,amount,Amount),Amount<=100\n";
    expect_tpl += "    .\n\n";

    Assert.assertEquals(expect_tpl,outcome);
  }

  @Test
  public void testPolicy_subform2(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_subform2.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }

    String expect_tpl = "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'danskebank')\n";
    expect_tpl += "    ,extract(Form,banknote,Banknote)\n";
    expect_tpl += "    ,extract(Banknote,amount,Amount)\n";
    expect_tpl += "    ,extract(Amount,distribution,Distribution),Distribution<=100\n";
    expect_tpl += "    .\n\n";

    Assert.assertEquals(expect_tpl,outcome);
  }

  @Test
  public void testPolicy_sameAttributeInTwoSubforms(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_sameAttributeInTwoSubforms.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }

    String expect_tpl = "accept(Form):-\n";
    expect_tpl += "    extract(Form,format,'danskebank')\n";
    expect_tpl += "    ,extract(Form,cat,Cat)\n";
    expect_tpl += "    ,extract(Cat,amount,Amount),Amount>100\n";
    expect_tpl += "    ,extract(Form,dog,Dog)\n";
    expect_tpl += "    ,extract(Dog,amount,Amount2),Amount2>100\n";
    expect_tpl += "    .\n\n";

    Assert.assertEquals(expect_tpl,outcome);
  }

  @Test
  public void testPolicy_delegation(){
    String outcome = "";
    try {
      outcome = runTest(testFolder + "/NaturalLanguage_delegation.txt");
    }catch (IOException ex){
      ex.printStackTrace();
    }

    String expect_tpl = "accept(Form):-\n" +
        "    extract(Form,format,'danskebank')\n" +
        "    ,extract(Form,delegation,Delegation)\n" +
        "    ,extract(Delegation,format,'delegationxml')\n" +
        "    ,checkMandate(Delegation,Form)\n" +
        "    ,checkMandatorKey(Delegation,'eIDAS')\n" +
        "    ,validDelegation(Delegation)\n" +
        "    .\n" +
        "\n";

    Assert.assertEquals(expect_tpl,outcome);
  }




}
