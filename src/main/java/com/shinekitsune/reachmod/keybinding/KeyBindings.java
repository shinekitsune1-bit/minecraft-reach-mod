package com.shinekitsune.reachmod.keybinding;

import com.shinekitsune.reachmod.ReachMod;
import com.shinekitsune.reachmod.screen.ReachModScreen;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {

    public static KeyBinding openConfigKeyBinding;

    public static void register() {
        openConfigKeyBinding = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "key.reachmod.open_config",
                        GLFW.GLFW_KEY_R,
                        "category.reachmod"
                )
        );

        ReachMod.CLIENT_EXECUTOR.execute(() -> {
            while (true) {
                if (openConfigKeyBinding.wasPressed()) {
                    MinecraftClient client = MinecraftClient.getInstance();

                    if (client.currentScreen == null) {
                        client.setScreen(new ReachModScreen());
                    }
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
    }
						 }
