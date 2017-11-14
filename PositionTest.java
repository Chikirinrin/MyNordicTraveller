import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {
    private Country country1;
    private City cityA, cityB;
    private Position pos;

    @Before
    public void setUp() throws Exception {
        country1 = new Country("Country 1",null);
        cityA = new City("cityA",80, country1);
        cityB = new City("cityB", 70, country1);
        pos = new Position(cityA,cityB,3);
    }

    @Test
    public void Position(){
        assertEquals(pos.getFrom(), cityA);
        assertEquals(pos.getTo(),cityB);
        assertEquals(pos.getDistance(),3);
        assertEquals(pos.getTotal(), 3);
    }


    @Test
    public void hasArrived() throws Exception {
       for(int i=0; i<3; i++){
           assertFalse(pos.hasArrived());
           pos.move();
       }
       assertTrue(pos.hasArrived());
    }

    @Test
    public void move() throws Exception {

            assertEquals(pos.getDistance(),3);
            assertTrue(pos.move());
            assertEquals(pos.getDistance(),2);
            assertTrue(pos.move());
            assertEquals(pos.getDistance(),1);
            assertTrue(pos.move());
            assertEquals(pos.getDistance(),0);
            assertFalse(pos.move());
    }

    @Test
    public void turnAround() throws Exception {
    }

}