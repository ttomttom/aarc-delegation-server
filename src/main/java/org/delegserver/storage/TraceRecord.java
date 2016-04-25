package org.delegserver.storage;

import edu.uiuc.ncsa.security.core.Identifier;
import edu.uiuc.ncsa.security.core.util.IdentifiableImpl;

import static edu.uiuc.ncsa.security.core.util.BeanUtils.checkEquals;

import java.util.List;


public class TraceRecord extends IdentifiableImpl {

	private static final long serialVersionUID = -7707448168067694856L;

	//protected String cnHash;
	protected int sequenceNr = 0;	
	protected String attrHash;
	protected String attrSalt;	
	protected List<String> attrNames;
	
	public TraceRecord(TraceRecordIdentifier identifier) {
		super(identifier);
	}
	
	/* GETTERS AND SETTERS */
	
	@Override
	public void setIdentifier(Identifier identifier) {
		super.setIdentifier(identifier);
		
		System.out.println("SET IDENTIFIER TO -> " + identifier.getClass().getCanonicalName() + " VALUE: " + identifier.toString());
	}
	
	public String getCnHash() {
		//return cnHash;
		return ((TraceRecordIdentifier)this.getIdentifier()).cnHash;
	}
	
	public String getAttrHash() {
		return attrHash;
	}
	
	public List<String> getAttrNames() {
		return attrNames;
	}
	
	public void setCnHash(String cnHash) {
		//this.cnHash = dnHash;
		this.setIdentifier(new TraceRecordIdentifier(cnHash));
	}
	
	public void setAttrHash(String attrHash) {
		this.attrHash = attrHash;
	}
	
	public void setAttrNames(List<String> attrNames) {
		this.attrNames = attrNames;
	}
	
	public String getAttrSalt() {
		return attrSalt;
	}
	
	public void setAttrSalt(String attrSalt) {
		this.attrSalt = attrSalt;
	}
	
	public int getSequenceNr() {
		return sequenceNr;
	}
	
	public void setSequenceNr(int sequenceNr) {
		this.sequenceNr = sequenceNr;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		} else {
			if ( obj instanceof TraceRecord) {
				TraceRecord rec = (TraceRecord) obj;
				if ( ! checkEquals(getCnHash(), rec.getCnHash()) ) return false;
				if ( this.getSequenceNr() != rec.getSequenceNr() ) return false;
				if ( ! checkEquals(getAttrHash(), rec.getAttrHash()) ) return false;
				if ( ! checkEquals(getAttrSalt(), rec.getAttrSalt()) ) return false;
				//if ( ! checkEquals(getAttrNames(), rec.getAttrNames()) ) return false;
				return true;				
			} else {
				return false;
			}
		}
	}
	
	@Override
	public String toString() {
		return "TraceRecord: \n" + 
			   "	cnHash=" + getIdentifierString() + "\n" +
			   "	sequnceNr=" + sequenceNr + "\n" +
	           "	attrHash=" + attrHash + "\n" + 
	           "	attrSalt=" + attrSalt + "\n" +   
			   "	attributeNames=" + attrNames + "\n";
	}
	
}