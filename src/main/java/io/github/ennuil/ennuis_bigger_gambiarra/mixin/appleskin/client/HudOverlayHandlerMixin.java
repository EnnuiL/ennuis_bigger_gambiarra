package io.github.ennuil.ennuis_bigger_gambiarra.mixin.appleskin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.MinecraftClient;
import org.quiltmc.loader.api.minecraft.ClientOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import squeek.appleskin.client.HUDOverlayHandler;

@ClientOnly
@Mixin(HUDOverlayHandler.class)
public class HudOverlayHandlerMixin {
	// Actually, why do I have to do a mixin here? Borrow the local from the original place!
	@ModifyExpressionValue(method = {"onPreRender", "onRender"}, at = @At(value = "CONSTANT", args = "intValue=91"))
	private int modify91(int original, @Local MinecraftClient client) {
		if (client.interactionManager.isTenfoursized()) {
			return 101;
		}

		return original;
	}
}
