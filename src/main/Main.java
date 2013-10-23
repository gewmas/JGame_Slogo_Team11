package main;

import controller.Controller;

/**
 * 
 * Test Cases:
 * 
 * 
1Multiple Turtles
tell [ 2 3 ]
 
2Variables
make :random sum 1 random 100   fd :random
 
3Func Definition
to star [ ]  [    repeat 5    [      fd 50     rt 144   ] ]  star   
 
4Loops
repeat 4 [   fd 100   rt 90   fd 100   rt 90   fd 50   rt 90   fd 50   rt 90   fd 100   rt 90   fd 25   rt 90   fd 25   rt 90   fd 50  ]

5Loops with Para
make :x 20  repeat :x  [    fd :x    repeat :x    [      fd 50      rt 80     fd 20     lt 160   ]   rt 90   fd 10 ]    
set :distance 10 repeat 18 [   forward product 5 :distance   right 150   forward product 6 :distance         right 100   forward product 3 :distance   right 90 ]    

6Func
to squaggle [ ] [   forward 50   right 150   forward 60                          right 100   forward 30   right 90 ]   to pinwheel [ ] [   repeat 18  [ squaggle  ]  ]   pinwheel

7Func with Para
to dash [ :count ]         [           repeat :count            [             pu fd 4 pd fd 4           ]               ]   dash  10
 * 
 */

public class Main {
    public static void main (String[] args) {
        new Controller();
    }
}
