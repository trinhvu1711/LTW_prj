package model;

import java.util.List;

import dal.EpisodeDao;
import dal.MovieActorDao;
import dal.MovieCategoryDao;
import dal.MovieDirectorDao;
import dal.MovieRegionDao;
import dal.MovieStudioDao;
import dal.MovieTagDao;

public class Movie {
	private int id;
	private String name;
	private String origin_name;
	private String slug;
	private String content;
	private String notify;	
	private String showtimes;	
	private String thumb_url;
	private String poster_url;
	
	private int is_shown_in_theater;
	private int is_recommended;	
	private int is_copyright;	
	private int is_sensitive_content;	
	
	private Type type;
	private Status status;
	
	private String trailer_url;
	private String episode_time;
	private String episode_current;
	private String episode_total;
	private String quality;
	private String language;
	private String publish_year;
	
	private int view_total;
	private int view_day;
	private int view_week;
	private int view_month;
	private int rating_count;
	private int rating_start;
	
	private int created;
	private int updated;
	
	private List<Tag> tags;
	private List<Region> regions;
	private List<Actor> actors;
	private List<Director> directors;
	private List<Studio> studios;
	private List<Category> categories;
	private List<Episode> episode;
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(int id, String name, String origin_name, String slug, String content, String thumb_url, Type type,
			Status status, String episode_time, String episode_current, String episode_total, String quality,
			String language, String publish_year) {
		super();
		this.id = id;
		this.name = name;
		this.origin_name = origin_name;
		this.slug = slug;
		this.content = content;
		this.thumb_url = thumb_url;
		this.type = type;
		this.status = status;
		this.episode_time = episode_time;
		this.episode_current = episode_current;
		this.episode_total = episode_total;
		this.quality = quality;
		this.language = language;
		this.publish_year = publish_year;
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

	public String getOrigin_name() {
		return origin_name;
	}

	public void setOrigin_name(String origin_name) {
		this.origin_name = origin_name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNotify() {
		return notify;
	}

	public void setNotify(String notify) {
		this.notify = notify;
	}

	public String getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(String showtimes) {
		this.showtimes = showtimes;
	}

	public String getThumb_url() {
		return thumb_url;
	}

	public void setThumb_url(String thumb_url) {
		this.thumb_url = thumb_url;
	}

	public String getPoster_url() {
		return poster_url;
	}

	public void setPoster_url(String poster_url) {
		this.poster_url = poster_url;
	}

	public int getIs_shown_in_theater() {
		return is_shown_in_theater;
	}

	public void setIs_shown_in_theater(int is_shown_in_theater) {
		this.is_shown_in_theater = is_shown_in_theater;
	}

	public int getIs_recommended() {
		return is_recommended;
	}

	public void setIs_recommended(int is_recommended) {
		this.is_recommended = is_recommended;
	}

	public int getIs_copyright() {
		return is_copyright;
	}

	public void setIs_copyright(int is_copyright) {
		this.is_copyright = is_copyright;
	}

	public int getIs_sensitive_content() {
		return is_sensitive_content;
	}

	public void setIs_sensitive_content(int is_sensitive_content) {
		this.is_sensitive_content = is_sensitive_content;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTrailer_url() {
		return trailer_url;
	}

	public void setTrailer_url(String trailer_url) {
		this.trailer_url = trailer_url;
	}

	public String getEpisode_time() {
		return episode_time;
	}

	public void setEpisode_time(String episode_time) {
		this.episode_time = episode_time;
	}

	public String getEpisode_current() {
		return episode_current;
	}

	public void setEpisode_current(String episode_current) {
		this.episode_current = episode_current;
	}

	public String getEpisode_total() {
		return episode_total;
	}

	public void setEpisode_total(String episode_total) {
		this.episode_total = episode_total;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPublish_year() {
		return publish_year;
	}

	public void setPublish_year(String publish_year) {
		this.publish_year = publish_year;
	}

	public int getView_total() {
		return view_total;
	}

	public void setView_total(int view_total) {
		this.view_total = view_total;
	}

	public int getView_day() {
		return view_day;
	}

	public void setView_day(int view_day) {
		this.view_day = view_day;
	}

	public int getView_week() {
		return view_week;
	}

	public void setView_week(int view_week) {
		this.view_week = view_week;
	}

	public int getView_month() {
		return view_month;
	}

	public void setView_month(int view_month) {
		this.view_month = view_month;
	}

	public int getRating_count() {
		return rating_count;
	}

	public void setRating_count(int rating_count) {
		this.rating_count = rating_count;
	}

	public int getRating_start() {
		return rating_start;
	}

	public void setRating_start(int rating_start) {
		this.rating_start = rating_start;
	}

	public int getCreated() {
		return created;
	}

	public void setCreated(int created) {
		this.created = created;
	}

	public int getUpdated() {
		return updated;
	}

	public void setUpdated(int updated) {
		this.updated = updated;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public List<Studio> getStudios() {
		return studios;
	}

	public void setStudios(List<Studio> studios) {
		this.studios = studios;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Episode> getEpisode() {
		return episode;
	}

	public void setEpisode(List<Episode> episode) {
		this.episode = episode;
	}

	public List<Actor> getMovieActors(){
		return new MovieActorDao().get(id);
	}
	
	public List<Category> getMovieCategories(){
		return new MovieCategoryDao().get(id);
	}

	
	public List<Director> getMovieDirectors(){
		return new MovieDirectorDao().get(id);
	}
	
	public List<Region> getMovieRegions(){
		return new MovieRegionDao().get(id);
	}
	
	public List<Studio> getMovieStudios(){
		return new MovieStudioDao().get(id);
	}
	
	public List<Tag> getMovieTags(){
		return new MovieTagDao().get(id);
	}
	
	public List<Episode> getEpisodes(){
		return new EpisodeDao().get(id);
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", origin_name=" + origin_name + ", slug=" + slug + ", content="
				+ content + ", thumb_url=" + thumb_url + ", type=" + type + ", status=" + status + ", episode_time="
				+ episode_time + ", episode_current=" + episode_current + ", episode_total=" + episode_total + "]";
	}

	
}