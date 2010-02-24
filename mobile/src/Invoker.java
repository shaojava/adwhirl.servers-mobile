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

import com.amazonaws.sdb.AmazonSimpleDBClient;
import com.amazonaws.sdb.AmazonSimpleDBException;
import com.amazonaws.sdb.model.CreateDomainRequest;

import org.apache.log4j.Logger;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.ContextHandlerCollection;
import org.mortbay.jetty.servlet.*;

import servlet.ConfigServlet;
import util.AdWhirlUtil;

public class Invoker {
	static Logger log = Logger.getLogger("Invoker");
	
	private static AmazonSimpleDBClient sdb;
	
	public static void main(String[] args) {
		sdb = new AmazonSimpleDBClient(AdWhirlUtil.myAccessKey, AdWhirlUtil.mySecretKey, AdWhirlUtil.config);
		 
		/*
		try {
			setupSimpleDB();
		} catch (AmazonSimpleDBException e) {
			log.fatal("Unable to initialize SimpleDB databases: " + e.getMessage());
			System.exit(0);
		}
		*/

		Server server = new Server(80);
		try {
			ContextHandlerCollection contextHandlerCollection = new ContextHandlerCollection();
	        Context servletContext = new Context(contextHandlerCollection, "/");
	        servletContext.addServlet(new ServletHolder(new	ConfigServlet(servletContext)), "/getInfo.php");
	        server.setHandler(contextHandlerCollection);
	        server.start();
		} catch (Exception e) {
			log.fatal("Unable to start server: " + e.getMessage());
			System.exit(0);
		}		
	}

	@SuppressWarnings("unused")
	private static void setupSimpleDB() throws AmazonSimpleDBException {
		createDomain(AdWhirlUtil.DOMAIN_APPS);
		createDomain(AdWhirlUtil.DOMAIN_APPS_INVALID);
		createDomain(AdWhirlUtil.DOMAIN_NETWORKS);
		createDomain(AdWhirlUtil.DOMAIN_CUSTOMS);
		createDomain(AdWhirlUtil.DOMAIN_CUSTOMS_INVALID);
		createDomain(AdWhirlUtil.DOMAIN_STATS);
		createDomain(AdWhirlUtil.DOMAIN_STATS_TEMP);
		createDomain(AdWhirlUtil.DOMAIN_STATS_INVALID);
		createDomain(AdWhirlUtil.DOMAIN_USERS);
		createDomain(AdWhirlUtil.DOMAIN_USERS_FORGOT);
		createDomain(AdWhirlUtil.DOMAIN_USERS_UNVERIFIED);
	}
	
	private static void createDomain(String domain) throws AmazonSimpleDBException {
		log.info("Creating Amazon SimpleDB domain: " + domain);
		CreateDomainRequest request = new CreateDomainRequest(domain);
		sdb.createDomain(request);
	}
}