#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

#define arraySize 23
#define maxValue 50
#define MAX 32767

int dataArray[arraySize];

void generateData(int maxDataValue)
{
	srand(time(NULL));

	int index;
	for (index = 0; index < arraySize; index++)
	{
		dataArray[index] = rand() % maxDataValue;
	}
}

int generateExampleDataSet()
{
	int exampleSize = 8;
	int exampleSet[8] = { 44, 23, 42, 33, 16, 54, 34, 18 };
	
	int index;
	for (index = 0; index < arraySize; index++)
	{
		if (index < exampleSize)
		{
			dataArray[index] = exampleSet[index];
		}
		else
		{
			dataArray[index] = 0;
		}
	}

	return exampleSize;
}

void printArrayContents(char* labelText)
{
	printf("%s Array contents : { ", labelText);

	int index;
	for (index = 0; index < arraySize; index++)
	{
		printf("%d ", dataArray[index]);
	}

	printf("}\n");
}

void swap(int* dataArray, int index1, int index2)
{
	int temp = dataArray[index1];
	
	dataArray[index1] = dataArray[index2];
	dataArray[index2] = temp;
}

void bubbleSort()
{
	int dataSize = generateExampleDataSet();

	int outerIndex, innerIndex;
	for (outerIndex = 0; outerIndex < dataSize - 1; outerIndex++)
	{
		for (innerIndex = 0; innerIndex < (dataSize - (outerIndex - 1)); innerIndex++)
		{
			if (dataArray[innerIndex + 1] < dataArray[innerIndex])
			{
				swap(dataArray, innerIndex + 1, innerIndex);
			}
		}
	}
}

void bubbleSort_opt1()
{
	int dataSize = generateExampleDataSet();

	bool didSwap;
	int outerIndex, innerIndex;
	for (outerIndex = 0; outerIndex < dataSize - 1; outerIndex++)
	{
		didSwap = false;
		for (innerIndex = 0; innerIndex < (dataSize - (outerIndex - 1)); innerIndex++)
		{
			if (dataArray[innerIndex + 1] < dataArray[innerIndex])
			{
				swap(dataArray, innerIndex + 1, innerIndex);
				didSwap = true;
			}
		}

		if (!didSwap)
		{
			return;
		}
	}
}

void bubbleSort_opt2()
{
	int dataSize = generateExampleDataSet();

	bool didSwap;
	int outerIndex, innerIndex;
	for (outerIndex = 0; outerIndex < dataSize - 2 - outerIndex; outerIndex++)
	{
		didSwap = false;
		for (innerIndex = 0; innerIndex < (dataSize - (outerIndex - 1)); innerIndex++)
		{
			if (dataArray[innerIndex + 1] < dataArray[innerIndex])
			{
				swap(dataArray, innerIndex + 1, innerIndex);
				didSwap = true;
			}
		}

		if (!didSwap)
		{
			return;
		}
	}
}

void shakerSort()
{
	// YOUR CODE GOES HERE
}

void selectionSort()
{
	// YOUR CODE GOES HERE
}

void insertionSort()
{
	// YOUR CODE GOES HERE
}


void test()
{
	int N = 5;
	int i;
	for (i = 0; i < N / 2; ++i)
	{
		printf("%d ", i);
	}
}

int main()
{
	//// Bubble sort
	//generateData(maxValue);
	//printArrayContents("\nUnsorted");

	//printf("Sorting...\n");
	//bubbleSort();
	//printArrayContents("Bubble");

	//
	//// Bubble sort optimised 1
	//generateData(maxValue);
	//bubbleSort();
	//printArrayContents("\nUnsorted");

	//printf("Sorting...\n");
	//bubbleSort_opt1();
	//printArrayContents("Bubble opt 1");

	//// Bubble sort optimised 2
	//generateData(maxValue);
	//printArrayContents("\nUnsorted");

	//printf("Sorting...\n");
	//bubbleSort_opt2();
	//printArrayContents("Bubble opt 2");

	//// Cocktail Shaker sort
	//generateData(maxValue);
	//printArrayContents("\nUnsorted");

	//printf("Sorting...\n");
	//shakerSort();
	//printArrayContents("Shaker");

	//// Selection sort
	//generateData(maxValue);
	//printArrayContents("\nUnsorted");

	//printf("Sorting...\n");
	//selectionSort();
	//printArrayContents("Selection");

	//// Insertion sort
	//generateData(maxValue);
	//printArrayContents("\nUnsorted");

	//printf("Sorting...\n");
	//insertionSort();
	//printArrayContents("Insertion");
	
	test();

	return 0;
}
