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
package org.jkiss.dbeaver.ext.hsqldb.model;

import org.jkiss.dbeaver.ext.generic.model.GenericSQLDialect;
import org.jkiss.dbeaver.model.exec.jdbc.JDBCDatabaseMetaData;
import org.jkiss.dbeaver.model.exec.jdbc.JDBCSession;
import org.jkiss.dbeaver.model.impl.jdbc.JDBCDataSource;

import java.util.Arrays;

public class HSQLDialect extends GenericSQLDialect {

    public HSQLDialect() {
        super("HSQLDB", "hsqldb");
    }

    public void initDriverSettings(JDBCSession session, JDBCDataSource dataSource, JDBCDatabaseMetaData metaData) {
        super.initDriverSettings(session, dataSource, metaData);
        addDataTypes(
            Arrays.asList(
                "NCHAR",
                "NCLOB"));

        addSQLKeywords(
            Arrays.asList(
                "SYNONYM",
                "COMPARABLE",
                "ELSEIF",
                "END_EXEC",
                "FIRST_VALUE",
                "HANDLER",
                "ITERATE",
                "LAST_VALUE",
                "LEAD",
                "LEAVE",
                "LIKE_REGEX",
                "LOOP",
                "MAX_CARDINALITY",
                "NTH_VALUE",
                "NTILE",
                "OFFSET",
                "PERIOD",
                "RESIGNAL",
                "SIGNAL",
                "STACKED",
                "TRIM_ARRAY",
                "UNTIL",
                "VALUE"
            ));

        addFunctions(
            Arrays.asList(
                "CURRENT_CATALOG",
                "CURRENT_SCHEMA",
                "OCCURRENCES_REGEX",
                "POSITION_REGEX",
                "SUBSTRING_REGEX",
                "TRANSLATE_REGEX"
                ));
    }

    @Override
    public boolean supportsAliasInSelect() {
        return true;
    }

}
