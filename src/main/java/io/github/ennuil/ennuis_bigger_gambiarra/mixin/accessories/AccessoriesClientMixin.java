package io.github.ennuil.ennuis_bigger_gambiarra.mixin.accessories;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import io.wispforest.accessories.client.AccessoriesClient;
import net.minecraft.client.Minecraft;
import org.joml.Vector2i;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AccessoriesClient.class)
public abstract class AccessoriesClientMixin {
	@ModifyExpressionValue(
		method = "lambda$initLayer$19",
		at = @At(
			value = "INVOKE",
			target = "Lio/wispforest/accessories/compat/config/AccessoriesConfig$ScreenOptions_;creativeInventoryButtonOffset()Lorg/joml/Vector2i;"
		)
	)
	private static Vector2i dislocateCreativeAccessoriesButton(Vector2i original) {
		return Minecraft.getInstance().gameMode.isTenfoursized() ? new Vector2i(original).add(18, 0) : original;
	}
}
