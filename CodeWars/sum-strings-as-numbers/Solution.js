function sumStrings(a,b) { 
  //reverse the string that it now starts backward.
  //ex) "123" -> "321"
  var s1 = reverse(a);
  var s2 = reverse(b);
  var ans = "";
  var tick = 0;
  var j = 0;
  
  //add two strings until the minimum(s1, s2)
  for (var i = 0; i < s1.length && i < s2.length; ++i)
  {
    var num1 = parseInt(s1.substring(i, i + 1));
    var num2 = parseInt(s2.substring(i, i + 1));
    
//     console.log("num1: " + num1);
//     console.log("num2: " + num2);
    //check if num1 + num2 is greater than 10
    if ((num1 + num2 + tick) > 9)
    {
      var num = (num1 + num2 + tick) % 10;
      ans = ans.concat(num.toString());
      tick = 1;
      continue;
    }
    ans = ans.concat((num1 + num2 + tick).toString());
    console.log(ans);
    tick = 0;
  }
  
  //iterate through the rest if s1 still exists
  while (i < s1.length)
  {
    var num1 = parseInt(s1.substring(i, i + 1)) + tick;
    
    //check if num1 is still 0.
    if (num1 === 0) continue;
    
    //check if num1 is greater than 9
    if (num1 > 9)
    {
      ans = ans.concat((num1 % 10).toString());
      tick = 1;
      i++;
      continue ;
    }
    ans = ans.concat(num1.toString());
    tick = 0;
    i++;
  }
  
  //iterate through the rest if s2 still exists
  while (i < s2.length)
  {
    var num2 = parseInt(s2.substring(i, i + 1)) + tick;
    
    if (num2 > 9)
    {
      ans = ans.concat((num2 % 10).toString());
      tick = 1;
      i++;
      continue ;
    }
    ans = ans.concat(num2.toString());
    tick = 0;
    i++;
  }
  
  console.log("tick: " + tick);
  //if there is still tick then add it to ans
  if (tick === 1) ans = ans.concat(tick.toString());
  
  //reverse the string
  ans = reverse(ans);
  console.log("ans is:" + ans);
  //check leading zeros
  while (ans.charAt(j) === '0') {j++;};
  return (ans.substring(j, ans.length));
}

function reverse(s) {
  return (s.split('').reverse().join(''));
}




//best solution I think is...

String.prototype.reverse = function() {
  return this.split('').reverse().join('');
}

function sumStrings(a,b) {
  a = a.reverse(); b = b.reverse();
  var carry = 0;
  var index = 0;
  var sumDigits = [];
  while (index < a.length || index < b.length || carry != 0) {
    var aDigit = index < a.length ? parseInt(a[index]) : 0;
    var bDigit = index < b.length ? parseInt(b[index]) : 0;
    var digitSum = aDigit + bDigit + carry;
    sumDigits.push((digitSum % 10).toString());
    carry = Math.floor(digitSum / 10);
    index++;
  }
  sumDigits.reverse();
  while (sumDigits[0] == '0') sumDigits.shift();
  return sumDigits.join('');
}