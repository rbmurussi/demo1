package com.example.demo.controller;

import com.example.demo.service.SessionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
@Tag(name = "Session", description = "Endpoints for managing session")
public class SessionController {

    public final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/open")
    public long open(@RequestParam(name = "minutes", defaultValue = "1") int minutes,
                     @RequestParam(name = "title", defaultValue = "TEST") String title) {
        return sessionService.open(minutes, title);
    }

    @GetMapping("/vote/{idSession}/{cpf}/{yesOrNo}")
    @ResponseStatus(HttpStatus.OK)
    public String vote(@PathVariable Long idSession, @PathVariable String cpf, @PathVariable String yesOrNo) {
        return sessionService.vote(idSession, cpf, yesOrNo);
    }
}
