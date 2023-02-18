#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

#define DATASET_SIZE 23
#define EXAMPLE_DATASET_SIZE 8

#define maxValue 50
#define MAX 32767

#define DO_TEST 0

#pragma region Week 3

int* generateDataSet(int maxDataValue)
{
	int* data = (int*)malloc(DATASET_SIZE * sizeof(int));
	srand(time(NULL));

	int index;
	for (index = 0; index < DATASET_SIZE; index++)
	{
		data[index] = rand() % maxDataValue;
	}

	return data;
}

int* generateExampleDataSet()
{
	int* exampleSet = (int*)malloc(EXAMPLE_DATASET_SIZE * sizeof(int));
	exampleSet[0] = 44;
	exampleSet[1] = 23;
	exampleSet[2] = 42;
	exampleSet[3] = 33;
	exampleSet[4] = 16;
	exampleSet[5] = 54;
	exampleSet[6] = 34;
	exampleSet[7] = 18;
	
	return exampleSet;
}

void swap(int* data, int index1, int index2)
{
	int temp = data[index1];
	
	data[index1] = data[index2];
	data[index2] = temp;
}

void bubbleSort(int* data, int dataSize)
{
	int outerIndex, innerIndex, comparator;
	for (outerIndex = 0; outerIndex < dataSize - 1; outerIndex++)
	{
		comparator = (dataSize - 1);
		for (innerIndex = 0; innerIndex < comparator; innerIndex++)
		{
			if (data[innerIndex + 1] < data[innerIndex])
			{
				swap(data, innerIndex + 1, innerIndex);
			}
		}
	}
}

void optimisedBubbleSort1(int* data, int dataSize)
{
	bool didSwap;
	int outerIndex, innerIndex, comparator;
	for (outerIndex = 0; outerIndex < dataSize - 1; outerIndex++)
	{
		didSwap = false;
		comparator = (dataSize - 1 - outerIndex);
		for (innerIndex = 0; innerIndex < comparator; innerIndex++)
		{
			if (data[innerIndex + 1] < data[innerIndex])
			{
				swap(data, innerIndex + 1, innerIndex);
				didSwap = true;
			}
		}

		if (!didSwap)
		{
			return;
		}
	}
}

void optimisedBubbleSort2(int* data, int dataSize)
{
	bool didSwap;
	int outerIndex, innerIndex, comparator;
	for (outerIndex = 0; outerIndex < dataSize - 1; outerIndex++)
	{
		didSwap = false;
		comparator = dataSize - (outerIndex + 1);
		for (innerIndex = 0; innerIndex < comparator; innerIndex++)
		{
			if (data[innerIndex + 1] < data[innerIndex])
			{
				swap(data, innerIndex + 1, innerIndex);
				didSwap = true;
			}
		}

		if (!didSwap)
		{
			return;
		}
	}
}

void shakerSort(int* data, int dataSize)
{
	int leftIndex = 0;
	int rightIndex = dataSize - 1;
	bool swapped = true;

	while (swapped)
	{
		swapped = false;

		// Pass through array from left to right
		int lastSwapIndex = rightIndex, currentIndex = leftIndex;
		for (; currentIndex < rightIndex; currentIndex++)
		{
			if (data[currentIndex] > data[currentIndex + 1])
			{
				int temp = data[currentIndex];
				data[currentIndex] = data[currentIndex + 1];
				data[currentIndex + 1] = temp;
				swapped = true;
				lastSwapIndex = currentIndex;
			}
		}
		rightIndex = lastSwapIndex;

		if (!swapped)
		{
			// If no swaps were made, the array is already sorted
			return;
		}

		swapped = false;

		// Pass through array from right to left
		lastSwapIndex = leftIndex;
		currentIndex = rightIndex;
		for (; currentIndex > leftIndex; currentIndex--)
		{
			if (data[currentIndex] < data[currentIndex - 1])
			{
				int temp = data[currentIndex];
				data[currentIndex] = data[currentIndex - 1];
				data[currentIndex - 1] = temp;
				swapped = true;
				lastSwapIndex = currentIndex;
			}
		}
		leftIndex = lastSwapIndex;
	}
}


#pragma endregion

#pragma region Week 4

