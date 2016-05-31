package pythonError.errorInterpreter.pythonInterpreter;

/**
 * Created by Matthew Doyle on 30/05/2016.
 */

import pythonError.errorInterpreter.errorSearch.BoyerMoore;
import pythonError.errorInterpreter.inputPhaser.Error;

import java.util.HashMap;

public class Python {

	private HashMap<String, Error> explanations;

	public Python(boolean useDefaultExceptionList) {
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
			addException("FloatingPointError", "Raised when a floating point operation fails. This exception is always defined, but can only be raised when Python is configured with the --with-fpectl option, or the WANT_SIGFPE_HANDLER symbol is defined in the pyconfig.h file.");
			addException("OverflowError", "Raised when the result of an arithmetic operation is too large to be represented. This cannot occur for integers (which would rather raise MemoryError than give up). However, for historical reasons, OverflowError is sometimes raised for integers that are outside a required range. Because of the lack of standardization of floating point exception handling in C, most floating point operations are not checked.");
			addException("ZeroDivisionError", "Raised when the second argument of a division or modulo operation is zero. The associated value is a string indicating the type of the operands and the operation.",
					"This error occurs when your program tries to divide a number by zero, which is not possible.",
					"Check that you are not dividing a number by zero. Is it possible that any variables you are using are zero?");
			addException("AssertionError", "Raised when an assert statement fails.");
			addException("AttributeError", "Raised when an attribute reference (see Attribute references) or assignment fails. (When an object does not support attribute references or attribute assignments at all, TypeError is raised.)");
			addException("BufferError", "Raised when a buffer related operation cannot be performed.");
			addException("EOFError", "Raised when the input() function hits an end-of-file condition (EOF) without reading any data. (N.B.: the io.IOBase.read() and io.IOBase.readline() methods return an empty string when they hit EOF.)");
			addException("ImportError", "Raised when an import statement fails to find the module definition or when a from ... import fails to find a name that is to be imported.\n" +
					"\n" +
					"The name and path attributes can be set using keyword-only arguments to the constructor. When set they represent the name of the module that was attempted to be imported and the path to any file which triggered the exception, respectively.");
			addException("LookupError", "The base class for the exceptions that are raised when a key or index used on a mapping or sequence is invalid: IndexError, KeyError. This can be raised directly by codecs.lookup().");
			addException("IndexError", "Raised when a sequence subscript is out of range. (Slice indices are silently truncated to fall in the allowed range; if an index is not an integer, TypeError is raised.)");
			addException("KeyError", "Raised when a mapping (dictionary) key is not found in the set of existing keys.");
			addException("MemoryError", "Raised when an operation runs out of memory but the situation may still be rescued (by deleting some objects). The associated value is a string indicating what kind of (internal) operation ran out of memory. Note that because of the underlying memory management architecture (C’s malloc() function), the interpreter may not always be able to completely recover from this situation; it nevertheless raises an exception so that a stack traceback can be printed, in case a run-away program was the cause.");
			addException("NameError", "Raised when a local or global name is not found. This applies only to unqualified names. The associated value is an error message that includes the name that could not be found.");
			addException("UnboundLocalError", "Raised when a reference is made to a local variable in a function or method, but no value has been bound to that variable. This is a subclass of NameError.");
			addException("OSError", "This exception is raised when a system function returns a system-related error, including I/O failures such as “file not found” or “disk full” (not for illegal argument types or other incidental errors).\n" +
					"\n" +
					"The second form of the constructor sets the corresponding attributes, described below. The attributes default to None if not specified. For backwards compatibility, if three arguments are passed, the args attribute contains only a 2-tuple of the first two constructor arguments.\n" +
					"\n" +
					"The constructor often actually returns a subclass of OSError, as described in OS exceptions below. The particular subclass depends on the final errno value. This behaviour only occurs when constructing OSError directly or via an alias, and is not inherited when subclassing.");
			addException("BlockingIOError", "Raised when an operation would block on an object (e.g. socket) set for non-blocking operation. Corresponds to errno EAGAIN, EALREADY, EWOULDBLOCK and EINPROGRESS.");
			addException("ChildProcessError", "Raised when an operation on a child process failed. Corresponds to errno ECHILD.");
			addException("ConnectionError", "A base class for connection-related issues.");
			addException("BrokenPipeError", "A subclass of ConnectionError, raised when trying to write on a pipe while the other end has been closed, or trying to write on a socket which has been shutdown for writing. Corresponds to errno EPIPE and ESHUTDOWN.");
			addException("ConnectionAbortedError", "A subclass of ConnectionError, raised when a connection attempt is aborted by the peer. Corresponds to errno ECONNABORTED.");
			addException("ConnectionRefusedError", "A subclass of ConnectionError, raised when a connection attempt is refused by the peer. Corresponds to errno ECONNREFUSED.");
			addException("ConnectionResetError", "A subclass of ConnectionError, raised when a connection is reset by the peer. Corresponds to errno ECONNRESET.");
			addException("FileExistsError", "Raised when trying to create a file or directory which already exists. Corresponds to errno EEXIST.");
			addException("FileNotFoundError", "Raised when a file or directory is requested but doesn’t exist. Corresponds to errno ENOENT.");
			addException("InterruptedError", "Raised when a system call is interrupted by an incoming signal. Corresponds to errno EINTR.");
			addException("IsADirectoryError", "Raised when a file operation (such as os.remove()) is requested on a directory. Corresponds to errno EISDIR.");
			addException("NotADirectoryError", "Raised when a directory operation (such as os.listdir()) is requested on something which is not a directory. Corresponds to errno ENOTDIR.");
			addException("PermissionError", "Raised when trying to run an operation without the adequate access rights - for example filesystem permissions. Corresponds to errno EACCES and EPERM.");
			addException("ProcessLookupError", "Raised when a given process doesn’t exist. Corresponds to errno ESRCH.");
			addException("TimeoutError", "Raised when a system function timed out at the system level. Corresponds to errno ETIMEDOUT.");
			addException("ReferenceError", "This exception is raised when a weak reference proxy, created by the weakref.proxy() function, is used to access an attribute of the referent after it has been garbage collected. For more information on weak references, see the weakref module.");
			addException("RuntimeError", "Raised when an error is detected that doesn’t fall in any of the other categories. The associated value is a string indicating what precisely went wrong.");
			addException("NotImplementedError", "This exception is derived from RuntimeError. In user defined base classes, abstract methods should raise this exception when they require derived classes to override the method.");
			addException("RecursionError", "This exception is derived from RuntimeError. It is raised when the interpreter detects that the maximum recursion depth (see sys.getrecursionlimit()) is exceeded.");
			addException("SyntaxError", "Raised when the parser encounters a syntax error. This may occur in an import statement, in a call to the built-in functions exec() or eval(), or when reading the initial script or standard input (also interactively).\n" +
					"\n" +
					"Instances of this class have attributes filename, lineno, offset and text for easier access to the details. str() of the exception instance returns only the message.");
			addException("IndentationError", "Base class for syntax errors related to incorrect indentation. This is a subclass of SyntaxError.");
			addException("TabError", "Raised when indentation contains an inconsistent use of tabs and spaces. This is a subclass of IndentationError.");
			addException("SystemError", "Raised when the interpreter finds an internal error, but the situation does not look so serious to cause it to abandon all hope. The associated value is a string indicating what went wrong (in low-level terms).\n" +
					"\n" +
					"You should report this to the author or maintainer of your Python interpreter. Be sure to report the version of the Python interpreter (sys.version; it is also printed at the start of an interactive Python session), the exact error message (the exception’s associated value) and if possible the source of the program that triggered the error.");
			addException("TypeError", "Raised when an operation or function is applied to an object of inappropriate type. The associated value is a string giving details about the type mismatch.");
			addException("ValueError", "Raised when a built-in operation or function receives an argument that has the right type but an inappropriate value, and the situation is not described by a more precise exception such as IndexError.");
			addException("UnicodeError", "Raised when a Unicode-related encoding or decoding error occurs. It is a subclass of ValueError.\n" +
					"\n" +
					"UnicodeError has attributes that describe the encoding or decoding error. For example, err.object[err.start:err.end] gives the particular invalid input that the codec failed on.");
			addException("UnicodeDecodeError", "Raised when a Unicode-related error occurs during decoding. It is a subclass of UnicodeError.");
			addException("UnicodeEncodeError", "Raised when a Unicode-related error occurs during encoding. It is a subclass of UnicodeError.");
			addException("UnicodeTranslateError", "Raised when a Unicode-related error occurs during translating. It is a subclass of UnicodeError.");
			addException("Warning", "Base class for warning categories.");
			addException("DeprecationWarning", "Base class for warnings about deprecated features.");
			addException("PendingDeprecationWarning", "Base class for warnings about features which will be deprecated in the future.");
			addException("RuntimeWarning", "Base class for warnings about dubious runtime behavior.");
			addException("SyntaxWarning", "Base class for warnings about dubious syntax.");
			addException("UserWarning", "Base class for warnings generated by user code.");
			addException("FutureWarning", "Base class for warnings about constructs that will change semantically in the future.");
			addException("ImportWarning", "Base class for warnings about probable mistakes in module imports.");
			addException("UnicodeWarning", "Base class for warnings related to Unicode.");
			addException("ResourceWarning", "Base class for warnings related to resource usage.");
		}
	}

	private void addException(String exception, String explanation) { // Creates objects
		explanations.put(exception, new Error(BoyerMoore.compile(exception), explanation));
	}

	private void addException(String exception, String explanation, String simpleExplanation, String solution) { // Creates objects
		explanations.put(exception, new Error(BoyerMoore.compile(exception), explanation, simpleExplanation, solution));
	}

	public HashMap<String, Error> getExplanations() {
		return explanations;
	}

	public String getExplanation(String exception) { // Returns the explanation for an exception
		assert explanations.containsKey(exception);
		return explanations.get(exception).getExplanation();
	}

	public String getSimpleExplanation(String exception) { // Returns the simple explanation for an exception
		assert explanations.containsKey(exception);
		return explanations.get(exception).getSimpleExplanation();
	}

	public String getSolution(String exception) { // Returns the solution for an exception
		assert explanations.containsKey(exception);
		return explanations.get(exception).getSolution();
	}

	public Error getError(String exception) { // Returns the solution for an exception
		assert explanations.containsKey(exception);
		return explanations.get(exception);
	}
}
