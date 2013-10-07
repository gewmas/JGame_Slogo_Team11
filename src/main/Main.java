package main;

import controller.Controller;

public class Main {

    public static void main(String[] args){
        Controller controller = new Controller();
        controller.interpretCommand("fd sum 8 9 bk 8 lt 1 rt 2 seth 4");

//        controller.interpretCommand("make :random sum 1 random 100");
//        controller.interpretCommand("DOTIMES  [  :i sum 1 3 ] [ fd 23 fd 23 ]");
//        controller.interpretCommand("for [ :i sum 1 3 sum 1 3 sum 1 3 ] [  fd 23 fd 23 ] ");
//        controller.interpretCommand("if lessp 2 3 [ fd sum 1 2 ]");
//        controller.interpretCommand("ifelse lessp 2 3 [ fd sum 1 2 ] [ fd sum 1 sum 1 2 ]");
//        controller.interpretCommand("cs xcor ycor heading pendown? showing?");

//        controller.interpretCommand("to method [ :x ] [ fd :x ] method sum 1 2");
//        controller.interpretCommand("DOTIMES [ :i sum 1 2 ] [ fd :i fd 2 ]");

//        controller.interpretCommand("for [ :i 0 3 1 ] [  fd :i fd sum :i 1 ]");
//        controller.interpretCommand("repeat 180 [ fd 1 rt 2 ]");
        
        
    }
}
