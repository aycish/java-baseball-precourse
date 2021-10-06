package baseball.model;

import baseball.view.GameViewer;
import baseball.dto.GameData;

public class GameService {

    /**
    * 임의의 숫자 3개를 생성하여 GameData에 저장한다.
    *
    * @param gameData : NumberGenerator로 부터 랜덤한 3자리 숫자의 리스트를 받아온다.
    */
    public static void generateComputerNumbers(GameData gameData) {
        NumberGenerator.generateRandomNumbers(gameData);
    }

    /**
    * GameData에 저장되어 있는 사용자의 입력으로 숫자 리스트로 전환한다.
    * 만약, GameData에 에러 메세지가 존재하는 경우 이를 출력하고 false를 반환하여 재입력 받게한다.
    *
    * @param gameData : 콘솔로 입력 받은 String을 UserInputValidator로 전달하고,
    *                   사용자 입력으로 만들어진 3자리 숫자의 리스트를 받아온다.
    * @return 정상 종료는 true, 비정상 종료는 false 반환
    */
    public static boolean getUserNumber(GameData gameData) {
        UserInputValidator.createUserNumberList(gameData);
        if (gameData.getMessage().contains("ERROR")) {
            GameViewer.printWrongInputNotice(gameData.getMessage());
            gameData.setMessage("");
            return false;
        }
        return true;
    }

    /**
    * GameData에 저장되어 있는 재시작/종료 여부에 대한 사용자 입력을 통해 restartFlag를 설정한다.
    * 만약, 비정상적인 입력이 입력되어 에러메세지가 존재하는 경우, 이를 출력하고 false를 반환하여 재입력 받게한다.
    *
    * @param gameData : 사용자 입력을 UserInputValidator로 전달하고 restartFlag를 받아온다.
    * @return 정상 종료는 true, 비정상 종료는 false 반환
    */
    public static boolean getRestartFlag(GameData gameData) {
        UserInputValidator.createRestartFlag(gameData);
        if (gameData.getMessage().contains("ERROR")) {
            GameViewer.printWrongInputNotice(gameData.getMessage());
            gameData.setMessage("");
            return false;
        }
        return true;
    }

    /**
    * @param gameData : 컴퓨터 숫자와 사용자 숫자를 Grader에게 전달하고, 채점 결과를 받아온다.
    */
    public static void gradeUserInput(GameData gameData) {
        Grader.gradeUserInput(gameData);
    }

}
