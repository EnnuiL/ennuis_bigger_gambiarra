package io.github.ennuil.ennuis_bigger_gambiarra.mixin.accessories;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import io.wispforest.accessories.menu.variants.AccessoriesExperimentalMenu;
import io.wispforest.accessories.menu.variants.AccessoriesMenuBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AccessoriesExperimentalMenu.class)
public abstract class AccessoriesExperimentalMenuMixin extends AccessoriesMenuBase {
	private AccessoriesExperimentalMenuMixin() {
		super(null, 0, null, null);
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
		method = "quickMoveStack",
		at = @At(
			value = "CONSTANT",
			args = "intValue=41"
		)
	)
	private int modifyPlayerInvOffset(int original) {
		return this.owner.getInventory().isTenfoursized() ? 45 : original;
	}

	@ModifyExpressionValue(
		method = "quickMoveStack",
		at = @At(
			value = "CONSTANT",
			args = "intValue=42"
		)
	)
	private int modifyPlayerInvOffset2(int original) {
		return this.owner.getInventory().isTenfoursized() ? 46 : original;
	}

	@ModifyExpressionValue(
		method = "quickMoveStack",
		at = @At(
			value = "CONSTANT",
			args = "intValue=32"
		)
	)
	private int modifyPlayerInvOffset3(int original) {
		return this.owner.getInventory().isTenfoursized() ? 35 : original;
	}

	@ModifyExpressionValue(
		method = "quickMoveStack",
		at = @At(
			value = "CONSTANT",
			args = "intValue=45"
		),
		// Fixes newer (and unpublished on Maven) versions of Accessories
		require = 0
	)
	private int modifyPlayerInvOffset4(int original) {
		return this.owner.getInventory().isTenfoursized() ? 49 : original;
	}
}
