package net.pixeldreamstudios.elderia_addon.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pixeldreamstudios.elderia_addon.ElderiaAddon;

@Mod.EventBusSubscriber(modid = "elderia_addon", bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabRegistry {
    private static final DeferredRegister<CreativeModeTab> TABS;
    public static final RegistryObject<CreativeModeTab> ELDERIA_TAB;

    public CreativeTabRegistry() {
    }

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }

    static {
        TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ElderiaAddon.MOD_ID);
        ELDERIA_TAB = TABS.register("elderia_tab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup." + ElderiaAddon.MOD_ID + ".elderia_tab")).icon(() -> new ItemStack(ItemRegistry.CRUSADER_HELMET.get())).displayItems((enabledFeatures, entries) -> {
            entries.accept(ItemRegistry.CRUSADER_HELMET.get());
            entries.accept(ItemRegistry.CRUSADER_CHESTPLATE.get());
            entries.accept(ItemRegistry.CRUSADER_LEGGINGS.get());
            entries.accept(ItemRegistry.CRUSADER_BOOTS.get());
        }).build());
    }
}
