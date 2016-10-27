/**Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.***/
private static void setZeros(int[][] matrix)
        {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        int i;
        int j;
        for(i=0;i<matrix.length;++i)
        {
        for(j=0;j<matrix[0].length;++j)
        {
        /**Set row[i] and col[j] to 1 if the element is zero.***/
        if (matrix[i][j] == 0)
        {
        row[i]=1;
        col[j]=1;
        }//EOF if

        }//EOF for
        }//EOF for

        for(i=0;i<matrix.length;++i)
        {
        for(j=0;j<matrix[0].length;++j)
        {
        if(row[i] == 1 || col[j] == 1)
        {
        matrix[i][j] = 0;
        }
        }
        }

        List<List<Integer>> array = new LinkedList<>();
        /***Testing...***/
        for(i=0;i<matrix.length;++i) {
        List<Integer> temp = new ArrayList<>();
        for (j = 0; j < matrix[0].length; ++j) {
        temp.add(new Integer(matrix[i][j]));
        }
        array.add(temp);
        }
        System.out.println(array.toString());

        }

public static void ConvertToZeros(int[][] matrix)
        {
        if(matrix==null || matrix.length < 1)
        return;
        int m = matrix.length;	//row number
        int n = matrix[0].length; //col number
        int i,j;
        //int[] zrows = new int[m]; //row position which there exists 0
        List<Integer> zrows = new ArrayList<Integer>();
        //int[] zcols = new int[n]; //column position which there exists 0
        List<Integer> zcols = new ArrayList<Integer>();
        for(i=0;i<m;++i)
        {
        for(j=0;j<n;++j)
        {
        if(matrix[i][j] == 0)
        {
        zrows.add(i);
        zcols.add(j);
        }
        }	//EOF for j
        }	//EOF for i

        for(i=0;i<m;++i)
        {
        for(j=0;j<n;++j)
        {
        if(zrows.contains(i) || zcols.contains(j))
        {
        matrix[i][j] = 0;
        }
        }	//EOF for j
        }	//EOF for i

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


        }