

package com.devsuperior.dsm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsm.entities.Score;
import com.devsuperior.dsm.entities.ScorePk;


public interface ScoreRepository extends JpaRepository<Score, ScorePk>  {

} 