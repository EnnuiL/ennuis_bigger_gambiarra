package io.github.ennuil.ennuis_bigger_gambiarra.mixin.jei;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import io.github.ennuil.ennuis_bigger_inventories.api.HackjobKit;
import mezz.jei.library.transfer.BasicRecipeTransferInfo;
import net.minecraft.screen.ScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BasicRecipeTransferInfo.class)
public abstract class PlayerRecipeTransferHandlerMixin {
	@ModifyExpressionValue(method = "getInventorySlots", at = @At(value = "FIELD", target = "Lmezz/jei/library/transfer/BasicRecipeTransferInfo;inventorySlotCount:I"))
	private int modifySlotEnd(int original, @Local ScreenHandler screenHandler) {
		// This hackjob is generic enough to affect everything that's needed but it might be overreaching!
		// I recommend EMI for a better experience, but if you really want JEI, I guess we have this ticking time bomb
		// Do *not* point fingers to JEI's mod authors!!! I'm the one doing the gambiarra in the first place!
		return original == 36 && HackjobKit.isTenfoursized() ? 40 : original;
	}
}
