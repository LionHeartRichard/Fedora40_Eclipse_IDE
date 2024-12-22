package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	public static void main(String[] args) {
		// Создаем сложный объект
		Map<Object, Set<Object>> complexObject = new HashMap<>();

		Set<Object> set1 = new HashSet<>();
		set1.add("Value1");
		set1.add("Value2");

		Set<Object> set2 = new HashSet<>();
		set2.add(1);
		set2.add(2);
		set2.add(null);

		Set<Object> set3 = new HashSet<>();

		complexObject.put("Key1", set1);
		complexObject.put("Key2", set2);
		complexObject.put("Key3", set3);

		// Сериализуем
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String jsonString = objectMapper.writeValueAsString(complexObject);
			System.out.println(jsonString);

			complexObject = objectMapper.readValue(jsonString, new TypeReference<Map<Object, Set<Object>>>() {
			});
		
	
            String jsonInput = "{ "userId": [{ "userId": "1", "userName": "Alice" }, { "userId": "2", "userName": "Bob" }], "userId": [{ "userId": "2", "userName": "Bob" }] }";

            // Создаем ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Десериализация
            Map<User, Set<User>> userMap = mapper.readValue(jsonInput, new TypeReference<Map<User, Set<User>>>(){});

            // Выводим результат
            for (Map.Entry<User, Set<User>> entry : userMap.entrySet()) {
                System.out.println("User: " + entry.getKey().getName());
                System.out.println("Friends: ");
                for (User friend : entry.getValue()) {
                    System.out.println(" - " + friend.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
