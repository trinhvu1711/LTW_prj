package model;

public class Movie {
	private String id;
	private String name;
	private String origin_name;
	private String slug;
	private String content;
	private String thumb_url;
	private String poster_url;
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
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(String id, String name, String origin_name, String slug, String content, String thumb_url,
			String poster_url, Type type, Status status) {
		super();
		this.id = id;
		this.name = name;
		this.origin_name = origin_name;
		this.slug = slug;
		this.content = content;
		this.thumb_url = thumb_url;
		this.poster_url = poster_url;
		this.type = type;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", origin_name=" + origin_name + ", slug=" + slug + ", content="
				+ content + ", thumb_url=" + thumb_url + ", poster_url=" + poster_url + ", type=" + type + ", status="
				+ status + ", trailer_url=" + trailer_url + "]";
	}
	
	
	
}
