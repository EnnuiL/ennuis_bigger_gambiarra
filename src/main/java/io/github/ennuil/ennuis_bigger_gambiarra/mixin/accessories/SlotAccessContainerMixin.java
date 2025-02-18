package io.github.ennuil.ennuis_bigger_gambiarra.mixin.accessories;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import io.wispforest.accessories.menu.SlotAccessContainer;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SlotAccessContainer.class)
public abstract class SlotAccessContainerMixin {
	@ModifyExpressionValue(
		method = "ofPlayerArmor",
		at = @At(
			value = "CONSTANT",
			args = "intValue=39"
		)
	)
	private static int modifyOffset(int original, @Local(argsOnly = true) Player player) {
		return player.getInventory().isTenfoursized() ? 43 : original;
	}

	@ModifyExpressionValue(
		method = "ofPlayerArmor",
		at = @At(
			value = "CONSTANT",
			args = "intValue=40"
		)
	)
	private static int modifyOffhandSlot(int original, @Local(argsOnly = true) Player player) {
		return player.getInventory().isTenfoursized() ? 44 : original;
	}
}
