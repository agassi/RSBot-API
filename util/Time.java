package org.powerbot.game.api.util;

import java.util.concurrent.TimeUnit;

/**
 * A utility for manipulating time.
 *
 * @author Timer
 */
public class Time {
	/**
	 * @param time The number of milliseconds to ensure sleeping for.
	 */
	public static void sleep(final int time) {
		try {
			final long start = System.currentTimeMillis();
			Thread.sleep(time);
			long now;
			while (start + time > (now = System.currentTimeMillis())) {
				Thread.sleep(start + time - now);
			}
		} catch (final InterruptedException ignored) {
		}
	}

	/**
	 * Sleeps for a random number of milliseconds.
	 *
	 * @param min the minimum sleep time.
	 * @param max the maximum sleep time.
	 */
	public static void sleep(final int min, final int max) {
		sleep(Random.nextInt(min, max));
	}

	/**
	 * Converts milliseconds to a String in the format
	 * hh:mm:ss.
	 *
	 * @param time The number of milliseconds.
	 * @return The formatted String.
	 */
	public static String format(final long time) {
		return String.format(
    				"%02d:%02d:%02d",
    				TimeUnit.MILLISECONDS.toHours(time)
    						- TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS
    								.toDays(time)),
    				TimeUnit.MILLISECONDS.toMinutes(time)
    						- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
    								.toHours(time)),
    				TimeUnit.MILLISECONDS.toSeconds(time)
    						- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
    								.toMinutes(time)));
  }
}
