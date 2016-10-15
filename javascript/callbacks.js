//Callback functions

let add = function(a, b) {
  return a + b;
};

let multiply = function(a, b) {
  return (a * b);
};

let divide = function(a, b) {
  return (a / b);
};

let calc = function(a, b, callback) {
  if (typeof callback === "function") {
    return (callback(a, b));
  };
};

console.log(calc(4, 2, multiply));

var MyArr = [{
  num: 4,
  str: 'blue'
}, {
  num: 5,
  str: 'apple'
}, {
  num: 19,
  str: 'cat'
}];
//this sorts in alphabetical order
MyArr.sort(function(val1, val2) {
  if (val1.str < val2.str) {
    return (-1);
  } else {
    return (1);
  };
});
console.log(MyArr);

//this sorts in reverse alphabetical order
MyArr.sort(function(val1, val2) {
  if (val1.str > val2.str) {
    return (-1);
  } else {
    return (1);
  };
});
console.log(MyArr);

//this sorts in numerical order
MyArr.sort(function(val1, val2) {
  if (val1.num < val2.num) {
    return (-1);
  } else {
    return (1);
  };
});
console.log(MyArr);

//this sorts in reverse numerical order
MyArr.sort(function(val1, val2) {
  if (val1.num > val2.num) {
    return (-1);
  } else {
    return (1);
  };
});
console.log(MyArr);


