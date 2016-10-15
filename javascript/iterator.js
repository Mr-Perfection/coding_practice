//Iterable, Iterator

let mySet = new Set([1, 2, 3, 4, 5]);
for (let val of mySet) {
  console.log(val);
};

let anObject = {
	name: 'Bob',
  age: 42,
  friends: ['john', 'Alan', 'Peacon'],
  getName: function() {
  	return (this.name);
  }
};

for(let key in anObject ){
	console.log(key);
};

let myArray = [1,2,4,6,7,8];
let iterator = myArray[Symbol.iterator]();
console.log(iterator.next());