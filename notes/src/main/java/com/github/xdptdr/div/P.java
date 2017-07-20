package com.github.xdptdr.div;

import com.github.xdptdr.notes.N;

public class P {

	public static interface Ex {
		public void ex();
	}

	public static void p() {
		int nex[] = new int[] { 87, 82, 79, 77, 89, 97, 76, 92, 76, 70, 79, 74, 99, 81, 62, 75, 93, 102, 77, 81, 71, 72,
				63, 91, 80, 95, 82, 82, 76, 71, 55, 84, 95, 81, 63, 65, 76, 67, 83, 78, 57, 56, 54, 64, 58 };

		int count = 0;
		for (int i = 1; i <= nex.length; ++i) {
			for (int j = 1; j <= nex[i - 1]; ++j) {
				++count;
				System.out.println(i + "." + j);
			}
		}
		System.out.println("Total : " + count);

		ex(1, 1, new Ex() {
			@Override
			public void ex() {
				N.azzertEquals(15. * 20000. / 100., 3000.);
				N.azzertEquals(3000., si(3, 3));
			}

		});

		ex(1, 2, new Ex() {
			@Override
			public void ex() {
			}

		});

	}

	private static void ex(int i, int j, Ex ex) {
		ex.ex();

	}

	private static double si(int i, int j) {
		return i * Math.pow(10, j);
	}

	public static void main(String[] args) {
		p();
	}
}
