package com.sumrakk.thelionkingremake.client;

import com.sumrakk.thelionkingremake.TheLionKingRemake;
import com.sumrakk.thelionkingremake.items.ModItems;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.ElytraModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class PeacockElytraLayer<T extends LivingEntity, M extends BipedModel<T>> extends LayerRenderer<T, M> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(TheLionKingRemake.MOD_ID, "textures/entity/peacock_elytra.png");

    private final ElytraModel<T> elytraModel = new ElytraModel<>();

    public PeacockElytraLayer(IEntityRenderer<T, M> renderer) {
        super(renderer);
    }

    @Override
    public void render(MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight, T entity,
                       float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks,
                       float netHeadYaw, float headPitch) {

        ItemStack itemstack = entity.getItemStackFromSlot(EquipmentSlotType.CHEST);

        if (itemstack.getItem() == ModItems.PEACOCK_ELYTRA.get()) {
            matrixStack.push();
            matrixStack.translate(0.0D, 0.0D, 0.125D);

            this.getEntityModel().copyModelAttributesTo(this.elytraModel);
            this.elytraModel.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

            // ✅ ПРАВИЛЬНЫЙ КОД ДЛЯ 1.16.5
            this.elytraModel.render(matrixStack,
                    buffer.getBuffer(this.elytraModel.getRenderType(TEXTURE)),
                    packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

            matrixStack.pop();
        }
    }
}