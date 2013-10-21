package model.expression;

import java.util.List;
import model.Model;
import Exceptions.SlogoException;
import controller.ColorIndex;
import controller.ControllerToModelInterface;


public class SetPaletteExpression extends FourParameterExpression {

    public SetPaletteExpression (List<String> cmdList, Model model) throws SlogoException {
        super(cmdList, model);
    }

    public void executeControllerCommand (ControllerToModelInterface controller)
                                                                                throws SlogoException {

        List<NumberExpression> numList = preEvaluate();

        ColorIndex index =
                new ColorIndex(numList.get(0).getNumber(), numList.get(1).getNumber(), numList
                        .get(2).getNumber(), numList.get(3).getNumber());
        controller.addColorIndex(index);
    }

}
