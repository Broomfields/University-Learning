///
/// ---------------------------------------------------------------------------------------------------------------------------------------------------
///	File			| Console Manager.h
///	Description		| The Console Manager class is a static support class that provides debugging functionality to the rest of the project. 
/// ---------------------------------------------------------------------------------------------------------------------------------------------------
///	Note : Any revisions should be listed in the source file with changes made.


#pragma once
#include <iostream>

namespace TaxRateCalculator
{
	using namespace System;
	using namespace System::Collections;
	using namespace System::Collections::Concurrent;
	using namespace System::Timers;

	public ref class ConsoleManager
	{
		// Utility Properties
		// -------------------
	private:

		static double DiagnositicsIndex;
		static int DiagnositicsID;

		static bool ConsoleInitialised;
		static bool PreInitialisationBuffer;
		static unsigned int PreInitialisationBufferSize;
		static unsigned int PreInitialisationBufferIndex;
		static bool Exiting;

		static System::Collections::Concurrent::ConcurrentQueue<Tuple<DateTime, String^, String^, int>^> MessageQueue;
		static System::Timers::Timer^ ConsoleTimer;



		// Public Functions
		// -----------------
	public:

		// Returns a diagnostic ID which is incremented on every call
		static int NewDiagnositicsID(); // Used for identifiying objects

		// Outputs formatted messages to spy and to the live debug console if it is enabled
		static void DiagMessage(String^ message);				// Outputs 'Diagnostics' message to spy with the appropriate formatting
		static void DiagMessage(String^ message, bool push);	// Outputs 'Diagnostics' message to spy with the appropriate formatting (Will only output to SPY if push == true)
		static void InfoMessage(String^ message);				// % ~ 'Info' variant of the above
		static void InfoMessage(String^ message, bool push);	// % ~ 'Info' variant of the above (Will only output to SPY if push == true)
		static void ErrorMessage(String^ message);				// % ~ 'Error' variant of the above
		static void FatalMessage(String^ message);				// % ~ 'Fatal' variant of the above
		static void ConsoleMessage(String^ message);			// Outputs to console (Public Accessor - Doesn't print to spy)

		static void DebugMessage(String^ message);				// ONLY outputs to SPY if asserts ifdef DEBUG == true
		static void DebugMessage2(String^ message);				// Second colour variant of the above
		static void DebugMessage3(String^ message);				// Third colour variant of the above

		static void MemoryDebugMessage(String^ preMessage, unsigned int startBytes, unsigned int endBytes);	// Debug message, but in a different colour to stand out
		static unsigned int KB(unsigned int bytes);	// Returns Kilobytes from given Bytes
		static unsigned int MB(unsigned int bytes);	// Returns Megabytes from given Bytes

		//static void UserError(String^ message); // Outputs error message box to user
		//static void UserMessage(String^ header, String^ message, System::Windows::Forms::MessageBoxIcon icon); // Outputs to message box to user
		//static void UserMessage(String^ header, String^ message, String^ messageType, int consoleType, System::Windows::Forms::MessageBoxIcon icon); // Outputs to message box to user (called by all other Message functions)

		static void InitialiseDebugConsole();	// Allocates/attaches a new/existing console to the application for live diagnostics output
		static void TerminateDebugConsole();	// Frees the console alocated to the application for live diagnostics output

		static void Exit();

		// Utility Functions
		// ------------------
	private:

		static void SetTimer();																				// Initialises and starts diagnostics timer thread
		static void EnqueueMessage(DateTime time, String^ message, String^ type, int colourPreset);			// Enqueues a message if the console has either been initialised or the initial console buffer has yet to be exceeded
		static void OutputConsoleMessage(DateTime time, String^ message, String^ type, int colourPreset);	// Outputs to console (called by all other Message functions ~ ALL CALLERS MUST ASSERT ConsoleInitialised)
		static void SetConsoleColours(int colourPreset);								// Sets console colours base on the preset number given

		// Events
		// -------
	private:
		static void OnTimedEvent(System::Object^ source, System::Timers::ElapsedEventArgs^ e);


		// Constructors
		// -------------
	public:

		static ConsoleManager(void);

	};
}

