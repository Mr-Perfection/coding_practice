class Node implements Comparator<Node>, Comparable<Node>{
    private int[] index;
    private int value;
    public Node(int i, int j, int value){
        index = new int[]{i, j};
        this.value = value;
    }
    public Node(){}
    // Overriding the compareTo method
    public int compareTo(Node node) {
      return (this.value).compareTo(node.value);
    }

    // Overriding the compare method to sort the age 
    public int compare(Node node1, Node node2) {
      return (node1.value - node2.value);
    }
    public int[] get_index()
    {
        return index;
    }
}
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<Node> store = new LinkedList<Node>();
        for (int i = 0; i < nums1.length; ++i)
        {
            for (int j = 0; j < nums2.length; ++j)
            {
                store.offer(new Node(i, j, nums1[i] + nums2[j]));
            }
        }
        Collection.sort(store, new Node());
        List<int[]> solution = new LinkedList<int[]>();
        k = Math.min(k, store.size());
        for (int i = 0; i < k; ++i)
            solution.add(store.get(i).get_index);
        return (solution);
    }
}