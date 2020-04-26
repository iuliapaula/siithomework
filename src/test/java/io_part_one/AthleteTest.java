package io_part_one;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AthleteTest {

    Athlete athlete = new Athlete();

    @Before
    public void setUp() throws Exception {
        //"11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo"
        athlete.setAthleteNumber("11");
        athlete.setAthleteName("Umar Jorgson");
        athlete.setCountryCode("SK");
        athlete.setSkiTimeResult("30:27");
        athlete.setFirstShootingRange("xxxox");
        athlete.setSecondShootingRange("xxxxx");
        athlete.setThirdShootingRange("xxoxo");
    }

    @Test
    public void shouldReturnFinalTimeInSeconds() {
        long result = athlete.finalTimeInSeconds();
        assertEquals(1857, result);
    }

    @Test
    public void shouldReturnFinalTimeInMinutesAndSeconds() {
        String result = athlete.finalTimeInMinutesAndSeconds();
        assertEquals("30:57", result);
    }

    @Test
    public void shouldReturnFinalResultAsString() {
        String result = athlete.finalResult();
        assertEquals("Umar Jorgson 30:57 (30:27 + 30)", result);
    }
}