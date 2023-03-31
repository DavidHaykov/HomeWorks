import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegExTest
{
    @Test
    void testTaskA()
    {
        String[] expected = { "3", "25", "888" };
        String regexp = "\\b\\d+\\b";
        String[] actual = RegExpUtil.regexPatternMatchStream(regexp,
                "Today during 3 hours we studied 25 tutorial chapters and built 888 expressions");
        assertArrayEquals(expected, actual);
    }
    @Test
    void testTaskB()
    {
        String[] expected = { "$0.5", "$550,000" };
        String regexp = "\\$\\d+(,\\d{3})*(\\.\\d+)?";
        String[] actual = RegExpUtil.regexPatternMatchStream(regexp,
                "Pen costs $0.5 , but house costs $550,000");
        assertArrayEquals(expected, actual);
    }
    @Test
    void testTaskC()
    {
        String[] expected = { "Jacob Cohen" };
        String regexp = "\\bJacob\\s\\w+";
        String[] actual = RegExpUtil.regexPatternMatchStream(regexp,
                "Abraham Smith, Jacob Cohen, Peter Jacobson, Meir Jacob");
        assertArrayEquals(expected, actual);
    }
    @Test
    void testTaskD()
    {
        String[] expected = { "Jacob Cohen", "Meir Jacob" };
        String regexp = "\\b\\w+\\s+(?:Jacob|Cohen)\\b";
        String[] actual = RegExpUtil.regexPatternMatchStream(regexp,
                "Abraham Smith, Jacob Cohen, Peter Jacobson, Meir Jacob");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testTaskE()
    {
        String[] expected = { "Ivan Ivanov", "Oskar Oskarson", "Peter Peterson" };
        String regexp = "\\b(\\w+)\\s+(\\1\\w+)\\b";
        String[] actual = RegExpUtil.regexPatternMatchStream(regexp,
                "Rachel Simpson, Ivan Ivanov, Oskar Oskarson, Meyer Peterson, Peter Peterson");
        assertArrayEquals(expected, actual);
    }

}