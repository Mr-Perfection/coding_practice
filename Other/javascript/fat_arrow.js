//Fat arrow
"use strict";
let square = (a) => {
  return (a * a)
};
console.log(square(2));

let mult = (a, b) => {
  return (a * b)
};

//when should you use Fat Arrow
//1. when you try to have access to this from upper level function.
var x = function() {
  this.i = 1;
  var that = this;
  setTimeout(function() {
    that.i++;
    console.log(that.i);
  }, 1);
};
var y = function() {
  this.i = 1;
  setTimeout(() => {
    this.i++;
    console.log(this.i);
  });
};


var xx = new x();
var yy = new y();
