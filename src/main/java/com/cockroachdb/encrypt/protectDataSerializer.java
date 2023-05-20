package com.cockroachdb.encrypt;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class protectDataSerializer extends JsonSerializer {
    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String pii = o.toString().replaceAll("\\w(?=\\w{2})","X");
        jsonGenerator.writeString(pii);
    }
}
