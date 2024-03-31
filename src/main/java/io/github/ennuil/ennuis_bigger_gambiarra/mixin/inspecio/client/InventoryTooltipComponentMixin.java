package io.github.ennuil.ennuis_bigger_gambiarra.mixin.inspecio.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import io.github.queerbric.inspecio.tooltip.InventoryTooltipComponent;
import net.minecraft.client.MinecraftClient;
import org.quiltmc.loader.api.minecraft.ClientOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@ClientOnly
@Mixin(InventoryTooltipComponent.class)
public abstract class InventoryTooltipComponentMixin {
	@ModifyExpressionValue(method = "of", at = @At(value = "CONSTANT", args = "intValue=9"))
	private static int modifyNines(int original) {
		return MinecraftClient.getInstance().interactionManager.isTenfoursized() ? 10 * 3 : original;
	}
}
