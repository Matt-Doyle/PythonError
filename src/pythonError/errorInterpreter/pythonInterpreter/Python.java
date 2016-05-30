package pythonError.errorInterpreter.pythonInterpreter;

/**
 * Created by Matthew Doyle on 30/05/2016.
 */

import java.util.ArrayList;
import java.util.HashMap;

import pythonError.errorInterpreter.errorSearch.BMPattern;
import pythonError.errorInterpreter.errorSearch.BoyerMoore;

public class Python {

	private ArrayList<BMPattern> exceptions;
	private HashMap<String, String> explanations;

	Python(boolean useDefaultExceptionList) {
		exceptions = new ArrayList<>();
		explanations = new HashMap<>();
		if (useDefaultExceptionList) {
			addException("BaseException", "The base class for all built-in exceptions. It is not meant to be directly inherited by user-defined classes (for that, use Exception). If str() is called on an instance of this class, the representation of the argument(s) to the instance are returned, or the empty string when there were no arguments.");
			addException("SystemExit", "This exception is raised by the sys.exit() function. It inherits from BaseException instead of Exception so that it is not accidentally caught by code that catches Exception. This allows the exception to properly propagate up and cause the interpreter to exit. When it is not handled, the Python interpreter exits; no stack traceback is printed. The constructor accepts the same optional argument passed to sys.exit(). If the value is an integer, it specifies the system exit status (passed to C’s exit() function); if it is None, the exit status is zero; if it has another type (such as a string), the object’s value is printed and the exit status is one.\n" +
					"\n" +
					"A call to sys.exit() is translated into an exception so that clean-up handlers (finally clauses of try statements) can be executed, and so that a debugger can execute a script without running the risk of losing control. The os._exit() function can be used if it is absolutely positively necessary to exit immediately (for example, in the child process after a call to os.fork()).");
			addException("KeyboardInterrupt", "Raised when the user hits the interrupt key (normally Control-C or Delete). During execution, a check for interrupts is made regularly. The exception inherits from BaseException so as to not be accidentally caught by code that catches Exception and thus prevent the interpreter from exiting.");
			addException("GeneratorExit", "Raised when a generator or coroutine is closed; see generator.close() and coroutine.close(). It directly inherits from BaseException instead of Exception since it is technically not an error.");
			addException("Exception", "All built-in, non-system-exiting exceptions are derived from this class. All user-defined exceptions should also be derived from this class.");
			addException("StopIteration", "Raised by built-in function next() and an iterator‘s __next__() method to signal that there are no further items produced by the iterator.\n" +
					"\n" +
					"The exception object has a single attribute value, which is given as an argument when constructing the exception, and defaults to None.\n" +
					"\n" +
					"When a generator or coroutine function returns, a new StopIteration instance is raised, and the value returned by the function is used as the value parameter to the constructor of the exception.\n" +
					"\n" +
					"If a generator function defined in the presence of a from __future__ import generator_stop directive raises StopIteration, it will be converted into a RuntimeError (retaining the StopIteration as the new exception’s cause).");
			addException("StopAsyncIteration", "Must be raised by __anext__() method of an asynchronous iterator object to stop the iteration.");
			addException("ArithmeticError", "The base class for those built-in exceptions that are raised for various arithmetic errors: OverflowError, ZeroDivisionError, FloatingPointError.");
			addException("FloatingPointError", "This should not be occurring");
			addException("OverflowError", "This should not be occurring");
			addException("ZeroDivisionError", "This should not be occurring");
			addException("AssertionError", "This should not be occurring");
			addException("AttributeError", "This should not be occurring");
			addException("BufferError", "This should not be occurring");
			addException("EOFError", "This should not be occurring");
			addException("ImportError", "This should not be occurring");
			addException("LookupError", "This should not be occurring");
			addException("IndexError", "This should not be occurring");
			addException("KeyError", "This should not be occurring");
			addException("MemoryError", "This should not be occurring");
			addException("NameError", "This should not be occurring");
			addException("UnboundLocalError", "This should not be occurring");
			addException("OSError", "This should not be occurring");
			addException("BlockingIOError", "This should not be occurring");
			addException("ChildProcessError", "This should not be occurring");
			addException("ConnectionError", "This should not be occurring");
			addException("BrokenPipeError", "This should not be occurring");
			addException("ConnectionAbortedError", "This should not be occurring");
			addException("ConnectionRefusedError", "This should not be occurring");
			addException("ConnectionResetError", "This should not be occurring");
			addException("FileExistsError", "This should not be occurring");
			addException("FileNotFoundError", "This should not be occurring");
			addException("InterruptedError", "This should not be occurring");
			addException("IsADirectoryError", "This should not be occurring");
			addException("NotADirectoryError", "This should not be occurring");
			addException("PermissionError", "This should not be occurring");
			addException("ProcessLookupError", "This should not be occurring");
			addException("TimeoutError", "This should not be occurring");
			addException("ReferenceError", "This should not be occurring");
			addException("RuntimeError", "This should not be occurring");
			addException("NotImplementedError", "This should not be occurring");
			addException("RecursionError", "This should not be occurring");
			addException("SyntaxError", "This should not be occurring");
			addException("IndentationError", "This should not be occurring");
			addException("TabError", "This should not be occurring");
			addException("SystemError", "This should not be occurring");
			addException("TypeError", "This should not be occurring");
			addException("ValueError", "This should not be occurring");
			addException("UnicodeError", "This should not be occurring");
			addException("UnicodeDecodeError", "This should not be occurring");
			addException("UnicodeEncodeError", "This should not be occurring");
			addException("UnicodeTranslateError", "This should not be occurring");
			addException("Warning", "This should not be occurring");
			addException("DeprecationWarning", "This should not be occurring");
			addException("PendingDeprecationWarning", "This should not be occurring");
			addException("RuntimeWarning", "This should not be occurring");
			addException("SyntaxWarning", "This should not be occurring");
			addException("UserWarning", "This should not be occurring");
			addException("FutureWarning", "This should not be occurring");
			addException("ImportWarning", "This should not be occurring");
			addException("UnicodeWarning", "This should not be occurring");
			addException("ResourceWarning", "This should not be occurring");
		}
	}

	public void addException(String Exception, String Explanation) { // Creates objects
		exceptions.add(BoyerMoore.compile(Exception));
		explanations.put(Exception, Explanation);
	}

	public ArrayList<BMPattern> getExceptionList() { // Returns list of exceptions
		return exceptions;
	}

	public String getExplanation(String Exception) { // Returns the explanation for an exception
		assert explanations.containsKey(Exception);
		return explanations.get(Exception);
	}
}