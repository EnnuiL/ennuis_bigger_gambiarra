package io.github.ennuil.ennuis_bigger_gambiarra.mixin.emi;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.emi.emi.handler.InventoryRecipeHandler;
import io.github.ennuil.ennuis_bigger_gambiarra.mixin.emi.accessors.InventoryMenuAccessor;
import net.minecraft.world.inventory.InventoryMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(InventoryRecipeHandler.class)
public abstract class InventoryRecipeHandlerMixin {
	@ModifyExpressionValue(method = "getInputSources(Lnet/minecraft/world/inventory/InventoryMenu;)Ljava/util/List;", at = @At(value = "CONSTANT", args = "intValue=36"))
	private int modify36(int original, InventoryMenu menu) {
		return ((InventoryMenuAccessor) menu).getOwner().level().inferTenfoursized() ? 10 * 4 : original;
	}
}
