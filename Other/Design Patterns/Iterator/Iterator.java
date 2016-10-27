package com.StephenLee;

/**
 * Created by StephenLee on 6/2/16.
 */
public interface Iterator {
    boolean hasNext();
    Object next();

    /***in main
     *         NameRepo repo = new NameRepo();
     //        for(Iterator iter = repo.getIterator(); iter.hasNext();)
     //        {
     //
     //        }

     Iterator iter = repo.getIterator();

     while (iter.hasNext())
     {
     String name = (String)iter.next();
     System.out.print("Name is: " + name);
     }
     ***/
}
