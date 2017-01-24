function cakes(recipe, available) {
  //if the recipe has a longer length than available, then return 0.
  if (recipe.length > available.length) return (0);
  var min = Number.MAX_VALUE;
  
  for (var key in recipe)
  {
    if (recipe.hasOwnProperty(key) && available.hasOwnProperty(key))
    {
      var calc = Math.floor(available[key] / recipe[key]);
      min =  (calc) < min ? calc : min;
    }
    else
      return (0);
  }
  return (min);
}

//much shorter solution....insane
function cakes(recipe, available) {
  return Object.keys(recipe).reduce(function(val, ingredient) {
    return Math.min(Math.floor(available[ingredient] / recipe[ingredient] || 0), val)
  }, Infinity)  
}
function cakes(recipe, available) {
  return Object.keys(recipe).reduce(function(val, ingredient) {
  	return (Math.min(Math.floor(available[ingredient] / recipe[ingredient]) || 0), val)
  }, Infinity);
}