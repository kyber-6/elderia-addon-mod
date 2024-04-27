package net.pixeldreamstudios.elderia_addon.registry;

import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pixeldreamstudios.elderia_addon.ElderiaAddon;
import net.pixeldreamstudios.elderia_addon.item.ExampleMagicSword;
import net.pixeldreamstudios.elderia_addon.item.armor.sets.CrusaderArmorItem;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ElderiaAddon.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> EXAMPLE_MAGIC_SWORD = ITEMS.register("example_magic_sword", () -> new ExampleMagicSword(new SpellDataRegistryHolder[]{new SpellDataRegistryHolder(ExampleSpellRegistry.SUPER_HEAL_SPELL, 1)}));
    public static final RegistryObject<Item> CRUSADER_HELMET = ITEMS.register("crusader_helmet", () -> new CrusaderArmorItem(Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CRUSADER_CHESTPLATE = ITEMS.register("crusader_chestplate", () -> new CrusaderArmorItem(Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CRUSADER_LEGGINGS = ITEMS.register("crusader_leggings", () -> new CrusaderArmorItem(Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CRUSADER_BOOTS = ITEMS.register("crusader_boots", () -> new CrusaderArmorItem(Type.BOOTS, new Item.Properties()));
}
