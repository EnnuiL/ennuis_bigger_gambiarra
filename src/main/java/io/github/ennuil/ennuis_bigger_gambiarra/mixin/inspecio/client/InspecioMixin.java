package io.github.ennuil.ennuis_bigger_gambiarra.mixin.inspecio.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import io.github.queerbric.inspecio.Inspecio;
import net.minecraft.client.MinecraftClient;
import org.quiltmc.loader.api.minecraft.ClientOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@ClientOnly
@Mixin(Inspecio.class)
public abstract class InspecioMixin {
	@ModifyExpressionValue(method = "getInvSizeFor", at = @At(value = "CONSTANT", args = "intValue=27"))
	private static int modify27(int original) {
		// Well, it's a client mod after all
		return MinecraftClient.getInstance().interactionManager.isTenfoursized() ? 10 * 3 : original;
	}
}
