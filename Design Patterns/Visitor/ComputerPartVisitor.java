package com.StephenLee;

/**
 * Created by StephenLee on 6/2/16.
 */
public interface ComputerPartVisitor {

    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
    void visit(Computer computer);

}
