package de.kreth.textumbruch.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.fop.hyphenation.Hyphenation;
import org.apache.fop.hyphenation.Hyphenator;
import org.junit.BeforeClass;
import org.junit.Test;

public class HyphenatorTest {

   private static Hyphenator h = new Hyphenator("de", null,2,4);

   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
      h = new Hyphenator("de", null,2,4);
   }

   @Test
   public void testHyph() {
      Hyphenation hn = h.hyphenate("Abkürzung");
      assertNotNull(hn);
      assertEquals(2, hn.getHyphenationPoints().length);
      assertEquals(2, hn.getHyphenationPoints()[0]);
      assertEquals(5, hn.getHyphenationPoints()[1]);
      assertEquals("Ab-kür-zung", hn.toString());
   }

   @Test
   public void testHyphIndex() {
      Hyphenation hn = h.hyphenate("Abkürzung");
      assertNotNull(hn);
      assertEquals(2, hn.getHyphenationPoints().length);

      String part1 = "Abkürzung".substring(0, hn.getHyphenationPoints()[1]) + "-";
      assertEquals("Abkür-", part1);
   }

}
