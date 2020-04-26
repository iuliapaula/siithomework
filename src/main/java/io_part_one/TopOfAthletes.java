package io_part_one;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TopOfAthletes {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\athletes_results.csv";
        SkiBiathlonStandings skiBiathlonStandings = new SkiBiathlonStandings();
        List<String> linesFromFile = Files.lines(Paths.get(path))
                    .collect(Collectors.toList());
        List<Athlete> athletes = skiBiathlonStandings.athletesListFromFilesLines(linesFromFile);
        System.out.println(skiBiathlonStandings.topAthletes(athletes));
    }
}
