package com.StephenLee;

/**
 * Created by StephenLee on 6/2/16.
 */
public class ShapeFactory {

    public Shape getShape(String shapeType)
    {
        if(shapeType == null)
        {
            return null;
        }

        if(shapeType.equalsIgnoreCase("RECTANGLE"))
        {
            return new Rectangle();
        }
        else
        if(shapeType.equalsIgnoreCase("CIRCLE"))
        {
            return new Circle();
        }

        return null;

    }
}
