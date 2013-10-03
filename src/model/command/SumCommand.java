package model.command;

import java.util.List;
import model.Command;

public class SumCommand extends Command {

    @Override
    public void execute(List<String> commandInput) {
        // TODO Auto-generated method stub

    }
    
    /**
     * 
     * Example: {"sum", "1", "sum", "2", "3"}
     * Explanation: Parser see the first string "sum" and call sumCommand, sumCommand first remove "sum",
     * now the command is {"1", "sum", "2", "3"}
     * Then check the current first string "1", not "sum" move on (this should be done in Parser because other Keywords
     * Then check the second string "sum", oh! it is "sum", then do it recursively (this should also be done in Parser)
     * So pass {"1", "sum", "2", "3"} and the pointer and remove "sum" => {"1", "2", "3"}
     * Finally we reach the calculation part and remove "3" and replace "2" with "5" => {"1", "5"}
     * Go back to the previous call and calculate "1" + "5" and remove "5" and replace "1" => {"6"}
     * YEAH!
     * 
     * @param commands
     * @param begin
     */
    
    public static void sumCommand(List<String> commands, int begin){
//      if(commands.get(begin).equals("sum")){
          commands.remove(begin);
//      }

      //Check 1st variable
      if(commands.get(begin).equals("sum")){
          SumCommand.sumCommand(commands, begin);
      }
      
      //Check 2nd variable
      if(commands.get(begin+1).equals("sum")){
          SumCommand.sumCommand(commands, begin+1);
      }
      
      double sum = Double.parseDouble(commands.get(begin)) + Double.parseDouble(commands.get(begin+1));
      commands.remove(begin+1);
      //        com8970655mands.remove(begin+1);
      commands.set(begin, Double.toString(sum));

  }

}
