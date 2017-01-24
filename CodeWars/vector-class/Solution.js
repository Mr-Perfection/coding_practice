var Vector function (components) {
	this.items = components;
	this.length = components.length;
}

Vector.prototype = {
	do: function (action, vector)
	{
		if (vector.length !== this.length) { throw 'Different length!';}
		return new Vector(this.items.map(function (v, k){
			return eval (v + action + vector.items[k]);
		}));
	},
	add: function (v) { return this.do('+', v); },
	subtract: function (v) { return this.do('-', v); },
	sum: function (v) { return eval(v.items.join('+')); },
	dot: function (v) { return this.sum(this.do('*', v)); },
	norm: function () { return Math.sqrt(this.dot((this)); },
	toString: function() { return '(' + this.items + ')'; },
	equals: function (v) { return this.toString() == v.toString(); }  
}




//mine
var Vector = function (components) {
  this.arr = components;
  this.length = components.length;
};

Vector.prototype = {
  do: function (action, vector)
  {
    //if the input vector does not have a same length as this.length, throw an error
    if (vector.length !== this.length) {throw 'different length';};
    
    //return new vector with mapping with eval function
    return new Vector(this.arr.map(function(v, k) {
      return eval(v + action + vector.arr[k]);
    }));
  },
  //eval functions
  add: function (v) { return (this.do('+', v));},
  subtract: function (v) { return (this.do('-', v));},
  sum: function (v) { return (eval(v.arr.join('+')));},
  dot: function (v) { return (this.sum(this.do('*', v)));},
  norm: function () { return (Math.sqrt(this.dot(this)));},
  toString: function () { return ('(' + this.arr + ')');},
  equals: function (v) {return (this.toString() == v.toString());}
};