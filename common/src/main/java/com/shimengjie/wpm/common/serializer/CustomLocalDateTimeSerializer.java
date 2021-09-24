package com.shimengjie.wpm.common.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 支持LocalDateTime序列化成时间戳
 * @author shimengjie
 */
public class CustomLocalDateTimeSerializer extends StdSerializer<LocalDateTime> {

    private DateTimeFormatter formatter;
    private boolean useTimestamp;

    public CustomLocalDateTimeSerializer(boolean useTimestamp) {
        super(LocalDateTime.class, false);
        this.useTimestamp = useTimestamp;
    }

    public CustomLocalDateTimeSerializer(DateTimeFormatter formatter) {
        super(LocalDateTime.class, false);
        this.formatter = formatter;
    }


    @Override
    public void serializeWithType(LocalDateTime value, JsonGenerator g, SerializerProvider provider,
                                  TypeSerializer typeSer) throws IOException {
        WritableTypeId typeIdDef = typeSer.writeTypePrefix(g,
                typeSer.typeId(value, JsonToken.VALUE_NUMBER_INT));
        serialize(value, g, provider);
        typeSer.writeTypeSuffix(g, typeIdDef);
    }


    @Override
    public void serialize(LocalDateTime value, JsonGenerator g, SerializerProvider provider) throws IOException {
        if (this.useTimestamp) {
            g.writeNumber(toTimestamp(value));
            return;
        }
        g.writeString(value.format(formatter));
    }

    protected long toTimestamp(LocalDateTime value) {
        if (null == value) {
            return 0;
        }
        return value.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }
}
