package model;

public class Comment {
	private int id;
	private int id_movie;
	private String username;
	private String content;
	private String path;
	private String name;
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	
	public Comment(int id_movie, String username, String content, String path, String name) {
		super();
		this.id_movie = id_movie;
		this.username = username;
		this.content = content;
		this.path = path;
		this.name = name;
	}

	public int getId_movie() {
		return id_movie;
	}
	public void setId_movie(int id_movie) {
		this.id_movie = id_movie;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
