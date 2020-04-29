package jdbc_homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class DAOImplTest {
    DAOImpl daoImpl = new DAOImpl();
    Accomodation accomodationSingle = new Accomodation(1, "single", "queen", 1, "single room");
    Accomodation accomodationDouble = new Accomodation(2, "double", "double", 2, "double room");


    @Test
    public void insertAccomodation() {
        int result = daoImpl.insertAccomodation(accomodationSingle);
        assertEquals(1, result);
    }

    @Test
    public void insertAccomodationFair() {
    }

    @Test
    public void insertRoomFair() {
    }

    @Test
    public void getPricesPerEachRoom() {
    }
}