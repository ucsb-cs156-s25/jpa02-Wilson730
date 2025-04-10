package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-s25-teams>
        assertEquals("Wilson L", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
   
    @Test
    public void getGithubId_returns_correct_githubId() {
        String expected = "Wilson730";
        assertEquals(expected, Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name(){
        Team t = Developer.getTeam();
        assertEquals("s25-16", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Wilson L"),"Team should contain Wilson");
        assertTrue(t.getMembers().contains("Suhrit P"),"Team should contain Suhrit");
        assertTrue(t.getMembers().contains("John H"),"Team should contain John");
        assertTrue(t.getMembers().contains("Jeffrey L"),"Team should contain Jeffrey");
        assertTrue(t.getMembers().contains("Christian L"),"Team should contain Christian");
        assertTrue(t.getMembers().contains("Derek K"),"Team should contain Derek");
    }
}
