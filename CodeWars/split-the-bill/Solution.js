function splitTheBill(x) {;
  const avg = Object.keys(x).reduce((previous, next) => previous + x[next], 0) / Object.keys(x).length;
  Object.keys(x).forEach(v => x[v] = Number((x[v] - avg).toFixed(2)));
  return x;
}