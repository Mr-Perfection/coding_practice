package com.StephenLee;

/**
 * Created by StephenLee on 6/2/16.
 */
public class Keyboard implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor){
        computerPartVisitor.visit(this);
    }
}
