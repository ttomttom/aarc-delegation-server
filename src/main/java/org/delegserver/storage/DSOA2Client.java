package org.delegserver.storage;

import edu.uiuc.ncsa.security.core.Identifier;
import edu.uiuc.ncsa.security.oauth_2_0.OA2Client;

public class DSOA2Client extends OA2Client {

	protected String description;
	
	public DSOA2Client(Identifier identifier) {
		super(identifier);
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public DSOA2Client clone() {
        DSOA2Client client = new DSOA2Client(getIdentifier());
        client.setName(getName());
        client.setHomeUri(getHomeUri());
        client.setErrorUri(getErrorUri());
        client.setEmail(getEmail());
        client.setProxyLimited(isProxyLimited());
        client.setRtLifetime(getRtLifetime());
        client.setCallbackURIs(getCallbackURIs());
        client.setCreationTS(getCreationTS());
        client.setSecret(getSecret());
		client.setDescription( this.description );
		
		return client;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean superEquals = super.equals(obj);
		if ( !superEquals ) {
			return false;
		}
		
		DSOA2Client c = (DSOA2Client) obj;
		if (!getDescription().equals(c.getDescription())) {
			return false;
		}
		
		return true;
	}
	
}