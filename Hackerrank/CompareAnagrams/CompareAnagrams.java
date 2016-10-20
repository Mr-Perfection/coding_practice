private static boolean compareAnagrams(char[] s1, char[] s2)
        {
        int i,j;
        Map<Integer, Character> map1 = new HashMap<>();
        Map<Integer, Character> map2 = new HashMap<>();

        /**If two strings do not have same # of characters then they should not be the anagrams***/
        if(s1.length != s2.length) return false;

        /**Store all the characters of s1 and s2 to the **/
        for(i=0;i<s1.length;++i)
        {
        map1.put(i,s1[i]);
        map2.put(i,s2[i]);
        }
        /***If map1's keys & values are as same as map2's, then return true.**/
        if(map1.equals(map2))return true;


        /***If all the values from map1 and map2 are the same, then return true
         * In this case, I could've used HashSet which can have faster lookup time O(1) but with the condition that the
         * values could be duplicates, I decided to go with ArrayLists which cost O(n).***/
        List<Character> list1 = new ArrayList<>();
        list1.addAll(map1.values());
        List<Character> list2 = new ArrayList<>();
        list2.addAll(map2.values());
        if(list1.containsAll(list2)) return true;

        return false;

        }

/***Good things too know:
 *  HashSet:It provides O(1) time for the basic operations, such as add, remove, contains, and size.
 *
 *  ArrayList: It provides
 *  O(1) time for get() method because it is index based data structure so access time is fast.
 *  O(1 - n) for insertion (add) method because consider the case when array is full, we need to copy contents to new array
 *  if array gets full which makes inserting an element into ArrayList of O(n) in worst case, while ArrayList also needs to update its index
 *  O(1 - n) for the same reason as insertion
 *
 *  LinkedList: It provides
 *  O(n) as LinkedList is not an index based data structure so you will need to traverse up to index ,
 *  where index <=n , n is size of linked list
 *  O(1) for insertion (Given a pointer to node we need to insert item) because we needn't to be re-size the array, you just need to update pointers
 *  O(1) for deletion for the same reason as insertion
 *  ****/