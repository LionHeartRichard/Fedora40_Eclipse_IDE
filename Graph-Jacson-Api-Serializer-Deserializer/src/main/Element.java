package main;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Element {
	private int idElemnt;
	private String nameElemnt;
	private Graph<Human> graphElement;
}
