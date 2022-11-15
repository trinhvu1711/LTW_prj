package model;

public class Type {
	private String type_id;
	private String type_name;
	public Type(String id, String type_name) {
		super();
		this.type_id = id;
		this.type_name = type_name;
	}
	public String getId() {
		return type_id;
	}
	public void setId(String id) {
		this.type_id = id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	@Override
	public String toString() {
		return "Type [type_id=" + type_id + ", type_name=" + type_name + "]";
	}
	
}
