package lambda;

import java.util.Arrays;
import java.util.List;

public class ComparatorDemo {
	public static void main(String[] args) {
		List<Circle> circles = Arrays.asList(new Circle(3, 5, 12), new Circle(50, 100, 0), new Circle(1, -2, 4),
				new Circle(8, 8, 8), new Circle(5, 1, 7), new Circle(2, 1, 0));

		// вместо компаратора используем лямбду
		circles.sort((circle1, circle2) -> {
			return circle1.getRadius() - circle2.getRadius();
		});

		circles.forEach(v -> System.out.println(v));

		// ------------------------------------------------------------------------------
		System.out.println("-".repeat(100));

		circles.sort((circle1, circle2) -> {
			if (circle1.getRadius() == 0) {
				return 1;
			}
			if (circle2.getRadius() == 0) {
				return -1;
			}
			return circle1.getRadius() - circle2.getRadius();
		});

		circles.forEach(v -> System.out.println(v));
		System.out.println("-".repeat(100));
		// -------------------------------------------------------
		circles.sort((circle1, circle2) -> {
			int radius = circle1.getRadius() - circle2.getRadius();
			if (radius == 0) {
				return circle1.getCenterX() + circle1.getCenterY() - circle2.getCenterX() - circle2.getCenterY();
			}
			return radius;
		});

		circles.forEach(v -> System.out.println(v));
		System.out.println("-".repeat(100));
		// -------------------------------------------------------

		circles.sort((c1, c2) -> c1.getRadius() - c2.getRadius());
		circles.forEach(v -> System.out.println(v));
	}
}
