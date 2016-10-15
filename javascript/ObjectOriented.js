//Object oriented 

var Person = function(name, email) {
  this.name = name;
  this.email = email;
};

var person1 = new Person("Stephen", "sungsooea@gmail.com");
//console.log(person1 instanceof Person);
//console.log(person1.constructor);
//delete(person1.name);
//console.dir(person1);
var Pizza = function(name) {
  // this is private attributees
  this.name = name;
  var crust = ' olah!';
  this.getName = function() {
    return (crust);
  };
  var getCrust = function() {
  	var fake = "got you";
    return (fake);
  };
  var tmp = {};
  tmp.getCrust = getCrust;
  return (tmp);
};

var pizza1 = new Pizza("hello");
//console.dir(pizza1);
//console.log(pizza1.getName());
console.log(pizza1.getCrust());

