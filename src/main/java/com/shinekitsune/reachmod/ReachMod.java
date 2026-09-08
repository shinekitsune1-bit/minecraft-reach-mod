package com.shinekitsune.reachmod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReachMod {
	public static final String MOD_ID = "reach_mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static void init() {
		LOGGER.info("Reach Mod initialized!");
	}
}
