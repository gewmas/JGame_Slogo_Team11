package model;

import java.util.ResourceBundle;
import Exceptions.SlogoException;

public abstract class Model {

    public abstract void updateTrace (String userInput, ResourceBundle messages) throws SlogoException;

}
