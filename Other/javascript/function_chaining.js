//function chaining
var obj = function() {
  var i = 0;

  var add = function(j) {
    i += j;
    return (this);
  };
  var subtract = function(j) {
    i -= j;
    return (this);
  };
  var print = function() {
    console.log("the number is: " + i);
  };
  return ({
    add: add,
    subtract: subtract,
    print: print
  });
};

var obj1 = new obj();
obj1.add(2).subtract(1).print();
obj1.add(2).subtract(1).print();
