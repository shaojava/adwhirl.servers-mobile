/*
Copyright 2009 AdMob, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package obj;

import util.AdWhirlUtil;

public class Ration {
	private String nid = "";
	private int type = 0;
	private String nname = "";
	private int weight = 0;
	private String networkKey = "";
	private int priority = 0;
	
	public Ration(String nid) {
		this.nid = nid;
	}
	
	public String getNid() {
		return this.nid;
	}
	
	public int getType() {
		return this.type;
	}
	public void setType(int type) {
		this.type = type;
		this.nname = AdWhirlUtil.getNetworkPrefix(type);
	}
	
	public String getNName() {
		return this.nname;
	}
	
	public int getWeight() {
		return this.weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public String getNetworkKey() {
		return this.networkKey;
	}
	public void setNetworkKey(String networkKey) {
		this.networkKey = networkKey;
	}
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
}