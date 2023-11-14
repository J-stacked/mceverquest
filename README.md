MC Everquest!
 
## Issues:
- Z-fighting on models
- Death message names of entities need fixed

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


## Creating usable mob model
### Step 1: EQModelViewer (skip this step if you already have an .obj of what you want to add)
<details>
 <summary>Details</summary>
Use the EQModelViewer to extract models from the Everquest S3D files.
 
- **Load s3d**
 
 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/df868a62-6725-4a59-abcd-d3675aa9a138)

- **Load Model**

 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/ee3d5c33-8aae-4fab-b146-6b4067002850)

- **Load Object**

 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/f1c31e6d-f4ec-4d74-a3c0-8016c1259f8e)

- **Export OBJ**
 
 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/e91cad75-4d45-4dd3-af8d-4bcec8520606)

</details>

### Step 2: Voxelizer (or create model from scratch in Blockbench)
<details>
 <summary>Details</summary>
 
- **Open file**
 
 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/29a695c0-0471-4e96-8455-9865fdf65366)


- **Make voxels below 1000 to avoid a Java StackOverflow error**
 
 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/d91280c1-eb76-465a-afed-07498a76199e)


- **Save as Minecraft (.json)**
 
 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/e605ad02-3463-4eb2-a1af-6863a9d54ef5)

</details>

### Step 3: Blockbench
<details>
 <summary>Details</summary>
 
<details>
 <summary>Importing</summary>

#### Import
- Open .json model in Blockbench

 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/591d3115-00c2-404e-879a-d1c3c3868d53)

- Convert project (_File > Convert Project_) to "Modded Entity".

  ![image](https://github.com/J-stacked/mceverquest/assets/146044161/981ac7f9-c170-447b-93c5-6b5fd78a5c41)


> **IMPORTANT**
> 
> Please ensure the project is converted to "Modded Entity".  If not, there will be texturing and animation issues.  Also, in _File > Project..._, ensure the Export Version is set to Fabric 1.17+
> 
> ![image](https://github.com/J-stacked/mceverquest/assets/146044161/dab24515-2250-4ff5-b21b-afc90eda6411)

> **IMPORTANT**
> 
> Please ensure the model is facing the -Z direction.  Otherwise, it will not walk facing forward.


</details>

<details>
 <summary>Grouping</summary>
 
#### Grouping
- Group cubes as body parts, creating a hierarchy starting with the mob name as the root, then including each limb as a subfolder.  Include the torso (body) as its own part.  This will help when it comes to animating the newly added mob later.

 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/45d7a616-6e43-484e-b693-709735c8862f)
 
- Add cubes to groups by either individually selecting the voxels or by holding down CTRL and dragging the left mouse button.  Then, right click your selection and add to intended body group.

 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/5d86fe59-4ca2-4801-9aa0-42ad5688e486)
 
- Repeat until all cubes are consolidated into groups.
  
