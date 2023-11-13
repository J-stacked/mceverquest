MC Everquest!
 


# Modding Guide:

## Software needed:
1. Editor: IntelliJ IDEA Community Edition 2023 (https://www.jetbrains.com/idea/)
   
   -Minecraft Development plugin
2. Blockbench (https://www.blockbench.net/)
   
   -Animation to Java Converter plugin
   
   -Fabric Modded Entity plugin
   
   -Animated Java plugin
3. Online voxelizer (https://drububu.com/miscellaneous/voxelizer/?out=min)
4. EQModelViewer & ZoneConverter (https://github.com/mixxit/eqemu_zonetools/blob/master/EQModel_Viewer_ZoneConverter.zip)


## Creating usable mob model
### EQModelViewer

### Voxelizer

### Blockbench



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

