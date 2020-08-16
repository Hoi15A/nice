package moe.neat.mixin;

import net.minecraft.entity.ItemEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin {

    @Shadow public abstract ItemStack getStack();

    @Inject(at = @At("HEAD"), method = "isFireImmune", cancellable = true)
    private void isFireImmune(CallbackInfoReturnable<Boolean> cir) {
        if (this.getStack().getItem().equals(Items.POTATO)) {
            //BlockItem box = (BlockItem)this.getStack().getItem();

            cir.setReturnValue(true);
        }
    }
}
