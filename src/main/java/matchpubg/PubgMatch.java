package matchpubg;

public class PubgMatch {
	private String type;
	private String id;
	private MatchAttributes attributes;
	private MatchRelationships	relationships;
	private MatchLinks links;
	
	
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
	public MatchAttributes getAttributes() {
		return attributes;
	}
	public void setAttributes(MatchAttributes attributes) {
		this.attributes = attributes;
	}
	public MatchRelationships getRelationships() {
		return relationships;
	}
	public void setRelationships(MatchRelationships relationships) {
		this.relationships = relationships;
	}
	public MatchLinks getLinks() {
		return links;
	}
	public void setLinks(MatchLinks links) {
		this.links = links;
	}
}
