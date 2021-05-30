package com.texoit.ricardo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.texoit.ricardo.entity.MovieProducer;
import com.texoit.ricardo.entity.MovieProducerId;

public interface MovieProducerRepository extends JpaRepository<MovieProducer, MovieProducerId> {
	
	// Relaciona Tabelas FILME e PRODUTOS ordenando por produtor e ano
	@Query(value="select mp from MovieProducer as mp join mp.movie as movie join mp.producer as producer "
			+ "where movie.winner = true order by producer.id, movie.year")
	List<MovieProducer> findByMovieWinner(Boolean isWinner);
	
}
