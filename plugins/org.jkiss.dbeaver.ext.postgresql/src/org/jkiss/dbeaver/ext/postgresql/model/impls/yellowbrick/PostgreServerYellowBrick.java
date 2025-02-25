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
package org.jkiss.dbeaver.ext.postgresql.model.impls.yellowbrick;

import org.jkiss.dbeaver.DBException;
import org.jkiss.dbeaver.ext.postgresql.model.PostgreDataSource;
import org.jkiss.dbeaver.ext.postgresql.model.PostgreTableBase;
import org.jkiss.dbeaver.ext.postgresql.model.impls.PostgreServerExtensionBase;
import org.jkiss.dbeaver.model.runtime.DBRProgressMonitor;
import org.jkiss.utils.CommonUtils;

/**
 * PostgreServerYellowBrick
 */
public class PostgreServerYellowBrick extends PostgreServerExtensionBase {

    public PostgreServerYellowBrick(PostgreDataSource dataSource) {
        super(dataSource);
    }

    @Override
    public boolean supportsTransactions() {
        return false;
    }

    @Override
    public String getServerTypeName() {
        return "YellowBrick";
    }

    @Override
    public String readTableDDL(DBRProgressMonitor monitor, PostgreTableBase table) throws DBException {
        // Extract main portion from server
        StringBuilder ddl = new StringBuilder();

        String tableDDL = YellowBrickUtils.extractTableDDL(monitor, table);
        if (!CommonUtils.isEmpty(tableDDL)) {
            ddl.append(tableDDL);
            return ddl.toString();
        }
        return null;
    }

    @Override
    public boolean supportsExplainPlanXML() {
        return false;
    }
}

