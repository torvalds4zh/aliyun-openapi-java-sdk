/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aliyuncs.dds.transform.v20151201;

import java.util.ArrayList;
import java.util.List;

import com.aliyuncs.dds.model.v20151201.SampleResponse;
import com.aliyuncs.dds.model.v20151201.SampleResponse.SecurityIpGroup;
import java.util.Map;
import com.aliyuncs.transform.UnmarshallerContext;


public class SampleResponseUnmarshaller {

	public static SampleResponse unmarshall(SampleResponse sampleResponse, UnmarshallerContext context) {
		
		sampleResponse.setRequestId(context.stringValue("SampleResponse.RequestId"));
		sampleResponse.setSecurityIps(context.stringValue("SampleResponse.SecurityIps"));

		List<SecurityIpGroup> securityIpGroups = new ArrayList<SecurityIpGroup>();
		for (int i = 0; i < context.lengthValue("SampleResponse.SecurityIpGroups.Length"); i++) {
			SecurityIpGroup securityIpGroup = new SecurityIpGroup();
			securityIpGroup.setSecurityIpGroupName(context.stringValue("SampleResponse.SecurityIpGroups["+ i +"].SecurityIpGroupName"));
			securityIpGroup.setSecurityIpGroupAttribute(context.stringValue("SampleResponse.SecurityIpGroups["+ i +"].SecurityIpGroupAttribute"));
			securityIpGroup.setSecurityIpList(context.stringValue("SampleResponse.SecurityIpGroups["+ i +"].SecurityIpList"));

			securityIpGroups.add(securityIpGroup);
		}
		sampleResponse.setSecurityIpGroups(securityIpGroups);
	 
	 	return sampleResponse;
	}
}