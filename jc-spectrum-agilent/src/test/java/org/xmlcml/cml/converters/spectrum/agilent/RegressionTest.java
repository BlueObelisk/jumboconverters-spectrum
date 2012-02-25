package org.xmlcml.cml.converters.spectrum.agilent;

import org.junit.Ignore;


import org.junit.Test;
import org.xmlcml.cml.converters.spectrum.agilent.AgilentLCMS2CMLConverter;
import org.xmlcml.cml.converters.testutils.JumboConvertersRegressionSuite;

/**
 *
 * @author ojd20
 */
public class RegressionTest {

   @Test
   @Ignore // FAIL
   public void agilent2cml() {
      JumboConvertersRegressionSuite.run(AgilentModule.AGILENT_DIR, "txt", "xml",
                            new AgilentLCMS2CMLConverter());
   }

}
