package games.model;

import games.Game;
import lombok.Data;

@Data
public class GameResult {
    private final Game game;
    private final GameResultInfo gameResultInfo;
}