package io.github.ennuil.ennuis_bigger_gambiarra.mixin.emi.accessors;

import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractFurnaceMenu.class)
public interface AbstractFurnaceMenuAccessor {
	@Accessor
	Level getLevel();
}
