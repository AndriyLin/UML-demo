package com.andriy.client;

import java.util.Random;

public final class RandomGenerator {
	
	public static String getRandomString(int num) {
		StringBuffer buffer = new StringBuffer(
				"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		StringBuffer result = new StringBuffer();
		int range = buffer.length();
		Random random = new Random();
		for (int i = 0; i < num; i++) {
			result.append(buffer.charAt(random.nextInt(range)));
		}
		return result.toString();
	}
}
