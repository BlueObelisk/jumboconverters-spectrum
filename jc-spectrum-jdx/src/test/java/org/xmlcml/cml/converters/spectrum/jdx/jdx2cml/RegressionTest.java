/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xmlcml.cml.converters.spectrum.jdx.jdx2cml;

import org.junit.Ignore;

import org.junit.Test;
import org.xmlcml.cml.converters.spectrum.jdx.JDXModule;
import org.xmlcml.cml.converters.testutils.JumboConvertersRegressionSuite;

/**
 *
 * @author ojd20
 */
public class RegressionTest {

   @Test
   @Ignore
   public void jdx2cml() {
	   JumboConvertersRegressionSuite.run(JDXModule.JDX_JDX2CML_DIR, "jdx", "cml",
                            new JDX2CMLConverter());
   }

}
