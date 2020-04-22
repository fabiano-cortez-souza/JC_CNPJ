package br.com.fabiano.infra;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
	public Properties getProperties() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			String propFilename = "infra.properties";
			input = getClass().getClassLoader().getResourceAsStream(propFilename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + propFilename);
			}
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}
}
