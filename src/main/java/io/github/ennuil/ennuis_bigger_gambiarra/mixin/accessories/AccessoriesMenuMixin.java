package io.github.ennuil.ennuis_bigger_gambiarra.mixin.accessories;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import io.wispforest.accessories.menu.variants.AccessoriesMenu;
import io.wispforest.accessories.menu.variants.AccessoriesMenuBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AccessoriesMenu.class)
public abstract class AccessoriesMenuMixin extends AccessoriesMenuBase {
	protected AccessoriesMenuMixin() {
		super(null, 0, null, null);
	}

	@ModifyExpressionValue(
		method = "<init>",
		at = @At(
			value = "CONSTANT",
			args = "intValue=9"
		)
	)
	private int modifyNines1(int original) {
		return this.owner.getInventory().isTenfoursized() ? 10 : original;
	}

	@ModifyExpressionValue(
		method = "<init>",
		at = @At(
			value = "CONSTANT",
			args = "intValue=152",
			ordinal = 0
		)
	)
	private int modifyOffhandX(int original) {
		return this.owner.getInventory().isTenfoursized() ? 170 : original;
	}

	@ModifyExpressionValue(
		method = "<init>",
		at = @At(
			value = "CONSTANT",
			args = "intValue=40"
		)
	)
	private int modifyOffhandSlot(int original) {
		return this.owner.getInventory().isTenfoursized() ? 44 : original;
	}

	@ModifyExpressionValue(
		method = "<init>",
		at = @At(
			value = "CONSTANT",
			args = "intValue=39"
		)
	)
	private int modifyEquipmentSlot(int original) {
		return this.owner.getInventory().isTenfoursized() ? 43 : original;
	}
}
