import java.lang.*;
import java.util.*;
import java.io.*;

public class ReverseWords
{
	/*** function store_solution
		description: the function stores the strings from the list into StringBuilder
		@param: Stringbuilder sb, a stringbuilder that will store the words in one string
		@param: List<Strings> list, a list of words.
		@return: void
	***/
	public static void store_solution(StringBuilder sb, List<String> list)
	{
		sb.append(list.get(0));
		for (int i = 1; i < list.size(); ++i)
			sb.append(" " + list.get(i));
	}

	/*** function is_white_space
		description: the function that checks if character is a white space or not.
		@param: char c, a character from the string.
		@return: boolean , true if it is a white space.
	***/
	public static boolean is_white_space(char c)
	{
		if (c == '\n' || c == ' ' || c == '\t') return (true);
		else return (false);
	}

	/*** function reverse_words
		description: the function that reverses a string so that:
		ex) "PHP is the best programming language", the output should be "language programming best the is PHP".
		@params: String str, a string that represents as an input.
		@params: String str, a string that represents as an output (the reversed input. refer back to description).
	***/
	public static String reverse_words(String str)
	{
		int i = 0;
		List<String> list = new ArrayList<String>();
		StringBuilder solution = new StringBuilder();

		//check if input is null
		if (str == null || str.length() == 0) 
			return ("");
		
		//iterate through String str and skip the first whitespaces.
		//ex) "   hello world" => "hello world"
		while (is_white_space(str.charAt(i))) i++;

		//the first letter must a a character that is not white space. Store words into the list.
		while (i < str.length())
		{
			//if there is the white space in the beginning, then skip.
			while (is_white_space(str.charAt(i))) i++;
			
			int j = i;
			//iterate until there is a white space and add the substring (or a word) into the list.
			while (j < str.length() && !is_white_space(str.charAt(j))) 
				j++;
			list.add(str.substring(i, j));

			i = j;			
		}

		//list has all the words stored. Need to reverse them.
		Collections.reverse(list);

		//store the words into the solution
		store_solution(solution, list);

		return (solution.toString());
	}
	public static void main(String[] args) {
		System.out.println("test: " + reverse_words("language programming best the is PHP"));
	}
}