package com.skyhawk.security.controller;

import com.skyhawk.security.dto.AggregatedStatResponse;
import com.skyhawk.security.dto.PlayerStatRequest;
import com.skyhawk.security.service.StatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class StatController {

    private final StatService statService;

    @PostMapping("/log")
    @ResponseStatus(HttpStatus.CREATED)
    public String logStat(@Valid @RequestBody PlayerStatRequest request) {
        log.info("Received request to log stats for player {}", request.getPlayerId());
        statService.logPlayerStat(request);
        return "Stats logged successfully";
    }

    @GetMapping("/aggregate/player/{playerId}")
    public AggregatedStatResponse getPlayerAggregate(@PathVariable String playerId) {
        log.info("Fetching aggregate stats for player {}", playerId);
        return statService.getPlayerAggregate(playerId);
    }

    @GetMapping("/aggregate/team/{teamId}")
    public AggregatedStatResponse getTeamAggregate(@PathVariable String teamId) {
        log.info("Fetching aggregate stats for team {}", teamId);
        return statService.getTeamAggregate(teamId);
    }
}
