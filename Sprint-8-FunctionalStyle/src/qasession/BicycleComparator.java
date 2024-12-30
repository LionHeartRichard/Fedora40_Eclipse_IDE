package qasession;

import java.util.Comparator;

public class BicycleComparator implements Comparator<Bicycle> {

	@Override
	public int compare(Bicycle b1, Bicycle b2) {
		return Integer.compare(b1.getFrameSize(), b2.getFrameSize());
	}

}
