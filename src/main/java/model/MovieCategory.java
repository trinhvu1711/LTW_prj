package model;

public class MovieCategory {
	private int id_movie;
	private int id_category;
	public MovieCategory(int id_movie, int id_category) {
		super();
		this.id_movie = id_movie;
		this.id_category = id_category;
	}
	public int getId_movie() {
		return id_movie;
	}
	public void setId_movie(int id_movie) {
		this.id_movie = id_movie;
	}
	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	@Override
	public String toString() {
		return "MovieCategory [id_movie=" + id_movie + ", id_category=" + id_category + "]";
	}
	
}	
