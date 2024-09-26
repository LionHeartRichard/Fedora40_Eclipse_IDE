package packtelreference;

import java.util.ArrayList;
import java.util.List;

public class ContactLsit {
	private int limit = 0;
	private List<Contact> listContacts = new ArrayList<Contact>();

	public ContactLsit() {
	}

	public ContactLsit(int limit) {
		this.limit = limit;
	}

	public void addContact(String name, String phone) {
		if (listContacts.size() == limit) {
			System.out.println("Справочник полон, добавление невозможно");
			return;
		}
		listContacts.add(new Contact(name, phone));
	}

	public Contact findContactByName(String name) {
		for (Contact contact : listContacts) {
			if (contact.getName().equals(name)) {
				return contact;
			}
		}
		return null;
	}

	public void printAllContacts() {
		if (listContacts.isEmpty()) {
			System.out.println("Список контактов пуст");
			return;
		}
		for (Contact contact : listContacts) {
			System.out.println(contact.toString());
		}
	}

	public void clearContactList() {
		listContacts.clear();
		System.out.println("Список контактов очищен");
	}

}
