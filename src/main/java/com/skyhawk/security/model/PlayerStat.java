package com.skyhawk.security.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStat {
    private String playerId;
    private String teamId;
    private String gameId;
    private int points;
    private int rebounds;
    private int assists;
    private int steals;
    private int blocks;
    private int fouls;
    private int turnovers;
    private float minutesPlayed;
    private LocalDateTime timestamp;

    public PlayerStat(String playerId, String teamId, String gameId, int points, int rebounds, int assists, int steals,
                      int blocks, int fouls, int turnovers, float minutesPlayed) {
        this.playerId = playerId;
        this.teamId = teamId;
        this.gameId = gameId;
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
        this.fouls = fouls;
        this.turnovers = turnovers;
        this.minutesPlayed = minutesPlayed;
        this.timestamp = LocalDateTime.now();
    }
}
