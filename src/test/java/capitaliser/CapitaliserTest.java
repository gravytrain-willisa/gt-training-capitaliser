package capitaliser;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CapitaliserTest {
    private final Capitaliser capitaliser = new Capitaliser();

    @Test
    void ignoresBlank() {
        assertThat(capitaliser.titleAlphaNumericCase("")).isEmpty();
    }

    @Test
    void ignoresNull() {
        assertThat(capitaliser.titleAlphaNumericCase(null)).isEmpty();
    }

    @Test
    void rubberStampsAnOkString() {
        assertThat(capitaliser.titleAlphaNumericCase("GtGithub")).isEqualTo("GtGithub");
    }

    @Test
    void rubberStampsAnOkStringWithNumbers() {
        assertThat(capitaliser.titleAlphaNumericCase("Gt1Github2")).isEqualTo("Gt1Github2");
    }

    @Test
    void willCorrectALowercaseString() {
        assertThat(capitaliser.titleAlphaNumericCase("github")).isEqualTo("Github");
    }

    @Test
    void willAllowANumberInALowercaseString() {
        assertThat(capitaliser.titleAlphaNumericCase("git2hub")).isEqualTo("Git2hub");
    }

    @Test
    void filtersOutNonAlphaNumericCharacters() {
        assertThat(capitaliser.titleAlphaNumericCase("Ah!!!!")).isEqualTo("Ah");
        assertThat(capitaliser.titleAlphaNumericCase("A!h!!!!")).isEqualTo("Ah");
    }

    @Test
    void allowsPreExistingWordsWithSeparatorsIntoTitleCase() {
        assertThat(capitaliser.titleAlphaNumericCase("Git Hub Is Awesome")).isEqualTo("GitHubIsAwesome");
    }

    @Test
    void capitalizesWordsSeparatedByDashes() {
        assertThat(capitaliser.titleAlphaNumericCase("git-hub-is-awesome")).isEqualTo("GitHubIsAwesome");
    }

    @Test
    void capitalizesWordsSeparatedByDashesAndIgnoresMultiDash() {
        assertThat(capitaliser.titleAlphaNumericCase("git-hub----is-awesome")).isEqualTo("GitHubIsAwesome");
    }
}