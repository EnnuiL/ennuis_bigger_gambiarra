package io.github.ennuil.ennuis_bigger_gambiarra.mixin.accessories;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import io.github.ennuil.ennuis_bigger_inventories.api.HackjobKit;
import io.wispforest.accessories.client.gui.components.ComponentUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ComponentUtils.class)
public abstract class ComponentUtilsMixin {
	@ModifyExpressionValue(
		method = "createPlayerInv",
		at = @At(
			value = "CONSTANT",
			args = "intValue=8"
		)
	)
	private static int modifyRowMax(int original) {
		return HackjobKit.isTenfoursized() ? 9 : original;
	}
}
