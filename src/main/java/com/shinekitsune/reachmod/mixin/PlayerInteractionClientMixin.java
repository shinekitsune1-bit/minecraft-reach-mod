package com.shinekitsune.reachmod.mixin;

import com.shinekitsune.reachmod.ReachConfig;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerInteractionManager.class)
public class PlayerInteractionClientMixin {

	@Inject(method = "getReachDistance", at = @At("HEAD"), cancellable = true)
	private void modifyClientReachDistance(CallbackInfoReturnable<Float> cir) {
		cir.setReturnValue((float) ReachConfig.getReachDistance());
	}
}
