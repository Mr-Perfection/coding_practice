#include <stdlib.h>
#include <stdio.h>
int ft_atoi(const char *str);

int main(int argc, char** argv)
{
	if (argc == 2)
	{
		printf("the original atoi function is: %d", atoi(argv[1]));
		printf("my atoi function is: %d", ft_atoi(argv[1]));

	}

	return (0);
}
