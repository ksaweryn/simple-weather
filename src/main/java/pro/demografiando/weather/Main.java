package pro.demografiando.weather;

import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main class
 * 
 * @author javier
 *
 */
public class Main {
	private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

	public static void main(String[] args) throws Exception {
		/*
		 * LOGGER.debug("Debug Message Logged !!!");
		 * LOGGER.info("Info Message Logged !!!");
		 * LOGGER.error("Error Message Logged !!!", new
		 * NullPointerException("NullError"));
		 */

		String zipcode = "";
		try {
			zipcode = args[0];
		} catch (Exception e) {
			zipcode = "60202";
		}
		new Main(zipcode).start();
	}

	private static String zip;

	public Main(String zip) {
		this.zip = zip;
	}

	public static void start() throws Exception {
		InputStream dataIn = new YahooRetriever().retrieve(Integer.valueOf(zip));

		/*
		 * Weather weather = new YahooParser().parse(dataIn);
		 * 
		 * System.out.println(new WeatherFormatter().format(weather));
		 */
	}
}
