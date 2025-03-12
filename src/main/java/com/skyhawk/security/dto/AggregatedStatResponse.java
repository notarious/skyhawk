package com.skyhawk.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AggregatedStatResponse {
    private String id;
    private double avgPoints;
    private double avgRebounds;
    private double avgAssists;
    private double avgSteals;
    private double avgBlocks;
    private double avgFouls;
    private double avgTurnovers;
    private double avgMinutesPlayed;
}
