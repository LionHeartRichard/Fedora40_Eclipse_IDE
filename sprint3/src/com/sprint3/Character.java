package com.sprint3;

public class Character {
	int gold;
	int silver;
	double wood;
	byte health;
	byte helpersNumber;

	public Character(int characterGold, int characterSilver, double characterWood, byte characterHealth,
			byte characterHelpersNumber) {
		gold = characterGold;
		silver = characterSilver;
		wood = characterWood;
		health = characterHealth;
		helpersNumber = characterHelpersNumber;
	}
}
