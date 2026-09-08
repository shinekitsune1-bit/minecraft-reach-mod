package com.shinekitsune.reachmod.screen;

import com.shinekitsune.reachmod.ReachConfig;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.CheckboxWidget;
import net.minecraft.text.Text;

public class ReachModScreen extends Screen {

    private static final int SLIDER_WIDTH = 150;
    private static final int SLIDER_HEIGHT = 20;
    private static final int SLIDER_X = 50;
    private static final int SLIDER_Y = 60;

    private CheckboxWidget enabledCheckbox;
    private ButtonWidget decreaseButton;
    private ButtonWidget increaseButton;
    private int sliderValue;

    public ReachModScreen() {
        super(Text.literal("Reach Mod Configuration"));
        this.sliderValue = (int) ReachConfig.reachDistance;
    }

    @Override
    protected void init() {
        super.init();

        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("Reach Mod Settings"),
                button -> {}
        ).dimensions(this.width / 2 - 75, 10, 150, 20).build());

        this.enabledCheckbox = CheckboxWidget.builder(
                Text.literal("Reach Mod Enabled"),
                this.textRenderer
        ).pos(SLIDER_X, 40)
         .checked(ReachConfig.enabled)
         .build();

        this.addDrawableChild(this.enabledCheckbox);

        this.decreaseButton = this.addDrawableChild(ButtonWidget.builder(
                Text.literal("-"),
                button -> this.decreaseReach()
        ).dimensions(SLIDER_X, SLIDER_Y, 40, SLIDER_HEIGHT).build());

        this.increaseButton = this.addDrawableChild(ButtonWidget.builder(
                Text.literal("+"),
                button -> this.increaseReach()
        ).dimensions(
                SLIDER_X + SLIDER_WIDTH + 10,
                SLIDER_Y,
                40,
                SLIDER_HEIGHT
        ).build());

        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("Done"),
                button -> this.close()
        ).dimensions(this.width / 2 - 50, this.height - 30, 100, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);

        context.drawCenteredTextWithShadow(
                this.textRenderer,
                Text.literal("Reach Distance: " + this.sliderValue + " blocks"),
                SLIDER_X + SLIDER_WIDTH / 2 + 25,
                SLIDER_Y + 5,
                0xFFFFFF
        );

        context.drawTextWithShadow(
                this.textRenderer,
                Text.literal("Min: 1 | Max: 10"),
                SLIDER_X,
                SLIDER_Y + 30,
                0xAAAAAA
        );
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
    public void close() {
        ReachConfig.enabled = this.enabledCheckbox.isChecked();
        ReachConfig.setReachDistance(this.sliderValue);
        super.close();
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
			}
