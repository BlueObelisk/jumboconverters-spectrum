/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xmlcml.cml.converters.spectrum.bruker;

import org.junit.Ignore;


import org.junit.Test;
import org.xmlcml.cml.converters.testutils.JumboConvertersRegressionSuite;

/**
 *
 * @author ojd20
 */
public class RegressionTest {

   @Test
   @Ignore // changing case
   // TODO real bug
   public void bruker2cml() {
	   JumboConvertersRegressionSuite.run(BrukerModule.BRUKER_DIR, "dx", "xml",
    		                              new Bruker2XMLConverter());
   }
   
}
