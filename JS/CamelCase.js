/* My approach:
  - split the String by ' '
  - loop through the words
  - join them
*/

String.prototype.camelCase=function(){
  arr = this.split(' ');
  for(let i = 0; i < arr.length; ++i){
    arr[i] = arr[i].charAt(0).toUpperCase()+arr[i].substring(1);
  }
  return arr.join('')
}


String.prototype.camelCase=function(){
  arr = this.split(' ')
  arr = arr.map(function(e){
    return e.charAt(0).toUpperCase() + e.substring(1);
  })
  return arr.join('')
}
