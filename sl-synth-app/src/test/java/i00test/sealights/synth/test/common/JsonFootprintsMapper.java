package i00test.sealights.synth.test.common;

import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonFootprintsMapper {

  public Map<String, List<String>> footprints(final String json) {

    JSONArray footprintsArray = null;
    try {
      footprintsArray = new JSONArray(json);
    } catch (JSONException e) {
      throw new RuntimeException(e);
    }

    return jsonArrayToStream(footprintsArray)
        .flatMap(this::testMethodHit)
        .collect(toMap(TestMethodHit::getTestName, TestMethodHit::getMethodNames));
  }

  public Stream<TestMethodHit> testMethodHit(JSONObject jsonFootprintObject) {
    final List<String> methods =
        getJsonObjectList(getJsonArray(jsonFootprintObject, "methods"), String.class);

    return extractJsonObjectStream(jsonFootprintObject, "executions")
        .flatMap(execution -> extractJsonObjectStream(execution, "hits"))
        .map(hit -> extractTestNameWithMethodHits(hit, methods));
  }

  private JSONArray getJsonArray(JSONObject jsonObject, String fieldName) {
    try {
      return jsonObject.getJSONArray(fieldName);
    } catch (JSONException e) {
      throw new RuntimeException(e);
    }
  }

  private TestMethodHit extractTestNameWithMethodHits(JSONObject hit, List<String> methodIndex) {
    try {
      final String anonymousTestName = "" + hit.getInt("start") + "-" + hit.getInt("end");
      final String testName = hit.isNull("testName") ? anonymousTestName : hit.getString("testName");
      final List<String> methods =
          getJsonObjectList(getJsonArray(hit, "methods"), Integer.class).stream()
              .map(methodIndex::get)
              .collect(Collectors.toList());

      return new TestMethodHit(testName, methods);

    } catch (JSONException e) {
      throw new RuntimeException(e);
    }
  }

  private Stream<JSONObject> extractJsonObjectStream(
      JSONObject objectWithArrayFiled, String fieldName) {
    return Stream.of(
        getJsonObjectList(getJsonArray(objectWithArrayFiled, fieldName))
            .toArray(new JSONObject[0]));
  }

  private Stream<JSONObject> jsonArrayToStream(JSONArray jsonArray) {
    return Stream.of(getJsonObjectList(jsonArray).toArray(new JSONObject[0]));
  }

  private List<JSONObject> getJsonObjectList(JSONArray jsonArray) {
    List<JSONObject> list = new ArrayList<>(jsonArray.length());
    try {
      for (int i = 0; i < jsonArray.length(); i++) {
        list.add(jsonArray.getJSONObject(i));
      }
    } catch (JSONException e) {
      throw new RuntimeException(e);
    }
    return list;
  }

  private <T> List<T> getJsonObjectList(JSONArray jsonArray, Class<T> cls) {
    List<T> list = new ArrayList<>(jsonArray.length());
    try {
      for (int i = 0; i < jsonArray.length(); i++) {
        list.add((T) jsonArray.get(i));
      }
    } catch (JSONException jsonException) {
      throw new RuntimeException(jsonException);
    }
    return list;
  }
}
