#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define arraySize 15
#define maxValue 50
#define MAX 32767

int dataArray[arraySize] = { 41, 30, 19, 25, 38, 27, 2, 39, 23, 48, 7, 11, 16, 17, 24 };

int main(int argc, char* argv[])
{
	// Use the method below if you want to test you method with a random array of size maxValue generateData(maxValue);

	printArrayContents("\n");

	exercise1();
	exercise2();
	exercise3();
	exercise4();
	exercise5();
	exercise6();
	exercise7();
	exercise8();
	exercise9();
}


// Generate array of data
void generateData(int maxDataValue)
{
	int iterator = 0;

	srand(time(0));

	for (iterator = 0; iterator < arraySize; iterator++)
	{
		dataArray[iterator] = rand() % maxDataValue;
	}
}

void printArrayContents(char* labelText)
{
	int iterator = 0;

	printf("%sArray contents: {", labelText);

	for (iterator = 0; iterator < arraySize; iterator++)
	{
		printf("%d ", dataArray[iterator]);
	}

	printf("}\n");
}

// Print cell currently visited
void visitCell(int index)
{
	printf("%2d ", dataArray[index]);
}

void packLeft(int k)
{
	int iterator = 0;

	for (iterator = 0; iterator < k; iterator++)
	{
		printf("   ");
	}
}

// Exercise 1 : Scan the given array from left to right.
void exercise1()
{
	int iterator = 0;

	printf("Scanning array from left to right:\n");

	for (iterator = 0; iterator < arraySize; iterator++)
	{
		visitCell(iterator);
	}

	printf("\n\n");
}

// Exercise 2 : Scan the given array from right to left.
void exercise2()
{
	int iterator = 0;

	printf("Scanning array from right to left:\n");

	for (iterator = arraySize - 1; iterator >= 0; iterator--)
	{
		visitCell(iterator);
	}

	printf("\n\n");
}

// Exercise 3 : Scan the given array from left to centre, then from right to centre. 
void exercise3()
{
	int iterator = 0;

	printf("Scanning array from left to centre, then right to centre:\n");

	for (iterator = 0; iterator < arraySize / 2; iterator++)
	{
		visitCell(iterator);
	}

	for (iterator = arraySize - 1; iterator >= arraySize / 2; iterator--)
	{
		visitCell(iterator);
	}

	printf("\n\n");
}

// Exercise 4 : Scan the given array from centre to left, then centre to right.
void exercise4()
{
	int iterator = 0;

	printf("Scanning array from centre to left, then centre to right:\n");

	for (iterator = arraySize / 2 - 1; iterator >= 0; iterator--)
	{
		visitCell(iterator);
	}

	for (iterator = arraySize / 2; iterator < arraySize; iterator++)
	{
		visitCell(iterator);
	}

	printf("\n\n");
}

// Exercise 5 : Scan the given array from left to right, then right to left.
void exercise5()
{
	int iterator = 0;

	printf("Scanning array from left to right, then right to left:\n");

	for (iterator = 0; iterator < arraySize; iterator++)
	{
		visitCell(iterator);
	}

	for (iterator = arraySize - 1; iterator >= 0; iterator--)
	{
		visitCell(iterator);
	}

	printf("\n\n");
}

// Exercise 6 : Scan the given array from left to right, then right to left, as many times as there are items in the array.
void exercise6()
{
	int outerIterator = 0;
	int iterator = 0;

	printf("Scanning array from left to right, then right to left, as many times as there are items in the array:\n");

	for (outerIterator = 0; outerIterator < arraySize; outerIterator++)
	{
		for (iterator = 0; iterator < arraySize; iterator++)
		{
			visitCell(iterator);
		}

		for (iterator = arraySize - 1; iterator >= 0; iterator--)
		{
			visitCell(iterator);
		}
	}

	printf("\n\n");
}

// Exercise 7 : Scan the given array from left to right, then back to left, then repeat process but at right end, each time, one cell short than the previous pass.
void exercise7()
{
	int outerIterator = 0;
	int iterator = 0;

	printf("Scanning array from left to right, then right to left, then repeat process but at right end, each time, one cell short than the previous pass:\n");

	for (outerIterator = 0; outerIterator < arraySize; outerIterator++)
	{
		for (iterator = 0; iterator < arraySize - outerIterator; iterator++)
		{
			visitCell(iterator);
		}

		for (iterator = arraySize - 1 - outerIterator; iterator >= 0; iterator--)
		{
			visitCell(iterator);
		}
	}

	printf("\n\n");
}

// Exercise 8 : Scan the given array from left to right, then right to left, then repeat process but at left end, each time, one cell short than the previous pass.
void exercise8()
{
	int outerIterator = 0;
	int iterator = 0;

	printf("Scanning array from left to right, then right to left, then repeat process but at left end, each time, one cell short than the previous pass:\n");

	for (outerIterator = 0; outerIterator < arraySize; outerIterator++)
	{
		for (iterator = outerIterator; iterator < arraySize; iterator++)
		{
			visitCell(iterator);
		}

		for (iterator = arraySize - 1 - outerIterator; iterator >= outerIterator; iterator--)
		{
			visitCell(iterator);
		}
	}

	printf("\n\n");
}

// Exercise 9 : Scan the given array from left to right, then right to left, then repeat process but at each end, each time, one cell short than the previous pass.
void exercise9()
{
	int outerIterator = 0;
	int iterator = 0;

	printf("Scanning array from left to right, then right to left, then repeat process but at each end, each time, one cell short than the previous pass:\n");

	for (outerIterator = 0; outerIterator < arraySize; outerIterator++)
	{
		for (iterator = outerIterator; iterator < arraySize - outerIterator; iterator++)
		{
			visitCell(iterator);
		}

		for (iterator = arraySize - 1 - outerIterator; iterator >= outerIterator; iterator--)
		{
			visitCell(iterator);
		}
	}

	printf("\n\n");
}
