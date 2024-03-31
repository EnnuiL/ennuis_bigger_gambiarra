package io.github.ennuil.ennuis_bigger_gambiarra.mixin.emi.accessors;

import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractFurnaceScreenHandler.class)
public interface AbstractFurnaceScreenHandlerAccessor {
	@Accessor
	World getWorld();
}
