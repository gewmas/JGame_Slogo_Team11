package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testExample.TestLoopsExample;
import testExample.TestLoopsWithVariablesExample;
import testExample.TestProceduresExample;
import testExample.TestProceduresWithParametersExample;
import testExample.TestSimpleExample;
import testExample.TestVariablesExample;



@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestController.class,
    TestModel.class,
   TestParser.class,
//   TestSaveLoad.class,
   
   TestLoopsExample.class,
   TestLoopsWithVariablesExample.class,
   TestProceduresExample.class,
   TestProceduresWithParametersExample.class,
   TestSimpleExample.class,
   TestVariablesExample.class
   
})

public class TestSuite {   
}  