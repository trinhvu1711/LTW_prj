package model;

public class Director {
	private int id;
	private String name;
	private String slug;
	private String thumb_url;
	private int isMale;
	public Director() {
		// TODO Auto-generated constructor stub
	}
	public Director(int id, String name, String slug, String thumb_url, int isMale) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.thumb_url = thumb_url;
		this.isMale = isMale;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getThumb_url() {
		return thumb_url;
	}
	public void setThumb_url(String thumb_url) {
		this.thumb_url = thumb_url;
	}
	public int getMale() {
		return isMale;
	}
	public void setMale(int isMale) {
		this.isMale = isMale;
	}
	@Override
	public String toString() {
		return "Director [id=" + id + ", name=" + name + ", slug=" + slug + ", thumb_url=" + thumb_url + ", isMale="
				+ isMale + "]";
	}
	
}
