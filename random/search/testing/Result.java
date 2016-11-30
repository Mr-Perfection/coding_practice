import java.lang.*;
import java.util.*;

public class Result {
	public enum SearchResult { NotFound, FoundExact, FoundGreater, FoundLess} 
	SearchResult search;
	int index;
	public Result(){
		this.search = SearchResult.NotFound;
		this.index = -1;
	}
	public Result(SearchResult result, int index)
	{
		this.search = result;
		this.index = index;
	}
	public int get_index()
	{
		return (this.index);
	}
	public SearchResult get_search()
	{
		return (this.search);
	}
}