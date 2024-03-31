package io.github.ennuil.ennuis_bigger_gambiarra.mixin.emi.accessors;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.CraftingScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CraftingScreenHandler.class)
public interface CraftingScreenHandlerAccessor {
	@Accessor
	PlayerEntity getPlayer();
}
