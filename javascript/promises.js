//Promises
let promiseToClean = new Promise(function(resolve, reject) {
  //cleaning the room
  var isClean = false;

  if (isClean) {
    resolve("Good job!");
  } else {
    reject("WTF!");
  }
});

//chaining promises
promiseToClean.then(function(fromResolve) {
  console.log("Room is..." + fromResolve);
}).catch(function(fromReject) {
  console.log("Room is..." + fromReject);
});

let cleanRoom = function() {
  return new Promise(function(resolve, reject) {
    resolve("Cleaned Room! ");
  });
};

let vaccumRoom = function(message) {
  return new Promise(function(resolve, reject) {
    resolve(message + "Vaccumed Room! ");
  });
};

let getReward = function(message) {
  return new Promise(function(resolve, reject) {
    resolve(message + "Got Reward! ");
  });
};

cleanRoom().then(function(result) {
  return vaccumRoom(result);
}).then(function(result) {
  return getReward(result);
}).then(function(result) {
	console.log(result);
});

//parallel promises (all promises are executed at the same time. Wait for all promises to be finished)
Promise.all([cleanRoom(), vaccumRoom(), getReward()]).then(function(){
	console.log("all finished");
});
//race (at least one promise is finished, then it is completed)
Promise.race([cleanRoom(), vaccumRoom(), getReward()]).then(function(){
	console.log("race finished");
});
