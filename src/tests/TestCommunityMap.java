package tests;

import model.Community;
import model.CommunityMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCommunityMap {

    ArrayList<Community> testCommunities;

    CommunityMap testCommunityMap;

    @BeforeEach
    public void runBefore() throws IOException {
        testCommunities = new ArrayList<>();
        testCommunityMap = new CommunityMap("hello");
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
    void testLoadFromFile() throws IOException {
        Community community1 = new Community("Sally", 1, "9ab", "English");
        Community community2 = new Community("Sam", 9, "abc", "Spanish");

        testCommunityMap.loadFromFile("inputfile.txt");
        assertEquals(testCommunityMap.getCommunities().get(0).getName(), community1.getName());
        assertEquals(testCommunityMap.getCommunities().get(1).getName(), community2.getName());

    }
    @Test
    void splitOnSpace() {
        ArrayList<String> s = new ArrayList<>();
        s.add("Sally");
        s.add("1");
        s.add("9ab");
        s.add("English");
        assertEquals(testCommunityMap.splitOnSpace("Sally 1 9ab English"), s);
    }

    @Test
    void saveToFile() throws IOException {
        Community community1 = new Community("Sally", 1, "9ab", "English");
        Community community2 = new Community("Sam", 9, "abc", "Spanish");

        testCommunityMap.getCommunities().add(community1);
        testCommunityMap.getCommunities().add(community2);

        testCommunityMap.saveToFile();
        testLoadFromFile();
    }
    @Test
    public void testFindNameOfCommunity(){
        String name = "testName";
      //  assertEquals(testCommunities.findName);
        //also not sure what to put here
        // goal: check to see that mostRecent gets set to the picked name
    }


}
