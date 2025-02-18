package io.github.ennuil.ennuis_bigger_gambiarra.mixin.emi.accessors;

import net.minecraft.world.inventory.StonecutterMenu;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(StonecutterMenu.class)
public interface StonecutterMenuAccessor {
	@Accessor
	@Final
	Level getLevel();
}
