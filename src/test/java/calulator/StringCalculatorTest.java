package calulator;

import org.junit.jupiter.api.Test;

import caculator.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @Test
    void isSplitAndSum_ShouldReturnZeroWithNull() {
        String[] split = StringCalculator.split(null);
        assertThat(StringCalculator.sumProcess(split)).isEqualTo(0);
    }

    @Test
    void isSplitAndSum_ShouldReturnZeroWithBlack() {
        String[] split = StringCalculator.split("");
        assertThat(StringCalculator.sumProcess(split)).isEqualTo(0);
    }

    @Test
    void isSplitAndSum_ShouldCalculateOneDigit() {
        String[] split = StringCalculator.split("1");
        assertThat(StringCalculator.sumProcess(split)).isEqualTo(1);
    }

    @Test
    void isSplitAndSum_ShouldThrowRuntimeExceptionMinus() {
        String minusStr = "-1";
        int num = Integer.parseInt(minusStr);
        String[] split = StringCalculator.split(minusStr);

        RuntimeException runtimeException =
            assertThrows(RuntimeException.class, () -> StringCalculator.sumProcess(split));
        assertThat(runtimeException.getMessage())
            .isEqualTo("Illegal leading minus sign on unsigned string %d.", num);
    }
    @Test
    void isSplitAndSum_ShouldThrowRuntimeExceptionString() {
        String inputWithString = "1, one";
        String expectedException = "one";
        String[] split = StringCalculator.split(inputWithString);

        RuntimeException runtimeException =
            assertThrows(RuntimeException.class, () -> StringCalculator.sumProcess(split));
        assertThat(runtimeException.getMessage())
            .isEqualTo("For input string: \" %s\"", expectedException);
    }
    @Test
    void isSplitAndSum_ShouldCalculateByComma() {
        String[] split = StringCalculator.split("1,2");
        assertThat(StringCalculator.sumProcess(split)).isEqualTo(3);
    }
    @Test
    void isSplitAndSum_ShouldCalculateByCommaAndSemicolon() {
        String[] split = StringCalculator.split("1,2;3");
        assertThat(StringCalculator.sumProcess(split)).isEqualTo(6);
    }

    @Test
    void isSplitAndSum_ShouldCalculateByCommaAndSemicolonAndCustomSeparator() {
        String[] split = StringCalculator.split("//ㄱ\n1ㄱ3ㄱ5;4,1");
        assertThat(StringCalculator.sumProcess(split)).isEqualTo(14);
    }
}