package practicum.yandex.trainer.generics.guest;

import java.util.ArrayList;

class Practicum {

	public static void main(String[] args) {
		Guest guest1 = new Guest("Николай", "Яблонев");
		Guest guest2 = new Guest("Екатерина", "Майская");
		VipGuest guest3 = new VipGuest("Иван", "Комаров");

		ArrayList<Guest> allGuests = new ArrayList<>();
		allGuests.add(guest1);
		allGuests.add(guest2);
		allGuests.add(guest3);

		ArrayList<VipGuest> vipGuests = new ArrayList<>();
		vipGuests.add(guest3);

		// создаём список любых гостей
		GuestsList<Guest> allGuestsList = new GuestsList<>();
		allGuestsList.invite(allGuests);
		allGuestsList.printAllGuests();

		// создаём список VIP-гостей
		GuestsList<VipGuest> vipGuestsList = new GuestsList<>();
		// добавить можно только ArrayList из VIP-гостей
		vipGuestsList.invite(vipGuests);
		vipGuestsList.printAllGuests();

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

	public void invite(ArrayList<T> guestsToInvite) {
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
