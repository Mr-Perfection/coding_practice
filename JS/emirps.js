function isPrime(n) {
  let max = Math.sqrt(n);
  for (let i = 2; i <= max; ++i) {
    if (n % i === 0) {
      return false;
    }
  }
  return true;
}

function findEmirp(n){
  let emirps = [];
  let sol = [0,0,0];
  if (n < 14) return sol;
  for (let i = 13; i < n; ++i) {
    if (isPrime(i)) {
      let rev = +i.toString().split("").reverse().join("");
      if (rev !== i && isPrime(rev))
        emirps.push(i);
    }
  }
//   console.log(emirps);
  sol[0] = emirps.length;
  sol[1] = emirps[emirps.length - 1];
  sol[2] = emirps.reduce( (e1,e2)=> e1 + e2, 0);
  return sol;
}

