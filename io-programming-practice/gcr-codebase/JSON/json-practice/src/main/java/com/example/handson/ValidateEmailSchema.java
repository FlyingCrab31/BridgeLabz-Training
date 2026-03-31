package com.example.handson;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.*;

import java.io.InputStream;
import java.util.Set;

public class ValidateEmailSchema {
    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode json = mapper.readTree("{\"email\":\"anu@gmail.com\"}");

        InputStream schemaStream =
                ValidateEmailSchema.class
                        .getClassLoader()
                        .getResourceAsStream("email_schema.json");

        JsonSchemaFactory factory =
                JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);

        JsonSchema schema = factory.getSchema(schemaStream);

        Set<ValidationMessage> errors = schema.validate(json);

        System.out.println(errors.isEmpty() ? "Valid Email " : errors);
    }
}
