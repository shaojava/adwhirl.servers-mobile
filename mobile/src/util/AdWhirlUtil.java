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

package util;

import com.amazonaws.sdb.AmazonSimpleDBConfig;

public class AdWhirlUtil {
    public static final String SERVER = "AdWhirlLB-473732162.us-east-1.elb.amazonaws.com";

    public static final String DOMAIN_APPS = "apps";
    public static final String DOMAIN_APPS_INVALID = "apps_invalid";
    public static final String DOMAIN_NETWORKS = "networks";
    public static final String DOMAIN_CUSTOMS = "customs";
    public static final String DOMAIN_CUSTOMS_INVALID = "customs_invalid";
    public static final String DOMAIN_STATS = "stats";
    public static final String DOMAIN_STATS_TEMP = "stats_temp";
    public static final String DOMAIN_STATS_INVALID = "stats_invalid";
    public static final String DOMAIN_USERS = "users";
    public static final String DOMAIN_USERS_FORGOT = "users_forgot";
    public static final String DOMAIN_USERS_UNVERIFIED = "users_unverified";

    public static final String myAccessKey = "CHANGEME";
    public static final String mySecretKey = "CHANGEME";
	
    public static AmazonSimpleDBConfig config;

    //Special characters need to be escaped.
    public static final String KEY_SPLIT = "\\|;\\|";

    public static enum NETWORKS {
	PADDING, //We want to be 1-indexed
	    ADMOB,
	    JUMPTAP,
	    VIDEOEGG,
	    MEDIALETS,
	    LIVERAIL,
	    MILLENNIAL,
	    GREYSTRIPE,
	    QUATTRO,
	    CUSTOM,
	    ADWHIRL,
	    MOBCLIX,
	    MDOTM,
	    FOURTHSCREEN,
	    GOOGLE_ADSENSE,
	    GOOGLE_DOUBLECLICK,
	    GENERIC,
	    EVENT
	    }

    public static String getNetworkPrefix(int type) {
	switch(type) {
	case 1:
	    return "admob";
	case 2:
	    return "jumptap";
	case 3:
	    return "videoegg";
	case 4:
	    return "medialets";
	case 5:
	    return "liverail";
	case 6:
	    return "millennial";
	case 7:
	    return "greystripe";
	case 8:
	    return "quattro";
	case 9:
	    return "custom";
	case 10:
	    return "adrollo";  //adwhirl
	case 11:
	    return "mobclix";
	case 12:
	    return "mdotm"; 
	case 13:
	    return "adrollo";  //4thscreen
	case 14:
	    return "google_adsense";
	case 15:
	    return "google_doubleclick";
	case 16:
	    return "generic";
	case 17:
	    return "event";
	default:
	    return "unknown";
	}
    }
	
    public enum HITTYPE {
    	PADDING,
	IMPRESSION,
	    CLICK
	    }
	
    public enum LAUNCH_TYPE {
    	PADDING,
    	LAUNCH_TYPE_SAFARI,
    	LAUNCH_TYPE_CANVAS,
    	LAUNCH_TYPE_LS
    }
    
    static {
	//TODO: Read from config file
		
	config = new AmazonSimpleDBConfig();
		
	//TODO: What is this value?
	config.setSignatureVersion("0");
    }
}