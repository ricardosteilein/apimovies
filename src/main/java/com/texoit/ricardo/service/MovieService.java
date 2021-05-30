package com.texoit.ricardo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texoit.ricardo.dto.MovieDTO;
import com.texoit.ricardo.dto.YearWinnerDTO;
import com.texoit.ricardo.dto.YearWinnerMovieDTO;
import com.texoit.ricardo.entity.Movie;
import com.texoit.ricardo.except.BadRequestException;
import com.texoit.ricardo.except.ResourceNotFoundException;
import com.texoit.ricardo.repository.MovieRepository;

@Service
public class MovieService {
	
	Logger logger = LoggerFactory.getLogger(MovieService.class);
	
	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie> getMoviesFromAYear(Integer year) {
		return movieRepository.findByYear(year);
	}
	
	public List<MovieDTO> getMoviesByYear(Integer year) {
		List<Movie> movies = movieRepository.findByYear(year);
		
		if (movies == null || movies.isEmpty()) {
			return new ArrayList<>();
		} 
		
		List<MovieDTO> moviesDto = new ArrayList<>();
		for (Movie m : movies) {
			moviesDto.add(new MovieDTO(m));
		}
		
		return moviesDto;		
	}
	
	public YearWinnerDTO getYearsWithMoreThanOneWinners() {
		List<YearWinnerMovieDTO> years = movieRepository.findYearsWithModeThanOneWinner();
		if (years == null || years.isEmpty()) {
			return new YearWinnerDTO();
		}
		return new YearWinnerDTO(years);
	}

	public void remove(Long id) {
		Optional<Movie> optional = movieRepository.findById(id);
		
		if ( !optional.isPresent() ) {
			throw new ResourceNotFoundException();
		}
		
		Movie movie = optional.get();
		if ( movie.getWinner() ) {
			throw new BadRequestException();
		}
		
		movieRepository.delete(movie);
	}
	
	public List<Movie> findAll(){
        return movieRepository.findAll();
    }
}
