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
	
	public static void main(String[] args) {

		System.out.println("--------------------Test case #1----------------------");
		//test case #1
		final int[] input = new int[]{0, 2, 4, 6, 8};
		final int[] keys = new int[]{-1, 0, 0, 1, 2, 2};
		
		Result t1_0 = do_search(input, keys[0], SearchType.LessThanEquals);
		System.out.println("search result is: " + t1_0.get_search().name());
		System.out.println("index is: " + t1_0.get_index());
		assert t1_0.get_search() == Result.SearchResult.NotFound : "wrong return value. Should be NotFound"; 
		Result t1_1 = do_search(input, keys[1], SearchType.LessThan);
		System.out.println("search result is: " + t1_1.get_search().name());
		System.out.println("index is: " + t1_1.get_index());
		assert t1_1.get_search() == Result.SearchResult.NotFound : "wrong return value. Should be NotFound"; 
		Result t1_2 = do_search(input, keys[2], SearchType.Equals);
		System.out.println("search result is: " + t1_2.get_search().name());
		System.out.println("index is: " + t1_2.get_index());	
		Result t1_3 = do_search(input, keys[3], SearchType.Equals);
		System.out.println("search result is: " + t1_3.get_search().name());
		System.out.println("index is: " + t1_3.get_index());
		Result t1_4 = do_search(input, keys[4], SearchType.GreaterThanEquals);
		System.out.println("search result is: " + t1_4.get_search().name());
		System.out.println("index is: " + t1_4.get_index());
		Result t1_5 = do_search(input, keys[5], SearchType.GreaterThan);
		System.out.println("search result is: " + t1_5.get_search().name());
		System.out.println("index is: " + t1_5.get_index());
		//test case #2
		System.out.println("\n\n--------------------Test case #2----------------------");
		final int[] input1 = new int[]{8, 6, 4, 2, 0};
		final int[] keys1 = new int[]{-1, 0, 4, 8, 5, 2, 8, 9};
		Result test2_0 = do_search(input1, keys1[0], SearchType.LessThan);
		System.out.println("search result is: " + test2_0.get_search().name());
		System.out.println("index is: " + test2_0.get_index());
		Result test2_1 = do_search(input1, keys1[1], SearchType.LessThan);
		System.out.println("search result is: " + test2_1.get_search().name());
		System.out.println("index is: " + test2_1.get_index());
		Result test2_2 = do_search(input1, keys1[2], SearchType.LessThanEquals);
		System.out.println("search result is: " + test2_2.get_search().name());
		System.out.println("index is: " + test2_2.get_index());
		Result test2_3 = do_search(input1, keys1[3], SearchType.Equals);
		System.out.println("search result is: " + test2_3.get_search().name());
		System.out.println("index is: " + test2_3.get_index());
		Result test2_4 = do_search(input1, keys1[4], SearchType.GreaterThanEquals);
		System.out.println("search result is: " + test2_4.get_search().name());
		System.out.println("index is: " + test2_4.get_index());
		Result test2_5 = do_search(input1, keys1[5], SearchType.GreaterThanEquals);
		System.out.println("search result is: " + test2_5.get_search().name());
		System.out.println("index is: " + test2_5.get_index());
		Result test2_6 = do_search(input1, keys1[6], SearchType.GreaterThan);
		System.out.println("search result is: " + test2_6.get_search().name());
		System.out.println("index is: " + test2_6.get_index());
		assert test2_6.get_search() == Result.SearchResult.NotFound : "wrong return value. Should be NotFound"; 
		Result test2_7 = do_search(input1, keys1[7], SearchType.GreaterThan);
		System.out.println("search result is: " + test2_7.get_search().name());
		System.out.println("index is: " + test2_7.get_index());
		assert test2_7.get_search() == Result.SearchResult.NotFound : "wrong return value. Should be NotFound"; 


	}
}