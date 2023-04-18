package i00test.sealights.synth.test.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class FootprintsResultClient {

  final private String hostUrl;

  public FootprintsResultClient(String hostUrl) {
    this.hostUrl = hostUrl;
  }

  public Map<String, List<String>> fetchFootprints() {
    HttpURLConnection connection = null;
    try {
      connection = createHttpCOnnection();
      final String response = fetchResponse(connection);

      JsonFootprintsMapper jsonFootprintsMapper = new JsonFootprintsMapper();
      return jsonFootprintsMapper.footprints(response);

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      if (connection != null) {
        connection.disconnect();
      }
    }
  }

  private static String fetchResponse(HttpURLConnection connection) {
    try {
      final InputStream inputStream = connection.getInputStream();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

      StringBuilder response = new StringBuilder();

      String line;
      while ((line = bufferedReader.readLine()) != null) {
        response.append(line);
      }
      bufferedReader.close();

      return response.toString();
    } catch (IOException ioe) {
      throw new RuntimeException(ioe);
    }
  }

  private HttpURLConnection createHttpCOnnection() throws IOException {
    final URL url = new URL(hostUrl.concat("/api/test/footprints/v6"));
    final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.setRequestProperty("Content-Type", "application/json");

    connection.setUseCaches(false);
    connection.setDoOutput(true);
    return connection;
  }
}
