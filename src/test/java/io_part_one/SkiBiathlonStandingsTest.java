package io_part_one;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SkiBiathlonStandingsTest {

    SkiBiathlonStandings skiBiathlonStandings = new SkiBiathlonStandings();
    Athlete umar = new Athlete("11","Umar Jorgson","SK","30:27","xxxox","xxxxx","xxoxo");
    Athlete jimmy = new Athlete ("1","Jimmy Smiles","UK","29:15","xxoox","xooxo","xxxxo");
    Athlete piotr = new Athlete("27","Piotr Smitzer","CZ","30:10","xxxxx","xxxxx","xxxxx");

    @Test
    public void shouldReturnTopOfAthletes() {
        List<Athlete> athletes = List.of(umar, jimmy, piotr);
        String result = skiBiathlonStandings.topAthletes(athletes);
        assertThat(result).isEqualTo("Winner - Piotr Smitzer 30:10 (30:10 + 0)\n" +
                "Runner-up - Jimmy Smiles 30:15 (29:15 + 60)\n" +
                "Third Place - Umar Jorgson 30:57 (30:27 + 30)");
    }

    @Test
    public void shouldReturnAthletesFromLines() {
        List<String> lines = List.of("11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo", "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo", "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx");
        List<Athlete> athletes = skiBiathlonStandings.athletesListFromFilesLines(lines);
        assertThat(athletes.size()).isEqualTo(3);
        assertThat(athletes.get(0)).isEqualToComparingFieldByField(umar);
        assertThat(athletes.get(1)).isEqualToComparingFieldByField(jimmy);
        assertThat(athletes.get(2)).isEqualToComparingFieldByField(piotr);
    }

    @Test
    public void returnAthleteFromParsedLine() {
        Athlete athlete = skiBiathlonStandings.athleteFromParsedLine("11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo");
        assertThat(athlete).isEqualToComparingFieldByField(umar);
    }

    @Test
    public void shouldReturnParsedLine() {
        String[] result = skiBiathlonStandings.arrayFromParsedLine("11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo");
        String[] expectedResult = {"11","Umar Jorgson","SK","30:27","xxxox","xxxxx","xxoxo"};
        for (int i = 0, length = expectedResult.length; i < length; i++) {
            assertEquals(expectedResult[i], result[i]);
        }
    }

    @Test
    public void shouldReturnPenaltyInSecondsFromShootingRange() {
        long result = skiBiathlonStandings.penaltyInSeconds("xxoxo");
        long resultNoneMissed = skiBiathlonStandings.penaltyInSeconds("xxxxx");
        long resultAllMissed = skiBiathlonStandings.penaltyInSeconds("ooooo");
        assertEquals(20, result);
        assertEquals(0, resultNoneMissed);
        assertEquals(50, resultAllMissed);
    }

    @Test
    public void shouldReturnTimeResultInSeconds() {
        long result = skiBiathlonStandings.timeResultInSeconds("30:27");
        assertEquals(1827, result);
    }


}