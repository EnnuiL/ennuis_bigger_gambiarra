package io.github.ennuil.ennuis_bigger_gambiarra.mixin.emi;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.emi.emi.handler.InventoryRecipeHandler;
import io.github.ennuil.ennuis_bigger_gambiarra.mixin.emi.accessors.PlayerScreenHandlerAccessor;
import net.minecraft.screen.PlayerScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(InventoryRecipeHandler.class)
public abstract class InventoryRecipeHandlerMixin {
	@ModifyExpressionValue(method = "getInputSources(Lnet/minecraft/screen/PlayerScreenHandler;)Ljava/util/List;", at = @At(value = "CONSTANT", args = "intValue=36"))
	private int modify36(int original, PlayerScreenHandler handler) {
		return ((PlayerScreenHandlerAccessor) handler).getOwner().getWorld().inferTenfoursized() ? 10 * 4 : original;
	}
}
