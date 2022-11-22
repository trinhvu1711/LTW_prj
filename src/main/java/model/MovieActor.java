package model;

public class MovieActor {
	private int id_movie;
	private int id_actor;
	public MovieActor(int id_movie, int id_actor) {
		super();
		this.id_movie = id_movie;
		this.id_actor = id_actor;
	}
	public int getId_movie() {
		return id_movie;
	}
	public void setId_movie(int id_movie) {
		this.id_movie = id_movie;
	}
	public int getId_actor() {
		return id_actor;
	}
	public void setId_actor(int id_actor) {
		this.id_actor = id_actor;
	}
	@Override
	public String toString() {
		return "MovieActor [id_movie=" + id_movie + ", id_actor=" + id_actor + "]";
	}
	
}
