/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xmlcml.cml.converters.spectrum.jdx.cml2jdx;

import org.junit.Ignore;
import org.junit.Test;
import org.xmlcml.cml.converters.spectrum.jdx.JDXModule;
import org.xmlcml.cml.converters.testutils.RegressionSuite;

/**
 *
 * @author ojd20
 */
public class RegressionTest {

   @Test
   @Ignore
   public void cml2jdx() {
      RegressionSuite.run(JDXModule.JDX_CML2JDX_DIR, "cml", "jdx",
                            new CMLSpect2JDXConverter());
   }


}
