package pythonError.errorInterpreter.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Christopher on 6/18/2016.
 */
public class FileLoader {

	public static String loadToString(String filepath) {
		InputStreamReader isr = new InputStreamReader(Class.class.getResourceAsStream(filepath));
		BufferedReader br = new BufferedReader(isr);
		StringBuilder file = new StringBuilder();
		String line;
		try {
			while( (line = br.readLine()) != null) {
				file.append(line);
				file.append('\n');
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file.toString();
	}
}
