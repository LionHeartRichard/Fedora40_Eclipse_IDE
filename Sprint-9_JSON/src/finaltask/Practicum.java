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

???SubtitleLanguage{

}

class SubtitleItem {
	...values=new HashMap<>();

	...begin;

	...end;

	// геттеры и сеттеры

	@Override
    public boolean equals(Object o) {
       ...
    }

	@Override
    public int hashCode() {
       ...
    }

	public SubtitleItem(...) {
			...
    }
}

	class SubtitleListTypeToken extends???
	{

		}

		class LocalTimeTypeAdapter extends???
		{
	private final DateTimeFormatter timeFormatter = ???

	@Override
    public void write(???) throws IOException {

    }

	@Override
    public LocalTime read(???) throws IOException {

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