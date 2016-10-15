// Call, Apply, Bind

var obj = {num:2};
var obj2 = {num:5};
var obj3 = {num:6};
var arr = [5,5,5];
var addToObj = function(a,b,c){
	return (a + b + c + this.num);
};

console.log(addToObj.call(obj, 2, 1, 3));
console.log(addToObj.apply(obj, arr));
console.log(addToObj.apply(obj2, arr));

var bound = addToObj.bind(obj3);
//console.dir(bound);
console.log(bound(1,2,3));