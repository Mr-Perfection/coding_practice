function VendingMachine(coins) {
	this.coins = coins;
}

VendingMachine.prototype.vending = function(price, credit) {
	change = {};
	var paidValue = 0;
	for (var coinValue in credit){
		if (!this.coins.hasOwnProperty(coinValue))
			change[coinValue] = credit[coinValue];
		else {
			paidValue += credit[coinValue] * coinValue;
			this.coins[coinValue] += credit[coinValue];
		}
	}
	if (paidValue < price)
		change = credit;
	else if (paidValue == price)
		change = {};
	else {
		var coinsValues = [];
	}

}