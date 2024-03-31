package io.github.ennuil.ennuis_bigger_gambiarra.mixin.emi;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.emi.emi.handler.CookingRecipeHandler;
import io.github.ennuil.ennuis_bigger_gambiarra.mixin.emi.accessors.AbstractFurnaceScreenHandlerAccessor;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CookingRecipeHandler.class)
public abstract class CookingRecipeHandlerMixin {
	@ModifyExpressionValue(method = "getInputSources(Lnet/minecraft/screen/AbstractFurnaceScreenHandler;)Ljava/util/List;", at = @At(value = "CONSTANT", args = "intValue=36"))
	private int modify36(int original, AbstractFurnaceScreenHandler handler) {
		return ((AbstractFurnaceScreenHandlerAccessor) handler).getWorld().inferTenfoursized() ? 10 * 4 : original;
	}
}
