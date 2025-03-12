package com.skyhawk.security.service;

import com.skyhawk.security.dto.AggregatedStatResponse;
import com.skyhawk.security.dto.PlayerStatRequest;
import com.skyhawk.security.model.PlayerStat;
import com.skyhawk.security.model.StatSummary;
import com.skyhawk.security.repository.InMemoryStatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatService {
    private final InMemoryStatRepository repository;

    public void logPlayerStat(PlayerStatRequest request) {
        PlayerStat stat = new PlayerStat(
                request.getPlayerId(),
                request.getTeamId(),
                request.getGameId(),
                request.getPoints(),
                request.getRebounds(),
                request.getAssists(),
                request.getSteals(),
                request.getBlocks(),
                request.getFouls(),
                request.getTurnovers(),
                request.getMinutesPlayed()
        );
        repository.save(stat);
    }

    public AggregatedStatResponse getPlayerAggregate(String playerId) {
        List<PlayerStat> stats = repository.findByPlayerId(playerId);
        return aggregateStats(playerId, stats);
    }

    public AggregatedStatResponse getTeamAggregate(String teamId) {
        List<PlayerStat> stats = repository.findByTeamId(teamId);
        return aggregateStats(teamId, stats);
    }

    private AggregatedStatResponse aggregateStats(String id, List<PlayerStat> stats) {
        int count = stats.size();
        StatSummary summary = stats.stream()
                .reduce(new StatSummary(), StatSummary::add, StatSummary::combine);
        return summary.toAggregatedResponse(id, count);
    }
}
