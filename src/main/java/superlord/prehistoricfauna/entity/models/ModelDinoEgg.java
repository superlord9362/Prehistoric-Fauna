package superlord.prehistoricfauna.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * EntityEgg - superlord9362
 * Created using Tabula 7.0.1
 */
public class ModelDinoEgg extends ModelBase {
    public ModelRenderer EggBase;
    public ModelRenderer EggOuter;

    public ModelDinoEgg() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.EggBase = new ModelRenderer(this, 0, 0);
        this.EggBase.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.EggBase.addBox(-1.0F, -5.0F, -1.0F, 2, 6, 2, 0.0F);
        this.EggOuter = new ModelRenderer(this, 8, 0);
        this.EggOuter.setRotationPoint(-0.5F, 0.0F, -0.5F);
        this.EggOuter.addBox(-1.0F, -4.0F, -1.0F, 3, 4, 3, 0.0F);
        this.EggBase.addChild(this.EggOuter);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.EggBase.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
