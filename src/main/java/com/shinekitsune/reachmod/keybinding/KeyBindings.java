package com.shinekitsune.reachmod.keybinding;

import com.shinekitsune.reachmod.screen.ReachModScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
	public static KeyMapping openConfigKeyBinding;

	public static void init() {
		openConfigKeyBinding = KeyBindingHelper.registerKeyBinding(
			new KeyMapping(
				"key.reach_mod.open_config",
				GLFW.GLFW_KEY_R,
				"category.reach_mod"
			)
		);

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (openConfigKeyBinding.consumeClick()) {
				Minecraft.getInstance().setScreen(new ReachModScreen());
			}
		});
	}
}
