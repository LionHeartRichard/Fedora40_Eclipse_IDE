package variationsbranching;

public class Main {
	public static void main(String[] args) {
		BranchingWithIfElse objIfElse = new BranchingWithIfElse();
		for (int i = 0; i < 10; ++i) {
			System.out.println(objIfElse.getMessage(i));
		}
		System.out.println("-".repeat(30));

		BranchingWithSwitch objSwitch = new BranchingWithSwitch();
		for (int i = 0; i < 10; ++i) {
			System.out.println(objSwitch.getMessage(i));
		}
		System.out.println("_".repeat(30));

		ManagerMessages manager = new MessageDayByStudent();
		manager.getMessage();
	}
}
