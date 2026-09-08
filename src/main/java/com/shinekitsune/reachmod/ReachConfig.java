package com.shinekitsune.reachmod;

public class ReachConfig {
	public static boolean enabled = true;
	public static double reachDistance = 4.5;
	public static int maxReach = 10;
	public static int minReach = 1;

	public static void load() {
		// Config loading logic will go here
	}

	public static void setReachDistance(double distance) {
		if (distance < minReach) {
			reachDistance = minReach;
		} else if (distance > maxReach) {
			reachDistance = maxReach;
		} else {
			reachDistance = distance;
		}
	}

	public static void toggleEnabled() {
		enabled = !enabled;
	}

	public static double getReachDistance() {
		return enabled ? reachDistance : 4.5; // Default Minecraft reach
	}
}
