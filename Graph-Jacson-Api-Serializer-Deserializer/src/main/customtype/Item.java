package main.customtype;

import lombok.Getter;
import lombok.Setter;
import main.Human;
import main.User;

@Getter
@Setter
public class Item {
	private int id;
	private String itemName;
	private Wrapper<Human> owner;
}