// Implement the SelectionSort algorithm. Check that the results are as expected (i.e. the
// integer values are sorted in ascending or descending numerical order).
void selectionSort(int* data, int dataSize)
{
	int outerIndex, innerIndex, minimumIndex;

	// One by one move boundary of unsorted subarray
	for (outerIndex = 0; outerIndex < dataSize - 1; outerIndex++)
	{
		// Find the minimum element in unsorted array
		minimumIndex = outerIndex;
		for (innerIndex = outerIndex + 1; innerIndex < dataSize; innerIndex++)
		{
			if (data[innerIndex] < data[minimumIndex])
			{
				minimumIndex = innerIndex;
			}
		}

		// Swap the found minimum element with the first element
		int temp = data[minimumIndex];
		data[minimumIndex] = data[outerIndex];
		data[outerIndex] = temp;
	}
}

// Implement the InsertionSort algorithm. Check that the results are as expected (i.e. the
// integer values are sorted in ascending or descending numerical order).
void insertionSort(int* data, int dataSize)
{
	int outerIndex, innerIndex, key;

	for (outerIndex = 1; outerIndex < dataSize; outerIndex++)
	{
		key = data[outerIndex];
		innerIndex = outerIndex - 1;

		// Move elements of data[0..outerIndex-1], that are greater than key, to one position ahead of their current position
		while (innerIndex >= 0 && data[innerIndex] > key)
		{
			data[innerIndex + 1] = data[innerIndex];
			innerIndex--;
		}

		data[innerIndex + 1] = key;
	}
}

#pragma endregion


#pragma region Output To User

void printSeperator(char seperatorCharacter, int seperatorLength)
{
	char* seperator = malloc(seperatorLength + 1);
	memset(seperator, seperatorCharacter, seperatorLength);
	seperator[seperatorLength] = 0;

	printf("\n%s\n", seperator);

	free(seperator);
}

void printHeader(char* headerText)
{
	int length = strlen(headerText) + 4;

	printf("\n");
	printSeperator('-', length);
	printf(" # %s", headerText);
	printSeperator('-', length);
	printf("\n\n");
}

void printArrayContents(char* labelText, int* data, int dataSize)
{
	printf("%s Array contents :\n -> { ", labelText);

	char* delimiter = ", ";

	int index;
	for (index = 0; index < dataSize; index++)
	{
		if (index == (dataSize - 1))
		{
			delimiter = "";
		}

		printf("%d%s", data[index], delimiter);
	}

	printf(" }\n");
}

void doSort(void (*sortFunction)(int*, int), char* sortName)
{
	printHeader(sortName);

	// Example Data Set

	printf("'Example' DataSet\n");
	int* exampleDataSet = generateExampleDataSet();
	printArrayContents("\nUnsorted", exampleDataSet, EXAMPLE_DATASET_SIZE);

	printf("\n<Sorting 'Example' DataSet>\n\n");
	sortFunction(exampleDataSet, EXAMPLE_DATASET_SIZE);
	printArrayContents("Sorted", exampleDataSet, EXAMPLE_DATASET_SIZE);

	free(exampleDataSet);

	printf("\n\n");

	// Generated Data Set

	printf("'Generated' DataSet\n");
	int* dataSet = generateDataSet(maxValue);
	printArrayContents("\nUnsorted", dataSet, DATASET_SIZE);

	printf("\n<Sorting 'Generated' DataSet>\n\n");
	sortFunction(dataSet, DATASET_SIZE);
	printArrayContents("Sorted", dataSet, DATASET_SIZE);

	free(dataSet);

	printf("\n\n");
}

#pragma endregion


#pragma region Testing

void test()
{
	int N = 5;
	int i;
	for (i = 0; i < N / 2; ++i)
	{
		printf("%d ", i);
	}
}

#pragma endregion


int main()
{
	if (DO_TEST)
	{
		test();
	}
	else
	{
		doSort(bubbleSort, "Bubble");

		doSort(optimisedBubbleSort1, "Bubble (Optimisation 1)");

		doSort(optimisedBubbleSort2, "Bubble (Optimisation 2)");

		doSort(shakerSort, "Shaker");

		doSort(selectionSort, "Selection");

		doSort(insertionSort, "Insertion");
	}

	Sleep(10);

	return 0;
}
