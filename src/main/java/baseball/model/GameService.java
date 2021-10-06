package baseball.model;

import baseball.view.GameViewer;
import baseball.dto.GameData;

public class GameService {

    public static void generateComputerNumbers(GameData gameData) {
        NumberGenerator.generateRandomNumbers(gameData);
    }

    public static boolean getUserNumber(GameData gameData) {
        UserInputValidator.createUserNumberList(gameData);
        if (gameData.getMessage().contains("ERROR")) {
            GameViewer.printWrongInputNotice(gameData.getMessage());
            gameData.setMessage("");
            return false;
        }
        return true;
    }

    public static boolean getRestartFlag(GameData gameData) {
        UserInputValidator.createRestartFlag(gameData);
        if (gameData.getMessage().contains("ERROR")) {
            GameViewer.printWrongInputNotice(gameData.getMessage());
            gameData.setMessage("");
            return false;
        }
        return true;
    }

    public static void gradeUserInput(GameData gameData) {
        Grader.gradeUserInput(gameData);
    }

}
