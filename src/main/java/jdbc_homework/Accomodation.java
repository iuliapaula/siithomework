package jdbc_homework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Accomodation {
    private int id;
    private String type;
    private String bedType;
    private int maxGuests;
    private String description;

}
