package io.github.ennuil.ennuis_bigger_gambiarra.mixin.emi;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.emi.emi.handler.StonecuttingRecipeHandler;
import io.github.ennuil.ennuis_bigger_gambiarra.mixin.emi.accessors.StonecutterScreenHandlerAccessor;
import net.minecraft.screen.StonecutterScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(StonecuttingRecipeHandler.class)
public abstract class StonecuttingRecipeHandlerMixin {
	@ModifyExpressionValue(method = "getInputSources(Lnet/minecraft/screen/StonecutterScreenHandler;)Ljava/util/List;", at = @At(value = "CONSTANT", args = "intValue=36"))
	private int modify36(int original, StonecutterScreenHandler handler) {
		return ((StonecutterScreenHandlerAccessor) handler).getWorld().inferTenfoursized() ? 10 * 4 : original;
	}
}
