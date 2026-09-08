package com.shinekitsune.reachmod.screen;

import com.shinekitsune.reachmod.ReachConfig;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.network.chat.Component;

public class ReachModScreen extends Screen {
	private static final int SLIDER_WIDTH = 150;
	private static final int SLIDER_HEIGHT = 20;
	private static final int SLIDER_X = 50;
	private static final int SLIDER_Y = 60;

	private Checkbox enabledCheckbox;
	private Button decreaseButton;
	private Button increaseButton;
	private int sliderValue;

	public ReachModScreen() {
		super(Component.literal("Reach Mod Configuration"));
		this.sliderValue = (int) ReachConfig.reachDistance;
	}

	@Override
	protected void init() {
		super.init();

		// Title
		this.addRenderableWidget(new Button.Builder(
				Component.literal("Reach Mod Settings"),
				button -> {}
		).pos(this.width / 2 - 75, 10).width(150).build());

		// Toggle Enable/Disable
		this.enabledCheckbox = new Checkbox(
				SLIDER_X,
				40,
				150,
				20,
				Component.literal("Reach Mod Enabled"),
				ReachConfig.enabled
		);
		this.addRenderableWidget(this.enabledCheckbox);

		// Decrease Button
		this.decreaseButton = this.addRenderableWidget(new Button.Builder(
				Component.literal("-"),
				button -> this.decreaseReach()
		).pos(SLIDER_X, SLIDER_Y).width(40).height(SLIDER_HEIGHT).build());

		// Increase Button
		this.increaseButton = this.addRenderableWidget(new Button.Builder(
				Component.literal("+"),
				button -> this.increaseReach()
		).pos(SLIDER_X + SLIDER_WIDTH + 10, SLIDER_Y).width(40).height(SLIDER_HEIGHT).build());

		// Done Button
		this.addRenderableWidget(new Button.Builder(
				Component.literal("Done"),
				button -> this.onClose()
		).pos(this.width / 2 - 50, this.height - 30).width(100).build());
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
		super.render(guiGraphics, mouseX, mouseY, partialTick);

		// Draw reach distance label and value
		guiGraphics.drawCenteredString(this.font, 
			"Reach Distance: " + this.sliderValue + " blocks", 
			SLIDER_X + SLIDER_WIDTH / 2 + 25, 
			SLIDER_Y + 5, 
			0xFFFFFF);

		// Draw range info
		guiGraphics.drawString(this.font, "Min: 1 | Max: 10", SLIDER_X, SLIDER_Y + 30, 0xAAAAAA);
	}

	private void increaseReach() {
		if (this.sliderValue < ReachConfig.maxReach) {
			this.sliderValue++;
			ReachConfig.setReachDistance(this.sliderValue);
		}
	}

	private void decreaseReach() {
		if (this.sliderValue > ReachConfig.minReach) {
			this.sliderValue--;
			ReachConfig.setReachDistance(this.sliderValue);
		}
	}

	@Override
	public void onClose() {
		ReachConfig.enabled = this.enabledCheckbox.selected();
		ReachConfig.setReachDistance(this.sliderValue);
		super.onClose();
	}

	@Override
	public boolean isPauseScreen() {
		return false;
	}
}
