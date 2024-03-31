package io.github.ennuil.ennuis_bigger_gambiarra.mixin.emi;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.emi.emi.handler.CraftingRecipeHandler;
import io.github.ennuil.ennuis_bigger_gambiarra.mixin.emi.accessors.CraftingScreenHandlerAccessor;
import net.minecraft.screen.CraftingScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CraftingRecipeHandler.class)
public abstract class CraftingRecipeHandlerMixin {
	@ModifyExpressionValue(method = "getInputSources(Lnet/minecraft/screen/CraftingScreenHandler;)Ljava/util/List;", at = @At(value = "CONSTANT", args = "intValue=36"))
	private int modify36(int original, CraftingScreenHandler handler) {
		return ((CraftingScreenHandlerAccessor) handler).getPlayer().getWorld().inferTenfoursized() ? 10 * 4 : original;
	}
}
