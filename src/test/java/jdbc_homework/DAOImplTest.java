package jdbc_homework;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DAOImplTest {
    DAOImpl daoImpl = new DAOImpl();
    Accomodation accomodationSingle = new Accomodation(1, "single", "queen", 1, "single room");
    RoomFair singleSeason = new RoomFair(1, 100, "full season");
    AccomodationFair accomodationFair = new AccomodationFair(1, 1, 1);

    RoomFair extraSeason = new RoomFair(2, 80, "extra season");
    AccomodationFair singleExtraSeason = new AccomodationFair(2, 1, 2);



    @Test
    public void insertAccomodation() {
        int result = daoImpl.insertAccomodation(accomodationSingle);
        assertEquals(1, result);
    }

    @Test
    public void insertRoomFair() {
        int result = daoImpl.insertRoomFair(singleSeason);
        assertEquals(1, result);
    }

    @Test
    public void insertAccomodationFair() {
        int result = daoImpl.insertAccomodationFair(accomodationFair);
    }

    @Test
    public void getPricesPerEachRoom() {
        daoImpl.insertRoomFair(extraSeason);
        daoImpl.insertAccomodationFair(singleExtraSeason);
        List<AccomodationPrices> accomodationPrices = daoImpl.getPricesPerEachRoom();
        accomodationPrices.forEach(System.out::println);
    }
}