package org.delegserver.oauth2;

import edu.uiuc.ncsa.myproxy.oa4mp.server.OA4MPConfigTags;

public interface DSConfigTags extends OA4MPConfigTags {

	public static final String DN_GENERATOR = "dnGenerator";
	public static final String DN_GENERATOR_CN_NAME = "cnName";
	public static final String DN_GENERATOR_CN_UNIQUE_ID = "cnUniqueId";
	public static final String DN_GENERATOR_ORGANISATION = "organisation";
	public static final String DN_GENERATOR_SOURCE = "source";
	
	public static final String DN_RECORD_STORE = "dnRecords";

	/* This is an attribute of the <scope> tag */
	public static final String SCOPE_NAME = "name";
	public static final String CLAIM_NAME = "name";
	
	public static final String SCOPE_CLAIM = "claim";
	
}
