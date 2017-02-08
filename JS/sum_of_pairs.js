/*
  [11, 3, 7, 5]
  dict = (11,-1),(3,7),(7,3),(5,5)
  mem = [-1,7,3]
              ^ matched!
  [10, 5, 2, 3, 7, 5], 10
  dict = (10,0),(5,5),(2,8),(3,7),(7,3),(5,5)
  * iterate through ints, check element as a key and store a value in mem, and
    and if the element is inside the mem, return [key,value]

  mem =  [0,5,8,7]
                ^
O(n) wtf time out?
craop... didnt know indexOf is o(n) and its better to use let i = 0;i<length;++i inside for statement
*/
var sum_pairs=function(ints, s){
    mem = [];
    for(let i in ints){
      if(mem.indexOf(ints[i])>-1){
        return [s-ints[i],ints[i]]
      }
      mem.push(s-ints[i])
    }
    return undefined
}


var sum_pairs=function(ints, s){
    let mem = {}
    for(let i = 0; i < ints.length; ++i){
      if(mem[s-ints[i]]){
        return [s-ints[i],ints[i]]
      }
      mem[ints[i]] = true
    }
    return undefined
}
