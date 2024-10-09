package variationsbranching;

//anti-pattern

public class BranchingWithIfElse {
	public String getMessage(int typeMessage) {
		if (typeMessage == 0) {
			return "С новым годом!!!";
		} else if (typeMessage == 1) {
			return "С рождеством!!!";
		} else if (typeMessage == 2) {
			return "С днем студента!!!";
		} else if (typeMessage == 3) {
			return "С днем всех влюбленных!!!";
		} else if (typeMessage == 4) {
			return "С днем защитника отечества!!!";
		} else if (typeMessage == 5) {
			return "С первым днем весны!!!";
		} else if (typeMessage == 6) {
			return "С международным женским днем!!!";
		} else if (typeMessage == 7) {
			return "С праздником трудящихся!!! 1-е мая!!!";
		} else if (typeMessage == 8) {
			return "С днем защиты детей!!!";
		} else if (typeMessage == 9) {
			return "С началом учебного года!!!";
		} else {
			return "Вы стали нашим клиентом!!!";
		}
	}
}
