import java.lang.*;
import java.util.*;

public class challenge {
	public enum SearchType { LessThan, LessThanEquals, Equals, GreaterThanEquals, GreaterThan} 

	public static Result search_equals(int[] inputs, int key)
	{
		Result result = new Result();
		for (int i = 0; i < inputs.length; ++i) 
			if (inputs[i] == key)
			{
				result.index = i;
				result.search = Result.SearchResult.FoundExact;
			} 
		return (result);
	}
	public static Result search_less_than(int[] inputs, int key)
	{
		Result result = new Result();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < inputs.length; ++i) 
			if (inputs[i] < key)
			{
				if (max < inputs[i]) 
				{
					result.index = i;
					result.search = Result.SearchResult.FoundLess;
					max = inputs[i];
				}
			}
		return (result);
	}
	public static Result search_greater_than(int[] inputs, int key)
	{
		Result result = new Result();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < inputs.length; ++i) 
			if (inputs[i] > key)
			{
				if (min > inputs[i]) 
				{
					result.index = i;
					result.search = Result.SearchResult.FoundGreater;
					min = inputs[i];
				}
			}
		return (result);
	}
	public static Result do_search(int[] inputs, int key, SearchType type)
	{
		Result result = new Result();
		if (inputs == null) return (null);
		switch(type)
		{
			case Equals:
				result = search_equals(inputs, key);
			break;
			case LessThan:
				result = search_less_than(inputs, key);
			break;
			case LessThanEquals:
				result = search_equals(inputs, key);
				if (result.get_search() == Result.SearchResult.NotFound) 
					result = search_less_than(inputs, key);
			break;
			case GreaterThan:
				result = search_greater_than(inputs, key);
			break;
			case GreaterThanEquals:
				result = search_equals(inputs, key);
				if (result.get_search() == Result.SearchResult.NotFound) 
					result = search_greater_than(inputs, key);
			break;
			default:
				System.out.println("Invalid SearchType.");
			break;
		}
		return (result);
	}
}