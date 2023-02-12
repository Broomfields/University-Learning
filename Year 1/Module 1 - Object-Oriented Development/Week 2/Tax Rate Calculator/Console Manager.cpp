///
/// ---------------------------------------------------------------------------------------------------------------------------------------------------
///	File			| Console Manager.cpp
///	Description		| The Console Manager class is a static support class that provides debugging functionality to the rest of the project. 
/// ---------------------------------------------------------------------------------------------------------------------------------------------------
/// Revison Author	| SB
/// Revison	Index	| 0
/// Revision Date	| 20/04/2022
/// ---------------------------------------------------------------------------------------------------------------------------------------------------
///	Note : Any further revisions should be listed in the source file with changes made.
///


#include "Console Manager.h"

#include <windows.h>
//#include <iostream>

using namespace TaxRateCalculator;

#pragma region Constructors


static ConsoleManager::ConsoleManager(void)
{
	DiagnositicsIndex = 0;
	DiagnositicsID = 0;

	ConsoleInitialised = false;
	PreInitialisationBuffer = true;
	PreInitialisationBufferSize = 1000;
	PreInitialisationBufferIndex = 0;
}


#pragma endregion


#pragma region Events


void ConsoleManager::OnTimedEvent(System::Object^ source, System::Timers::ElapsedEventArgs^ e)
{
	if (ConsoleInitialised)
	{
		while (MessageQueue.Count > 0)
		{
			Tuple<DateTime, String^, String^, int>^ message = nullptr;

			if (MessageQueue.TryDequeue(message))
			{
				OutputConsoleMessage(message->Item1, message->Item2, message->Item3, message->Item4);
			}
			else
			{
				ErrorMessage("Failed to Dequeue a diagnostics message... (Seeing this means that the message ended up being dequeued on a retry) ");
			}
		}
	}
}


#pragma endregion


#pragma region Utility Functions


// Initialises and starts console timer thread
void ConsoleManager::SetTimer()
{
	try
	{
		ConsoleTimer = gcnew System::Timers::Timer(500);

		ConsoleTimer->Elapsed += gcnew System::Timers::ElapsedEventHandler(ConsoleManager::OnTimedEvent); // Sets elapsed event

		ConsoleTimer->AutoReset = true; // Triggers elapsed event more than once

		ConsoleTimer->Enabled = true; // Starts timer


		// If the timer is declared in a long-running method, use KeepAlive to prevent garbage collection
		// from occurring before the method ends.
		GC::KeepAlive(ConsoleTimer);
	}
	catch (Exception^ e)
	{
		ConsoleManager::ErrorMessage(String::Format("ProdigyManager - Failed to initialise diagnostics timer! \nMore Information: {0}", e->Message));
	}
}


void ConsoleManager::EnqueueMessage(DateTime time, String^ message, String^ type, int colourPreset)
{
	bool enqueue = (ConsoleInitialised || PreInitialisationBuffer);
	if (enqueue)
	{
		MessageQueue.Enqueue(Tuple::Create(time, message, type, colourPreset));

		if (!ConsoleInitialised)
		{
			PreInitialisationBufferIndex++;

			if (PreInitialisationBufferIndex >= PreInitialisationBufferSize)
			{
				PreInitialisationBuffer = false;
				String^ bufferMessage = "Pre-Console-Initialisation-Buffer has hit maximum capacity. \nAny following messages will not be added to the console buffer until it initialised.";
				MessageQueue.Enqueue(Tuple::Create(DateTime::Now, bufferMessage, "FATAL", 3));
			}
		}
	}

}


// Outputs to console (called by all other Message functions ~ ALL CALLERS MUST ASSERT ConsoleInitialised)
void ConsoleManager::OutputConsoleMessage(DateTime time, String^ message, String^ type, int colourPreset)
{
	String^ preface = String::Format("{0,5} | {1} | {2} | ", ++DiagnositicsIndex, time.ToLongTimeString(), type->PadLeft(12));
	String^ extraPreface = "\n      |          |              | ~ ";

	message = message->Replace("\n", extraPreface);
	String^ output = preface + message;

	SetConsoleColours(colourPreset);
	Console::WriteLine(output);
	Console::ResetColor();
}


