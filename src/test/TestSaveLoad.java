package test;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import controller.Controller;

public class TestSaveLoad {
    Controller c;
    
    @Before
    public void setUp () throws Exception {
        c = new Controller();
    }

    @After
    public void tearDown () throws Exception {
    }

//    @Test
    public void testSave(){
        c.saveFile("repeat 360 [ fd 1 rt 1 ]");
    }
    
    @Test
    public void testLoad() throws IOException{
        c.loadFile();
    }

}
