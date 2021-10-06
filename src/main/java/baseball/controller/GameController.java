package baseball.controller;

import baseball.view.GameViewer;
import baseball.dto.GameData;
import baseball.model.GameService;

public class GameController {
    private GameData gameData = new GameData();
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

    /**
    * 게임 시작 시, 게임에서 사용하는 데이터를 초기화한다.
    */
    private void initializeGame() {
        if (gameStatus == START) {
            gameData.initGameData();
            GameService.generateComputerNumbers(gameData);
            gameStatus = RUNNING;
        }
    }

    /**
    * 사용자로부터 입력받고, 정상 입력이 아닌 경우 반복한다.
    */
    private void getUserNumber() {
        do{
            gameData.setUserInput(GameViewer.printInputNotice());
        } while(!GameService.getUserNumber(gameData));
    }

    /**
    * 사용자로부터 재시작 여부를 입력받고, 정상 입력이 아닌 경우 반복한다.
    */
    private void getRestartFlag() {
        if (gameStatus != FINISHED) {
            return ;
        }
        do {
            gameData.setUserInput(GameViewer.printRestartNotice());
        } while(!GameService.getRestartFlag(gameData));
        gameStatus = gameData.getRestartFlag();
    }

    /**
    * 사용자가 입력한 숫자의 점수를 채점한 뒤, 출력한다.
    * 정답인 경우, 게임의 상태를 변경하여 재시작 사용 여부를 받을 수 있게한다.
    */
    private void gradeUserInput() {
        GameService.gradeUserInput(gameData);
        GameViewer.printScore(gameData.getStrikeCount(),gameData.getBallCount());
        if (gameData.getStrikeCount() == ANSWER) {
            gameStatus = FINISHED;
            GameViewer.printGameOver();
        }
    }

}
