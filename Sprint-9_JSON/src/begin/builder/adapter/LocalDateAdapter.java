package begin.builder.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class LocalDateAdapter extends TypeAdapter<LocalDate> {
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	@Override
	public void write(final JsonWriter jsonWriter, final LocalDate localDate) throws IOException {
		jsonWriter.value(localDate.format(dtf));
	}

	@Override
	public LocalDate read(final JsonReader jsonReader) throws IOException {
		return LocalDate.parse(jsonReader.nextString(), dtf);
	}
}
