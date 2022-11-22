package model;

public class MovieStudio {
	private int id_movie;
	private int id_studio;
	public MovieStudio(int id_movie, int id_studio) {
		super();
		this.id_movie = id_movie;
		this.id_studio = id_studio;
	}
	public int getId_movie() {
		return id_movie;
	}
	public void setId_movie(int id_movie) {
		this.id_movie = id_movie;
	}
	public int getId_studio() {
		return id_studio;
	}
	public void setId_studio(int id_studio) {
		this.id_studio = id_studio;
	}
	@Override
	public String toString() {
		return "MovieStudio [id_movie=" + id_movie + ", id_studio=" + id_studio + "]";
	}
	
}
