package jdbc_homework;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
public class AccomodationPrices {
   private int id;
   private int idAccomodation;
   private int idRoomFair;
   private String accomodationType;
   private String bedType;
   private double value;
   private String season;
}
