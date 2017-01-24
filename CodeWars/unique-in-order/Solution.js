var uniqueInOrder=function(iterable){
  if (iterable.length == 0) return ([]);
  var arr = [];
  arr.push(iterable[0]);
  for (var i = 1; i < iterable.length; ++i)
  {
    if (iterable[i] != iterable[i - 1]) arr.push(iterable[i]);
  }
  return (arr);
}


//best practice...wtf
var uniqueInOrder = function (iterable)
{
  return [].filter.call(iterable, (function (a, i) { return iterable[i - 1] !== a }));
}