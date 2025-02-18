package io.github.ennuil.ennuis_bigger_gambiarra.mixin.emi;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.emi.emi.handler.CookingRecipeHandler;
import io.github.ennuil.ennuis_bigger_gambiarra.mixin.emi.accessors.AbstractFurnaceMenuAccessor;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CookingRecipeHandler.class)
public abstract class CookingRecipeHandlerMixin {
	@ModifyExpressionValue(method = "getInputSources(Lnet/minecraft/world/inventory/AbstractFurnaceMenu;)Ljava/util/List;", at = @At(value = "CONSTANT", args = "intValue=36"))
	private int modify36(int original, AbstractFurnaceMenu menu) {
		return ((AbstractFurnaceMenuAccessor) menu).getLevel().inferTenfoursized() ? 10 * 4 : original;
	}
}
