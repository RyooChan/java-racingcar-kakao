package caculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static Matcher matcher = null;

    public static int sumProcess(String[] strList) {
        return sum(toInts(strList));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    public static String[] split(String text) {

        if (isBlank(text)) {
            return new String[]{"0"};
        }

        matcher = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1) + "|,|;";
            return matcher.group(2).split(customDelimiter);
        }

        return text.split(",|;");
    }

    private static int[] toInts(String[] values) {
        int[] num = new int[values.length];

        for (int i=0; i<values.length; i++) {
            int valueNum = Integer.parseUnsignedInt(values[i]);
            num[i] = valueNum;
        }

        return num;
    }

    private static int sum(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }
}
