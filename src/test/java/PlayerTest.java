import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class PlayerTest {

    @Test
    void isGetWinner_ShouldReturnMaxCountPlayerList() {
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("first", 5));
        playerList.add(new Player("second", 4));
        playerList.add(new Player("third", 5));
        playerList.add(new Player("firth", 2));

        List<Player> expectedWinner = new ArrayList<>();;
        expectedWinner.add(new Player("first", 5));
        expectedWinner.add(new Player("third", 5));

        List<Player> winnerList = Player.getWinner(playerList);
        assertThat(winnerList).isEqualTo(expectedWinner);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void isUpdatePlayerScore_ShouldIncreaseScoreGreaterOrEqualWithFour(int num) {
        Player player = new Player("name",0);
        Player expectedMove = new Player("name",1);
        Player afterMove = Player.updatePlayerScore(player, num);
        assertThat(expectedMove).isEqualTo(afterMove);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void isUpdatePlayerScore_ShouldNotIncreaseScoreLessOrEqualWithThree(int num) {
        Player player = new Player("name",0);
        Player expectedMove = new Player("name",0);
        Player afterMove = Player.updatePlayerScore(player, num);
        assertThat(expectedMove).isEqualTo(afterMove);
    }

    @Test
    void isGetPlayer_ShouldReturnSplitPlayerList(){
        String playerString="pobi,crong,honux";
        String[] split = playerString.split(",");
        List<Player> playerList = Player.getPlayer(split);

        List<Player> expectedPlayerList = new ArrayList<>();
        expectedPlayerList.add(new Player("pobi", Player.START_SCORE));
        expectedPlayerList.add(new Player("crong", Player.START_SCORE));
        expectedPlayerList.add(new Player("honux", Player.START_SCORE));

        assertThat(playerList).isEqualTo(expectedPlayerList);
    }

    @Test
    void SplitPlayer2(){
        String playerString="pobi,,honux";
        String[] split = playerString.split(",");
        List<Player> playerList = Player.getPlayer(split);

        List<Player> expectedPlayerList = new ArrayList<>();
        expectedPlayerList.add(new Player("pobi", Player.START_SCORE));
        expectedPlayerList.add(new Player("", Player.START_SCORE));
        expectedPlayerList.add(new Player("honux", Player.START_SCORE));

        assertThat(playerList).isEqualTo(expectedPlayerList);
    }
    @Test
    void SplitPlayer3(){
        String playerString=",,honux";
        String[] split = playerString.split(",");

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                Player.getPlayer(split);
            }).withMessage("동일이름 안됨");

    }

    @Test
    void isGetPlayer_ShouldThrowIllegalArgumentExceptionWithOverFive(){
        String playerStr="longNamehaha";
        String[] split = playerStr.split(",");

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                Player.getPlayer(split);
            }).withMessage("5자 이상 불가능");
    }

    @Test
    void makeRanNumByStrList() {
        String playerString="pobi,crong,honux";
        String[] split = playerString.split(",");
        int expectedSize = split.length;

        List<Integer> randomNumList = RandomGenerator.makeRanNumList(split);
        assertThat(randomNumList.size()).isEqualTo(expectedSize);
    }

    @Test
    void updatePlayerTest() {
        List<Integer> randomNumList = new ArrayList<>();
        randomNumList.add(4);
        randomNumList.add(2);
        randomNumList.add(7);

        List<Player> initPlayerList = new ArrayList<>();
        initPlayerList.add(new Player("pobi", 0));
        initPlayerList.add(new Player("crong", 0));
        initPlayerList.add(new Player("honux", 0));

        List<Player> updatePlayerList = Player.updatePlayerList(initPlayerList, randomNumList);

        List<Player> expectedPlayerList = new ArrayList<>();
        expectedPlayerList.add(new Player("pobi", 1));
        expectedPlayerList.add(new Player("crong", 0));
        expectedPlayerList.add(new Player("honux", 1));

        assertThat(updatePlayerList).isEqualTo(expectedPlayerList);
    }
}
