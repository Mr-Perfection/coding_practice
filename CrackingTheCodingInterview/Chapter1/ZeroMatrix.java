void optimalZeroMatrix(int[][] matrix) {
  if (matrix == null) return ;
  boolean rowZero = false;
  boolean colZero = false;
  int m = matrix.length;
  int n = matrix[0].length;
  // iterate through the first row and check if the row has zero.
  for (int i = 0; i < n ; ++i) {
    if (matrix[0][i] == 0) {
      rowZero = true;
      break;
    }
  }
  // iterate through the first column and check if the column has zero.
  for (int i = 0; i < n ; ++i) {
    if (matrix[i][0] == 0) {
      colZero = true;
      break;
    }
  }

  // iterate through the rest of matrix and set 0th row or col element to 0
  for (int i = 1; i < m ; ++i ) {
    for (int j = 1; j < n ; ++j ) {
      if (matrix[i][j] == 0) {
        matrix[i][0] = 0;
        matrix[0][j] = 0;
      }
    }
  }

  // iterate through the first row and set the columns to 0 if element is 0
  for (int i = 1; i < n ; ++i ) {
    if (matrix[0][i] == 0)
      nullifyCol(matrix, i); //set zeros for ith column
  }

  // iterate through the first column and set the rows to 0 if element is 0
  for (int i = 1; i < m ; ++i ) {
    if (matrix[i][0] == 0)
      nullifyRow(matrix, i); //set zeros for ith column
  }

  // if rowZero is 0, the entire row is zero
  if (rowZero) {
    nullifyRow(matrix, 0);
  }
  if (colZero) {
    nullifyCol(matrix, 0);
  }

}

void zeroMatrix(int[][] matrix) {

  if (matrix == null) return ;  /*
    TODO

  */
  // create two arrays to keep track of which rows or columns have zeros. (mxn matrix)
  boolean[] rows = new boolean[matrix.length];
  boolean[] columns = new boolean[matrix[0].length];
  int m = matrix.length;
  int n = matrix[0].length;

  // iterate through matrix
  for (int i = 0; i < m ; ++i ) {
    for (int j = 0; j < n ; ++j) {
      if (matrix[i][j] == 0) {
        rows[i] = true;
        columns[j] = true;
      }
    }
  }

  // iterate through rows and set all zeros
  for (int i = 0;i < m; ++i ) {
    if (rows[i] == true) {
      for (int j = 0; j < m ; ++j ) {
        if (matrix[i][j] != 0) {
          matrix[i][j] = 0;
        }
      }
    }
  }
  // iterate through columns and set all zeros
  for (int i = 0;i < m; ++i ) {
    if (columns[i] == true) {
      for (int j = 0; j < m ; ++j ) {
        if (matrix[j][i] != 0) {
          matrix[j][i] = 0;
        }
      }
    }
  }
}
