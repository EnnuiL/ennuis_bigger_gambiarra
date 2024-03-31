package io.github.ennuil.ennuis_bigger_gambiarra.mixin.emi.accessors;

import net.minecraft.screen.StonecutterScreenHandler;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(StonecutterScreenHandler.class)
public interface StonecutterScreenHandlerAccessor {
	@Accessor
	@Final
	World getWorld();
}
