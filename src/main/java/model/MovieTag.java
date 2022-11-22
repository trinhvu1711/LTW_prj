package model;

public class MovieTag {
	private int id_movie;
	private int id_tag;
	public MovieTag(int id_movie, int id_tag) {
		super();
		this.id_movie = id_movie;
		this.id_tag = id_tag;
	}
	public int getId_movie() {
		return id_movie;
	}
	public void setId_movie(int id_movie) {
		this.id_movie = id_movie;
	}
	public int getId_tag() {
		return id_tag;
	}
	public void setId_tag(int id_tag) {
		this.id_tag = id_tag;
	}
	@Override
	public String toString() {
		return "MovieTag [id_movie=" + id_movie + ", id_tag=" + id_tag + "]";
	}
	
}
