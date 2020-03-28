package matchpubg;

public class PubgRoster {
	private String type;
	private String id;
	private RosterAttributes attributes;
	private RosterRelationships relationships;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public RosterAttributes getAttributes() {
		return attributes;
	}
	public void setAttributes(RosterAttributes attributes) {
		this.attributes = attributes;
	}
	public RosterRelationships getRelationships() {
		return relationships;
	}
	public void setRelationships(RosterRelationships relationships) {
		this.relationships = relationships;
	}
	
	
}
