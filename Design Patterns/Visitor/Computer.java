package com.StephenLee;

/**
 * Created by StephenLee on 6/2/16.
 */
public class Computer implements ComputerPart {

    ComputerPart[] parts;

    public Computer() {parts = new ComputerPart[]{new Monitor(), new Keyboard()};}

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {

        for(int i=0;i<parts.length;++i)
            parts[i].accept(computerPartVisitor);
        computerPartVisitor.visit(this);

    }
}