// Sets console colours base on the preset number given
void ConsoleManager::SetConsoleColours(int colourPreset)
{
	switch (colourPreset)
	{
	case 0: // Diagnostic
	{
		Console::BackgroundColor = ConsoleColor::Yellow;
		Console::ForegroundColor = ConsoleColor::Black;
		break;
	}
	case 1: // Information
	{
		Console::BackgroundColor = ConsoleColor::Green;
		Console::ForegroundColor = ConsoleColor::Black;
		break;
	}
	case 2: // Error
	{
		Console::BackgroundColor = ConsoleColor::Red;
		Console::ForegroundColor = ConsoleColor::White;
		break;
	}
	case 3: // Fatal
	{
		Console::BackgroundColor = ConsoleColor::DarkRed;
		Console::ForegroundColor = ConsoleColor::White;
		break;
	}
	case 4: // Debug
	{
		Console::BackgroundColor = ConsoleColor::Blue;
		Console::ForegroundColor = ConsoleColor::White;
		break;
	}
	case 5: // Debug 2
	{
		Console::BackgroundColor = ConsoleColor::DarkMagenta;
		Console::ForegroundColor = ConsoleColor::White;
		break;
	}
	case 6: // Debug 3
	{
		Console::BackgroundColor = ConsoleColor::Cyan;
		Console::ForegroundColor = ConsoleColor::Black;
		break;
	}
	case 7: // Diagnostic
	{
		Console::BackgroundColor = ConsoleColor::Gray;
		Console::ForegroundColor = ConsoleColor::Black;
		break;
	}
	default:
	{
		Console::BackgroundColor = ConsoleColor::White;
		Console::ForegroundColor = ConsoleColor::Black;
		break;
	}

	};
}


#pragma endregion


#pragma region Public Functions


// Returns a diagnostic ID which is incremented on every call
int ConsoleManager::NewDiagnositicsID() // Used for identifiying objects
{
	DiagnositicsID++;
	return DiagnositicsID;
}


// Outputs formatted DEBUG messages to spy and the console
void ConsoleManager::DiagMessage(String^ message)
{
	DiagMessage(message, false);
}


void ConsoleManager::DiagMessage(String^ message, bool push)
{
	//if (push)
	//{
	//	Report(svdiag, (CString)message);
	//}

	EnqueueMessage(DateTime::Now, message, "DIAGNOSTIC", 0);
}


void ConsoleManager::InfoMessage(String^ message)
{
	InfoMessage(message, false);
}


void ConsoleManager::InfoMessage(String^ message, bool push)
{
	//if (push)
	//{
	//	Report(svinfo, (CString)message);
	//}

	EnqueueMessage(DateTime::Now, message, "INFORMATION", 1);
}


void ConsoleManager::ErrorMessage(String^ message)
{
	//Report(sverror, (CString)message);

	EnqueueMessage(DateTime::Now, message, "ERROR", 2);
}


void ConsoleManager::FatalMessage(String^ message)
{
	//Report(svfatal, (CString)message);

	EnqueueMessage(DateTime::Now, message, "FATAL", 3);
}


// Outputs to console (Public Accessor - Doesn't print to spy)
void ConsoleManager::ConsoleMessage(String^ message)
{
	EnqueueMessage(DateTime::Now, message, "DIAGNOSTIC", 0);
}


// Is DiagMessage but asserts ifdef DEBUG
void ConsoleManager::DebugMessage(String^ message)
{
//#ifdef DEBUG
	//Report(svdiag, (CString)message);
//#endif // DEBUG

	EnqueueMessage(DateTime::Now, message, "DEBUG", 4);
}


// Debug message, but in a different colour to stand out
void ConsoleManager::DebugMessage2(String^ message)
{
//#ifdef DEBUG
	//Report(svdiag, (CString)message);
//#endif // DEBUG

	EnqueueMessage(DateTime::Now, message, "DEBUG", 5);
}


// Debug message, but in a different colour to stand out
void ConsoleManager::DebugMessage3(String^ message)
{
//#ifdef DEBUG
	//Report(svdiag, (CString)message);
//#endif // DEBUG

	EnqueueMessage(DateTime::Now, message, "DEBUG", 6);
}


