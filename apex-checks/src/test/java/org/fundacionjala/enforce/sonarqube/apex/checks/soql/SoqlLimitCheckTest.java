/*
 * Copyright (c) Fundacion Jala. All rights reserved.
 * Licensed under the MIT license. See LICENSE file in the project root for full license information.
 */
package org.fundacionjala.enforce.sonarqube.apex.checks.soql;

import org.junit.Before;
import org.junit.Test;
import org.sonar.squidbridge.api.SourceFile;
import org.sonar.squidbridge.checks.CheckMessagesVerifier;

import java.io.File;

import static org.fundacionjala.enforce.sonarqube.apex.ApexAstScanner.scanFile;

public class SoqlLimitCheckTest {
    
    private SoqlLimitCheck check;
    private SourceFile sourceFile;

    @Before
    public void setUp() {
        check = new SoqlLimitCheck();
    }
    
    @Test
    public void testStartAndStopClass() throws Exception {
        sourceFile = scanFile(new File("src/test/resources/checks/soqlLimit.cls"), check);
        System.out.println("sourceFile.getCheckMessages(): ==> "+ sourceFile.getCheckMessages());;
        /*CheckMessagesVerifier.verify(sourceFile.getCheckMessages())
                .next().atLine(4).withMessage("Define the LIMIT for this SOQL statement.")
                .next().atLine(5).withMessage("Define the LIMIT for this SOQL statement.");*/
    }

    @Test
    public void testStartAndStopClass_1() throws Exception {
        sourceFile = scanFile(new File("src/test/resources/checks/WebToCaseFormController.cls"), check);
        System.out.println("sourceFile.getCheckMessages(): ==> "+ sourceFile.getCheckMessages());;
        /*CheckMessagesVerifier.verify(sourceFile.getCheckMessages())
                .next().atLine(4).withMessage("Define the LIMIT for this SOQL statement.")
                .next().atLine(5).withMessage("Define the LIMIT for this SOQL statement.");*/
    }
}
