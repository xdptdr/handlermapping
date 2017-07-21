package com.github.xdptdr.div;

import com.github.xdptdr.div.m.Musician;

public class M {

	public void m() {

		Musician thaikovsky = w("Pyotr_Ilyich_Tchaikovsky", 1840, 1893);

		y(thaikovsky, "7_WWz2DSnT8",

				"Piano Concerto No. 1 in B-Flat Minor Op. 23 - Allegro non troppo",
				"Eugene Onegin Act III -- Polonaise", "Symphony No. 6 in B Minor \"Pathetique\" - 1st mov.",
				"Violin Concerto in D Major Op. 35 - Andante", "Slavonic March in B-Flat Minor, Op. 31",
				"1812 - Overture", "The Nutcracker, Op. 71 -- Ouverture",
				"The Nutcracker Op. 71 - Dance of the Sugarplum Fairy", "The Nutcracker Op. 71 - Waltz of the Flowers",
				"The Sleeping Beauty Op. 66 - Ouverture", "Swan Lake - Dance of the Swans",
				"Swan Lake - Waltz in A Major", "Swan Lake - Scene from Act 2"

		);

		Musician strauss = w("Richard_Strauss", 1864, 1949);

		y(strauss, "d4AmYBhGBfM",
				"Waltz, Op. 437: Emperor Waltz", "Radetzky March, Op. 228 (Strauss I)",
				"Waltz, Op. 410: Voices of Spring", "Waltz, Op. 314: The Blue Danube", "Polka, Op. 214: Chit-chat",
				"Waltz, Op. 354: Viennese Blood", "Waltz, Op. 307: Viennese Sweets",
				"Waltz, Op. 325: Tales from the Vienna Woods", "Waltz, Op. 114: Lovesongs",
				"Waltz, Op. 388: Roses from the South", "Waltz, Op. 443: Be Embraced, You Millions!",
				"Waltz, Op. 234: Accelerations", "Waltz, Op. 354: Viennese Blood", "Polka, Op. 139: Light Blood",
				"Polka, Op. 234: Pizzicato Polka", "Polka, Op. 281: Polka Schnell"

		);

	}

	private void y(Musician musician, String... strings) {

	}

	private Musician w(String name, int birth, int death) {
		return null;
	}
}
