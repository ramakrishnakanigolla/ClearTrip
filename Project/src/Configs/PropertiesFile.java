package Configs;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

	public static void readPropertiesFile() {
		Properties prop = new Properties();
		try
		{
			InputStream input = new FileInputStream("\\src\\Configs\\PropertiesFile.java");
			prop.load(input);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
