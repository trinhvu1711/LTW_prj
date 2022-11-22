package model;

public class Category {
	private int id;
	private String name;
	private String slug;
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(int id, String name, String slug) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
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
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", slug=" + slug + "]";
	}
	
}
