package mathRandomPrj.dice;

import mathRandomPrj.game.Game;
import mathRandomPrj.game.GameAction;

import java.util.LinkedHashMap;
import java.util.Map;

public class DiceGame extends Game<DicePlayer> {
    public DiceGame(String gameName) {
        super(gameName);
    }

    @Override
    public DicePlayer createNewPlayer(String name) {
        return new DicePlayer(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {

        Map<Character, GameAction> gameActions = new LinkedHashMap<>(Map.of(
                'R', new GameAction('R', "Roll Dice", this::rollDice)
        ));
        gameActions.putAll(getStandardActions());
        return gameActions;
    }

    private boolean rollDice(int playerIndex) {
        return getPlayer(playerIndex).rollDiceSelect();

    }
}
