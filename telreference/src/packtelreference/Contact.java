package packtelreference;

public class Contact {
	private String phone;
	private String name;

	public Contact() {
	}

	public Contact(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "    " + name + ": " + phone;
	}
}
