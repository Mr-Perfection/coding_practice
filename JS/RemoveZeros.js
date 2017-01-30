function removeZeros(array) {
  // Sort "array" so that all elements with the value of zero are moved to the
  // end of the array, while the other elements maintain order.
  // [0, 1, 2, 0, 3] --> [1, 2, 3, 0, 0]
  // Zero elements also maintain order in which they occurred.
  // [0, "0", 1, 2, 3] --> [1, 2, 3, 0, "0"]
  
  // Do not use any temporary arrays or objects. Additionally, you're not able
  // to use any Array or Object prototype methods such as .shift(), .push(), etc
  
  // the correctly sorted array should be returned.
  let end = array.length;
  for (let i = 0; i < end; ++i) {
    if (array[i] === 0 || array[i] === "0") {
      shiftToEnd(array, i, array[i]);
      end--;
      i--;
    }
  }
  return array;
}

function shiftToEnd(array, index, value) {
  let len = array.length;
  
  for (let i = index; i < len - 1; ++i)
    array[i] = array[i + 1];
  array[len - 1] = value; 
  
}