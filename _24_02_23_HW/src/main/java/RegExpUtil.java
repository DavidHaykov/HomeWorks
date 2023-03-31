import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegExpUtil
    {
        public static String[] regexPatternMatchStream(String regex, String input) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            int count = 0;
            while (matcher.find()) {
                count++;
            }
            String[] matches = new String[count];
            matcher.reset();
            int i = 0;
            while (matcher.find()) {
                matches[i++] = matcher.group();
            }
            return matches;
        }
    }