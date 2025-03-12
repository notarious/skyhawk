package com.skyhawk.security.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StatSummary {
    private int points;
    private int rebounds;
    private int assists;
    private int steals;
    private int blocks;
    private int fouls;
    private int turnovers;
    private double minutes;

    public StatSummary add(PlayerStat stat) {
        points += stat.getPoints();
        rebounds += stat.getRebounds();
        assists += stat.getAssists();
        steals += stat.getSteals();
        blocks += stat.getBlocks();
        fouls += stat.getFouls();
        turnovers += stat.getTurnovers();
        minutes += stat.getMinutesPlayed();
        return this;
    }

    public StatSummary combine(StatSummary other) {
        points += other.points;
        rebounds += other.rebounds;
        assists += other.assists;
        steals += other.steals;
        blocks += other.blocks;
        fouls += other.fouls;
        turnovers += other.turnovers;
        minutes += other.minutes;
        return this;
    }

    public com.skyhawk.security.dto.AggregatedStatResponse toAggregatedResponse(String id, int count) {
        return new com.skyhawk.security.dto.AggregatedStatResponse(
                id,
                count == 0 ? 0 : points / (double) count,
                count == 0 ? 0 : rebounds / (double) count,
                count == 0 ? 0 : assists / (double) count,
                count == 0 ? 0 : steals / (double) count,
                count == 0 ? 0 : blocks / (double) count,
                count == 0 ? 0 : fouls / (double) count,
                count == 0 ? 0 : turnovers / (double) count,
                count == 0 ? 0 : minutes / count
        );
    }
}
