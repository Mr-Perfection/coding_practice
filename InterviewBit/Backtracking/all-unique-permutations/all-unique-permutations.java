/**
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example :
[1,1,2] have the following unique permutations:

[1,1,2]
[1,2,1]
[2,1,1]


**/

public class Solution {

	public static void ft_swap(ArrayList<Integer> collection, int i, int j)
	{
		int item_i = collection.get(i);
		int item_j = collection.get(j);
		collection.set(i, item_j);
		collection.set(j, item_i);

	}
	public static void ft_permutation( ArrayList<ArrayList<Integer>> solution,ArrayList<Integer> collection,int index)
	{
		//terminating case: index reaches the max size of the collection of integers
		int size = collection.size();
		// if (index > size)
		// 	return ;
		else if (index >= size)
		{
			if (solution.contains(collection) == true)
				return ;
			//create a new temp. permutation.
			ArrayList<Integer> temp = new ArrayList<Integer>(collection);
			solution.add(temp);
			return ;
		}

		for (int i = index; i < collection.size(); ++i)
		{
			ft_swap(collection, index, i);
			ft_permutation(solution, collection, index + 1);
			ft_swap(collection, index, i);
			
		}
	}
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
		//ArrayList<Integer> permutation = new ArrayList<Integer>();

		ft_permutation(solution, a, 0);
		return (solution);
	}
}
