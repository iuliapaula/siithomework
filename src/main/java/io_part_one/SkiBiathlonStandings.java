package io_part_one;

import com.google.common.collect.Lists;
import lombok.ToString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
public class SkiBiathlonStandings {

    public String topAthletes(List<Athlete> athletesList) {
        List<Athlete> topAthletes = athletesList.stream()
                .sorted((athlete1, athlete2) -> Long.compare(athlete1.finalTimeInSeconds(), athlete2.finalTimeInSeconds()))
                .limit(3)
                .collect(Collectors.toList());
        return ("Winner - " + topAthletes.get(0).finalResult()
                + "\nRunner-up - " + topAthletes.get(1).finalResult()
                + "\nThird Place - " + topAthletes.get(2).finalResult());
    }

    public List<Athlete> athletesListFromFilesLines(List<String> lines) {
        List<Athlete> athleteList = new ArrayList<>();
        for (String line : lines) {
            athleteList.add(athleteFromParsedLine(line));
        }
        return athleteList;
    }

    public Athlete athleteFromParsedLine(String entryLine) {
        String[] parsedLine = arrayFromParsedLine(entryLine);
        Athlete athlete = new Athlete();
        athlete.setAthleteNumber(parsedLine[0]);
        athlete.setAthleteName(parsedLine[1]);
        athlete.setCountryCode(parsedLine[2]);
        athlete.setSkiTimeResult(parsedLine[3]);
        athlete.setFirstShootingRange(parsedLine[4]);
        athlete.setSecondShootingRange(parsedLine[5]);
        athlete.setThirdShootingRange(parsedLine[6]);
        return athlete;
    }


    public String[] arrayFromParsedLine(String entryLine) {
        return entryLine.split(",");
    }

    public long penaltyInSeconds(String shootingRange) {
        int penaltyPerMissedShot = 10;
        long missedShots = Lists.charactersOf(shootingRange)
                .stream()
                .filter(c -> c == 'o')
                .count();
        return missedShots * penaltyPerMissedShot;
    }

    public long timeResultInSeconds(String skiTimeResult) {
        String[] skiTimeResultArray = skiTimeResult.split(":");
        return Long.parseLong(skiTimeResultArray[0]) * 60 + Long.parseLong(skiTimeResultArray[1]);
    }


}
