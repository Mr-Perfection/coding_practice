function toCamelCase(str){
  var s = "";
  //if str is empty, return empty
  if (str.length === 0) return (s);
  
  //iterate through the string str.
  for (var i = 0; i < str.length; ++i)
  {
    //if it is at the last index and current character is '-'
    if ((i === str.length - 1) && (str[i] === '-' || str[i] === '_')) {continue; };
    
    //if it is inbetween i=0..str.length-2 and current character is '-'
    if (str[i] === '-' || str[i] === '_') 
    {
      i += 1;
      s = s.concat(str.charAt(i).toUpperCase());
      continue ;
    }
    s = s.concat(str.charAt(i));
  }
  return (s);
}