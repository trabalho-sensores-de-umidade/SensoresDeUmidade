package br.com.dbserver.samples.sensorumidade.service;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;

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
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		jgen.writeStartObject();		

		
		if (read.getId() == null) {
			
			jgen.writeNullField("id");
			
		} else {
			jgen.writeNumberField("id", read.getId());
			 
		}	
		jgen.writeNumberField("humidity", read.getHumidity());		
		jgen.writeStringField("date_read", formatter.format(read.getDate_read()));
		jgen.writeObjectField("id_sensor", read.getSensor());
		jgen.writeEndObject();
	}
	


}
