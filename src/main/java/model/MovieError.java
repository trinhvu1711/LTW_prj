package model;

public class MovieError {
	int id_movie;
	int id_episode;
	String name_movie;
	String name_episode;
	String link;
	String tap;
	public MovieError() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId_movie() {
		return id_movie;
	}
	public void setId_movie(int id_movie) {
		this.id_movie = id_movie;
	}
	public int getId_episode() {
		return id_episode;
	}
	public void setId_episode(int id_episode) {
		this.id_episode = id_episode;
	}
	public String getName_movie() {
		return name_movie;
	}
	public void setName_movie(String name_movie) {
		this.name_movie = name_movie;
	}
	public String getName_episode() {
		return name_episode;
	}
	public void setName_episode(String name_episode) {
		this.name_episode = name_episode;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	public String getTap() {
		return tap;
	}

	public void setTap(String tap) {
		this.tap = tap;
	}
	
}
