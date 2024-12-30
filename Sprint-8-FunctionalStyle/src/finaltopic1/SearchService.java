package finaltopic1;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchService {
	// Создаём объект класса, отвечающий за склад магазина
	private final Warehouse warehouse = new Warehouse();
	// Создаём объект класса, отвечающий за работу с поставщиками
	public final SRM srm = new SRM();

	// Основной метод поиска
	// Проверяет наличие товара с указанным именем на складе магазина
	// Если товар отсутствует, то проверяются склады поставщиков,
	// предпочтение отдаётся тому поставщику, у которого наименьшая цена товара.
	// Для поиска товара на складе поставщиков используется метод supplierSearch
	// Если товар нигде не найден, то возвращается пустой Optional
	public Optional<Candy> search(String candyName) {
		return warehouse.search(candyName).or(() -> supplierSearch(candyName));
	}

	// Ищет товар с указанным именем на складах поставщиков
	// Возвращает Optional с самым дешевым вариантом товара среди всех
	// поставщиков или пустой Optional, если товар не найден
	private Optional<Candy> supplierSearch(String candyName) {
		// Реализуйте данный метод при помощи Stream API и Optional,
		// используйте метод min из Stream API для нахождения товара с наименьшей ценой
		Set<Candy> candies = srm.listSuppliers().stream().map(candy -> {
			return srm.getProduct(candy, candyName);
		}).filter(candy -> candy != null).collect(Collectors.toSet());

		return candies.stream().min(Candy::compareByPrice);
	}
}