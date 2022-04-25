package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.log4j.Logger;

public class ConvertidorJson {
    private static final Logger LOGGER = Logger.getLogger(ConvertidorJson.class);

    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String json = null;
        try {
            json = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            LOGGER.info("Fallo al convertir clase en formato json", e);
        }
        return json;
    }
}
