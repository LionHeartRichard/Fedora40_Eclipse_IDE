package variationsbranching;

//anti-pattern

public class BranchingWithSwitch {
	public String getMessage(int typeMessage) {
		switch (typeMessage) {
		case 0: {
			return "С новым годом!!!";
		}
		case 1: {
			return "С рождеством!!!";
		}
		case 2: {
			return "С днем студента!!!";
		}
		case 3: {
			return "С днем всех влюбленных!!!";
		}
		case 4: {
			return "С днем защитника отечества!!!";
		}
		case 5: {
			return "С первым днем весны!!!";
		}
		case 6: {
			return "С международным женским днем!!!";
		}
		case 7: {
			return "С праздником трудящихся!!! 1-е мая!!!";
		}
		case 8: {
			return "С днем защиты детей!!!";
		}
		case 9: {
			return "С началом учебного года!!!";
		}
		default: {
			return "Вы стали нашим клиентом!!!";
		}
		}

	}
}
