package pythonError.errorInterpreter.pythonInterpreter;

/**
 * Created by Matthew Doyle on 30/05/2016.
 */

import java.util.ArrayList;
import java.util.HashMap;

import pythonError.errorInterpreter.errorSearch.BMPattern;
import pythonError.errorInterpreter.errorSearch.BoyerMoore;

public class Python {

	private ArrayList<BMPattern> Exceptions;
	private HashMap<String, String> Explanations;

	Python(boolean useDefaultExceptionList) {
		Exceptions = new ArrayList<>();
		Explanations = new HashMap<>();
		AddException("BaseException", "The base class for all built-in exceptions. It is not meant to be directly inherited by user-defined classes (for that, use Exception). If str() is called on an instance of this class, the representation of the argument(s) to the instance are returned, or the empty string when there were no arguments.");
		AddException("SystemExit", "This exception is raised by the sys.exit() function. It inherits from BaseException instead of Exception so that it is not accidentally caught by code that catches Exception. This allows the exception to properly propagate up and cause the interpreter to exit. When it is not handled, the Python interpreter exits; no stack traceback is printed. The constructor accepts the same optional argument passed to sys.exit(). If the value is an integer, it specifies the system exit status (passed to C’s exit() function); if it is None, the exit status is zero; if it has another type (such as a string), the object’s value is printed and the exit status is one.\n" +
				"\n" +
				"A call to sys.exit() is translated into an exception so that clean-up handlers (finally clauses of try statements) can be executed, and so that a debugger can execute a script without running the risk of losing control. The os._exit() function can be used if it is absolutely positively necessary to exit immediately (for example, in the child process after a call to os.fork()).");
		AddException("KeyboardInterrupt", "Raised when the user hits the interrupt key (normally Control-C or Delete). During execution, a check for interrupts is made regularly. The exception inherits from BaseException so as to not be accidentally caught by code that catches Exception and thus prevent the interpreter from exiting.");
		AddException("GeneratorExit", "Raised when a generator or coroutine is closed; see generator.close() and coroutine.close(). It directly inherits from BaseException instead of Exception since it is technically not an error.");
		AddException("Exception", "All built-in, non-system-exiting exceptions are derived from this class. All user-defined exceptions should also be derived from this class.");
		AddException("StopIteration", "Raised by built-in function next() and an iterator‘s __next__() method to signal that there are no further items produced by the iterator.\n" +
				"\n" +
				"The exception object has a single attribute value, which is given as an argument when constructing the exception, and defaults to None.\n" +
				"\n" +
				"When a generator or coroutine function returns, a new StopIteration instance is raised, and the value returned by the function is used as the value parameter to the constructor of the exception.\n" +
				"\n" +
				"If a generator function defined in the presence of a from __future__ import generator_stop directive raises StopIteration, it will be converted into a RuntimeError (retaining the StopIteration as the new exception’s cause).");
		AddException("StopAsyncIteration", "Must be raised by __anext__() method of an asynchronous iterator object to stop the iteration.");
		AddException("ArithmeticError", "The base class for those built-in exceptions that are raised for various arithmetic errors: OverflowError, ZeroDivisionError, FloatingPointError.");
		AddException("FloatingPointError", "This should not be occurring");
		AddException("OverflowError", "This should not be occurring");
		AddException("ZeroDivisionError", "This should not be occurring");
		AddException("AssertionError", "This should not be occurring");
		AddException("AttributeError", "This should not be occurring");
		AddException("BufferError", "This should not be occurring");
		AddException("EOFError", "This should not be occurring");
		AddException("ImportError", "This should not be occurring");
		AddException("LookupError", "This should not be occurring");
		AddException("IndexError", "This should not be occurring");
		AddException("KeyError", "This should not be occurring");
		AddException("MemoryError", "This should not be occurring");
		AddException("NameError", "This should not be occurring");
		AddException("UnboundLocalError", "This should not be occurring");
		AddException("OSError", "This should not be occurring");
		AddException("BlockingIOError", "This should not be occurring");
		AddException("ChildProcessError", "This should not be occurring");
		AddException("ConnectionError", "This should not be occurring");
		AddException("BrokenPipeError", "This should not be occurring");
		AddException("ConnectionAbortedError", "This should not be occurring");
		AddException("ConnectionRefusedError", "This should not be occurring");
		AddException("ConnectionResetError", "This should not be occurring");
		AddException("FileExistsError", "This should not be occurring");
		AddException("FileNotFoundError", "This should not be occurring");
		AddException("InterruptedError", "This should not be occurring");
		AddException("IsADirectoryError", "This should not be occurring");
		AddException("NotADirectoryError", "This should not be occurring");
		AddException("PermissionError", "This should not be occurring");
		AddException("ProcessLookupError", "This should not be occurring");
		AddException("TimeoutError", "This should not be occurring");
		AddException("ReferenceError", "This should not be occurring");
		AddException("RuntimeError", "This should not be occurring");
		AddException("NotImplementedError", "This should not be occurring");
		AddException("RecursionError", "This should not be occurring");
		AddException("SyntaxError", "This should not be occurring");
		AddException("IndentationError", "This should not be occurring");
		AddException("TabError", "This should not be occurring");
		AddException("SystemError", "This should not be occurring");
		AddException("TypeError", "This should not be occurring");
		AddException("ValueError", "This should not be occurring");
		AddException("UnicodeError", "This should not be occurring");
		AddException("UnicodeDecodeError", "This should not be occurring");
		AddException("UnicodeEncodeError", "This should not be occurring");
		AddException("UnicodeTranslateError", "This should not be occurring");
		AddException("Warning", "This should not be occurring");
		AddException("DeprecationWarning", "This should not be occurring");
		AddException("PendingDeprecationWarning", "This should not be occurring");
		AddException("RuntimeWarning", "This should not be occurring");
		AddException("SyntaxWarning", "This should not be occurring");
		AddException("UserWarning", "This should not be occurring");
		AddException("FutureWarning", "This should not be occurring");
		AddException("ImportWarning", "This should not be occurring");
		AddException("UnicodeWarning", "This should not be occurring");
		AddException("ResourceWarning", "This should not be occurring");
	}

	public void AddException(String Exception, String Explanation) { // Creates objects
		Exceptions.add(BoyerMoore.compile(Exception));
		Explanations.put(Exception, Explanation);
	}

	public ArrayList<BMPattern> getExceptionList() { // Returns list of exceptions
		return Exceptions;
	}

	public String getExplanation(String Exception) { // Returns the explanation for an exception
		assert Explanations.containsKey(Exception);
		return Explanations.get(Exception);
	}
}