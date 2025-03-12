package com.skyhawk.security.repository;

import com.skyhawk.security.model.PlayerStat;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Repository
public class InMemoryStatRepository {
    private final List<PlayerStat> statStore = new CopyOnWriteArrayList<>();

    public void save(PlayerStat stat) {
        statStore.add(stat);
    }

    public List<PlayerStat> findAll() {
        return new ArrayList<>(statStore);
    }

    public List<PlayerStat> findByPlayerId(String playerId) {
        return statStore.stream()
                .filter(stat -> stat.getPlayerId().equals(playerId))
                .collect(Collectors.toList());
    }

    public List<PlayerStat> findByTeamId(String teamId) {
        return statStore.stream()
                .filter(stat -> stat.getTeamId().equals(teamId))
                .collect(Collectors.toList());
    }
}
