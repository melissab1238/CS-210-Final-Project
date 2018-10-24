package tests;

import exceptions.ZeroPopulationError;
import model.Community;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCommunity {

    private String testName = "Test";
    private int population = 100;
    private static String province = "BC"; //remove?
    private String zipcode = "123 456";
    private String language = "English";

    Community testCommunity;

    @BeforeEach
    public void runBefore(){
        testCommunity = new Community(testName, population, zipcode, language);
    }

    @Test
    //piazza @222 instructor answer says we dont need to make tests for every single setter and getter, but i did one anyway
    public void testChangeName(){
        testCommunity.changeName("Test2");
        assertEquals(testCommunity.getName(), "Test2");
    }

    @Test
    public void testBirth(){
        testCommunity.birth();
        assertEquals(testCommunity.getPopulation(), population+1 );
    }

    @Test
    public void testDeath() throws ZeroPopulationError {
        testCommunity.death();
        assertEquals(testCommunity.getPopulation(), population-1 );
    }




}
