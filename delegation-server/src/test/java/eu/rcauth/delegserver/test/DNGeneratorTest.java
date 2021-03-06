package eu.rcauth.delegserver.test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import eu.rcauth.delegserver.oauth2.generator.DNGenerator;
import eu.rcauth.delegserver.oauth2.logging.ThreadsafeTraceLogger;
import eu.rcauth.delegserver.oauth2.logging.TraceLoggingFacade;
import eu.rcauth.delegserver.oauth2.util.HashingUtils;
import eu.rcauth.delegserver.storage.TraceRecordIdentifier;
import org.junit.Test;

public class DNGeneratorTest extends DNGenerator {

    public DNGeneratorTest() {
        super(null, null, null, null, new ThreadsafeTraceLogger(new TraceLoggingFacade( Logger.getLogger("Test") )));
    }

    @Test
    public void testGetUSR() {

        //String inputAttr = "sakdfjasoaasdvnasjkvndkjvnajkenvvervrevvvvvvvvv";
        String inputAttr = "32r2róÓÜÓ??'/as.121#($#)($)>>\"\"?vvvvvvvv1212sakd!é!jkenvver";

        String inputUSR = this.getUSR(inputAttr);

        System.out.println("INPUT = " + inputAttr);
        System.out.println("INPUT USR = " + inputUSR);
    }

    @Test
    public void testDNFormatter() {

        String org = "simple.org";
        String cn = "Simple Ton 45Ns0-21aaDX";

        String dn = String.format(DN_OPENSSL_FORMAT, org, cn);
        System.out.println("DN = " + dn);

        String format = "%4.4s %s";
        System.out.println( String.format(format, "ASDZQWE", "bla") );
        System.out.println( String.format(format, "WE", "bla") );
        System.out.println( String.format(format, "AQWE", "bla") );

        String[] split = "asd.asd.asd".split("\\.");
        System.out.println(split.length);
    }

    @Test
    public void testDisplayNameSimplification() {
        String[] input = {
            "Jőzsi Bácsi\uc3a1",
            "Ákom Bákom",
            "T\u00eatu Elpasso",
            "\u8a00\u8a9e \u6e2c\u8a66",
            "оживлённым берегам",
            "君子務本",
            "φάω σπασμένα",
            "þess að meiða",
            "på mig",
            "J'peux manger",
            "kācaṃ śaknomyattum",
            "ὕαλον ϕαγεῖν",
            "Michał Jankowski",
            "Բարեւ աշխարհ", // Armenian
            "გამარჯობა მსოფლიო", // Georgian
            "שולחן", // Hebrew with shin (has problems in Any-Latin/BGN)
            "https://centos7-shibboleth-idp-bd.novalocal/idp/shibboleth",
            "urn:mace:људи:tést", // Serbian/Macedonian
            "urn:mace:ανθρωποι:tést",
            "ΑΡΙΣΤΟΤΕΛΕΙΟ ΠΑΝΕΠΙΣΤΗΜΙΟ ΘΕΣΣΑΛΟΝΙΚΗΣ"
        };

        for (String s : input) {
            System.out.println("IN  : " + s);
            System.out.println("OUT : " + this.getPrintableString(s));
            System.out.println(" ================================ ");
        }

    }

    @Test
    public void testIdentifierMap() {
        Map<TraceRecordIdentifier, String> cnHashAlternatives = new HashMap<>();

        HashingUtils hasher = HashingUtils.getInstance();

        String[] CNs = {"CN 1 ASD", "CN 2 BSG", "CN 3 XXX"};
        for ( String cn : CNs) {
            String cnHash = hasher.hashToBase64(cn);
            cnHashAlternatives.put(new TraceRecordIdentifier(cnHash) ,cn );
        }

        String CN = "CN 2 BSG";
        String cnHash = hasher.hashToBase64(CN);
        String orig =  cnHashAlternatives.get( new TraceRecordIdentifier(cnHash) );

        System.out.println(orig);

    }
}
