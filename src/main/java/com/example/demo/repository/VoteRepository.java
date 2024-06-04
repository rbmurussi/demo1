package com.example.demo.repository;

import com.example.demo.model.ResultSession;
import com.example.demo.model.Vote;
import com.example.demo.model.VotePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository  extends JpaRepository<Vote, VotePk> {

    @Query("SELECT new ResultSession(v.vote, count(1)) FROM Vote v WHERE v.id.idSession = :idSession GROUP BY v.vote")
    List<ResultSession> findByIdSession(Long idSession);

}
