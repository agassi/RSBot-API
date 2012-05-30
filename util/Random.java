package org.powerbot.game.api.util;

/**
 * A utility that generates random numbers.
 *
 * @author Timer
 */
public class Random {
	private static final java.util.Random random = new java.util.Random();

	/**
	 * @return The next random boolean value.
	 */
	public static boolean nextBoolean() {
		seed();
		return random.nextBoolean();
	}

	/**
	 * Generates a pseudo-random number between two given values.
	 *
	 * @param min The minimum value (inclusive).
	 * @param max The maximum value (exclusive).
	 * @return The generated pseudo-random integer.
	 */
	public static int nextInt(final int min, final int max) {
		seed();
		if (max < min) {
			return max + random.nextInt(min - max);
		}
		return min + (max == min ? 0 : random.nextInt(max - min));
	}

	/**
	 * Generates a pseudo-random number between two given values.
	 *
	 * @param min The minimum value (inclusive).
	 * @param max The maximum value (exclusive).
	 * @return The generated pseudo-random double.
	 */
	public static double nextDouble(final double min, final double max) {
		seed();
		return min + random.nextDouble() * (max - min);
	}

	/**
	 * @return A generated pseudo-random double between 0.0 (inclusive) and 1.0 (exclusive).
	 */
	public static double nextDouble() {
		seed();
		return random.nextDouble();
	}

	/**
	 * Generates a pseudo-random number between the two given values with standard deviation.
	 *
	 * @param min The minimum value (inclusive).
	 * @param max The maximum value (exclusive).
	 * @param sd  Standard deviation.
	 * @return The generated pseudo-random integer.
	 */
	public static int nextGaussian(final int min, final int max, final int sd) {
		seed();
		return nextGaussian(min, max, min + (max - min) / 2, sd);
	}

	/**
	 * Generates a pseudo-random number between the two given values with standard deviation about a provided mean.
	 *
	 * @param min  The minimum value (inclusive).
	 * @param max  The maximum value (exclusive).
	 * @param mean The mean (>= min & < max).
	 * @param sd   Standard deviation.
	 * @return The generated pseudo-random integer.
	 */
	public static int nextGaussian(final int min, final int max, final int mean, final int sd) {
		seed();
		if (min == max) {
			return min;
		}
		int rand;
		do {
			rand = (int) (random.nextGaussian() * sd + mean);
		} while (rand < min || rand >= max);
		return rand;
	}
	
	private static void seed() {
		random.setSeed(System.nanoTime());
	}
}