/*
Once upon a time, on a way through the old wild west,…

… a man was given directions to go from one point to another. 
The directions were "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are opposite, 
"WEST" and "EAST" too. Going to one direction and coming back the opposite direction is a needless effort. 
Since this is the wild west, with dreadfull weather and not much water, it's important to save yourself some 
energy, otherwise you might die of thirst!

How I crossed the desert the smart way.

The directions given to the man are, for example, the following:

String[] plan = { "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" };
You can immediatly see that going "NORTH" and then "SOUTH" is not reasonable, 
better stay to the same place! So the task is to give to the man a simplified version of the plan. 
A better plan in this case is simply:
String[] plan = { "WEST" };
Other examples: In ["NORTH", "SOUTH", "EAST", "WEST"], 
the direction "NORTH" + "SOUTH" is going north and coming back right away. 
What a waste of time! Better to do nothing. The path becomes ["EAST", "WEST"],  
now "EAST" and "WEST" annihilate each other, 
therefore, the final result is [] (nil in Clojure). 
In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH" are not directly opposite 
but they become directly opposite after the reduction of "EAST" and "WEST" so the whole path is reducible 
to ["WEST", "WEST"].

Task
You have to write a function dirReduc which will take an array of strings and returns an array of 
strings with the needless directions removed (W<->E or S<->N side by side).

The Haskell version takes a list of directions with data Direction = North | East | West | South. 
The Clojure version returns nil when the path is reduced to nothing.

Examples

dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}) => new String[]{"WEST"}
dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"}) => new String[]{}
Note

All paths can't be made simpler. The path ["NORTH", "WEST", "SOUTH", "EAST"] is not reducible. 
"NORTH" and "WEST", "WEST" and "SOUTH", "SOUTH" and "EAST" are not directly opposite of each other 
and can't become such. Hence the result path is itself : ["NORTH", "WEST", "SOUTH", "EAST"].
*/

/**
	my approach:
		use stack to push() and pop() for "NORTH", "SOUTH", "WEST", "EAST"
		
		auxilary(stack,peek,value):
			if peek == "NORTH"
				if value == "SOUTH"
					stack.pop()
				else
					stack.push(value)
			end
			... check the rest of directions...
		end
		my function(arr):
			while (i < arr.length)
				if stack.isEmpty()
					stack.push(arr[i])
				else
					peek = stack.peek()
					if peek == "NORTH"
					else...
				end	
			end
			size = stack.size
			while (i < size)
				answer = stack(i)
			end
		end
		ex: { "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" }
*/


/***

VERY STUPID PROBLEM I think personally...


**/
import java.lang.*;
import java.util.*;
public class DirReduction {
	public enum Direction {
		NORTH, SOUTH, EAST, WEST
	}
	public static void dirReducHelper(Direction direction, String value, LinkedList<String> dq)
	{
		switch(direction)
		{
			case NORTH:
				if (value.equals("SOUTH"))
					dq.pop();
				else
					dq.push(value);
			break;
			case SOUTH:
				if (value.equals("NORTH"))
					dq.pop();
				else
					dq.push(value);
			break;
			case EAST:
				if (value.equals("WEST"))
					dq.pop();
				else
					dq.push(value);
			break;
			default:
				if (value.equals("EAST"))
					dq.pop();
				else
					dq.push(value);
			break;
		}
	}
    public static String[] dirReduc(String[] arr) {
    	//"EAST", "EAST", "WEST", "NORTH", "WEST", "EAST", "EAST", "SOUTH", "NORTH", "WEST"

        if (arr == null || arr.length == 0)
        	return new String[] {};
        if (arr.length == 1)
        		return (arr);
        LinkedList<String> dq = new LinkedList<String>();
        for (int i = 0; i < arr.length; ++i)
        {
        	if (dq.isEmpty())
        		dq.push(arr[i]);
        	else
        	{
        		String peek = dq.peek();
        		if (peek.equals("NORTH"))
        			dirReducHelper(Direction.NORTH, arr[i], dq);
        		else if (peek.equals("SOUTH"))
        			dirReducHelper(Direction.SOUTH, arr[i], dq);
        		else if (peek.equals("EAST"))
        			dirReducHelper(Direction.EAST, arr[i], dq);
        		else
        			dirReducHelper(Direction.WEST, arr[i], dq);
        	}
        }
        System.out.println(dq);
        return(dq.toArray(new String[dq.size()]));
    }
}

/*Misunderstood the question... Failed the test case:
	"NORTH", "WEST", "SOUTH", "EAST"
	returns "NORTH"

	new apporach: using hashmap?
	if arr == NORTH
		check hashmap to see if there exists South
*/

import java.lang.*;
import java.util.*;
public class DirReduction {
	public static String[] dirReduc(String[] arr) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] arr = new String[4]{"NORTH", "SOUTH", "EAST", "WEST"};
		map.put("NORTH", 0);
		map.put("SOUTH", 0);
		map.put("EAST", 0);
		map.put("WEST", 0);
		for (int i = 0; i < arr.length; ++i)
		{
			if (arr[i].equals("NORTH"))
			{
				int south = map.get("SOUTH");
				if (south > 0)
					map.put("SOUTH", south - 1);
				else
					map.put(arr[i], map.get(arr[i]) + 1);
			}
			else if (arr[i].equals("SOUTH"))
			{
				int north = map.get("NORTH");
				if (north > 0)
					map.put("NORTH", north - 1);
				else
					map.put(arr[i], map.get(arr[i]) + 1);
			}
			else if (arr[i].equals("EAST"))
			{
				int west = map.get("WEST");
				if (west > 0)
					map.put("WEST", west - 1);
				else
					map.put(arr[i], map.get(arr[i]) + 1);
			}
			else
			{
				int east = map.get("EAST");
				if (east > 0)
					map.put("EAST", east - 1);
				else
					map.put(arr[i], map.get(arr[i]) + 1);
			}
		}

	}

}


//best practice? but I think my algorithm is more efficient though...Im using Enums
import java.util.Stack;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        final Stack<String> stack = new Stack<>();

        for (final String direction : arr) {
            final String lastElement = stack.size() > 0 ? stack.lastElement() : null;

            switch(direction) {
                case "NORTH": if ("SOUTH".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
                case "SOUTH": if ("NORTH".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
                case "EAST":  if ("WEST".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
                case "WEST":  if ("EAST".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
            }
        }
        return stack.stream().toArray(String[]::new);
    }
}


