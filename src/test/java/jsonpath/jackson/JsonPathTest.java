package jsonpath.jackson;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

public final class JsonPathTest {
  ObjectMapper mapper;

  @BeforeTest
  public void beforeTest() {
    mapper = JsonMapper.builder()
        .enable(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)
        .build();
    Configuration.setDefaults(new JsonPathDefaults(mapper));
  }

  @Test
  public void read() {
    String json = """
      {
        "class": "JsonPathTest",
        "method": "read"
      }""";
    var context = JsonPath.parse(json);
    var className = context.read("$.class", String.class);
    assertEquals(className, "JsonPathTest");
  }
}
