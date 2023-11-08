package net.mceq.mceverquest.entity.client;

import net.mceq.mceverquest.entity.animation.ModAnimations;
import net.mceq.mceverquest.entity.custom.RatEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

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

		ModelPartData rat = modelPartData.addChild("rat", ModelPartBuilder.create(), ModelTransform.pivot(-19.2F, 16.0F, -2.0F));

		ModelPartData head = rat.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -3.4F, -1.0F, 12.0F, 4.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-4.0F, -5.4F, -1.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-8.0F, 0.6F, -1.0F, 6.0F, 0.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 6).mirrored().cuboid(-8.0F, -3.4F, -1.0F, 0.0F, 4.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 7).cuboid(-2.0F, -3.4F, -1.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(-6, 0).cuboid(-8.0F, -3.4F, -1.0F, 4.0F, 0.0F, 6.0F, new Dilation(0.0F))
				.uv(-6, 0).cuboid(-4.0F, -5.4F, -1.0F, 2.0F, 0.0F, 6.0F, new Dilation(0.0F))
				.uv(-1, 1).cuboid(-2.0F, -5.4F, 1.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-2.0F, -5.4F, -1.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 4).mirrored().cuboid(-4.0F, -5.4F, -1.0F, 0.0F, 2.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 6).cuboid(-2.0F, -5.4F, 1.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-2.0F, -5.4F, 3.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-8.0F, -3.4F, 5.0F, 12.0F, 4.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-4.0F, -5.4F, 5.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-2.0F, -5.4F, 3.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(-2.0F, -3.4F, 3.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-2.0F, 0.6F, 1.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(5.2F, 3.6F, 0.0F));

		ModelPartData body = rat.addChild("body", ModelPartBuilder.create().uv(-6, 0).cuboid(11.2F, -3.8F, -1.0F, 8.0F, 0.0F, 6.0F, new Dilation(0.0F))
				.uv(-2, 0).cuboid(19.2F, -3.8F, 1.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(9.2F, -3.8F, 1.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(13.2F, 6.2F, -1.0F, 6.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(5.2F, -1.8F, -1.0F, 6.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(7.2F, 4.2F, -1.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(9.2F, 2.2F, -1.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(11.2F, 4.2F, -1.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(7.2F, 6.2F, -1.0F, 4.0F, 0.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(11.2F, 6.2F, -1.0F, 6.0F, 0.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(5.2F, 6.2F, 1.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, -6).cuboid(23.2F, 0.2F, -1.0F, 0.0F, 2.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(23.2F, 2.2F, -1.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(23.2F, 2.2F, 3.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(21.2F, 4.2F, -1.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(21.2F, 0.2F, -1.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(21.2F, 0.2F, -1.0F, 2.0F, 0.0F, 6.0F, new Dilation(0.0F))
				.uv(0, -6).cuboid(21.2F, -1.8F, -1.0F, 0.0F, 2.0F, 6.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(21.2F, -3.8F, 1.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(19.2F, -1.8F, -1.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(19.2F, -1.8F, -1.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(2, 0).cuboid(5.2F, -1.8F, -1.0F, 4.0F, 0.0F, 6.0F, new Dilation(0.0F))
				.uv(4, 2).cuboid(9.2F, -1.8F, -1.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(9.2F, -1.8F, 3.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(5.2F, -1.8F, -1.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(19.2F, -3.8F, -1.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(15.2F, -3.8F, -1.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(11.2F, -3.8F, -1.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(11.2F, -3.8F, -1.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(11.2F, 4.2F, 1.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(11.2F, 4.2F, 3.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(5.2F, 4.2F, 1.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(19.2F, -3.8F, 1.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(19.2F, -3.8F, 3.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(9.2F, -3.8F, 1.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(9.2F, -3.8F, 1.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(9.2F, -3.8F, 3.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(13.2F, 6.2F, 5.0F, 6.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(5.2F, -1.8F, 5.0F, 6.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(7.2F, 4.2F, 5.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(9.2F, 2.2F, 5.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(11.2F, -3.8F, 3.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(11.2F, -3.8F, 5.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(11.2F, 4.2F, 3.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(21.2F, 4.2F, 3.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(21.2F, 0.2F, 5.0F, 2.0F, 4.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(15.2F, -3.8F, 5.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(19.2F, -3.8F, 3.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(5.2F, -1.8F, 3.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(19.2F, -1.8F, 3.0F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(19.2F, -1.8F, 5.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData backleftfoot = rat.addChild("backleftfoot", ModelPartBuilder.create().uv(0, 6).cuboid(4.4F, 6.2F, 0.6F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-1.6F, 8.2F, 0.6F, 6.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(4, 0).cuboid(-1.6F, -1.8F, 0.6F, 6.0F, 10.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-3.6F, -1.8F, 0.6F, 2.0F, 6.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(4.4F, 0.2F, 0.6F, 2.0F, 6.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.6F, 0.2F, 0.6F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-1.6F, -3.8F, 0.6F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-1.6F, 4.2F, 0.6F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(6.4F, 4.2F, 0.6F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(6.4F, 2.2F, 0.6F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(2.4F, 6.2F, 0.6F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.6F, 2.2F, 0.6F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.6F, 4.2F, 0.6F, 2.0F, 0.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(6.4F, 0.2F, 0.6F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(4.4F, 0.2F, 0.6F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(4, 0).cuboid(-5.6F, 0.2F, 0.6F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-5.6F, 2.2F, 0.6F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(4, 1).cuboid(-5.6F, 0.2F, 0.6F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(4.4F, -1.8F, 0.6F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(-2, 0).cuboid(0.4F, -1.8F, 0.6F, 4.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(4, 0).cuboid(-3.6F, -1.8F, 0.6F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(4, 1).cuboid(-3.6F, -1.8F, 0.6F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(0.4F, -3.8F, 0.6F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(4, 0).cuboid(-1.6F, -3.8F, 0.6F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(4, 1).cuboid(-1.6F, -3.8F, 0.6F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(14.8F, 0.0F, -3.6F));

		ModelPartData backrightfoot = rat.addChild("backrightfoot", ModelPartBuilder.create().uv(0, 6).cuboid(1.6F, 6.2F, -1.8F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(-2.4F, -3.8F, 0.2F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-0.4F, -3.8F, 0.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-2.4F, -3.8F, 0.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-2.4F, -1.8F, 2.2F, 6.0F, 10.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(3.6F, 0.2F, 2.2F, 2.0F, 6.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-4.4F, -1.8F, 2.2F, 2.0F, 6.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-2.4F, -3.8F, 2.2F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-6.4F, 0.2F, 2.2F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-4.4F, -1.8F, 0.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(-4.4F, -1.8F, 0.2F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(-0.4F, -1.8F, 0.2F, 4.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(3.6F, -1.8F, 0.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-6.4F, 0.2F, 0.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-6.4F, 2.2F, 0.2F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(-6.4F, 0.2F, 0.2F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(5.6F, 0.2F, 0.2F, 0.0F, 6.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(5.6F, 4.2F, -1.8F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(3.6F, 0.2F, 0.2F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-4.4F, 2.2F, 0.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-4.4F, 4.2F, -1.8F, 2.0F, 0.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-2.4F, 4.2F, 0.2F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-2.4F, 8.2F, 0.2F, 6.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(3.6F, 6.2F, 0.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(15.6F, 0.0F, 4.8F));

		ModelPartData rightfoot = rat.addChild("rightfoot", ModelPartBuilder.create().uv(0, 6).cuboid(-3.6F, 3.0F, -0.2F, 6.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(4, 0).cuboid(-3.6F, 1.0F, -0.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(-3.6F, 1.0F, -0.2F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.6F, 1.0F, -0.2F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(2.4F, 1.0F, -0.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-1.6F, 1.0F, -0.2F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-1.6F, -1.0F, -0.2F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-1.6F, -1.0F, 1.8F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-3.6F, 1.0F, 1.8F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-1.6F, -1.0F, -0.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(4.8F, 5.2F, 3.2F));

		ModelPartData leftfoot = rat.addChild("leftfoot", ModelPartBuilder.create().uv(0, 6).cuboid(1.6F, 1.8F, 0.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-4.4F, 3.8F, 0.2F, 6.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 5).cuboid(-2.4F, -0.2F, 0.2F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-2.4F, 1.8F, 2.2F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-2.4F, -0.2F, 2.2F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(3, -1).cuboid(-4.4F, 1.8F, 0.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(-4.4F, 1.8F, 0.2F, 2.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-4.4F, 1.8F, 0.2F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-2.4F, -0.2F, 0.2F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(-4.4F, 1.8F, 2.2F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(5.6F, 4.4F, -1.2F));

		ModelPartData tail = rat.addChild("tail", ModelPartBuilder.create().uv(0, 6).cuboid(-2.8F, 0.6F, 1.0F, 12.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(25.2F, 0.6F, 1.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(9.2F, 2.6F, 1.0F, 16.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(15.2F, 0.6F, 1.0F, 10.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(9.2F, 0.6F, 1.0F, 16.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(1.2F, -1.4F, 1.0F, 14.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(3.2F, -3.4F, 1.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(9.2F, 0.6F, 3.0F, 16.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(1.2F, -1.4F, 3.0F, 14.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(3.2F, -3.4F, 3.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(9.2F, 0.6F, 1.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(15.2F, -1.4F, 1.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(7.2F, -1.4F, 1.0F, 8.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 6).cuboid(7.2F, -3.4F, 1.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(3.2F, -3.4F, 1.0F, 4.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(20.0F, 5.6F, 0.0F));

		return TexturedModelData.of(modelData, 16, 16);
	}

	@Override
	public void setAngles(RatEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.RAT_RUN, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.RAT_IDLE, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -10.0F, 10.0F);
		headPitch = MathHelper.clamp(headPitch, -15.0F, 15.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		rat.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return rat;
	}
}