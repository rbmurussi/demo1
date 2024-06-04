package com.example.demo.service.impl;

import com.example.demo.model.Session;
import com.example.demo.model.Vote;
import com.example.demo.model.VotePk;
import com.example.demo.repository.SessionRepository;
import com.example.demo.repository.VoteRepository;
import com.example.demo.service.SessionService;
import com.example.demo.service.UserService;
import com.example.demo.util.BrazilUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final VoteRepository voteRepository;
    private final UserService userService;

    public SessionServiceImpl(SessionRepository sessionRepository, VoteRepository voteRepository, UserService userService) {
        this.sessionRepository = sessionRepository;
        this.voteRepository = voteRepository;
        this.userService = userService;
    }

    public Session save(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public long open(int minutes, String title) {
        Session session = new Session();
        session.setSession(new Date());
        session.setMinutes(minutes);
        session.setTitle(title);
        session = sessionRepository.save(session);
        return session.getId();
    }

    @Override
    public String vote(Long idSession, String cpf, String yesOrNo) {
        String ableToVote = userService.getAbleToVote(cpf);
        if(!ableToVote.equals(BrazilUtils.ABLE)) {
            return ableToVote;
        }
        Optional<Session> session = sessionRepository.findById(idSession);
        if(session.isEmpty()) {
            return "Not existing session";
        }
        java.util.Date date = session.get().getSession();
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime timeOverSession = localDateTime.plusMinutes(session.get().getMinutes());

        if(timeOverSession.isBefore(LocalDateTime.now())) {
            return "The session is over!";
        }

        VotePk id = new VotePk(idSession, cpf);
        Optional<Vote> optionalVote = voteRepository.findById(id);
        if(optionalVote.isPresent()) {
            return "You already vote this!";
        }
        boolean theVote = yesOrNo.toLowerCase().contains("yes");
        Vote vote = new Vote(id, theVote);
        voteRepository.save(vote);
        return "computed vote!";
    }
}
