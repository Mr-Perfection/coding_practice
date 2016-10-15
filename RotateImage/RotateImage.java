//Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
// write a method to rotate the image by 90 degrees. Can you do this in place?
/**matrix is two dimensional array, n is the image side length**/


public static void rotate( int[][] matrix)
        {
        int n = matrix.length;	//get the n from nxn matrix
        if(matrix.length <1 || matrix == null)
        return;
        int i,j;
        for(int layer=0;layer<n/2;++layer)
        {
        int start = layer;
        int end = n - 1 - layer; //do not want to replace the already replaced corner element!
        for(i=start;i<end;++i)
        {
        int offset = i - start;
        //first move the corners and then offsets of the corners
        int top = matrix[layer][i];
        matrix[start][i] = matrix[end-offset][layer]; //top = left
        matrix[end-offset][start] = matrix[end][end-offset];	//left = bott
        matrix[end][end-offset] = matrix[i][end];//bot = right
        matrix[i][end] = top;//right = top
        }
        }	//EOF for layer
        List<List<Integer>> array = new LinkedList<>();
        /***Testing...***/
        for(i=0;i<n;++i) {
        List<Integer> t = new ArrayList<>();
        for (j = 0; j < n; ++j) {
        t.add(new Integer(matrix[i][j]));
        }
        array.add(t);
        }
        System.out.println(array.toString());
        }	//EOF function rotate
public static void RotateImage(int[][] matrix, int n)
        {

        int side = n;
        int i,j;

        for(i=0;i<side/2;++i)    //loop through the rows
        {
        int first = i;
        int last = side - 1 - i;   //Need to decrements the last element so that matrix is not overwritten.

        /**Loop through the left half and store them into the matrix**/
        for(j=i;j<last;++j)
        {
        /****Need to make sure to set the offset value and prevent from subtracting twice. last is already decremented by i.****/
        int offset = j - i;
        /****Copy the elements and store them into variables******/
        int left = matrix[j][i];
        int bot = matrix[last][j];
        int right = matrix[last-offset][last];
        int top = matrix[i][last-offset];
        /***Left--->Bottom****/
        matrix[last][j] = left;
        /***Bottom--->Right****/
        matrix[last-offset][last] = bot;
        /***Right--->Top****/
        matrix[i][last-offset] = right;
        /***Top--->Left****/
        matrix[j][i] = top;



        }




        }

        List<List<Integer>> array = new LinkedList<>();
        /***Testing...***/
        for(i=0;i<side;++i) {
        List<Integer> temp = new ArrayList<>();
        for (j = 0; j < side; ++j) {
        temp.add(new Integer(matrix[i][j]));
        }
        array.add(temp);
        }
        System.out.println(array.toString());

        }
