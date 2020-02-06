package eu.lightest.gtpl.tools;

import eu.lightest.gtpl.datatype.AST;
import eu.lightest.gtpl.datatype.Form;
import eu.lightest.gtpl.datatype.Forms;
import eu.lightest.gtpl.parser.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * @author bnia, andschl
 */
public class NL2TPLTools {
  public static String translateToTPLinternally(String TranslatedToClearText) throws nlException {
    CharStream input = CharStreams.fromString(TranslatedToClearText);
    String tpl = translateCharStream(input);
    System.out.println(tpl);
    return tpl;
  }

  public static String translateCharStreamWithLibrary(CharStream input) throws nlException {
    String s = translateCharStream(input);
    s += addLibrary();
    return s;
  }

  public static String addLibrary() {
    String s = "trustschemeX(IssuerCert, TrustedScheme, TrustListEntry) :-\n"+
        "    extract(IssuerCert, trustscheme, Claim),\n"+
        "    trustlist(Claim, IssuerCert, TrustListEntry),\n"+
        "    trustscheme(Claim, TrustedScheme).\n"+
        "\n"+
        "trustschemeX(IssuerCert, TrustedScheme, TrustedTrustListEntry) :-\n"+
        "    extract(IssuerCert, trustscheme, Claim),\n"+
        "    trustlist(Claim, IssuerCert, TrustListEntry),\n"+
        "    encode_translation_domain(Claim, TrustedScheme, TTAdomain),\n"+
        "    lookup(TTAdomain, TranslationEntry),\n"+
        "    translate(TranslationEntry, TrustListEntry, TrustedTrustListEntry).\n"+
        "\n"+
        "checkMandate(Delegation, Transaction) :-\n" +
        "    extract(Delegation, proxyCert, ProxyCert),\n" +
        "    extract(ProxyCert, proxyKey, PkSig),\n" +
        "    verify_signature(Transaction, PkSig),\n" +
        "    extract(Delegation, mandatorCert, MandatorCert),\n" +
        "    extract(MandatorCert, mandatorKey, PkMandator),\n" +
        "    verify_signature(Delegation, PkMandator).\n" +
        "\n" +
        "checkMandatorKey(Delegation,TrustScheme) :-\n" +
        "    extract(Delegation, mandatorCert, MandatorCert),\n" +
        "    extract(MandatorCert, trustScheme, TrustSchemeClaim),\n" +
        "    trustscheme(TrustSchemeClaim, TrustScheme),\n" +
        "    trustlist(TrustSchemeClaim, MandatorCert, TrustListEntry),\n" +
        "    extract(TrustListEntry, format, generic_trustlist_format),\n" +
        "    extract(TrustListEntry, pubKey, PkIss),\n" +
        "    verify_signature(MandatorCert, PkIss).\n" +
        "\n" +
        "checkValidDelegation(Delegation) :-\n" +
        "    extract(Delegation, delegationProvider, DP),\n" +
        "    lookup(DP, DPEntry),\n" +
        "    extract(DPEntry, format, dp_format),\n" +
        "    extract(DPEntry, fingerprint, HMandate),\n" +
        "    verify_hash(Delegation, HMandate).\n" +
        "\n";
    return s;
  }

  public static String translateCharStream(CharStream input) throws nlException {
    // create a lexer/scanner
    nlLexer lex = new nlLexer(input);

    // get the stream of tokens from the scanner
    CommonTokenStream tokens = new CommonTokenStream(lex);

    // create a parser
    nlParser parser = new nlParser(tokens);

    // look for errors
    nlErrorListener l = new nlErrorListener();
    parser.addErrorListener(l);

    // and parse anything from the grammar for "nl"
    ParseTree parseTree = parser.nl();

    // look for errors
    if (parser.getNumberOfSyntaxErrors() > 0) {
      throw (new nlException() {
        @Override
        public String getMessage() {
          return l.getErrors().get(0);
        }

        @Override
        public String getLocalizedMessage() {
          return l.getErrors().get(0);
        }

        @Override
        public String toString() {
          return l.getErrors().get(0);
        }
      });
    }

    // Construct an interpreter and run it on the parse tree
    nlFormatMaker formatMaker = new nlFormatMaker();
    AST format = formatMaker.visit(parseTree);

    TranslationFormat2Tpl translation = new TranslationFormat2Tpl();

    String tpl = "";
    for(Form form : ((Forms)format).forms){
      tpl += translation.translationToplevel(form);
    }
    return tpl;
  }
}
