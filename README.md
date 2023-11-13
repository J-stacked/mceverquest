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
Use the EQModelViewer to extract models from the Everquest S3D files.
- Load s3d

 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/df868a62-6725-4a59-abcd-d3675aa9a138)
 
- Load Model

 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/ee3d5c33-8aae-4fab-b146-6b4067002850)
 
- Load Object

 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/f1c31e6d-f4ec-4d74-a3c0-8016c1259f8e)
 
- Export OBJ

 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/e91cad75-4d45-4dd3-af8d-4bcec8520606)


### Step 2: Voxelizer (or create model from scratch in Blockbench)
- Open file

 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/29a695c0-0471-4e96-8455-9865fdf65366)
 
- Make voxels below 1000 to avoid a Java StackOverflow error

 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/d91280c1-eb76-465a-afed-07498a76199e)
 
- Save as Minecraft (.json)

 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/e605ad02-3463-4eb2-a1af-6863a9d54ef5)


### Step 3: Blockbench
#### Import
- Open .json model in Blockbench

 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/591d3115-00c2-404e-879a-d1c3c3868d53)

- Convert project (_File > Convert Project_) to "Modded Entity".

  ![image](https://github.com/J-stacked/mceverquest/assets/146044161/981ac7f9-c170-447b-93c5-6b5fd78a5c41)

> [!IMPORTANT]
> Please ensure the project is converted to "Modded Entity".  If not, there will be texturing and animation issues.  Also, in _File > Project..._, ensure the Export Version is set to Fabric 1.17+
> 
> ![image](https://github.com/J-stacked/mceverquest/assets/146044161/dab24515-2250-4ff5-b21b-afc90eda6411)


#### Grouping
- Group cubes as body parts, creating a hierarchy starting with the mob name as the root, then including each limb as a subfolder.  Include the torso (body) as its own part.  This will help when it comes to animating the newly added mob later.

 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/45d7a616-6e43-484e-b693-709735c8862f)
 
- Add cubes to groups by either individually selecting the voxels or by holding down CTRL and dragging the left mouse button.  Then, right click your selection and add to intended body group.

 ![image](https://github.com/J-stacked/mceverquest/assets/146044161/5d86fe59-4ca2-4801-9aa0-42ad5688e486)
 
- Repeat until all cubes are consolidated into groups.
  
> [!NOTE]
> To help with grouping quickly, toggle the visibility of the groups.  This will prevent the cubes from being selected again, as well as hiding them from view.
>
> ![image](https://github.com/J-stacked/mceverquest/assets/146044161/0f8b3f36-77db-40a1-bcf5-774bc590b84c)

#### Texturing
- The texture will most likely not be able to be found initially, so go ahead and create a texture, then delete the old one.
  
  ![image](https://github.com/J-stacked/mceverquest/assets/146044161/897fd461-30b0-454e-878b-0ca78e8dc43a)
  
- Each face of a voxel will have a different highlighted area on the texture.  This highlighted area is what section of the texture will map to the face.

> [!NOTE]
> Try to fit the texture in as small a dimension as you can manage.  16x16 is ideal, but if the size must be increased then be sure to stick to dimensions that are square and a power of 2 (ex. 8x8, 16x16, 32x32).  This is managed in _File > Project... > Texture Size_.

> [!NOTE]
> In the _Edit_ tab, you will be able to adjust the placement of the texture on the faces of the voxel model.  In the _Paint_ tab, you will be able to actually paint the textures either on the texture tab on the left side of the screen or directly on the model.  Try to stick to a limited color palette.



head needs to face -Z


## Creating mob animations

### Blockbench

## Files to add/edit in Fabric mod
### Texture
#### add resources/assets/mceverquest/textures/entity/_YourMob_.png

### Code
#### add net/mceq/mceverquest/entity/client/_YourMob_ Model.java

#### add net/mceq/mceverquest/entity/custom/_YourMob_ Entity.java

#### add net/mceq/mceverquest/entity/client/_YourMob_ Renderer.java

#### edit net/mceq/mceverquest/entity/animation/ModAnimations.java

#### edit net/mceq/mceverquest/entity/ModEntities.java

#### edit net/mceq/mceverquest/entity/client/ModModelLayers.java

#### edit net/mceq/mceverquest/MCEverQuest.java

#### edit net/mceq/mceverquest/MCEverQuestClient.java

