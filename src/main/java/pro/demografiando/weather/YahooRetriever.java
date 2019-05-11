package pro.demografiando.weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class YahooRetriever {

	private static Logger LOGGER = LogManager.getLogger(YahooRetriever.class);

	public InputStream retrieve(int zipcode) throws Exception {
		LOGGER.info("Retrieving weather data");
		getYahooAuthorization();
		String url = "https://weather-ydn-yql.media.yahoo.com/forecastrss?p=" + zipcode;
		URLConnection connection = new URL(url).openConnection();
		return connection.getInputStream();
	}

	private void getYahooAuthorization() throws MalformedURLException, IOException {
		LOGGER.info("Starting authentication");
		String authorizationUrl = "https://api.login.yahoo.com/oauth2/request_auth?client_id=dj0yJmk9TU5OaWFnUllCeTNxJnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PThl&redirect_uri=oob&response_type=code&language=en-us";
		URLConnection connection = new URL(authorizationUrl).openConnection();
		LOGGER.info(connection.getOutputStream());

	}

}
