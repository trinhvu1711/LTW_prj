package model;

public class ImageProfile {
	private String name;
	private String path;
	private String username;
	public ImageProfile() {
		// TODO Auto-generated constructor stub
	}
	
	public ImageProfile(String name, String path, String username) {
		super();
		this.name = name;
		this.path = path;
		this.username = username;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
