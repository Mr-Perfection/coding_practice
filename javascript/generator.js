//generator

//iterator
let i = [1, 2, 3, 4];
let iterator = i[Symbol.iterator]();

//console.log(iterator.next());
//console.log(iterator.next());
//console.log(iterator.next());
//console.log(iterator.next());
//console.log(iterator.next());

function* generator() {
  yield(1);
  yield(2);
  yield(3);
  yield(4);
};

let iter = generator();
//console.log(iter.next());

function* infiniteMaker() {
  let i = 0;
  while (true) {
    yield i;
    i++;
  };
};

let iterate = infiniteMaker();
console.log(iterate.next());

function request(url) {
  return new Promise(function(resolve, reject) {
    makeAjaxCall(url, function(err, text) {
      if (err) reject(err);
      else resolve(text);
    });
  });
};

function *generate(){
	yield request('url1'); //try to resolve this request first
	yield request('url2'); //then proceed to next request
};