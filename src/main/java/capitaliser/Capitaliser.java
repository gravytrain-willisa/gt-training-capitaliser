package capitaliser;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Capitaliser {
    private static final Pattern NON_ALPHANUMERIC_OR_DASHES = Pattern.compile("[^A-Za-z0-9-]");

    public String titleAlphaNumericCase(String string) {
        if (string == null || string.length() == 0) {
            return "";
        }

        var filtered = NON_ALPHANUMERIC_OR_DASHES.matcher(string).replaceAll("");
        filtered = Stream
                .of(filtered.split("-"))
                .map(this::makeFirstLetterUppercase)
                .collect(Collectors.joining());

        return makeFirstLetterUppercase(filtered);
    }

    private String makeFirstLetterUppercase(String value) {
        if (value.length() == 0) {
            return value.toUpperCase();
        }
        var firstLetter = value.substring(0, 1);
        return firstLetter.toUpperCase() + value.substring(1);
    }
}
