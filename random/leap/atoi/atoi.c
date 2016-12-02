/*function check_digits
 * description: check whether the character is digits or not.
 * @param: char c, charcter in the string.
 * @return: int x, 0 if it is a non-digit  false, 1 if it is digit.
 * */
int check_digits(char c)
{
	if ((c - '0') >= 0 && (c - '0') <= 9)
		return (1);
	else
		return (0);

}

/* function atoi
 * description: convert string to integer
 * @param: string str, the string value
 * @return: int result, the integer value of str. 
 * */
int ft_atoi(const char *str)
{
	int result = 0;
	int i = 0;
	int neg = 1; //initially it is set to positive.

	//check if str* exists or not.
	if (str == 0)
		return (0);
	
	//check whitespaces and skip them (based on atoi behavior.)
	while (str[i] == ' ' || str[i] == '\n' || str[i] == '\t')
		i++;

	//check sign. Whether negative or positive
	if (str[i] == '-')
	{
		neg = -1;
		i++;
	}
	else if (str[i] == '+')
	{
		neg = 1;
		i++;
	}

	//iterate through string array
	while (check_digits(str[i]))
	{
		result = result * 10 + (str[i] - '0');
		i++;
	}
	return (result * neg);

}
