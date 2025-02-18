package io.github.ennuil.ennuis_bigger_gambiarra.mixin.owo;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import io.wispforest.owo.client.screens.SlotGenerator;
import net.minecraft.world.entity.player.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SlotGenerator.class)
public abstract class SlotGeneratorMixin {
	@ModifyExpressionValue(
		method = "playerInventory",
		at = @At(
			value = "CONSTANT",
			args = "intValue=9"
		)
	)
	private int modifyNines(int original, @Local(argsOnly = true) Inventory inventory) {
		return inventory.isTenfoursized() ? 10 : original;
	}
}
