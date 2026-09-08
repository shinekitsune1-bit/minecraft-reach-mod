package com.shinekitsune.reachmod.mixin;

import com.shinekitsune.reachmod.ReachConfig;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerInteractionManager.class)
public class PlayerInteractionManagerMixin {

	@Inject(method = "getReachDistance", at = @At("HEAD"), cancellable = true)
	private void modifyReachDistance(CallbackInfoReturnable<Float> cir) {
		cir.setReturnValue((float) ReachConfig.getReachDistance());
	}
}
