#pragma once

void generateData(int maxDataValue);			// Generate array of data
void printArrayContents(const char* labelText);	//
void visitCell(int index);						// Print cell currently visited
void packLeft(int k);							//
void outputExerciseHeader(char* headerText);	// Output Exercise Header

void exercise1();   // Exercise 1 : Scan the given array from left to right.
void exercise2();   // Exercise 2 : Scan the given array from right to left.
void exercise3();   // Exercise 3 : Scan the given array from left to centre, then from right to centre. 
void exercise4();   // Exercise 4 : Scan the given array from centre to left, then centre to right.
void exercise5();   // Exercise 5 : Scan the given array from left to right, then right to left.
void exercise6();   // Exercise 6 : Scan the given array from left to right, then right to left, as many times as there are items in the array.
void exercise7();   // Exercise 7 : Scan the given array from left to right, then back to left, then repeat process but at right end, each time, one cell short than the previous pass.
void exercise8();   // Exercise 8 : Scan the given array from left to right, then right to left, then repeat process but at left end, each time, one cell short than the previous pass.
void exercise9();   // Exercise 9 : Scan the given array from left to right, then right to left, then repeat process but at each end, each time, one cell short than the previous pass