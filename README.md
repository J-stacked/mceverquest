MC Everquest!

# Modding Guide:

## Software needed:
1. Editor: IntelliJ IDEA Community Edition 2023 (https://www.jetbrains.com/idea/)
   
   +Minecraft Development plugin
2. Blockbench (https://www.blockbench.net/)
   
   +Animation to Java Converter plugin
   
   +Fabric Modded Entity plugin
   
   +Animated Java plugin
3. Online voxelizer (https://drububu.com/miscellaneous/voxelizer/?out=min)
4. EQModelViewer & ZoneConverter (https://github.com/mixxit/eqemu_zonetools/blob/master/EQModel_Viewer_ZoneConverter.zip)
5. LanternExtractor (https://www.lanterneq.com/) (https://github.com/LanternEQ/LanternExtractor/wiki)


## Creating usable mob model
### Step 1: Getting Models from Everquest S3D files
<details>
 <summary> Option 1 - EQModel Viewer </summary>
Use the EQModelViewer to extract models from the Everquest S3D files.
 
- **Load s3d**
 
 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/d6dfb836-c224-4a01-8eb2-7fe6056c4762)

- **Load Model**

![image](https://github.com/J-stacked/mceverquest/assets/146044161/8727be48-bbc7-4f38-bbda-66dd25ceb74b)


- **Load Object**

![image](https://github.com/J-stacked/mceverquest/assets/146044161/9c72b514-29b6-4709-b2ab-a7f3591402ec)

- **Export OBJ**
 
![image](https://github.com/J-stacked/mceverquest/assets/146044161/10beb3a9-6990-441e-90b3-3a5557dbefce)


</details>

<details>
   <summary> Option 2 - LanternEQ </summary>
   
   -  **Edit _settings.txt_** 

   The path to the EverQuest installation will need to be edited.  Also, you will want to change ModelExportFormat to 1 (OBJ).

   - **Run in cmd window**

   Run _./LanternExtractor.exe all_ in the cmd window.  This will take a while.  The exports will be found in the _Exports_ folder once complete.
   
</details>

### Step 2: Voxelizer (or create model from scratch in Blockbench)
<details>
 <summary>Details</summary>
 
- **Open file**
 
![image](https://github.com/J-stacked/mceverquest/assets/146044161/07372262-8df5-4552-bcb7-a5f46d5c2578)

- **Make voxels below 1000 to avoid a Java StackOverflow error**
 
![image](https://github.com/J-stacked/mceverquest/assets/146044161/60bf5f35-8ce4-4cfe-bfde-3e31714a19b3)


- **Save as Minecraft (.json)**
 
![image](https://github.com/J-stacked/mceverquest/assets/146044161/312f80d5-ef0d-452c-bac9-4fcefd64d3a8)

</details>

### Step 3: Blockbench
<details>
 <summary>Details</summary>
 
<details>
 <summary>Importing</summary>

#### Import
- Open .json model in Blockbench

![image](https://github.com/J-stacked/mceverquest/assets/146044161/7627c240-5421-4323-be6b-77e2a6eb92df)


- Convert project (_File > Convert Project_) to "Modded Entity".

![image](https://github.com/J-stacked/mceverquest/assets/146044161/4960e9fe-338e-4988-aec8-a399c371abeb)


> **IMPORTANT**
> 
> Please ensure the project is converted to "Modded Entity".  If not, there will be texturing and animation issues.  Also, in _File > Project..._, ensure the Export Version is set to Fabric 1.17+
> 
> ![image](https://github.com/J-stacked/mceverquest/assets/146044161/b184889d-2e08-43f7-be95-c40eddb30741)

> **IMPORTANT**
> 
> Please ensure the model is facing the -Z direction.  Otherwise, it will not walk facing forward.


</details>

<details>
 <summary>Grouping</summary>
 
#### Grouping
- Group cubes as body parts, creating a hierarchy starting with the mob name as the root, then including each limb as a subfolder.  Include the torso (body) as its own part.  This will help when it comes to animating the newly added mob later.

 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/987c084c-a8ca-4e00-b9de-ea0e2a7819e8)
 
- Add cubes to groups by either individually selecting the voxels or by holding down CTRL and dragging the left mouse button.  Then, right click your selection and add to intended body group.

 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/bdab9e67-eae0-4333-90a7-dbacb1022698)

- Repeat until all cubes are consolidated into groups.
  
> **TIP**
> 
> To help with grouping quickly, toggle the visibility of the groups.  This will prevent the cubes from being selected again, as well as hiding them from view.
>
> ![image](https://github.com/J-stacked/mceverquest/assets/146044161/16f1afd0-affb-49a6-872b-5c26a92ac697)


</details>

<details>
 <summary>Texturing</summary>
 
#### Texturing
- The texture will most likely not be able to be found initially, so go ahead and create a texture, then delete the old one.
  
  ![image](https://github.com/J-stacked/mceverquest/assets/146044161/4d8f709b-1a48-4bdd-9d89-8b70a2257cb0)
  
- Each face of a voxel will have a different highlighted area on the texture.  This highlighted area is what section of the texture will map to the face.

> **TIP**
> Try to fit the texture in as small a dimension as you can manage.  16x16 is ideal, but if the size must be increased then be sure to stick to dimensions that are square and a power of 2 (ex. 8x8, 16x16, 32x32).  This is managed in _File > Project... > Texture Size_.

> **NOTE**
> In the _Edit_ tab, you will be able to adjust the placement of the texture on the faces of the voxel model.  In the _Paint_ tab, you will be able to actually paint the textures either on the texture tab on the left side of the screen or directly on the model.  Try to stick to a limited color palette.

- Once you are done, you should have a layout similar to this (overlook the absolutely phenomenal texturing for now!):

  ![image](https://github.com/J-stacked/mceverquest/assets/146044161/d12e2548-c388-41e1-8b92-045df258b70d)

</details>

</details>

## Creating mob animations

### Blockbench

<details>
 <summary>Getting started</summary>

- In the _Edit_ tab, adjust the pivot points of all limbs to somewhere that makes sense for the limb.  Also, you will want to set the pivot point for the mob overall.  Think of the pivot points as where the joints would be on each limb.

![image](https://github.com/J-stacked/mceverquest/assets/146044161/06494b26-6d41-4b59-a726-65ad0a1cd67c)

> **TIP**
>
> If you are in need of fine tuning for the pivot point, hold down CTRL while you drag the vectors.

- Go to the _Animate_ tab in Blockbench

![image](https://github.com/J-stacked/mceverquest/assets/146044161/a33abb27-c3cc-488d-bb5e-28b18b2651c5)

- Create an animation

![image](https://github.com/J-stacked/mceverquest/assets/146044161/d403ba30-4ccf-48c3-befb-0b7dce638b60)

- Name the animation and choose whether the animation will be a looping animation (ex. walking) or an animation that will play once (ex. looking around or attacking)

![image](https://github.com/J-stacked/mceverquest/assets/146044161/844b49f6-9e08-498e-b233-26bbd4421c85)

- Add a base position for everything you plan to animate with this animation at 0s.  This way, everything will snap back to normal.

![image](https://github.com/J-stacked/mceverquest/assets/146044161/5675e1b0-bd0c-4068-9821-c7023f52353c)

- Add your other positions along the _TIMELINE_

> NOTE
>
> To preview as it would look in Minecraft, hit the three bars in the upper right corner of the viewport, then go to _Preview Scene_, then select the environment you would like to emulate
>
> ![image](https://github.com/J-stacked/mceverquest/assets/146044161/cee60a27-ac1d-4c4f-9962-a9bfa44a6c5f)

- Typically you will want an idle animation, a walking animation, and an attack animation.  More or less can be added as needed.  For example, the rat only has a walking and idle animation, since attacking is done by more or less ramming into the player, which can be handled by the code pretty easily.  This fire elemental will have four animations: walking, idle, melee attack, and fire attack.

</details>

## Files to add/edit in Fabric mod
### Texture
#### add resources/assets/mceverquest/textures/entity/_YourMob_.png
<details>
 <summary>Exporting Texture</summary>
 
- In Blockbench, right click your texture file on the left hand side of the screen and hit _Save As_

> **NOTE**
>
> This texture file should be saved with NO uppercase letters.  If there are upper case letters, you will get a runtime error later on.

![image](https://github.com/J-stacked/mceverquest/assets/146044161/dcfda869-d0c0-4382-99f5-0c7e64c5a40f)

- Save this somewhere convenient for you to access
- Open this project in IntelliJ IDEA
- Drag the file from your file explorer on to _resources>assets>mceverquest>textures>entity_

![image](https://github.com/J-stacked/mceverquest/assets/146044161/99687e4e-39b0-41b0-88f9-da0deaf9a62c)

- Hit the refactor button to add it to the project!

</details>

### Animation
#### edit net/mceq/mceverquest/entity/animation/ModAnimations.java
<details>
 <summary>Exporting Animations</summary>

- In Blockbench, hit _File>Export>Export Animations to Java_.

> IMPORTANT
>
> Use Yarn mappings when saving

![image](https://github.com/J-stacked/mceverquest/assets/146044161/ce3d0ef1-d8b0-42d9-a103-0f7f86a2408d)


- While this project workspace is open in IntelliJ IDEA, open the resulting file from exporting the animations with IntelliJ IDEA but do not refactor the project to include this file.
- Copy all the contents of the newly exported animations text file.
- Make a new code region at the bottom of _net/mceq/mceverquest/entity/animation/ModAnimations.java_

![image](https://github.com/J-stacked/mceverquest/assets/146044161/b18a54b0-d925-41e7-8e64-aea964fbc31b)

- Paste your animation code!
- Close out of the animation text file you had opened, you will not need it anymore.
 
</details>

### Model
#### add net/mceq/mceverquest/entity/client/_YourMob_ Model.java
<details>
 <summary>Exporting Model</summary>

- In Blockbench, hit _File>Export>Export Java Entity_
- Export this somewhere convenient and label it similarly to _FireelementalModel_

![image](https://github.com/J-stacked/mceverquest/assets/146044161/e8dbb323-309e-4a89-843e-793f92d491b8)

</details>
<details>
 <summary>Programming Model</summary>
 
- Open the exported model file in IntelliJ, but do not refactor the project to include it.  We will use this file in a couple of steps.
- Create a new Java class under _net/mceq/mceverquest/entity/client/_ by right clicking the folder and hitting _New>Java Class_.  Name this similarly to _FireelementalModel_
- Create imports as follows:

```java

import net.mceq.mceverquest.entity.animation.ModAnimations;
import net.mceq.mceverquest.entity.custom.FireelementalEntity;  //this does not exist yet, but it will later!
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

```

- Change the class declaration similar to the code below.  It will throw an error until FireelementalEntity is implemented, but we will do that later.  This change of the model class allows us to inherit from already implemented code for _SinglePartEntityModel_ and inherit our not-yet-cerated code for _FireelementalEntity_ (or whatever your mob entity class will be named)

```java

public class FireelementalModel<T extends FireelementalEntity> extends SinglePartEntityModel<T> {

}

```


- Within the public class, add the following code in order to declare each body part.  Be sure to use names that you used in Blockbench for each body part and to declare each of them.

```java

private final ModelPart fireelemental;
private final ModelPart head;
private final ModelPart body;
private final ModelPart leftarm;
private final ModelPart rightarm;
private final ModelPart flame;

```

- Add the following code to create the class constructor, modifying it to cater to your mob's attributes

```java

public FireelementalModel(ModelPart root) {
   this.fireelemental = root.getChild("fireelemental");
   this.head = fireelemental.getChild("head");
   this.body = fireelemental.getChild("body");
   this.rightarm = fireelemental.getChild("rightarm");
   this.leftarm = fireelemental.getChild("leftarm");
   this.flame = fireelemental.getChild("flame");
}

```

- Next, you will add the model itself.  Copy and paste the _public static TexturedModelData getTexturedModelData()_ method from your exported model file into your newly created model file.  It should look similar to the code below.

```java

public static TexturedModelData getTexturedModelData() {
  ModelData modelData = new ModelData();
  ModelPartData modelPartData = modelData.getRoot();
  ModelPartData fireelemental = modelPartData.addChild("fireelemental", ModelPartBuilder.create(), ModelTransform.of(0.0F, 8.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

  //your model data goes here
}

```

- After that, we will implement two required override methods for inheriting _SinglePartEntityModel_
- The first required method will be _setAngles_, similar to what is shown below.  This allows us to set our different animations for our mob.

```java

@Override
public void setAngles(FireelementalEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {  //required
    this.getPart().traverse().forEach(ModelPart::resetTransform);

    this.animateMovement(ModAnimations.FIREELEMENTAL_WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
    this.updateAnimation(entity.idleAnimationState, ModAnimations.FIREELEMENTAL_IDLE, ageInTicks, 1f);
}

```

- The second required method will be _getPart()_.  This is straightforward and will be similar to the code below.

```java

@Override
public ModelPart getPart() {
    return fireelemental;
}

```

- Next, we will implement our renderer.  This is another override function, though not required by our inherited class.  Definitely include it, though!  Otherwise, you may have a bit of trouble rendering...

```java
@Override
public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
    fireelemental.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
}
```

- That's it for the model file!

</details>

### Programming Entity 
#### add net/mceq/mceverquest/entity/custom/_YourMob_ Entity.java
<details>
 <summary>Adding Entity</summary>
 
- Add a new Java class by right clicking _net/mceq/mceverquest/entity/custom/_ and hitting _New>Java Class_.  Name this similarly to _FireelementalEntity_.
- Add at least the following imports for now, though you will probably need to add more depending on the behavior of your mob.

```java

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

```

- In order to have hostile mob behavior, we will make the class inherit HostileEntity.  If you wish to make a non-hostile entity, this will change of course.  However, much of the following code will also change.

```java

public class FireelementalEntity extends HostileEntity

```

- Within the class, we will declare a _public final idleAnimationState_ and a _private int idleAnimationTimeout_.  _idleAnimationState_ will be used both in this file and for what we already programmed in _FireelementalModel_.  We will declare them as follows.

```java

public final AnimationState idleAnimationState = new AnimationState();
private int idleAnimationTimeout = 0;

```

- Next, we will create a default constructor to match one needed from inheriting _HostileEntity_.

```java

public FireelementalEntity(EntityType<? extends HostileEntity> entityType, World world) {
  super(entityType, world);
}

```

- We will now create a method to setup animation states for our idle animation.  It will likely look similar to the method implemented below.

```java

private void setupAnimationStates() {
    if (this.idleAnimationTimeout <= 0) {
        this.idleAnimationTimeout = this.random.nextInt(40) + 80;
        this.idleAnimationState.start(this.age);
    } else {
        --this.idleAnimationTimeout;
    }
}

```

- Next, let's set up some attributes for our mob.  This will be called on mod initialization later.  There are many other attributes that can be addded as well under _EntityAttributes_.

```java

public static DefaultAttributeContainer.Builder createFireelementalAttributes() {
    return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f)
            .add(EntityAttributes.GENERIC_ARMOR, 0.5f)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4);
}

```

- All we have left now are override methods!  Our first will be a method to update the limbs of our mob.  It will look similar to the one shown below.

```java

@Override
protected void updateLimbs(float posDelta) {
    float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
    this.limbAnimator.updateLimbs(f, 0.2f);
}

```

- Our next one will be to setup the animation states on the client side.

```java

@Override
public void tick() {
    super.tick();
    if(this.getWorld().isClient()) {
        setupAnimationStates();
    }
}

```

- Next, we will have to setup our goals.  This is obviously highly dependant on the mob you intend to setup.  Our Fire Elemental will look like the one below.  If you wish to view a complete list of goals, click one of the goals (ex. _MeleeAttackGoal_) with your middle mouse button.  It will open up Minecraft's code for the _MeleeAttackGoal_.  Scroll up in that file until you see the class declaration and move your cursor to where it inherits the _Goal_ class.  Hit CTRL+H on your keyboard to view the _Goal_'s class hierarchy.  It will open up a panel on the right side of your screen and display a complete list of all the goals.

```java

    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.75f, 1));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, BeeEntity.class, true));
    }

```

- Finally, let's add some sounds!  For fun, our Fire Elemental code will look like this for now.

```java

@Nullable
@Override
protected SoundEvent getAmbientSound() {
    return SoundEvents.ENTITY_BLAZE_AMBIENT;
}

@Nullable
@Override
protected SoundEvent getHurtSound(DamageSource source) {
    return SoundEvents.ENTITY_VILLAGER_HURT;
}

@Nullable
@Override
protected SoundEvent getDeathSound() {
    return SoundEvents.ENTITY_VILLAGER_CELEBRATE;
}

```

- That's all for our basic entity class!

</details>

#### add net/mceq/mceverquest/entity/client/_YourMob_ Renderer.java
<details>
 <summary>Adding Renderer</summary>

- Add a new Java class by right clicking _net/mceq/mceverquest/entity/client/_ and hitting _New>Java Class_.  Name this similarly to _FireelementalRenderer_.
- Add the following imports.

```java

import net.mceq.mceverquest.MCEverQuest;
import net.mceq.mceverquest.entity.custom.FireelementalEntity;  //change this accordingly!
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

```

- Let's inherit some stuff!  Change your code accordingly.

```java

public class FireelementalRenderer extends MobEntityRenderer<FireelementalEntity, FireelementalModel<FireelementalEntity>>{
    
}

```

- Inside the class, let's first grab our texture.

```java

private static final Identifier TEXTURE = new Identifier(MCEverQuest.MOD_ID, "textures/entity/fireelementalTexture.png");

```

- Alright, now to make the constructor.  Our Fire Elemental will look like this.  The 0.6f is the size of our shadow.  The ModModelLayers is not implemented yet, but we will get there later.

```java

public FireelementalRenderer(EntityRendererFactory.Context context) {
    super(context, new FireelementalModel<>(context.getPart(ModModelLayers.FIREELEMENTAL)), 0.6f);
}

```

- Next, let's implement a method to allow our texture to be grabbed.

```java

@Override
public Identifier getTexture(FireelementalEntity entity) {
    return TEXTURE;
}

```

- Finally, let's implement our _render_ method.

```java

@Override
public void render(FireelementalEntity mobEntity, float f, float g, MatrixStack matrixStack,
                   VertexConsumerProvider vertexConsumerProvider, int i) {

    super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
}

```

- We are now done with this class!  All easy work from here on out.

</details>

#### edit net/mceq/mceverquest/entity/ModEntities.java
<details>
 <summary>Adding Entity to list of Entities</summary>

- Open _net/mceq/mceverquest/entity/ModEntities.java_.
- Add _import net.mceq.mceverquest.entity.custom.FireelementalEntity;_ to your import list at the top (change the name, of course!)
- Add the following code within the class _ModEntities_:

```java

public static final EntityType<FireelementalEntity> FIREELEMENTAL = Registry.register(Registries.ENTITY_TYPE,
        new Identifier(MCEverQuest.MOD_ID, "fireelemental"),
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FireelementalEntity::new)
                .dimensions(EntityDimensions.fixed(1f, 2f)).build());

```

- Of course, change this to match your created mob.  The _SpawnGroup_ code determines in what group your monster will spawn.  In this case, we want a _MONSTER_.  EntityDimensions determine the width and height, respectively, of your mob.
 
</details>

#### edit net/mceq/mceverquest/entity/client/ModModelLayers.java
<details>
 <summary>Adding Model Texture layer</summary>

- Open _net/mceq/mceverquest/entity/client/ModModelLayers.java_.
- At the end of the class _ModModelLayers_, add the following code (adjusted to suit your mob):

```java

public static final EntityModelLayer FIREELEMENTAL =
        new EntityModelLayer(new Identifier(MCEverQuest.MOD_ID, "fireelemental"), "main");

```
 
</details>

#### edit net/mceq/mceverquest/MCEverQuest.java
<details>
 <summary>Initializing Mob Properties</summary>

- Open _net/mceq/mceverquest/MCEverQuest.java_.  Within the _onInitialize_ method of the _MCEverQuest_ class, add the following code adjusted to suit your mob:

```java

FabricDefaultAttributeRegistry.register(ModEntities.FIREELEMENTAL, FireelementalEntity.createFireelementalAttributes());

```
 
</details>

#### edit net/mceq/mceverquest/MCEverQuestClient.java
<details>
 <summary>Initializing Mob for Client</summary>

- Open _net/mceq/mceverquest/MCEverQuestClient.java_.  Within the _onInitializeClient_ method of the _MCEverQuestClient_ class, add the following code adjusted to suit your mob:

```java

EntityRendererRegistry.register(ModEntities.FIREELEMENTAL, FireelementalRenderer::new);
EntityModelLayerRegistry.registerModelLayer(ModModelLayers.FIREELEMENTAL, FireelementalModel::getTexturedModelData);

```
 
</details>

#### Special considerations for the fire elemental

- Here are some Fire Elemental specifics that I added.  They may be useful to reference to get added functionality, though I recommend looking at the default Minecraft mob code to get a true feel for it.

<details>
 <summary> Adding particles and burn sound </summary>

 - Added some flame particles around the fire elemental entity, as well as random burn sound effects.
 - This code is within the FireelementalEntity class

```java

@Override  //adds particles and ambient sound
public void tickMovement() {
    if (this.getWorld().isClient) {
        if (this.random.nextInt(24) == 0 && !this.isSilent()) {
            this.getWorld().playSound(this.getX() + 0.5, this.getY() + 0.5, this.getZ() + 0.5,
                    SoundEvents.ENTITY_BLAZE_BURN, this.getSoundCategory(), 0.3f + this.random.nextFloat(),
                    this.random.nextFloat() * 0.7f + 0.3f, false);
        }
        for (int i = 0; i < 2; ++i) {
            this.getWorld().addParticle(ParticleTypes.FLAME, this.getParticleX(0.2), this.getRandomBodyY(),
                    this.getParticleZ(0.2), 0.0, 0.0, 0.0);
        }
    }
    super.tickMovement();
}

```

</details>

<details>
 <summary> Adding a custom goal </summary>

- I added a custom attack goal for the fire elemental.  It will chase you and shoot fireballs at you if it can't reach you.

- This is the extra code in the FireelementalModel class.

```java

public void setAngles(FireelementalEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    ...

    this.updateAnimation(entity.attackAnimationState, ModAnimations.FIREELEMENTAL_MELEEATTACK, ageInTicks, 1f);
    this.updateAnimation(entity.fireAttackAnimationState, ModAnimations.FIREELEMENTAL_FIREATTACK, ageInTicks, 1f);
}

```

- This is the extra code within the FireelementalEntity class

```java

//new declarations
public final AnimationState attackAnimationState = new AnimationState();
public final AnimationState fireAttackAnimationState = new AnimationState();
private int attackAnimationTimeout = 0;
private int fireAttackAnimationTimeout = 0;
private static final TrackedData<Byte> FIREELEMENTAL_FLAGS = DataTracker.registerData(FireelementalEntity.class, TrackedDataHandlerRegistry.BYTE);

```

```java

//new animation states
private void setupAnimationStates() {
    if (this.idleAnimationTimeout <= 0) {
        this.idleAnimationTimeout = this.random.nextInt(40) + 80;
        this.idleAnimationState.start(this.age);
    } else {
        --this.idleAnimationTimeout;
    }

    if(this.isAttacking() && this.attackAnimationTimeout <= 0){
        this.attackAnimationState.start(this.age);
        this.attackAnimationTimeout = 25;
    }else{
        --this.attackAnimationTimeout;
    }

    if(this.isFireActive() && this.fireAttackAnimationTimeout <= 0){
        this.fireAttackAnimationState.start(this.age);
        this.fireAttackAnimationTimeout = 60;
    }else if (this.isFireActive()){
        --this.fireAttackAnimationTimeout;
    }
}

```

```java

//This tracked flag is for the fire effect when the fire elemental is about to shoot fireballs
@Override
protected void initDataTracker() {
    super.initDataTracker();
    this.dataTracker.startTracking(FIREELEMENTAL_FLAGS, (byte)0);
}

```

```java

//adds flame particles and ambient sound
@Override  
public void tickMovement() {
    if (this.getWorld().isClient) {
        if (this.random.nextInt(24) == 0 && !this.isSilent()) {
            this.getWorld().playSound(this.getX() + 0.5, this.getY() + 0.5, this.getZ() + 0.5,
                    SoundEvents.ENTITY_BLAZE_BURN, this.getSoundCategory(), 0.3f + this.random.nextFloat(),
                    this.random.nextFloat() * 0.7f + 0.3f, false);
        }
        for (int i = 0; i < 2; ++i) {
            this.getWorld().addParticle(ParticleTypes.FLAME, this.getParticleX(0.2), this.getRandomBodyY(),
                    this.getParticleZ(0.2), 0.0, 0.0, 0.0);
        }
    }
    super.tickMovement();
}

```

```java

//these methods manage the fire effect on the blaze
@Override
public boolean isOnFire() {
    return this.isFireActive();
}

private boolean isFireActive() {
    return (this.dataTracker.get(FIREELEMENTAL_FLAGS) & 1) != 0;
}

void setFireActive(boolean fireActive) {
    byte b = this.dataTracker.get(FIREELEMENTAL_FLAGS);
    b = fireActive ? (byte)(b | 1) : (byte)(b & 0xFFFFFFFE);
    this.dataTracker.set(FIREELEMENTAL_FLAGS, b);
}

```

```java

//our new goals
@Override
protected void initGoals() {
    this.goalSelector.add(1, new FireelementalAttackGoal(this));  //NEW!  Our new custom goal
    this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.75f, 1));
    this.goalSelector.add(3, new LookAroundGoal(this));

    this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge());  //NEW!  This adds a revenge goal if another mob hits the fire elemental.
    this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    this.targetSelector.add(3, new ActiveTargetGoal<>(this, BeeEntity.class, true));
}

```

```java

//and finally, our new goal!

static class FireelementalAttackGoal extends Goal {
     private final FireelementalEntity fireelemental;
     private int fireballsFired;
     private int fireballCooldown;
     private int targetNotVisibleTicks;
     private Path path;

     public FireelementalAttackGoal(FireelementalEntity fireelemental) {
         this.fireelemental = fireelemental;
         this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
     }

     @Override
     public boolean canStart() {
         LivingEntity livingEntity = this.fireelemental.getTarget();
         return livingEntity != null && livingEntity.isAlive() && this.fireelemental.canTarget(livingEntity);
     }

     @Override
     public void start() {
         this.fireballsFired = 0;
     }

     @Override
     public void stop() {
         this.fireelemental.setFireActive(false);
         this.targetNotVisibleTicks = 0;
     }

     @Override
     public boolean shouldRunEveryTick() {
         return true;
     }

     @Override
     public void tick() {
         --this.fireballCooldown;
         LivingEntity livingEntity = this.fireelemental.getTarget();
         if (livingEntity == null) {
             return;
         }
         boolean bl = this.fireelemental.getVisibilityCache().canSee(livingEntity);
         this.targetNotVisibleTicks = bl ? 0 : ++this.targetNotVisibleTicks;
         double d = this.fireelemental.squaredDistanceTo(livingEntity);

         if(fireballCooldown > 0){
             if(d<1 && this.fireelemental.attackAnimationTimeout <=0) {
                 this.fireelemental.tryAttack(livingEntity);
                 this.fireelemental.setAttacking(true);
             }else if(d<144){
                 this.path = this.fireelemental.getNavigation().findPathTo(livingEntity, 0);
                 this.fireelemental.getNavigation().startMovingAlong(this.path, 1.3D);
                 this.fireelemental.setAttacking(false);
             }else{
                 this.fireelemental.setAttacking(false);
             }
             return;
         }
         this.fireelemental.setAttacking(false);

         if (d < 4.0) {
             if (!bl) {
                 return;
             }
             if (this.fireballCooldown <= 0) {
                 this.fireballCooldown = 80;
             }
         } else if (d < this.getFollowRange() * this.getFollowRange() && bl) {
             double e = livingEntity.getX() - this.fireelemental.getX();
             double f = livingEntity.getBodyY(0.5) - this.fireelemental.getBodyY(0.5);
             double g = livingEntity.getZ() - this.fireelemental.getZ();
             if (this.fireballCooldown <= 0) {
                 ++this.fireballsFired;
                 if (this.fireballsFired == 1) {
                     this.fireballCooldown = 60;
                     this.fireelemental.setFireActive(true);
                 } else if (this.fireballsFired <= 4) {
                     this.fireballCooldown = 6;
                 } else {
                     this.fireballCooldown = 100;
                     this.fireballsFired = 0;
                     this.fireelemental.setFireActive(false);
                 }
                 if (this.fireballsFired > 1) {
                     double h = Math.sqrt(Math.sqrt(d)) * 0.5;
                     if (!this.fireelemental.isSilent()) {
                         this.fireelemental.getWorld().syncWorldEvent(null, WorldEvents.BLAZE_SHOOTS, this.fireelemental.getBlockPos(), 0);
                     }
                     for (int i = 0; i < 1; ++i) {
                         SmallFireballEntity smallFireballEntity = new SmallFireballEntity(this.fireelemental.getWorld(), this.fireelemental, this.fireelemental.getRandom().nextTriangular(e, 2.297 * h), f, this.fireelemental.getRandom().nextTriangular(g, 2.297 * h));
                         smallFireballEntity.setPosition(smallFireballEntity.getX(), this.fireelemental.getBodyY(0.5) + 0.5, smallFireballEntity.getZ());
                         this.fireelemental.getWorld().spawnEntity(smallFireballEntity);
                     }
                 }
             }
             this.fireelemental.getLookControl().lookAt(livingEntity, 10.0f, 10.0f);
         } else if (this.targetNotVisibleTicks < 5) {
             this.fireelemental.getMoveControl().moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 1.0);
         }
         super.tick();
     }

     private double getFollowRange() {
         return this.fireelemental.getAttributeValue(EntityAttributes.GENERIC_FOLLOW_RANGE);
     }
 }


```
 
</details>

<details>
 <summary> Adding special traits </summary>

 - I wanted to make the fire elemental immune to fire and make it hurt by water, so I added the following to the FireelementalEntity class.

```java

@Override
public boolean hurtByWater() {
    return true;
}

@Override
public boolean isFireImmune() {
    return true;
}

```
 
</details>

## Using Gradle
### Generating Minecraft source code

<details>
<summary> genSources </summary>
   
- Before we can run our project or utilize Minecraft methods, we will need to generate the Minecraft source code.  This is done by using Fabric's _genSources_ Gradle task.

![image](https://github.com/J-stacked/mceverquest/assets/146044161/b1a26e6c-c190-4143-8a4c-687c7c71c2e7)

- This will take a little bit, so be patient!

</details>

### Cleaning

<details>
<summary> clean </summary>

- Sometimes you may need to clean the project before building.  This is done by running the _clean_ task under the build list.

![image](https://github.com/J-stacked/mceverquest/assets/146044161/fc117567-f6c1-4473-9769-38b6f0991183)

</details>

### Building

<details>
<summary> build </summary>

- To build your project, use the _build_ task.

![image](https://github.com/J-stacked/mceverquest/assets/146044161/c6e7feb1-feeb-4604-9c4d-809a5316382c)

</details>

### Running

<details>
<summary> runClient </summary>

- To run the Minecraft client with our mod, use the Fabric _runClient_ task. 

![image](https://github.com/J-stacked/mceverquest/assets/146044161/35812681-56be-4626-bf9d-ad71f066e13b)

</details>




