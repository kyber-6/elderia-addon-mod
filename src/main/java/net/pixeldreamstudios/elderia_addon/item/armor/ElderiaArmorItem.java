package net.pixeldreamstudios.elderia_addon.item.armor;

import io.redspace.ironsspellbooks.api.spells.IPresetSpellContainer;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ElderiaArmorItem extends ArmorItem implements IPresetSpellContainer {
    public ElderiaArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack != null) {
            Item var3 = itemStack.getItem();
            if (var3 instanceof ArmorItem) {
                ArmorItem armorItem = (ArmorItem)var3;
                if (armorItem.getType() == Type.CHESTPLATE && !ISpellContainer.isSpellContainer(itemStack)) {
                    ISpellContainer spellContainer = ISpellContainer.create(1, true, true);
                    spellContainer.save(itemStack);
                }
            }

        }
    }
}
