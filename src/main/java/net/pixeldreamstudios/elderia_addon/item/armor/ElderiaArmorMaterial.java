package net.pixeldreamstudios.elderia_addon.item.armor;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.pixeldreamstudios.elderia_addon.ElderiaAddon;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public enum ElderiaArmorMaterial implements ArmorMaterial {
    CRUSADER("crusader", 28, (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (p_266650_) -> {
        p_266650_.put(ArmorItem.Type.BOOTS, 3);
        p_266650_.put(ArmorItem.Type.LEGGINGS, 6);
        p_266650_.put(ArmorItem.Type.CHESTPLATE, 8);
        p_266650_.put(ArmorItem.Type.HELMET, 3);
    }), 20, SoundEvents.ARMOR_EQUIP_CHAIN, 1.0F, 0.1F, () -> Ingredient.of(Items.IRON_INGOT), Map.of(
            AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 75.0, Operation.ADDITION),
            AttributeRegistry.HOLY_SPELL_POWER.get(), new AttributeModifier("Holy Power", 0.09, Operation.MULTIPLY_BASE),
            Attributes.MOVEMENT_SPEED, new AttributeModifier("Movement Speed", -0.05, Operation.MULTIPLY_BASE)
    ));

    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (p_266653_) -> {
        p_266653_.put(ArmorItem.Type.BOOTS, 13);
        p_266653_.put(ArmorItem.Type.LEGGINGS, 15);
        p_266653_.put(ArmorItem.Type.CHESTPLATE, 16);
        p_266653_.put(ArmorItem.Type.HELMET, 11);
    });
    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;
    private final Map<Attribute, AttributeModifier> additionalAttributes;

    private ElderiaArmorMaterial(String pName, int pDurabilityMultiplier, EnumMap pProtectionFunctionForType, int pEnchantmentValue, SoundEvent pSound, float pToughness, float pKnockbackResistance, Supplier pRepairIngredient, Map additionalAttributes) {
        this.name = ElderiaAddon.MOD_ID + ":" + pName;
        this.durabilityMultiplier = pDurabilityMultiplier;
        this.protectionFunctionForType = pProtectionFunctionForType;
        this.enchantmentValue = pEnchantmentValue;
        this.sound = pSound;
        this.toughness = pToughness;
        this.knockbackResistance = pKnockbackResistance;
        this.repairIngredient = new LazyLoadedValue(pRepairIngredient);
        this.additionalAttributes = additionalAttributes;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return (Integer)HEALTH_FUNCTION_FOR_TYPE.get(pType) * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return (Integer)this.protectionFunctionForType.get(pType);
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    public Map<Attribute, AttributeModifier> getAdditionalAttributes() {
        return this.additionalAttributes;
    }
}
