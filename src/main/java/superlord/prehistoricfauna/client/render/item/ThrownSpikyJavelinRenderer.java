package superlord.prehistoricfauna.client.render.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import superlord.prehistoricfauna.common.entity.projectile.ThrownSpikyJavelin;
import superlord.prehistoricfauna.init.PFItems;

public class ThrownSpikyJavelinRenderer extends EntityRenderer<ThrownSpikyJavelin> {

    private final ItemRenderer itemRenderer;

    public ThrownSpikyJavelinRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(ThrownSpikyJavelin entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();

        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTick, entity.yRotO, entity.getYRot()) - 90.0F));

        if (!entity.onGround()) {
            Vec3 velocity = entity.getDeltaMovement();
            double horizontalSpeed = Math.sqrt(velocity.x * velocity.x + velocity.z * velocity.z);
            float velocityPitch = (float) Math.toDegrees(Math.atan2(velocity.y, horizontalSpeed));
            poseStack.mulPose(Axis.ZP.rotationDegrees(-velocityPitch));
        } else {
            poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTick, entity.xRotO, entity.getXRot())));
        }
        poseStack.mulPose(Axis.ZP.rotationDegrees(-180.0F));

        ItemStack stack = entity.getJavelinStack();
        if (stack.isEmpty()) stack = new ItemStack(PFItems.SPIKY_JAVELIN.get());

        this.itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, packedLight, OverlayTexture.NO_OVERLAY, poseStack, bufferSource, entity.level(), entity.getId());

        poseStack.popPose();

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownSpikyJavelin entity) {
        return new ResourceLocation("minecraft", "textures/item/stick.png");
    }
}