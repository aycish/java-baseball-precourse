package baseball.controller;

import java.util.ArrayList;

import baseball.view.GameViewer;
import baseball.dto.GameData;
import baseball.model.GameService;

public class GameController {
    private GameData gameData = new GameData();
    private ArrayList<Integer> computerNumber = new ArrayList<>();
    private final int ANSWER = 3;
    private final int START = 1;
    private final int FINISHED = 2;
    private final int RUNNING = 3;
    private int gameStatus = START;

    public void startGame() {
        while(gameStatus == START || gameStatus == RUNNING) {
            initializeGame();
            getUserNumber();
            gradeUserInput();
            getRestartFlag();
        }
    }

    private void initializeGame() {
        if (gameStatus == START) {
            gameData.initGameData();
            GameService.generateComputerNumbers(gameData);
            computerNumber = gameData.getComputerNumberList();
            gameStatus = RUNNING;
        }
    }

    private void getUserNumber() {
        do{
            gameData.setUserInput(GameViewer.printInputNotice());
        } while(!GameService.getUserNumber(gameData));
    }

    private void getRestartFlag() {
        if (gameStatus != FINISHED) {
            return ;
        }
        do {
            gameData.setUserInput(GameViewer.printRestartNotice());
        } while(!GameService.getRestartFlag(gameData));
        gameStatus = gameData.getRestartFlag();
    }

    private void gradeUserInput() {
        gameData.setComputerNumberList(computerNumber);
        GameService.gradeUserInput(gameData);
        GameViewer.printScore(gameData.getStrikeCount(),gameData.getBallCount());
        if (gameData.getStrikeCount() == ANSWER) {
            gameStatus = FINISHED;
            GameViewer.printGameOver();
        }
    }

}
