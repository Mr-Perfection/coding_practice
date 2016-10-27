//spread operator and string interpolation
var x = function(...n){

};

x(1,2,3,4);


var y = function(x,y,z, ...n){

};

var arr1 = [1,2,3];
var arr2 = [1,2,...arr1,5];
//console.log(arr2);

//string interpolation
var str = "hello"
var one = 1;
var two = 2;
var ans = `yay! you are ${str}
${one + two}`;
//console.log(ans);

let test = function(str1, ...arr){
	console.log(str1);
  console.log(arr);
};

test`yay! you are ${str}
${one + two}`;

console.log('hello world'.endsWith('orld'));
console.log('hello world'.startsWith('he'));
console.log('hello world'.repeat(5));
console.log(String.raw`no new line \n`);