package java_8_streams_exercises;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TradingWithStreamsTest {

    TradingWithStreams tradingWithStreams = new TradingWithStreams();

    @Test
    public void shouldReturnTrueIfACertainDateMatchesAProvidedMonth() {
        boolean resultTrue = TradingWithStreams.dateMatchesProvidedMonth("1980/01/20", 1);
        assertTrue(resultTrue);
        boolean resultFalse = TradingWithStreams.dateMatchesProvidedMonth("1980/01/20", 2);
        assertFalse(resultFalse);
    }

    @Test
    public void shouldExtractNameAndLastNameFromAString() {
        String result = TradingWithStreams.extractNameAndLastName("Ion, Popescu, 1980/01/20");
        assertEquals("Ion, Popescu", result);
    }
}