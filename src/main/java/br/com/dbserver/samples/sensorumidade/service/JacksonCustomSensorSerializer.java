package br.com.dbserver.samples.sensorumidade.service;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import br.com.dbserver.samples.sensorumidade.read.Read;

public class JacksonCustomSensorSerializer  extends StdSerializer<Read> {

	private static final long serialVersionUID = 1L;

	public JacksonCustomSensorSerializer() {
		this(null);
	}

	public JacksonCustomSensorSerializer(Class<Read> s) {
		super(s);
	}

	@Override
	public void serialize(Read read, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		jgen.writeStartObject();
		LocalTime date = read.getDate_read();
		
		if (read.getId() == null) {
			
			jgen.writeNullField("id");
			
		} else {
			jgen.writeNumberField("id", read.getId());
			
		}		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedString = date.format(formatter);
		
		jgen.writeStringField("date", formattedString);
		jgen.writeNumberField("humidity", read.getHumidity());
		jgen.writeObjectId(read.getSensor());
	}

}
