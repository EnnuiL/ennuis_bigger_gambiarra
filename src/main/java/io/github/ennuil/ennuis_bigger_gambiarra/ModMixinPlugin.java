package io.github.ennuil.ennuis_bigger_gambiarra;

import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

// TODO - Print a log message when a mod with mixins to be applied is detected
public class ModMixinPlugin implements IMixinConfigPlugin {
	private static String mixinPackage;

	@Override
	public void onLoad(String mixinPackage) {
		ModMixinPlugin.mixinPackage = mixinPackage;
	}

	@Override
	public String getRefMapperConfig() {
		return null;
	}

	@Override
	public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
		if (mixinClassName.startsWith(mixinPackage)) {
			var id = mixinClassName.substring(mixinPackage.length());
			id = id.substring(1, id.indexOf('.', 1));

			return id.equals("common") || FabricLoader.getInstance().isModLoaded(id);
		}

		return true;
	}

	@Override
	public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}

	@Override
	public List<String> getMixins() {
		return null;
	}

	@Override
	public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}

	@Override
	public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
}
