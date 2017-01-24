
//My solution.
function pascalsTriangle(n) {
   var arr = [[]];
   var sol = [];
   
   //first and second row do not need Pascal's traingle algo.
   arr.push([1]);
   
   //check if it is only level 1 triangle or level 2 triangle
   if (n == 1) {return (concat_arr(sol, arr));};
   arr.push([1, 1]);
   if (n == 2) {return (concat_arr(sol, arr));};
   
   //itereate through an arr and push another array inside.
   for (var i = 3; i <= n; ++i)
   {
     var temp = [];
     temp.push(1);
     for (var j = 1; j < arr[i - 1].length; ++j)
     {
       temp.push(arr[i - 1][j - 1] + arr[i - 1][j]);
     }
     temp.push(1);
     arr.push(temp);
   }
   sol = concat_arr(sol, arr);
   return (sol);
}

//flatten 2D to 1D.
function concat_arr(sol,arr) {
  for (var i = 0; i < arr.length; ++i)
   {
     sol = sol.concat(arr[i]);
   }
   return (sol);
}








//what people say is the best practice... WOW interesting.. :/ I'm noob.
function pascalsTriangle(n) {
  var pascal = [];
  var idx = 0;
  
  for ( var i = 0; i < n; i++ ) {
    idx = pascal.length - i;
    for ( var j = 0; j < i+1; j++ ) {
      if ( j === 0 || j === i ) {
        pascal.push(1);
      } else {
        pascal.push( pascal[ idx+j ] + pascal[ idx+j-1 ] );
      }
    }
  }
  
  return pascal;
}