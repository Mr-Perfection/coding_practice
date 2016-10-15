//iif (immediately invoked function)
var counter = (function(){
	var i = 0;
  return({
  	set: function(j){
    	i += j;
    },
    get: function(){
    	return (i);
    },
    increment: function(){
    	i++;
    }
  });
})();

counter.set(4);
counter.increment(4);
console.log(counter.get());