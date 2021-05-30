package com.texoit.ricardo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.texoit.ricardo.dto.YearWinnerMovieDTO;
import com.texoit.ricardo.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	List<Movie> findByYear(Integer year);
	
	@Query(value="select new com.texoit.ricardo.dto.YearWinnerMovieDTO(movie.year, count(movie.winner)) "
			+ "from Movie as movie where movie.winner=true group by movie.year having count(movie.winner) > 1")
	List<YearWinnerMovieDTO> findYearsWithModeThanOneWinner();
	
}
