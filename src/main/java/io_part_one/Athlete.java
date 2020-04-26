package io_part_one;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Athlete {
    private String athleteNumber;
    private String athleteName;
    private String countryCode;
    private String skiTimeResult; //(Minutes:Seconds)
    private String firstShootingRange;
    private String secondShootingRange;
    private String thirdShootingRange;


    public String finalResult() {
        SkiBiathlonStandings skiBiathlonStandings = new SkiBiathlonStandings();
        return athleteName +
                ' ' +
                finalTimeInMinutesAndSeconds() +
                " (" +
                skiTimeResult +
                " + " +
                (skiBiathlonStandings.penaltyInSeconds(firstShootingRange)
                        + skiBiathlonStandings.penaltyInSeconds(secondShootingRange)
                        + skiBiathlonStandings.penaltyInSeconds(thirdShootingRange)) +
                ')';
    }

    public long finalTimeInSeconds() {
        SkiBiathlonStandings skiBiathlonStandings = new SkiBiathlonStandings();
        return skiBiathlonStandings.timeResultInSeconds(skiTimeResult)
                + skiBiathlonStandings.penaltyInSeconds(firstShootingRange)
                + skiBiathlonStandings.penaltyInSeconds(secondShootingRange)
                + skiBiathlonStandings.penaltyInSeconds(thirdShootingRange);
    }

    public String finalTimeInMinutesAndSeconds() {
        long finalTimeInSeconds = finalTimeInSeconds();
        long minutes = finalTimeInSeconds / 60;
        long seconds = finalTimeInSeconds % 60;
        return String.valueOf(minutes) +
                ':' +
                seconds;
    }

    public Athlete(String athleteNumber, String athleteName, String countryCode, String skiTimeResult, String firstShootingRange, String secondShootingRange, String thirdShootingRange) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;
    }
}
