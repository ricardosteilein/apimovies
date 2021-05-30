package com.texoit.ricardo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.texoit.ricardo.entity.MovieStudio;
import com.texoit.ricardo.entity.MovieStudioId;

public interface MovieStudioRepository extends JpaRepository<MovieStudio, MovieStudioId>{

}
