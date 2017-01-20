snail = function(array) {
  return (SnailSort(array));
}

function SnailSort(array) { 
  var solution = [];
  if (array.length == 0) return (solution);
  var max = array[0].length - 1;
  //grab the first row or use result.push.apply(result,array[0])
  for (var i = 0; i <= max; ++i) 
  {
    solution.push(array[0][i]);
  }
  //grab the last column
  for (var i = 1; i <= max; ++i) 
  {
    solution.push(array[i][max]);
  }
  //grab the last row
  for (var i = max - 1; i >= 0; --i) 
  {
    solution.push(array[max][i]);
  }
  //grab the first column
  for (var i = max - 1; i > 0; --i) 
  {
    solution.push(array[i][0]);
  }
  //subarray to be used recursively
  var subarray = [];
  //inner cycle
  for (var i = 1; i < max; ++i)
  {
    subarray.push(array[i].splice(1, max - 1));
  }
  //recursion
  solution = solution.concat(SnailSort(subarray));
  return solution;

}