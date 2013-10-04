package test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import model.DefaultModel;
import model.Model;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.parser.*;

public class TestParser {
    Parser parser;
    
    @Before
    public void setUp () throws Exception {
        parser = new DefaultParser();
    }

    @After
    public void tearDown () throws Exception {
    }

    @Test
    public void testParse() {
        String answer = parser.parse(Arrays.asList("sum", "5", "sum", "8", "9"));
        assertTrue(answer.equals("22"));
        
    }

}
