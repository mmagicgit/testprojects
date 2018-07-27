package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String name;
	private Integer yearOfBirth;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Movie> movies = new ArrayList<Movie>();

	public Actor() {
	}
	public Actor(String name, Integer yearOfBirth) {
		this.name = name;
		this.yearOfBirth = yearOfBirth;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(Integer yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	@Override
	public String toString() {
		return "Actor [Id=" + Id + ", name=" + name + ", yearOfBirth="+ yearOfBirth + ", movies=" + movies.size() + "]";
	}
	
	public void addMovie(Movie movie) {
		movies.add(movie);
	}
	
}
