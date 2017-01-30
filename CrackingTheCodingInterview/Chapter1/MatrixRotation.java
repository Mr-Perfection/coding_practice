/*
Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. (an you do this in place?
*/
void matrixRotation(int[][] matrix) {
  if (matrix == null || matrix.length != matrix[0].length) return ;

  int n = matrix.length;

  for (int i = 0;i < n / 2; ++i) {
    int start = i;
    int end = n - 1 - i;
    for (int j = start; j < end; ++j ) {
      int offset = j - start;
      int temp = matrix[i][start + offset];
      matrix[start][start + offset] = matrix[end - offset][start]; //top <- left
      matrix[end - offset][start] = matrix[end][end - offset]; // left <- bottom
      matrix[end][end - offset] = matrix[start + offset][end]; // bottom <- right
      matrix[start + offset][end] = temp;// right <- top
    }
  }
}
