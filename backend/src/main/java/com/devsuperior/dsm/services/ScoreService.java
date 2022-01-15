

package com.devsuperior.dsm.services;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsm.dto.MovieDTO;
import com.devsuperior.dsm.dto.ScoreDTO;
import com.devsuperior.dsm.entities.Movie;
import com.devsuperior.dsm.entities.Score;
import com.devsuperior.dsm.entities.User;
import com.devsuperior.dsm.repositories.MovieRepository;
import com.devsuperior.dsm.repositories.ScoreRepository;
import com.devsuperior.dsm.repositories.UserRepository;


@Service
public class ScoreService {

	@Autowired
	private  MovieRepository movierepository;
	@Autowired
	private  UserRepository  userrepository;
	@Autowired
	private  ScoreRepository  scorerepository;
	
	@Transactional
	public MovieDTO  saveScore(ScoreDTO dto) {
		
	User user = userrepository.findByEmail(dto.getEmail());
	if(user == null) {
		user = new User();
		user.setEmail(dto.getEmail());
		user = userrepository.saveAndFlush(user);
			
	}
		Movie movie = movierepository.findById(dto.getMovieid()).get();
		
		Score score =  new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scorerepository.saveAndFlush(score);
		
		double sum = 0;
		for(Score s: movie.getScores()) {
			
			sum = sum + s.getValue();
			
		}
		
		double avg = sum /movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movierepository.save(movie);
		
		return new MovieDTO(movie);		
	}
	
		
}
