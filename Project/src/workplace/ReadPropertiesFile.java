package workplace;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Properties;



public class ReadPropertiesFile {
	protected Properties prop =null;
	protected InputStream input=ReadPropertiesFile.class.getResource("C:\\\\Users\\\\user\\\\git\\\\ClearTrip\\\\Project\\\\src\\\\Configs\\\\Configuation.properties").openStream();
	
	public ReadPropertiesFile() throws IOException
	{
		prop = new Properties();
		prop.load(input);
		
		
	}
	
	
	public String getBrowser() {	return prop.getProperty("Browser");	}
	public String getURL() {	return prop.getProperty("URL");	}
	public String getWay() {	return prop.getProperty("way");	}
	public String getflightfromtag() {	return prop.getProperty("flightfromtag");	}
	public String getflightfromvalue() {	return prop.getProperty("flightfromvalue");	}
	public String getxpathoffromlist() {	return prop.getProperty("xpathoffromlist");	}
	public String getflighttovalue() {	return prop.getProperty("flighttovalue");	}
	public String getflighttotag() {	return prop.getProperty("flighttotag");	}
	public String getxpathoftolist() {	return prop.getProperty("xpathoftolist");	}
	public String getmonthxpath() {	return prop.getProperty("monthxpath");	}
	public String getmonth() {	return prop.getProperty("month");	}
	public String getclicknextxpath() {	return prop.getProperty("clicknextxpath");	}
	public String getalldatesxpath() {	return prop.getProperty("alldatesxpath");	}
	public String getdate() {	return prop.getProperty("date");	}
	public String getsearchbuttonid() {	return prop.getProperty("searchbuttonid");	}
	
	
	
}
