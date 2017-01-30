var Cat = (function () {
	let totalWeight = 0, count = 0;
	var constr = function(name, weight) {
		if (!name || !weight) { throw 'Cat(name, weight) please';}
		count++;
		totalWeight += weight;
		Object.defineProperty(this, "weight", 
			{
				set: function(v){
					totalWeight = totalWeight - weight + v;
					weight = v;
				},
				get: function() {return weight;}
			}
		);
	}
	constr.averageWeight = function() {
		return totalWeight / count;
	}
	return constr;
}());