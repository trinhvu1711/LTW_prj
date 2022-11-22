package model;

public class MovieDirector {
	private int id_movie;
	private int id_director;
	public MovieDirector(int id_movie, int id_director) {
		super();
		this.id_movie = id_movie;
		this.id_director = id_director;
	}
	public int getId_movie() {
		return id_movie;
	}
	public void setId_movie(int id_movie) {
		this.id_movie = id_movie;
	}
	public int getId_director() {
		return id_director;
	}
	public void setId_director(int id_director) {
		this.id_director = id_director;
	}
	@Override
	public String toString() {
		return "MovieDirector [id_movie=" + id_movie + ", id_director=" + id_director + "]";
	}
	
}
