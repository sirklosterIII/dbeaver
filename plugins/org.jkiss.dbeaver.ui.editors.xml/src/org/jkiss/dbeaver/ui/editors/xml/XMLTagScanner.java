/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2023 DBeaver Corp and others
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jkiss.dbeaver.ui.editors.xml;

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.*;
import org.jkiss.dbeaver.ui.editors.text.TextWhiteSpaceDetector;


public class XMLTagScanner extends RuleBasedScanner {

	XMLTagScanner(ColorRegistry manager) {
		IToken string =
			new Token(
				new TextAttribute(manager.get(XMLSourceViewerConfiguration.COLOR_XML_STRING)));

		IRule[] rules = new IRule[3];

		// Add rule for double quotes
		rules[0] = new SingleLineRule("\"", "\"", string, '\\'); //$NON-NLS-1$ //$NON-NLS-2$
		// Add a rule for single quotes
		rules[1] = new SingleLineRule("'", "'", string, '\\'); //$NON-NLS-1$ //$NON-NLS-2$
		// Add generic whitespace rule.
		rules[2] = new WhitespaceRule(new TextWhiteSpaceDetector());

		setRules(rules);
	}
}
