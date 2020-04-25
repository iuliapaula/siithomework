package java_8_streams_exercises;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TradingWithStreamsClassTest {

    List<Transaction> transactions = new ArrayList<>();
    TradingWithStreamsClass tradingWithStreamsClass = new TradingWithStreamsClass(transactions);
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    @Before
    public void setUp() throws Exception {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions.add(new Transaction(brian, 2011, 300));
        transactions.add(new Transaction(raoul, 2012, 1000));
        transactions.add(new Transaction(raoul, 2011, 400));
        transactions.add(new Transaction(mario, 2012, 710));
        transactions.add(new Transaction(mario, 2012, 700));
        transactions.add(new Transaction(alan, 2012, 950));
    }


    @Test
    public void shouldReturnUniqueCitiesWhereTradersWork() {
        List<String> result = tradingWithStreamsClass.getUniqueCities(transactions);
        assertEquals("Cambridge", result.get(0));
        assertEquals("Milan", result.get(1));
    }

    @Test
    public void shouldReturnAllTradersFromCambridgeSortedByName() {
        List<Trader> result = tradingWithStreamsClass.getTradersFromCambridge(transactions);
        assertThat(result.get(0)).isEqualToComparingFieldByField(alan);
        assertThat(result.get(1)).isEqualToComparingFieldByField(brian);
        assertThat(result.get(2)).isEqualToComparingFieldByField(raoul);

    }

    @Test
    public void shouldReturnAStringOfAllTradersNamesSorted() {
        String result = tradingWithStreamsClass.tradersNamesSortedAlphabetically(transactions);
        assertThat(result).isEqualToIgnoringCase("Alan Brian Mario Raoul");
    }

    @Test
    public void shouldReturnTrueIfAnyTradersAreBasedInMilan() {
        boolean result = tradingWithStreamsClass.tradersBasedInMilan(transactions);
        assertTrue(result);
    }

    @Test
    public void shouldPrintAllTransactionsValuesFromTheTradersLivingInCambridge() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tradingWithStreamsClass.transactionValuesTradersFromCambridge(transactions);
        String expectedOutput = "Trader: Brian; Transaction value: 300" + System.lineSeparator() +
                "Trader: Raoul; Transaction value: 1000" + System.lineSeparator() +
                "Trader: Raoul; Transaction value: 400" + System.lineSeparator() +
                "Trader: Alan; Transaction value: 950" + System.lineSeparator();

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void shouldReturnHighestValueOfAllTransactions() {
        int result = tradingWithStreamsClass.highestValueFromTransactions(transactions);
        assertEquals(1000, result);
    }

    @Test
    public void shouldReturnTheTransactionWithTheSmallestValue() {
        Transaction result = tradingWithStreamsClass.transactionWithSmallestValue(transactions);
        assertThat(result.getTrader()).isEqualToComparingFieldByField(brian);
        assertThat(result.getValue()).isEqualTo(300);
        assertThat(result.getYear()).isEqualTo(2011);
    }
}