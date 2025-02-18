package io.github.ennuil.ennuis_bigger_gambiarra.mixin.accessories;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import io.wispforest.accessories.Accessories;
import io.wispforest.accessories.client.gui.AccessoriesScreen;
import io.wispforest.accessories.menu.variants.AccessoriesMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AccessoriesScreen.class)
public abstract class AccessoriesScreenMixin extends AbstractContainerScreen<AccessoriesMenu> {
	@Unique
	private static final ResourceLocation ACCESSORIES_INVENTORY_LOCATION = Accessories.of("textures/gui/container/accessories_inventory_10x4.png");

	private AccessoriesScreenMixin() {
		super(null, null, null);
	}

	@ModifyArg(
		method = "renderBg",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/gui/GuiGraphics;blit(Lnet/minecraft/resources/ResourceLocation;IIIIII)V"
		)
	)
	private ResourceLocation modifyBackground(ResourceLocation original) {
		return this.minecraft.gameMode.isTenfoursized() ? ACCESSORIES_INVENTORY_LOCATION : original;
	}

	@ModifyExpressionValue(
		method = "renderBg",
		at = @At(
			value = "CONSTANT",
			args = "intValue=26"
		)
	)
	private int modifyScissorStart(int original) {
		return this.minecraft.gameMode.isTenfoursized() ? 35 : original;
	}

	@ModifyExpressionValue(
		method = "init",
		at = @At(
			value = "CONSTANT",
			args = "intValue=141"
		)
	)
	private int modifyBackButtonX(int original) {
		return this.minecraft.gameMode.isTenfoursized() ? 150 : original;
	}

	@ModifyExpressionValue(
		method = "init",
		at = @At(
			value = "CONSTANT",
			args = "intValue=154"
		)
	)
	private int modifyUnusedSlotsButtonX(int original) {
		return this.minecraft.gameMode.isTenfoursized() ? 163 + 12 : original;
	}
}