> **TIP**
> 
> To help with grouping quickly, toggle the visibility of the groups.  This will prevent the cubes from being selected again, as well as hiding them from view.
>
> ![image](https://github.com/J-stacked/mceverquest/assets/146044161/0f8b3f36-77db-40a1-bcf5-774bc590b84c)

</details>

<details>
 <summary>Texturing</summary>
 
#### Texturing
- The texture will most likely not be able to be found initially, so go ahead and create a texture, then delete the old one.
  
  ![image](https://github.com/J-stacked/mceverquest/assets/146044161/897fd461-30b0-454e-878b-0ca78e8dc43a)
  
- Each face of a voxel will have a different highlighted area on the texture.  This highlighted area is what section of the texture will map to the face.

> **TIP**
> Try to fit the texture in as small a dimension as you can manage.  16x16 is ideal, but if the size must be increased then be sure to stick to dimensions that are square and a power of 2 (ex. 8x8, 16x16, 32x32).  This is managed in _File > Project... > Texture Size_.

> **NOTE**
> In the _Edit_ tab, you will be able to adjust the placement of the texture on the faces of the voxel model.  In the _Paint_ tab, you will be able to actually paint the textures either on the texture tab on the left side of the screen or directly on the model.  Try to stick to a limited color palette.

- Once you are done, you should have a layout similar to this (overlook the absolutely phenomenal texturing for now!):

  ![image](https://github.com/J-stacked/mceverquest/assets/146044161/b785a58e-b67b-4587-82f7-7cb4886284a3)

</details>

</details>

## Creating mob animations

### Blockbench

<details>
 <summary>Getting started</summary>

- In the _Edit_ tab, adjust the pivot points of all limbs to somewhere that makes sense for the limb.  Also, you will want to set the pivot point for the mob overall.  Think of the pivot points as where the joints would be on each limb.

![image](https://github.com/J-stacked/mceverquest/assets/146044161/2cfce010-d3fa-4cdd-b5ab-bd9deb71c179)

> **TIP**
>
> If you are in need of fine tuning for the pivot point, hold down CTRL while you drag the vectors.

- Go to the _Animate_ tab in Blockbench

![image](https://github.com/J-stacked/mceverquest/assets/146044161/e97305c1-cafb-43fc-9b6c-5752621e1397)

- Create an animation

![image](https://github.com/J-stacked/mceverquest/assets/146044161/797e29a1-dfcd-40d0-8077-d40dbe09d6fb)

- Name the animation and choose whether the animation will be a looping animation (ex. walking) or an animation that will play once (ex. looking around or attacking)

![image](https://github.com/J-stacked/mceverquest/assets/146044161/36d9fdf1-a7e1-4cb4-a347-29b8c0b50e35)

- Add a base position for everything you plan to animate with this animation at 0s.  This way, everything will snap back to normal.

![image](https://github.com/J-stacked/mceverquest/assets/146044161/20a2c67d-362b-4b75-962b-71b62498e147)

- Add your other positions along the _TIMELINE_

> NOTE
>
> To preview as it would look in Minecraft, hit the three bars in the upper right corner of the viewport, then go to _Preview Scene_, then select the environment you would like to emulate
>
> ![image](https://github.com/J-stacked/mceverquest/assets/146044161/5fffd414-524d-4a10-be49-1a05a6150285)

- Typically you will want an idle animation, a walking animation, and an attack animation.  More or less can be added as needed.  For example, the rat only has a walking and idle animation, since attacking is done by more or less ramming into the player, which can be handled by the code pretty easily.  This fire elemental will have four animations: walking, idle, melee attack, and fire attack.

</details>

## Files to add/edit in Fabric mod
### Texture
#### add resources/assets/mceverquest/textures/entity/_YourMob_.png
<details>
 <summary>Exporting Texture</summary>
 
- In Blockbench, right click your texture file on the left hand side of the screen and hit _Save As_

![image](https://github.com/J-stacked/mceverquest/assets/146044161/4074f438-a1d5-42b3-b10d-fa039542b836)

- Save this somewhere convenient for you to access
- Open this project in IntelliJ IDEA
- Drag the file from your file explorer on to _resources>assets>mceverquest>textures>entity_

![image](https://github.com/J-stacked/mceverquest/assets/146044161/0967d19b-54bd-4062-bf04-8dc9285ab590)

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

![image](https://github.com/J-stacked/mceverquest/assets/146044161/6dc11778-c510-41c9-abe0-46ab2c2d4bc8)

- While this project workspace is open in IntelliJ IDEA, open the resulting file from exporting the animations with IntelliJ IDEA but do not refactor the project to include this file.
- Copy all the contents of the newly exported animations text file.
- Make a new code region at the bottom of _net/mceq/mceverquest/entity/animation/ModAnimations.java_

![image](https://github.com/J-stacked/mceverquest/assets/146044161/2d2a5eec-ddbe-4b69-bf47-270f2efd5af2)

- Paste your animation code!
- Close out of the animation text file you had opened, you will not need it anymore.
 
</details>

### Model
#### add net/mceq/mceverquest/entity/client/_YourMob_ Model.java
<details>
 <summary>Exporting Model</summary>

- In Blockbench, hit _File>Export>Export Java Entity_
- Export this somewhere convenient and label it similarly to _FireelementalModel_

![image](https://github.com/J-stacked/mceverquest/assets/146044161/06e3d1b2-0bcd-4d0e-b060-19c3ff377933)

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
public void setAngles(RatEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {  //required
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

</details>

### Programming Entity 
#### add net/mceq/mceverquest/entity/custom/_YourMob_ Entity.java
<details>
 <summary>Adding Entity</summary>

 
</details>

#### add net/mceq/mceverquest/entity/client/_YourMob_ Renderer.java
<details>
 <summary>Adding Renderer</summary>

 
</details>

#### edit net/mceq/mceverquest/entity/ModEntities.java
<details>
 <summary>Adding Entity to list of Entities</summary>

 
</details>

#### edit net/mceq/mceverquest/entity/client/ModModelLayers.java
<details>
 <summary>Adding Model Texture layer</summary>

 
</details>

#### edit net/mceq/mceverquest/MCEverQuest.java
<details>
 <summary>Initializing Mob Properties</summary>

 
</details>

#### edit net/mceq/mceverquest/MCEverQuestClient.java
<details>
 <summary>Initializing Mob for Client</summary>

 
</details>

