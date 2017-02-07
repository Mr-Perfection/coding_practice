# Complete the function below.


def  arbitrage(quotes):
    results = []
    for quote in quotes:
        # initial 100,000 dollars
        initial = 100000
        attrs = quote.split(' ')
        attrs = list(map(float,attrs))
        result = initial/attrs[0]/attrs[1]/attrs[2]
        profit = int(result-initial)
        if profit <= 0:
            results.append(0)
        else:
            results.append(profit)
    return results
