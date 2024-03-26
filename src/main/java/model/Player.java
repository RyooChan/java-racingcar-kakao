package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.toList;

public class Player {
    public static final int START_SCORE = 1;

    private int score;

    private final String name;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public static List<Player> getWinner(List<Player> playerList) {
        int maxScore = getMaxScore(playerList);

        List<Player> maxPlayers = playerList.stream()
            .filter(player -> player.isMaxScorePlayer(maxScore))
            .collect(toList());

        return maxPlayers;
    }

    public static List<String> getWinnerName(List<Player> playerList) {
        return getWinner(playerList).stream().map(
                     player -> player.name)
            .collect(toList());
    }

    private boolean isMaxScorePlayer(int maxScore) {
        return this.score == maxScore;
    }

    private static int getMaxScore(List<Player> playerList) {
        return playerList.stream()
            .map(player -> player.score)
            .max(Integer::compareTo)
            .orElse(START_SCORE);
    }

    public static List<Player> getPlayer(String[] playerNameList) {

        return stream(playerNameList)
            .map(playerName -> {
                return new Player(playerName, START_SCORE);
            })
            .collect(toList());
    }

    public static void validate(String str) {
        String[] playerNameList = str.split(",");
        HashSet<String> checker = new HashSet<>();

        for (String playerName : playerNameList) {
            validatePlayerNameLength(playerName);
            checker.add(playerName);
        }

        if (checker.size() != playerNameList.length) {
            throw new IllegalArgumentException("동일이름 안됨");
        }

    }

    private static void validatePlayerNameLength(String str) {
        if (str.length() > 5) {
            throw new IllegalArgumentException("5자 이상 불가능");
        }
    }


    public static Player updatePlayerScore(Player player, int num) {

        if (num > 3){
            player.score++;
        }

        return new Player(player.name, player.score);
    }

    public static List<Player> updatePlayerList(List<Player> initPlayerList, List<Integer> randomNumList) {
        List<Player> updatedPlayerList = new ArrayList<>();

        for (int i=0; i<initPlayerList.size(); i++) {
            updatedPlayerList.add(updatePlayerScore(initPlayerList.get(i), randomNumList.get(i)));
        }

        return updatedPlayerList;
    }

    public static String makeCarPrint(Player player) {
        String stringBuilder = player.name +
            " : " +
            makeDash(player.score);
        return stringBuilder;

    }

    private static String makeDash(int playerScore) {
        String dash = "-";
        return dash.repeat(playerScore);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return score == player.score && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, name);
    }
}
