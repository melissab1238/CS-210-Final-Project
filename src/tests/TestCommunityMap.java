package tests;

import model.Community;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCommunityMap {

    ArrayList<Community> testCommunities;

    @BeforeEach
    public void runBefore(){
        testCommunities = new ArrayList<>();
    }

    @Test
    public void testRun(){
        //not sure what to put here, ask TA
    }

    @Test
    public void testAddACommunity(){
        //also not sure what to put here, ask TA
    }

    @Test
    public void testFindNameOfCommunity(){
        String name = "testName";
      //  assertEquals(testCommunities.findName);
        //also not sure what to put here
        // goal: check to see that mostRecent gets set to the picked name
    }


}
