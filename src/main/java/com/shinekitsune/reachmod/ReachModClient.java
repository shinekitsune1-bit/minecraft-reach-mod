package com.shinekitsune.reachmod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReachModClient {
	public static final Logger LOGGER = LoggerFactory.getLogger(ReachMod.MOD_ID);

	public static void init() {
		LOGGER.info("Reach Mod Client initialized!");
		ReachConfig.load();
	}
}
