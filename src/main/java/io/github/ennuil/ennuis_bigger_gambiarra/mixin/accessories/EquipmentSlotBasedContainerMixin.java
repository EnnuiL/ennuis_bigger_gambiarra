package io.github.ennuil.ennuis_bigger_gambiarra.mixin.accessories;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import io.wispforest.accessories.menu.EquipmentSlotBasedContainer;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(EquipmentSlotBasedContainer.class)
public interface EquipmentSlotBasedContainerMixin {
	@ModifyExpressionValue(
		method = "lambda$ofPlayer$3",
		at = @At(
			value = "CONSTANT",
			args = "intValue=39"
		)
	)
	private static int modifyOffset(int original, @Local(argsOnly = true) Player player) {
		return player.getInventory().isTenfoursized() ? 43 : original;
	}
}
