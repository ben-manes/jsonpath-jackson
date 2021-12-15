package jsonpath.jackson;

import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration.Defaults;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.jayway.jsonpath.spi.mapper.MappingProvider;

public final class JsonPathDefaults implements Defaults {
  private final MappingProvider mapperProvider;
  private final JsonProvider jsonProvider;
  private final Set<Option> options;

  JsonPathDefaults(ObjectMapper mapper) {
    mapperProvider = new JacksonMappingProvider(mapper);
    jsonProvider = new JacksonJsonNodeJsonProvider(mapper);
    options = Set.of(Option.SUPPRESS_EXCEPTIONS);
  }

  @Override public Set<Option> options() {
    return options;
  }
  @Override public JsonProvider jsonProvider() {
    return jsonProvider;
  }
  @Override public MappingProvider mappingProvider() {
    return mapperProvider;
  }
}

