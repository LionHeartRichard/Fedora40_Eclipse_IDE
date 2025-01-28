package finaltask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

//****
class SubtitleLanguage {
//****
}

class SubtitleItem {
	private Map<SubtitleLanguage, String> values = new HashMap<>();
	private LocalTime begin;
	private LocalTime end;

	// generate method: equals/hashCode
	// constructor
}

class SubtitleListTypeToken extends TypeToken<List<SubtitleItem>> {

}

class LocalTimeTypeAdapter extends TypeAdapter<LocalTime> {
	private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSSS");

	@Override
	public void write(final JsonWriter jsonWriter, final LocalTime localTime) throws IOException {
		jsonWriter.value(localTime.format(timeFormatter));
	}

	@Override
	public LocalTime read(final JsonReader jsonReader) throws IOException {
		return LocalTime.parse(jsonReader.nextString(), timeFormatter);
	}
}

public class Practicum {

	public static void main(String[] args) {
        List<SubtitleItem> subtitles = Arrays.asList(
                new SubtitleItem(Map.of(SubtitleLanguage.ru, "Здравствуйте!",
                        SubtitleLanguage.en, "Hello!",
                        SubtitleLanguage.cn, "Ni hao"),
                        LocalTime.of(0, 0, 15),
                        LocalTime.of(0, 0, 17)
                ),
                new SubtitleItem(Map.of(SubtitleLanguage.ru, "Привет!",
                        SubtitleLanguage.en, "Hi!",
                        SubtitleLanguage.cn, "Ni hao"),
                        LocalTime.of(0, 0, 21),
                        LocalTime.of(0, 0, 24)
                ),
                new SubtitleItem(Map.of(SubtitleLanguage.ru, "Как дела?",
                        SubtitleLanguage.en, "How are you?",
                        SubtitleLanguage.cn, "Ni hao ma"),
                        LocalTime.of(0, 0, 28),
                        LocalTime.of(0, 0, 31)
                ),
                new SubtitleItem(Map.of(SubtitleLanguage.ru, "Всё хорошо, спасибо!",
                        SubtitleLanguage.en, "I'm fine, thank you!",
                        SubtitleLanguage.cn, "Wo hen hao, xie xie"),
                        LocalTime.of(0, 0, 34),
                        LocalTime.of(0, 0, 37)
                )
        );
        
        // адаптер для преобразования типа LocalTime в String в формате субтитров
        ??? localTimeTypeAdapter = ???
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.???
        Gson gson = gsonBuilder.???

        String subtitlesJson = gson.toJson(???);
        System.out.println(subtitlesJson);

        List<SubtitleItem> parsed = gson.fromJson(???, ???);
        if(parsed.equals(subtitles)) {
            System.out.println("Субтитры десериализованы корректно.");
        } else {
            System.out.println("Произошла ошибка при десериализации.");
        }
    }
}