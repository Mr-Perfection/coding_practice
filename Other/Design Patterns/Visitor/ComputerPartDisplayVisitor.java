package com.StephenLee;

/**
 * Created by StephenLee on 6/2/16.
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Computer computer) {
        System.out.println("Computer displaying");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Keyboard displaying");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Monitor displaying");
    }
}
