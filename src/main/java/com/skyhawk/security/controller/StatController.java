package com.skyhawk.security.controller;

import com.skyhawk.security.dto.AggregatedStatResponse;
import com.skyhawk.security.dto.PlayerStatRequest;
import com.skyhawk.security.service.StatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StatController {
    private final StatService statService;

    @PostMapping("/log")
    @ResponseStatus(HttpStatus.CREATED)
    public String logStat(@Valid @RequestBody PlayerStatRequest request) {
        statService.logPlayerStat(request);
        return "Stats logged successfully";
    }

    @GetMapping("/aggregate/player/{playerId}")
    public AggregatedStatResponse getPlayerAggregate(@PathVariable String playerId) {
        return statService.getPlayerAggregate(playerId);
    }

    @GetMapping("/aggregate/team/{teamId}")
    public AggregatedStatResponse getTeamAggregate(@PathVariable String teamId) {
        return statService.getTeamAggregate(teamId);
    }
}