// Debug message, but in a different colour to stand out
void ConsoleManager::MemoryDebugMessage(String^ preMessage, unsigned int startBytes, unsigned int endBytes)
{
	unsigned int startMB = MB(startBytes), endMB = MB(endBytes), diffMB = endMB - startMB;
	String^ message = String::Format("{0} ~ Start = {1}MBs ~ End = {2}MBs ~ Difference = {3}MBs", preMessage, startMB, endMB, diffMB);

#ifdef DEBUG
	//Report(svdiag, "MEMORY - " + (CString)message);
#endif // DEBUG

	EnqueueMessage(DateTime::Now, message, "MEMORY", 7);
}


// Returns Kilobytes from given Bytes
unsigned int ConsoleManager::KB(unsigned int bytes)
{
	int kb = 1024;
	return (bytes / kb);
}


// Returns Megabytes from given Bytes
unsigned int ConsoleManager::MB(unsigned int bytes)
{
	int mb = 1048576;
	return (bytes / mb);
}


//void ConsoleManager::UserError(String^ message)
//{
//	if (ConsoleInitialised)
//	{
//		Console::BackgroundColor = ConsoleColor::Red;
//		Console::ForegroundColor = ConsoleColor::White;
//	}
//
//	UserMessage("Error", message, "USER ERROR MESSAGE", 2, ::MessageBoxIcon::Error);
//}


// Outputs to message box (called by all other Message functions)
//void ConsoleManager::UserMessage(String^ header, String^ message, ::MessageBoxIcon icon)
//{
//	UserMessage("Error", message, "USER MESSAGE", 0, ::MessageBoxIcon::Error);
//}


// Outputs to message box (called by all other Message functions)
//void ConsoleManager::UserMessage(String^ header, String^ message, String^ messageType, int consoleType, ::MessageBoxIcon icon)
//{
//	EnqueueMessage(DateTime::Now, String::Format("{0} ~ {1}", header, message), messageType, consoleType);
//
//	::MessageBox::Show(message, header, ::MessageBoxButtons::OK, icon);
//}


// Allocates/attaches a new/existing console to the application for live diagnostics output
void ConsoleManager::InitialiseDebugConsole()
{
	if (!ConsoleInitialised)
	{
		if (!AttachConsole(-1)) // Creates and allocates a console (returns false if a console already exists)
		{
			AllocConsole(); // Allocates the existing console
		}

		// Disables User Interaction
		HANDLE consoleInputHandle = GetStdHandle(STD_INPUT_HANDLE);
		DWORD previousMode;
		GetConsoleMode(consoleInputHandle, &previousMode);
		SetConsoleMode(consoleInputHandle, ENABLE_EXTENDED_FLAGS | (previousMode & ~ENABLE_QUICK_EDIT_MODE));

		//_COORD consoleDimensions;
		//bool consoleFullScreen = (SetConsoleDisplayMode(consoleInputHandle, CONSOLE_FULLSCREEN_HARDWARE, &consoleDimensions) != 0);
		//
		//if (!consoleFullScreen)
		//{
		//	ErrorMessage(String::Format("Could not set the diagnostics console to fullscreen. Error Code: {0}.", GetLastError()));
		//}

		// Prevents the console from terminating application if user terminates the console
		//SetConsoleCtrlHandler(nullptr, true);


		SetTimer();

		InfoMessage("ConsoleManager - Initialised V11 Menu Diagnostics Console.", true);
		ConsoleInitialised = true;
	}
}


// Frees the console alocated to the application for live diagnostics output
void ConsoleManager::TerminateDebugConsole()
{
	if (ConsoleInitialised)
	{
		ConsoleManager::InfoMessage("ConsoleManager - Terminated V11 Menu Diagnostics Console.", true);

		Sleep(1000);
		ConsoleTimer->Stop();
		Sleep(1000);

		ConsoleInitialised = false;
		PreInitialisationBuffer = true;
		PreInitialisationBufferSize = 1000;
		PreInitialisationBufferIndex = 0;

		FreeConsole();
	}
}


void ConsoleManager::Exit()
{
	Exiting = true;
}


#pragma endregion
