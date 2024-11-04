package practicum.yandex.trainer.generics.guest;

import java.util.ArrayList;

class Practicum {

	public static void main(String[] args) {
		Guest guest1 = new Guest("Николай", "Яблонев");
		Guest guest2 = new Guest("Екатерина", "Майская");
		VipGuest guest3 = new VipGuest("Иван", "Комаров");

		ArrayList<Guest> guests = new ArrayList<>();
		guests.add(guest1);
		guests.add(guest2);

		ArrayList<VipGuest> bestFriends = new ArrayList<>();
		bestFriends.add(guest3);

		// создаём список гостей с использованием wildcard
		GuestsList<Guest> allGuestsList = new GuestsList<>();

		// приглашаем обычных гостей
		allGuestsList.invite(guests);
		// приглашаем лучших друзей
		allGuestsList.invite(bestFriends);

		allGuestsList.printAllGuests();

	}
}

class Guest {

	String name;
	String surname;

	public Guest(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String getGuestDescription() {
		return "Гость: " + name + " " + surname;
	}
}

class VipGuest extends Guest {

	public VipGuest(String name, String surname) {
		super(name, surname);
	}

	@Override
	public String getGuestDescription() {
		return "VIP-гость: " + name + " " + surname;
	}
}

class GuestsList<T extends Guest> {
	ArrayList<T> guests = new ArrayList<>();

	public void invite(ArrayList<? extends T> guestsToInvite) {
		for (T guest : guestsToInvite) {
			guests.add(guest);
		}
	}

	public void printAllGuests() {
		for (T guest : guests) {
			System.out.println(guest.getGuestDescription());
		}
	}
}
