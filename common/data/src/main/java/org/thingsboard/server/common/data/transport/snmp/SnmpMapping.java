/**
 * Copyright © 2016-2022 The Thingsboard Authors
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
package org.thingsboard.server.common.data.transport.snmp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.thingsboard.server.common.data.kv.DataType;

import java.util.regex.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SnmpMapping {
    private String oid;
    private String key;
    private DataType dataType;

    private static final Pattern OID_PATTERN = Pattern.compile("^\\.?([0-2])((\\.0)|(\\.[1-9][0-9]*))*$");

    @JsonIgnore
    public boolean isValid() {
        return StringUtils.isNotEmpty(oid) && OID_PATTERN.matcher(oid).matches() && StringUtils.isNotBlank(key);
    }
}