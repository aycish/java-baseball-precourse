package baseball.dto;

import java.util.ArrayList;

public class GameData {
    private ArrayList<Integer> computerNumberList = new ArrayList<>();
    private ArrayList<Integer> userNumberList= new ArrayList<>();
    private int ballCount;
    private int strikeCount;
    private int restartFlag;
    private String userInput;
    private String Message;

    public GameData() {}

    /**
    * 사용할 데이터를 초기화한다.
    */
    public void initGameData() {
        this.computerNumberList.clear();
        this.userNumberList.clear();
        this.ballCount = 0;
        this.strikeCount = 0;
        this.userInput = "";
        this.Message = "";
        this.restartFlag = 0;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public ArrayList<Integer> getComputerNumberList() {
        return computerNumberList;
    }

    public void setComputerNumberList(ArrayList<Integer> computerNumberList) {
        this.computerNumberList = computerNumberList;
    }

    public ArrayList<Integer> getUserNumberList() {
        return userNumberList;
    }

    public void setUserNumberList(ArrayList<Integer> userNumberList) {
        this.userNumberList = userNumberList;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getRestartFlag() {
        return restartFlag;
    }

    public void setRestartFlag(int restartFlag) {
        this.restartFlag = restartFlag;
    }
}
