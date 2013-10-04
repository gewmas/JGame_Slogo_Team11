package test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import model.DefaultModel;
import model.Model;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestModel {
    Model model;
    
    @Before
    public void setUp () throws Exception {
        model = new DefaultModel();
    }

    @After
    public void tearDown () throws Exception {
    }

    @Test
    public void testParseInput () {
        List<String> commandInputList = model.parseInput("fd sum 3 sum 1 sum 2 3");
        assertTrue(commandInputList.equals(Arrays.asList("fd", "sum", "3", "sum", "1", "sum", "2", "3")));
        
    }

}
