package io.github.ennuil.ennuis_bigger_gambiarra.mixin.accessories;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import io.wispforest.accessories.client.gui.AccessoriesExperimentalScreen;
import io.wispforest.accessories.menu.variants.AccessoriesExperimentalMenu;
import io.wispforest.owo.ui.base.BaseOwoHandledScreen;
import io.wispforest.owo.ui.container.FlowLayout;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AccessoriesExperimentalScreen.class)
public abstract class AccessoriesExperimentalScreenMixin extends BaseOwoHandledScreen<FlowLayout, AccessoriesExperimentalMenu> {
	private AccessoriesExperimentalScreenMixin() {
		super(null, null, null);
	}

	@ModifyExpressionValue(
		method = "build(Lio/wispforest/owo/ui/container/FlowLayout;)V",
		at = @At(
			value = "CONSTANT",
			args = "intValue=162"
		)
	)
	private int modifyInventorySize(int original) {
		return this.minecraft.gameMode.isTenfoursized() ? 180 : original;
	}

	@ModifyArg(
		method = "lambda$build$8",
		at = @At(
			value = "INVOKE",
			target = "Lio/wispforest/accessories/Accessories;of(Ljava/lang/String;)Lnet/minecraft/resources/ResourceLocation;"
		)
	)
	private String modifyTexture(String original) {
		return this.minecraft.gameMode.isTenfoursized() ? original.replace(".png", "_10x4.png") : original;
	}

	@ModifyExpressionValue(
		method = "lambda$build$8",
		at = @At(
			value = "CONSTANT",
			args = "intValue=195"
		)
	)
	private int modifyTextureSizeSmall(int original) {
		return this.minecraft.gameMode.isTenfoursized() ? 213 : original;
	}

	@ModifyExpressionValue(
		method = "lambda$build$8",
		at = @At(
			value = "CONSTANT",
			args = "intValue=234"
		)
	)
	private int modifyTextureSizeBig(int original) {
		return this.minecraft.gameMode.isTenfoursized() ? 252 : original;
	}
}
