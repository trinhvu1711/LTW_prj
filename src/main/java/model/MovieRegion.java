package model;

public class MovieRegion {
	private int id_movie;
	private int id_region;
	public MovieRegion(int id_movie, int id_region) {
		super();
		this.id_movie = id_movie;
		this.id_region = id_region;
	}
	public int getId_movie() {
		return id_movie;
	}
	public void setId_movie(int id_movie) {
		this.id_movie = id_movie;
	}
	public int getId_region() {
		return id_region;
	}
	public void setId_region(int id_region) {
		this.id_region = id_region;
	}
	@Override
	public String toString() {
		return "MovieRegion [id_movie=" + id_movie + ", id_region=" + id_region + "]";
	}
	
}
