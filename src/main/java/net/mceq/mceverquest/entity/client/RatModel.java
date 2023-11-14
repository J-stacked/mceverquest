package net.mceq.mceverquest.entity.client;

import net.mceq.mceverquest.entity.animation.ModAnimations;
import net.mceq.mceverquest.entity.custom.RatEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class RatModel<T extends RatEntity> extends SinglePartEntityModel<T> {
	private final ModelPart rat;
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart backleftfoot;
	private final ModelPart backrightfoot;
	private final ModelPart rightfoot;
	private final ModelPart leftfoot;
	private final ModelPart tail;

	public RatModel(ModelPart root) {
		this.rat = root.getChild("rat");
		this.head = rat.getChild("head");
		this.body = rat.getChild("body");
		this.backleftfoot = rat.getChild("backleftfoot");
		this.backrightfoot = rat.getChild("backrightfoot");
		this.rightfoot = rat.getChild("rightfoot");
		this.leftfoot = rat.getChild("leftfoot");
		this.tail = rat.getChild("tail");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData rat = modelPartData.addChild("rat", ModelPartBuilder.create(), ModelTransform.of(-0.2F, 16.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData head = rat.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(-13.8F, 3.6F, -2.0F));

		ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(0, 6).cuboid(-6.2F, 2.2F, -0.8F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(-6.2F, -1.8F, 1.2F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-6.2F, -3.8F, 1.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-8.2F, -3.8F, 3.2F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-12.2F, -1.8F, 3.2F, 12.0F, 4.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-6.2F, -3.8F, 1.2F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-6.2F, -3.8F, -0.8F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 4).mirrored().cuboid(-8.2F, -3.8F, -2.8F, 0.0F, 2.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 6).cuboid(-6.2F, -3.8F, -2.8F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(-1, 1).cuboid(-6.2F, -3.8F, -0.8F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(-6, 0).cuboid(-8.2F, -3.8F, -2.8F, 2.0F, 0.0F, 6.0F, new Dilation(0.0F))
				.uv(-6, 0).cuboid(-12.2F, -1.8F, -2.8F, 4.0F, 0.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(-6.2F, -1.8F, -2.8F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).mirrored().cuboid(-12.2F, -1.8F, -2.8F, 0.0F, 4.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 6).cuboid(-12.2F, 2.2F, -2.8F, 6.0F, 0.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-8.2F, -3.8F, -2.8F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-12.2F, -1.8F, -2.8F, 12.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(4.2F, -1.6F, 1.8F, 0.0F, 0.0F, 0.0F));

		ModelPartData body = rat.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(-19.0F, 0.0F, -2.0F));

		ModelPartData cube_r2 = body.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(3.0F, -3.8F, 3.2F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(3.0F, -3.8F, 1.2F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-11.0F, -3.8F, 1.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(3.0F, -5.8F, 1.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-1.0F, -5.8F, 3.2F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(5.0F, -1.8F, 3.2F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(5.0F, 2.2F, 1.2F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.0F, 2.2F, 1.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.0F, -5.8F, 3.2F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.0F, -5.8F, 1.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-7.0F, 0.2F, 3.2F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-9.0F, 2.2F, 3.2F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-11.0F, -3.8F, 3.2F, 6.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.0F, 4.2F, 3.2F, 6.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-7.0F, -5.8F, 1.2F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-7.0F, -5.8F, -0.8F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-7.0F, -5.8F, -0.8F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(3.0F, -5.8F, 1.2F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(3.0F, -5.8F, -0.8F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-11.0F, 2.2F, -0.8F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.0F, 2.2F, 1.2F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.0F, 2.2F, -0.8F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.0F, -5.8F, -2.8F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.0F, -5.8F, -2.8F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-1.0F, -5.8F, -2.8F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(3.0F, -5.8F, -2.8F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-11.0F, -3.8F, -2.8F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(-7.0F, -3.8F, 1.2F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(4, 2).cuboid(-7.0F, -3.8F, -2.8F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(2, 0).cuboid(-11.0F, -3.8F, -2.8F, 4.0F, 0.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(3.0F, -3.8F, -2.8F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(3.0F, -3.8F, -2.8F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(5.0F, -5.8F, -0.8F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, -6).cuboid(5.0F, -3.8F, -2.8F, 0.0F, 2.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(5.0F, -1.8F, -2.8F, 2.0F, 0.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(5.0F, -1.8F, -2.8F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(5.0F, 2.2F, -2.8F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(7.0F, 0.2F, 1.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(7.0F, 0.2F, -2.8F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, -6).cuboid(7.0F, -1.8F, -2.8F, 0.0F, 2.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-11.0F, 4.2F, -0.8F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.0F, 4.2F, -2.8F, 6.0F, 0.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-9.0F, 4.2F, -2.8F, 4.0F, 0.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.0F, 2.2F, -2.8F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-7.0F, 0.2F, -2.8F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-9.0F, 2.2F, -2.8F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-11.0F, -3.8F, -2.8F, 6.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.0F, 4.2F, -2.8F, 6.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(-7.0F, -5.8F, -0.8F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(-2, 0).cuboid(3.0F, -5.8F, -0.8F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(-6, 0).cuboid(-5.0F, -5.8F, -2.8F, 8.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(16.2F, 2.0F, 1.8F, 0.0F, 0.0F, 0.0F));

		ModelPartData backleftfoot = rat.addChild("backleftfoot", ModelPartBuilder.create(), ModelTransform.pivot(-4.2F, 0.0F, -5.6F));

		ModelPartData cube_r3 = backleftfoot.addChild("cube_r3", ModelPartBuilder.create().uv(4, 1).cuboid(-3.0F, -5.8F, -0.4F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(4, 0).cuboid(-3.0F, -5.8F, -0.4F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-1.0F, -5.8F, -0.4F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(4, 1).cuboid(-5.0F, -3.8F, -0.4F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(4, 0).cuboid(-5.0F, -3.8F, -0.4F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(-2, 0).cuboid(-1.0F, -3.8F, -0.4F, 4.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(3.0F, -3.8F, -0.4F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(4, 1).cuboid(-7.0F, -1.8F, -0.4F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-7.0F, 0.2F, -0.4F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(4, 0).cuboid(-7.0F, -1.8F, -0.4F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(3.0F, -1.8F, -0.4F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(5.0F, -1.8F, -0.4F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.0F, 2.2F, -0.4F, 2.0F, 0.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.0F, 0.2F, -0.4F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(1.0F, 4.2F, -0.4F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(5.0F, 0.2F, -0.4F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(5.0F, 2.2F, -0.4F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.0F, 2.2F, -0.4F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.0F, -5.8F, -0.4F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-7.0F, -1.8F, -0.4F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(3.0F, -1.8F, -0.4F, 2.0F, 6.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-5.0F, -3.8F, -0.4F, 2.0F, 6.0F, 0.0F, new Dilation(0.0F))
				.uv(4, 0).cuboid(-3.0F, -3.8F, -0.4F, 6.0F, 10.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.0F, 6.2F, -0.4F, 6.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(3.0F, 4.2F, -0.4F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.4F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData backrightfoot = rat.addChild("backrightfoot", ModelPartBuilder.create(), ModelTransform.pivot(-3.4F, 0.0F, 2.8F));

		ModelPartData cube_r4 = backrightfoot.addChild("cube_r4", ModelPartBuilder.create().uv(0, 6).cuboid(3.0F, 4.2F, -2.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.0F, 6.2F, -2.0F, 6.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.0F, 2.2F, -2.0F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.0F, 2.2F, -4.0F, 2.0F, 0.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.0F, 0.2F, -2.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(3.0F, -1.8F, -2.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(5.0F, 2.2F, -4.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(5.0F, -1.8F, -2.0F, 0.0F, 6.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(-7.0F, -1.8F, -2.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-7.0F, 0.2F, -2.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-7.0F, -1.8F, -2.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(3.0F, -3.8F, -2.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(-1.0F, -3.8F, -2.0F, 4.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(-5.0F, -3.8F, -2.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.0F, -3.8F, -2.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-7.0F, -1.8F, 0.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.0F, -5.8F, 0.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.0F, -3.8F, 0.0F, 2.0F, 6.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(3.0F, -1.8F, 0.0F, 2.0F, 6.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-3.0F, -3.8F, 0.0F, 6.0F, 10.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.0F, -5.8F, -2.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-1.0F, -5.8F, -2.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(-3.0F, -5.8F, -2.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(1.0F, 4.2F, -4.0F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.6F, 2.0F, 2.2F, 0.0F, 0.0F, 0.0F));

		ModelPartData rightfoot = rat.addChild("rightfoot", ModelPartBuilder.create(), ModelTransform.pivot(-14.2F, 5.2F, 1.2F));

		ModelPartData cube_r5 = rightfoot.addChild("cube_r5", ModelPartBuilder.create().uv(0, 6).cuboid(-3.8F, -0.2F, -2.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.8F, 1.8F, 0.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-3.8F, -0.2F, 0.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.8F, -0.2F, -2.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.8F, 1.8F, -2.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(0.2F, 1.8F, -2.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.8F, 1.8F, -2.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(-5.8F, 1.8F, -2.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(4, 0).cuboid(-5.8F, 1.8F, -2.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.8F, 3.8F, -2.0F, 6.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.2F, -0.8F, 1.8F, 0.0F, 0.0F, 0.0F));

		ModelPartData leftfoot = rat.addChild("leftfoot", ModelPartBuilder.create(), ModelTransform.pivot(-13.4F, 4.4F, -3.2F));

		ModelPartData cube_r6 = leftfoot.addChild("cube_r6", ModelPartBuilder.create().uv(0, 6).cuboid(-5.4F, 1.8F, 2.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.4F, -0.2F, 0.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.4F, 1.8F, 0.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(-5.4F, 1.8F, 0.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(3, -1).cuboid(-5.4F, 1.8F, 0.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.4F, -0.2F, 2.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.4F, 1.8F, 2.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 5).cuboid(-3.4F, -0.2F, 0.0F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.4F, 3.8F, 0.0F, 6.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(0.6F, 1.8F, 0.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F));

		ModelPartData tail = rat.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 5.6F, -2.0F));

		ModelPartData cube_r7 = tail.addChild("cube_r7", ModelPartBuilder.create().uv(0, 7).cuboid(3.0F, -1.8F, -0.8F, 4.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(7.0F, -1.8F, -0.8F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(7.0F, 0.2F, -0.8F, 8.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(15.0F, 0.2F, -0.8F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(9.0F, 2.2F, -0.8F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(3.0F, -1.8F, 1.2F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(1.0F, 0.2F, 1.2F, 14.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(9.0F, 2.2F, 1.2F, 16.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(3.0F, -1.8F, -0.8F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(1.0F, 0.2F, -0.8F, 14.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(9.0F, 2.2F, -0.8F, 16.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(15.0F, 2.2F, -0.8F, 10.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(9.0F, 4.2F, -0.8F, 16.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(25.0F, 2.2F, -0.8F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.0F, 2.2F, -0.8F, 12.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.2F, -1.6F, 1.8F, 0.0F, 0.0F, 0.0F));

		return TexturedModelData.of(modelData, 16, 16);
	}

	@Override
	public void setAngles(RatEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {  //required
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(ModAnimations.RAT_RUN, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.RAT_IDLE, ageInTicks, 1f);
	}


	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		rat.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return rat;
	}  //required
}