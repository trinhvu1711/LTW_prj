package model;

public class Episode {
	private int id;
	private String name;
	private String slug;
	private String link;
	public Episode() {
		// TODO Auto-generated constructor stub
	}

	public Episode(int id, String name, String slug, String link, int id_movie) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.link = link;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Episode [id=" + id + ", name=" + name + ", slug=" + slug + ", link=" + link + "]";
	}

}
