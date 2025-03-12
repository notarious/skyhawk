package com.skyhawk.security.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PlayerStatRequest {
    @NotBlank(message = "playerId is required")
    private String playerId;

    @NotBlank(message = "teamId is required")
    private String teamId;

    @NotBlank(message = "gameId is required")
    private String gameId;

    @NotNull(message = "points are required")
    private Integer points;

    @NotNull(message = "rebounds are required")
    private Integer rebounds;

    @NotNull(message = "assists are required")
    private Integer assists;

    @NotNull(message = "steals are required")
    private Integer steals;

    @NotNull(message = "blocks are required")
    private Integer blocks;

    @NotNull(message = "fouls are required")
    @Max(value = 6, message = "Maximum fouls is 6")
    private Integer fouls;

    @NotNull(message = "turnovers are required")
    private Integer turnovers;

    @NotNull(message = "minutesPlayed are required")
    @Min(value = 0, message = "Minutes cannot be less than 0")
    @Max(value = 48, message = "Minutes cannot be greater than 48")
    private Float minutesPlayed;
}
