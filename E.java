package net.tonicarter.tntexpansion;

import java.util.ArrayList;
import net.tonicarter.tonitnt.api.Category;
import net.tonicarter.tonitnt.api.Fx;
import net.tonicarter.tonitnt.api.Pal;
import net.tonicarter.tonitnt.api.Replace;
import net.tonicarter.tonitnt.api.Shape;
import net.tonicarter.tonitnt.api.Spec;
import net.tonicarter.tonitnt.api.TntPack;
import net.tonicarter.tonitnt.api.Tnts;
import net.tonicarter.tonitnt.api.Fx.Build;

public final class TntExpansionPack implements TntPack {
   private static final String RED_WOOL = "minecraft:red_wool";
   private static final String[] WOOLS = new String[]{
      "minecraft:red_wool",
      "minecraft:orange_wool",
      "minecraft:yellow_wool",
      "minecraft:lime_wool",
      "minecraft:light_blue_wool",
      "minecraft:blue_wool",
      "minecraft:purple_wool",
      "minecraft:magenta_wool"
   };
   private static final double PLANE_SPAN = 100.0;
   private static final int PLANE_TICKS = 134;
   private static final int MINUS_INFINITY = 1000000000;

   public String namespace() {
      return "tntexpansion";
   }

   public void define(Tnts var1) {
      var1.icon(Category.FAMILY_FRIENDLY, "mini_tnt")
         .icon(Category.INDUSTRIAL, "tnt_x20")
         .icon(Category.HEAVY_ORDNANCE, "tsar_bomb_tnt")
         .icon(Category.WORLD_BUSTER, "the_last_tnt")
         .fallback("tnt_x5");
      var1.add("tnt_x5", "TNT x5", 80, Fx.mega(12), Category.FAMILY_FRIENDLY, 2);
      var1.add("tnt_x10", "TNT x10", 80, Fx.mega(18), Category.INDUSTRIAL, 3);
      var1.add("tnt_x20", "TNT x20", 80, Fx.mega(24), Category.INDUSTRIAL, 5);
      var1.add("tnt_x50", "TNT x50", 80, Fx.mega(32), Category.HEAVY_ORDNANCE, 8);
      var1.add("tnt_x100", "TNT x100", 90, Fx.mega(42), Category.HEAVY_ORDNANCE, 11);
      var1.add("tnt_x250", "TNT x250", 90, Fx.mega(54), Category.HEAVY_ORDNANCE, 17);
      var1.add("tnt_x500", "TNT x500", 100, Fx.mega(68), Category.HEAVY_ORDNANCE, 23);
      var1.add("tnt_x1000", "TNT x1000", 100, Fx.mega(84), Category.HEAVY_ORDNANCE, 32);
      var1.add("tnt_x5000", "TNT x5000", 120, Fx.mega(112), Category.HEAVY_ORDNANCE, 49);
      var1.add("tnt_x10000", "TNT x10000", 140, Fx.mega(142), Category.HEAVY_ORDNANCE, 71);
      var1.add("mini_tnt", "Mini TNT", 60, Fx.vanilla(2.0F, false), Category.FAMILY_FRIENDLY, 1);
      var1.add("giant_tnt", "Giant TNT", 100, Fx.all(new Fx[]{Fx.mega(16), Fx.chain("tnt_x20", 14, 10.0, 20, 60)}), Category.HEAVY_ORDNANCE, 71);
      var1.add(
         "massive_tnt",
         "Massive TNT",
         120,
         Fx.all(new Fx[]{Fx.mega(28), Fx.chain("tnt_x100", 18, 20.0, 25, 90), Fx.delay(60, Fx.chain("tnt_x50", 12, 30.0, 10, 40))}),
         Category.HEAVY_ORDNANCE,
         301
      );
      var1.add("cluster_tnt", "Cluster TNT", 90, Fx.all(new Fx[]{Fx.mega(10), Fx.rain("tnt_x10", 20, 26.0, 40.0, 20, 60)}), Category.HEAVY_ORDNANCE, 52);
      var1.add("carpet_bomb_tnt", "Carpet Bomb TNT", 100, Fx.rain("tnt_x20", 40, 55.0, 60.0, 30, 120), Category.HEAVY_ORDNANCE, 157);
      var1.add("tnt_rain", "TNT Rain", 110, Fx.repeat(8, 20, Fx.rain("tnt_x10", 12, 40.0, 70.0, 20, 70)), Category.HEAVY_ORDNANCE, 244);
      var1.add("nuclear_tnt", "Nuclear TNT", 120, Fx.nuke(70, 120), Category.HEAVY_ORDNANCE, 62);
      var1.add("atomic_tnt", "Atomic TNT", 120, Fx.nuke(100, 150), Category.HEAVY_ORDNANCE, 93);
      var1.add("hydrogen_tnt", "Hydrogen TNT", 130, Fx.nuke(125, 180), Category.HEAVY_ORDNANCE, 126);
      var1.add(
         "tsar_bomb_tnt",
         "Tsar Bomb TNT",
         160,
         Fx.all(new Fx[]{Fx.nuke(175, 300), Fx.storm(true, 6000), Fx.delay(40, Fx.lightning(30, 90.0))}),
         Category.HEAVY_ORDNANCE,
         246
      );
      var1.add(
         "biohazard_tnt",
         "BioHazard TNT",
         110,
         Fx.all(
            new Fx[]{Fx.mega(55), Fx.fallout(55, 180), Fx.effectArea("minecraft:poison", 2, 900, 60.0), Fx.effectArea("tntexpansion:radiation", 1, 1200, 60.0)}
         ),
         Category.HEAVY_ORDNANCE,
         17
      );
      var1.add(
         "plague_tnt",
         "Plague TNT",
         100,
         Fx.all(
            new Fx[]{
               Fx.mega(30),
               Fx.effectArea("minecraft:poison", 3, 1200, 40.0),
               Fx.effectArea("minecraft:weakness", 2, 1200, 40.0),
               Fx.mobs("minecraft:zombie", 20, 20.0)
            }
         ),
         Category.HEAVY_ORDNANCE,
         7
      );
      var1.add("meteor_tnt", "Meteor TNT", 100, Fx.meteorStorm(7, 24.0, 14), Category.INDUSTRIAL, 3);
      var1.add("comet_tnt", "Comet TNT", 100, Fx.cometStorm(7, 24.0, 14), Category.INDUSTRIAL, 3);
      var1.add("meteor_storm_tnt", "Meteor Storm TNT", 120, Fx.repeat(6, 30, Fx.meteorStorm(6, 45.0, 12)), Category.HEAVY_ORDNANCE, 25);
      var1.add("asteroid_tnt", "Asteroid TNT", 120, Fx.all(new Fx[]{Fx.meteorStorm(3, 8.0, 30), Fx.delay(30, Fx.mega(40, 0.15F))}), Category.HEAVY_ORDNANCE, 11);
      var1.add("lava_tnt", "Lava TNT", 80, Fx.terraform(20, Shape.SPHERE, Pal.bowl("minecraft:lava"), 0.25F), Category.FAMILY_FRIENDLY, 2);
      var1.add("water_tnt", "Water TNT", 80, Fx.terraform(22, Shape.SPHERE, Pal.bowl("minecraft:water")), Category.FAMILY_FRIENDLY, 2);
      var1.add(
         "ice_tnt",
         "Ice TNT",
         80,
         Fx.all(new Fx[]{Fx.mega(12), Fx.terraform(20, Shape.SPHERE, Pal.ICE), Fx.effectArea("minecraft:slowness", 3, 400, 24.0)}),
         Category.INDUSTRIAL,
         3
      );
      var1.add("snow_tnt", "Snow TNT", 80, Fx.terraform(28, Shape.DOME, Pal.SNOW), Category.INDUSTRIAL, 2);
      var1.add(
         "blizzard_tnt",
         "Blizzard TNT",
         100,
         Fx.all(new Fx[]{Fx.cometStorm(10, 40.0, 8), Fx.terraform(40, Shape.PANCAKE, Pal.SNOW), Fx.effectArea("minecraft:slowness", 4, 900, 45.0)}),
         Category.HEAVY_ORDNANCE,
         10
      );
      var1.add("fire_tnt", "Fire TNT", 80, Fx.mega(18, 0.55F), Category.INDUSTRIAL, 3);
      var1.add("napalm_tnt", "Napalm TNT", 90, Fx.all(new Fx[]{Fx.mega(24, 0.75F), Fx.scatter(8, 24.0, Fx.mega(6, 0.9F))}), Category.HEAVY_ORDNANCE, 8);
      var1.add(
         "hellfire_tnt",
         "Hellfire TNT",
         120,
         Fx.all(
            new Fx[]{
               Fx.terraform(30, Shape.CRATER, Pal.bowl("minecraft:lava"), 0.6F),
               Fx.coat(38, Pal.SCORCHED),
               Fx.flyingMobs("minecraft:ghast", 6, 26.0, 14.0),
               Fx.meteorStorm(8, 34.0, 10)
            }
         ),
         Category.INDUSTRIAL,
         3
      );
      var1.add("magma_tnt", "Magma TNT", 90, Fx.all(new Fx[]{Fx.mega(22, 0.3F), Fx.terraform(24, Shape.CRATER, Pal.VOLCANO)}), Category.HEAVY_ORDNANCE, 6);
      var1.add(
         "acid_tnt",
         "Acid TNT",
         80,
         Fx.all(
            new Fx[]{Fx.mega(22), Fx.effectArea("minecraft:poison", 2, 600, 26.0), Fx.terraform(18, Shape.CRATER, Pal.sparse("minecraft:slime_block", 0.15F))}
         ),
         Category.INDUSTRIAL,
         4
      );
      var1.add("lightning_tnt", "Lightning TNT", 80, Fx.all(new Fx[]{Fx.mega(10), Fx.lightning(20, 22.0)}), Category.INDUSTRIAL, 3);
      var1.add("thunder_tnt", "Thunder TNT", 90, Fx.all(new Fx[]{Fx.mega(18), Fx.lightning(45, 45.0), Fx.storm(true, 4000)}), Category.HEAVY_ORDNANCE, 7);
      var1.add(
         "storm_tnt",
         "Storm TNT",
         110,
         Fx.all(new Fx[]{Fx.mega(24), Fx.storm(true, 8000), Fx.repeat(10, 20, Fx.lightning(8, 60.0))}),
         Category.HEAVY_ORDNANCE,
         11
      );
      var1.add("tornado_tnt", "Tornado TNT", 100, Fx.tornado(14, 500), Category.FAMILY_FRIENDLY, 1);
      var1.add("earthquake_tnt", "Earthquake TNT", 100, Fx.all(new Fx[]{Fx.earthquake(26, 400), Fx.collapse(30, 400, 0.15)}), Category.INDUSTRIAL, 3);
      var1.add("tsunami_tnt", "Tsunami TNT", 110, Fx.tsunami(44, 500), Category.HEAVY_ORDNANCE, 6);
      var1.add("volcano_tnt", "Volcano TNT", 120, Fx.volcano(26, 700), Category.INDUSTRIAL, 3);
      var1.add(
         "sandstorm_tnt",
         "Sandstorm TNT",
         100,
         Fx.all(new Fx[]{Fx.earthquake(30, 300), Fx.terraform(34, Shape.PANCAKE, Pal.DESERT), Fx.effectArea("minecraft:blindness", 0, 400, 40.0)}),
         Category.HEAVY_ORDNANCE,
         7
      );
      var1.add("creeper_tnt", "Creeper TNT", 80, Fx.all(new Fx[]{Fx.mega(8), Fx.mobs("minecraft:creeper", 24, 14.0)}), Category.FAMILY_FRIENDLY, 1);
      var1.add(
         "slime_tnt",
         "Slime TNT",
         80,
         Fx.all(new Fx[]{Fx.terraform(16, Shape.CRATER, Pal.SLIME), Fx.mobs("minecraft:slime", 18, 12.0)}),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add("ghast_tnt", "Ghast TNT", 90, Fx.all(new Fx[]{Fx.mega(12), Fx.flyingMobs("minecraft:ghast", 8, 24.0, 16.0)}), Category.FAMILY_FRIENDLY, 2);
      var1.add("blaze_tnt", "Blaze TNT", 80, Fx.all(new Fx[]{Fx.mega(14, 0.4F), Fx.mobs("minecraft:blaze", 18, 14.0)}), Category.INDUSTRIAL, 2);
      var1.add(
         "wither_tnt",
         "Wither TNT",
         120,
         Fx.all(new Fx[]{Fx.mega(30), Fx.effectArea("minecraft:wither", 2, 900, 34.0), Fx.mobs("minecraft:wither_skeleton", 12, 16.0)}),
         Category.HEAVY_ORDNANCE,
         7
      );
      var1.add(
         "dragon_tnt",
         "Dragon TNT",
         120,
         Fx.all(
            new Fx[]{
               Fx.mega(36),
               Fx.effectArea("minecraft:instant_damage", 1, 1, 40.0),
               Fx.scatter(10, 30.0, Fx.effectArea("minecraft:wither", 1, 400, 10.0)),
               Fx.coat(34, Pal.SCORCHED)
            }
         ),
         Category.HEAVY_ORDNANCE,
         9
      );
      var1.add("zombie_tnt", "Zombie TNT", 80, Fx.all(new Fx[]{Fx.mega(8), Fx.mobs("minecraft:zombie", 30, 16.0)}), Category.FAMILY_FRIENDLY, 1);
      var1.add("skeleton_tnt", "Skeleton TNT", 80, Fx.all(new Fx[]{Fx.mega(8), Fx.mobs("minecraft:skeleton", 30, 16.0)}), Category.FAMILY_FRIENDLY, 1);
      var1.add(
         "spider_tnt",
         "Spider TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.mega(8),
               Fx.mobs("minecraft:spider", 18, 14.0),
               Fx.mobs("minecraft:cave_spider", 12, 14.0),
               Fx.terraform(16, Shape.SPHERE, Pal.sparse("minecraft:cobweb", 0.08F))
            }
         ),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "raid_tnt",
         "Raid TNT",
         110,
         Fx.all(
            new Fx[]{
               Fx.mega(12),
               Fx.mobs("minecraft:pillager", 12, 18.0),
               Fx.mobs("minecraft:vindicator", 8, 18.0),
               Fx.mobs("minecraft:evoker", 3, 14.0),
               Fx.mobs("minecraft:ravager", 2, 12.0)
            }
         ),
         Category.FAMILY_FRIENDLY,
         2
      );
      var1.add(
         "mob_tnt",
         "Mob TNT",
         100,
         Fx.all(
            new Fx[]{
               Fx.mega(10),
               Fx.mobs("minecraft:zombie", 12, 16.0),
               Fx.mobs("minecraft:skeleton", 12, 16.0),
               Fx.mobs("minecraft:creeper", 12, 16.0),
               Fx.mobs("minecraft:spider", 10, 16.0),
               Fx.mobs("minecraft:enderman", 6, 16.0)
            }
         ),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "warden_tnt",
         "Warden TNT",
         140,
         Fx.all(new Fx[]{Fx.mega(26), Fx.mobs("minecraft:warden", 2, 8.0), Fx.effectArea("minecraft:darkness", 0, 1200, 40.0)}),
         Category.INDUSTRIAL,
         6
      );
      var1.add(
         "piglin_tnt",
         "Piglin TNT",
         90,
         Fx.all(new Fx[]{Fx.mega(10, 0.2F), Fx.mobs("minecraft:piglin_brute", 8, 14.0), Fx.mobs("minecraft:hoglin", 6, 14.0)}),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "guardian_tnt",
         "Guardian TNT",
         100,
         Fx.all(new Fx[]{Fx.terraform(22, Shape.SPHERE, Pal.bowl("minecraft:water")), Fx.mobs("minecraft:guardian", 14, 14.0)}),
         Category.FAMILY_FRIENDLY,
         2
      );
      var1.add("phantom_tnt", "Phantom TNT", 90, Fx.all(new Fx[]{Fx.mega(10), Fx.flyingMobs("minecraft:phantom", 16, 24.0, 18.0)}), Category.FAMILY_FRIENDLY, 1);
      var1.add(
         "shulker_tnt",
         "Shulker TNT",
         100,
         Fx.all(new Fx[]{Fx.mega(12), Fx.mobs("minecraft:shulker", 14, 16.0), Fx.fling(20.0, 1.2, true)}),
         Category.FAMILY_FRIENDLY,
         2
      );
      var1.add(
         "bee_tnt",
         "Bee TNT",
         80,
         Fx.all(new Fx[]{Fx.mega(6), Fx.flyingMobs("minecraft:bee", 40, 18.0, 3.0), Fx.terraform(14, Shape.SPHERE, Pal.sparse("minecraft:honey_block", 0.2F))}),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "farm_tnt",
         "Farm TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.mega(5),
               Fx.mobs("minecraft:cow", 10, 12.0),
               Fx.mobs("minecraft:pig", 10, 12.0),
               Fx.mobs("minecraft:chicken", 14, 12.0),
               Fx.mobs("minecraft:sheep", 10, 12.0)
            }
         ),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "villager_tnt",
         "Villager TNT",
         90,
         Fx.all(new Fx[]{Fx.mega(5), Fx.mobs("minecraft:villager", 16, 14.0), Fx.mobs("minecraft:iron_golem", 3, 10.0)}),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add("gravity_tnt", "Gravity TNT", 90, Fx.all(new Fx[]{Fx.fling(34.0, 2.4, false), Fx.collapse(34, 600, 0.05), Fx.mega(12)}), Category.INDUSTRIAL, 2);
      var1.add(
         "anti_gravity_tnt",
         "Anti-Gravity TNT",
         90,
         Fx.all(new Fx[]{Fx.fling(34.0, 2.6, true), Fx.collapse(30, 500, 1.1), Fx.mega(10)}),
         Category.INDUSTRIAL,
         2
      );
      var1.add("void_tnt", "Void TNT", 110, Fx.all(new Fx[]{Fx.terraform(16, Shape.SHAFT, Pal.DELETE), Fx.mega(14)}), Category.INDUSTRIAL, 3);
      var1.add("black_hole_tnt", "Black Hole TNT", 140, Fx.blackHole(34, 240, 56), Category.HEAVY_ORDNANCE, 24);
      var1.add(
         "time_tnt",
         "Time TNT",
         100,
         Fx.all(
            new Fx[]{Fx.mega(20), Fx.setTime(18000L), Fx.effectArea("minecraft:slowness", 5, 600, 30.0), Fx.effectArea("minecraft:blindness", 0, 300, 30.0)}
         ),
         Category.INDUSTRIAL,
         4
      );
      var1.add("space_tnt", "Space TNT", 110, Fx.all(new Fx[]{Fx.fling(40.0, 3.4, true), Fx.mega(18), Fx.delay(80, Fx.mega(40))}), Category.HEAVY_ORDNANCE, 14);
      var1.add(
         "dimension_tnt",
         "Dimension TNT",
         120,
         Fx.all(new Fx[]{Fx.terraform(34, Shape.SPHERE, Pal.DIMENSIONAL), Fx.scatter(3, 20.0, Fx.build(Build.PORTAL, 0)), Fx.teleport(30.0, 80.0)}),
         Category.INDUSTRIAL,
         4
      );
      var1.add("nether_tnt", "Nether TNT", 100, Fx.terraform(30, Shape.SPHERE, Pal.NETHER, 0.15F), Category.INDUSTRIAL, 2);
      var1.add("end_tnt", "End TNT", 100, Fx.terraform(30, Shape.SPHERE, Pal.END), Category.INDUSTRIAL, 2);
      var1.add("overworld_tnt", "Overworld TNT", 100, Fx.terraform(32, Shape.SPHERE, Pal.OVERWORLD), Category.INDUSTRIAL, 3);
      var1.add("portal_tnt", "Portal TNT", 90, Fx.all(new Fx[]{Fx.mega(8), Fx.scatter(6, 18.0, Fx.build(Build.PORTAL, 0))}), Category.INDUSTRIAL, 2);
      var1.add("teleport_tnt", "Teleport TNT", 80, Fx.all(new Fx[]{Fx.mega(6), Fx.teleport(30.0, 140.0)}), Category.FAMILY_FRIENDLY, 1);
      var1.add(
         "ender_tnt", "Ender TNT", 100, Fx.all(new Fx[]{Fx.mega(18), Fx.mobs("minecraft:enderman", 16, 18.0), Fx.teleport(24.0, 60.0)}), Category.INDUSTRIAL, 3
      );
      var1.add("chunk_tnt", "Chunk TNT", 120, Fx.all(new Fx[]{Fx.chunkWipe(1), Fx.fling(40.0, 1.6, true)}), Category.INDUSTRIAL, 3);
      var1.add("mountain_tnt", "Mountain TNT", 110, Fx.grow(46, Shape.CONE, Pal.MOUNTAIN), Category.INDUSTRIAL, 4);
      var1.add("village_tnt", "Village TNT", 110, Fx.build(Build.VILLAGE, 8), Category.FAMILY_FRIENDLY, 1);
      var1.add("house_tnt", "House TNT", 90, Fx.build(Build.HOUSE, 0), Category.FAMILY_FRIENDLY, 1);
      var1.add("city_tnt", "City TNT", 130, Fx.build(Build.CITY, 2), Category.FAMILY_FRIENDLY, 1);
      var1.add("castle_tnt", "Castle TNT", 120, Fx.build(Build.CASTLE, 12), Category.FAMILY_FRIENDLY, 1);
      var1.add("island_tnt", "Island TNT", 110, Fx.build(Build.ISLAND, 16), Category.FAMILY_FRIENDLY, 1);
      var1.add("ocean_tnt", "Ocean TNT", 110, Fx.terraform(42, Shape.CRATER, Pal.OCEAN), Category.INDUSTRIAL, 4);
      var1.add("desert_tnt", "Desert TNT", 100, Fx.terraform(40, Shape.PANCAKE, Pal.DESERT), Category.INDUSTRIAL, 3);
      var1.add("jungle_tnt", "Jungle TNT", 100, Fx.terraform(36, Shape.PANCAKE, Pal.JUNGLE), Category.INDUSTRIAL, 3);
      var1.add(
         "forest_tnt",
         "Forest TNT",
         100,
         Fx.all(new Fx[]{Fx.terraform(30, Shape.PANCAKE, Pal.OVERWORLD), Fx.grow(26, Shape.DOME, Pal.sparse("minecraft:oak_leaves", 0.06F))}),
         Category.INDUSTRIAL,
         5
      );
      var1.add(
         "swamp_tnt",
         "Swamp TNT",
         100,
         Fx.all(new Fx[]{Fx.terraform(30, Shape.CRATER, Pal.bowl("minecraft:water")), Fx.grow(24, Shape.DOME, Pal.sparse("minecraft:lily_pad", 0.05F))}),
         Category.INDUSTRIAL,
         4
      );
      var1.add(
         "mushroom_tnt",
         "Mushroom TNT",
         90,
         Fx.all(
            new Fx[]{
               Fx.terraform(26, Shape.PANCAKE, Pal.layered("minecraft:mycelium", "minecraft:dirt", "minecraft:stone")),
               Fx.grow(22, Shape.DOME, Pal.sparse("minecraft:red_mushroom_block", 0.04F))
            }
         ),
         Category.INDUSTRIAL,
         4
      );
      var1.add(
         "flower_tnt",
         "Flower TNT",
         80,
         Fx.all(new Fx[]{Fx.terraform(24, Shape.PANCAKE, Pal.OVERWORLD), Fx.grow(22, Shape.DOME, Pal.sparse("minecraft:poppy", 0.1F))}),
         Category.INDUSTRIAL,
         4
      );
      var1.add(
         "biome_tnt",
         "Biome TNT",
         110,
         Fx.oneOf(
            new Fx[]{
               Fx.terraform(34, Shape.PANCAKE, Pal.DESERT),
               Fx.terraform(34, Shape.PANCAKE, Pal.JUNGLE),
               Fx.terraform(34, Shape.PANCAKE, Pal.SNOW),
               Fx.terraform(34, Shape.PANCAKE, Pal.NETHER),
               Fx.terraform(34, Shape.PANCAKE, Pal.END),
               Fx.terraform(34, Shape.CRATER, Pal.OCEAN)
            }
         ),
         Category.INDUSTRIAL,
         3
      );
      var1.add(
         "world_tnt",
         "World TNT",
         140,
         Fx.all(new Fx[]{Fx.terraform(120, Shape.SPHERE, Pal.OVERWORLD), Fx.delay(60, Fx.mega(70))}),
         Category.HEAVY_ORDNANCE,
         37
      );
      var1.add("drill_tnt", "Drill TNT", 80, Fx.terraform(4, Shape.SHAFT, Pal.AIR), Category.FAMILY_FRIENDLY, 1);
      var1.add("quarry_tnt", "Quarry TNT", 110, Fx.terraform(14, Shape.SHAFT, Pal.AIR), Category.FAMILY_FRIENDLY, 1);
      var1.add("flatten_tnt", "Flatten TNT", 100, Fx.terraform(40, Shape.PANCAKE, Pal.AIR), Category.INDUSTRIAL, 3);
      var1.add("excavator_tnt", "Excavator TNT", 100, Fx.terraform(22, Shape.CUBE, Pal.AIR), Category.FAMILY_FRIENDLY, 2);
      var1.add("hollow_tnt", "Hollow TNT", 90, Fx.terraform(26, Shape.RING, Pal.AIR), Category.INDUSTRIAL, 2);
      var1.add("gold_tnt", "Gold TNT", 90, Fx.terraform(20, Shape.SPHERE, Pal.of("minecraft:gold_block")), Category.FAMILY_FRIENDLY, 2);
      var1.add("diamond_tnt", "Diamond TNT", 100, Fx.terraform(20, Shape.SPHERE, Pal.of("minecraft:diamond_block")), Category.FAMILY_FRIENDLY, 2);
      var1.add("emerald_tnt", "Emerald TNT", 100, Fx.terraform(20, Shape.SPHERE, Pal.of("minecraft:emerald_block")), Category.FAMILY_FRIENDLY, 2);
      var1.add("iron_tnt", "Iron TNT", 90, Fx.terraform(20, Shape.SPHERE, Pal.of("minecraft:iron_block")), Category.FAMILY_FRIENDLY, 2);
      var1.add(
         "redstone_tnt",
         "Redstone TNT",
         80,
         Fx.all(new Fx[]{Fx.mega(16), Fx.terraform(18, Shape.CRATER, Pal.of("minecraft:redstone_block"))}),
         Category.INDUSTRIAL,
         4
      );
      var1.add("obsidian_tnt", "Obsidian TNT", 110, Fx.terraform(22, Shape.SPHERE, Pal.of("minecraft:obsidian")), Category.FAMILY_FRIENDLY, 2);
      var1.add("bedrock_tnt", "Bedrock TNT", 130, Fx.terraform(10, Shape.RING, Pal.of("minecraft:bedrock")), Category.FAMILY_FRIENDLY, 1);
      var1.add("glass_tnt", "Glass TNT", 90, Fx.terraform(24, Shape.SPHERE, Pal.of("minecraft:glass")), Category.FAMILY_FRIENDLY, 2);
      var1.add("amethyst_tnt", "Amethyst TNT", 90, Fx.terraform(20, Shape.SPHERE, Pal.of("minecraft:amethyst_block")), Category.FAMILY_FRIENDLY, 2);
      var1.add(
         "honey_tnt",
         "Honey TNT",
         80,
         Fx.all(new Fx[]{Fx.mega(8), Fx.terraform(18, Shape.CRATER, Pal.of("minecraft:honey_block")), Fx.effectArea("minecraft:slowness", 2, 400, 20.0)}),
         Category.INDUSTRIAL,
         2
      );
      var1.add("xp_tnt", "XP TNT", 80, Fx.all(new Fx[]{Fx.mega(8), Fx.xpOrbs(60, 30, 18.0)}), Category.FAMILY_FRIENDLY, 1);
      var1.add(
         "firework_tnt", "Firework TNT", 80, Fx.all(new Fx[]{Fx.mega(6), Fx.scatter(30, 24.0, Fx.mega(2)), Fx.lightning(6, 20.0)}), Category.INDUSTRIAL, 3
      );
      var1.add(
         "supernova_tnt",
         "Supernova TNT",
         140,
         Fx.all(new Fx[]{Fx.mega(130, 0.2F), Fx.lightning(40, 120.0), Fx.mushroomCloud(), Fx.delay(50, Fx.mega(90))}),
         Category.HEAVY_ORDNANCE,
         100
      );
      var1.add(
         "galaxy_tnt",
         "Galaxy TNT",
         150,
         Fx.all(new Fx[]{Fx.mega(60), Fx.scatter(5, 60.0, Fx.blackHole(20, 160, 30)), Fx.delay(120, Fx.mega(80))}),
         Category.HEAVY_ORDNANCE,
         88
      );
      var1.add("planet_tnt", "Planet TNT", 130, Fx.all(new Fx[]{Fx.grow(44, Shape.DOME, Pal.MOUNTAIN), Fx.delay(60, Fx.mega(12))}), Category.HEAVY_ORDNANCE, 6);
      var1.add(
         "solar_tnt",
         "Solar TNT",
         130,
         Fx.all(new Fx[]{Fx.mega(80, 0.6F), Fx.setTime(6000L), Fx.storm(false, 1), Fx.scatter(12, 70.0, Fx.mega(12, 0.8F))}),
         Category.HEAVY_ORDNANCE,
         43
      );
      var1.add(
         "moon_tnt",
         "Moon TNT",
         120,
         Fx.all(
            new Fx[]{
               Fx.terraform(46, Shape.CRATER, Pal.layered("minecraft:gray_concrete_powder", "minecraft:tuff", "minecraft:deepslate")),
               Fx.setTime(18000L),
               Fx.delay(40, Fx.mega(28))
            }
         ),
         Category.HEAVY_ORDNANCE,
         11
      );
      var1.add(
         "apocalypse_tnt",
         "Apocalypse TNT",
         160,
         Fx.all(
            new Fx[]{
               Fx.mega(100, 0.3F), Fx.meteorStorm(14, 90.0, 14), Fx.storm(true, 12000), Fx.mobs("minecraft:zombie", 40, 60.0), Fx.delay(60, Fx.nuke(80, 240))
            }
         ),
         Category.WORLD_BUSTER,
         61
      );
      var1.add(
         "doomsday_tnt",
         "Doomsday TNT",
         160,
         Fx.all(
            new Fx[]{
               Fx.mega(120), Fx.repeat(6, 40, Fx.meteorStorm(8, 100.0, 14)), Fx.storm(true, 24000), Fx.effectArea("tntexpansion:radiation", 2, 2400, 120.0)
            }
         ),
         Category.WORLD_BUSTER,
         125
      );
      var1.add(
         "armageddon_tnt",
         "Armageddon TNT",
         170,
         Fx.all(new Fx[]{Fx.nuke(150, 300), Fx.delay(80, Fx.meteorStorm(20, 130.0, 18)), Fx.delay(160, Fx.mega(150))}),
         Category.WORLD_BUSTER,
         338
      );
      var1.add(
         "cataclysm_tnt",
         "Cataclysm TNT",
         170,
         Fx.all(new Fx[]{Fx.volcano(34, 800), Fx.earthquake(50, 600), Fx.tsunami(70, 700), Fx.delay(120, Fx.mega(110))}),
         Category.HEAVY_ORDNANCE,
         69
      );
      var1.add(
         "extinction_tnt",
         "Extinction TNT",
         170,
         Fx.all(
            new Fx[]{
               Fx.mega(140),
               Fx.effectArea("tntexpansion:radiation", 3, 3600, 150.0),
               Fx.effectArea("minecraft:wither", 3, 1200, 150.0),
               Fx.delay(60, Fx.nuke(120, 400))
            }
         ),
         Category.WORLD_BUSTER,
         69
      );
      var1.add(
         "world_destroyer_tnt",
         "World Destroyer TNT",
         180,
         Fx.all(new Fx[]{Fx.mega(175), Fx.delay(60, Fx.chunkWipe(6)), Fx.storm(true, 24000)}),
         Category.WORLD_BUSTER,
         111
      );
      var1.add(
         "planet_destroyer_tnt",
         "Planet Destroyer TNT",
         180,
         Fx.all(new Fx[]{Fx.mega(185), Fx.delay(40, Fx.chunkWipe(8)), Fx.delay(120, Fx.meteorStorm(24, 150.0, 20))}),
         Category.WORLD_BUSTER,
         173
      );
      var1.add(
         "dimension_destroyer_tnt",
         "Dimension Destroyer TNT",
         180,
         Fx.all(
            new Fx[]{
               Fx.terraform(150, Shape.SPHERE, Pal.DIMENSIONAL),
               Fx.delay(40, Fx.mega(110)),
               Fx.teleport(120.0, 400.0),
               Fx.delay(100, Fx.blackHole(60, 200, 90))
            }
         ),
         Category.WORLD_BUSTER,
         91
      );
      var1.add(
         "reality_breaker_tnt",
         "Reality Breaker TNT",
         190,
         Fx.all(
            new Fx[]{
               Fx.terraform(170, Shape.SPHERE, Pal.DIMENSIONAL),
               Fx.delay(50, Fx.mega(120)),
               Fx.repeat(8, 30, Fx.teleport(150.0, 300.0)),
               Fx.delay(150, Fx.blackHole(80, 240, 120))
            }
         ),
         Category.WORLD_BUSTER,
         112
      );
      var1.add(
         "end_of_the_world_tnt",
         "The End of the World TNT",
         200,
         Fx.all(new Fx[]{Fx.nuke(180, 600), Fx.delay(100, Fx.chunkWipe(10)), Fx.storm(true, 48000), Fx.repeat(10, 40, Fx.meteorStorm(10, 160.0, 16))}),
         Category.WORLD_BUSTER,
         757
      );
      var1.add(
         "end_of_everything_tnt",
         "The End of Everything TNT",
         220,
         Fx.all(
            new Fx[]{
               Fx.mega(190),
               Fx.delay(60, Fx.chunkWipe(12)),
               Fx.delay(140, Fx.blackHole(100, 300, 190)),
               Fx.effectArea("tntexpansion:radiation", 4, 6000, 200.0)
            }
         ),
         Category.WORLD_BUSTER,
         189
      );
      var1.add("ultimate_tnt", "Ultimate TNT", 180, Fx.all(new Fx[]{Fx.mega(190, 0.1F), Fx.mushroomCloud()}), Category.WORLD_BUSTER, 109);
      var1.add(
         "infinity_tnt", "Infinity TNT", 190, Fx.all(new Fx[]{Fx.mega(180), Fx.repeat(12, 25, Fx.scatter(4, 120.0, Fx.mega(30)))}), Category.WORLD_BUSTER, 298
      );
      var1.add(
         "god_tnt",
         "God TNT",
         200,
         Fx.all(new Fx[]{Fx.mega(190), Fx.setTime(6000L), Fx.storm(false, 1), Fx.lightning(60, 150.0), Fx.delay(60, Fx.nuke(160, 600))}),
         Category.WORLD_BUSTER,
         608
      );
      var1.add(
         "chaos_tnt",
         "Chaos TNT",
         140,
         Fx.oneOf(
            new Fx[]{
               Fx.mega(90),
               Fx.nuke(80, 180),
               Fx.meteorStorm(16, 80.0, 16),
               Fx.tornado(20, 600),
               Fx.volcano(30, 700),
               Fx.blackHole(40, 200, 70),
               Fx.tsunami(60, 600),
               Fx.chunkWipe(4),
               Fx.terraform(60, Shape.SPHERE, Pal.DIMENSIONAL),
               Fx.rain("tnt_x100", 20, 60.0, 60.0, 20, 80)
            }
         ),
         Category.HEAVY_ORDNANCE,
         38
      );
      var1.add(
         "annihilation_tnt",
         "Annihilation TNT",
         180,
         Fx.all(new Fx[]{Fx.mega(170), Fx.delay(50, Fx.terraform(140, Shape.SPHERE, Pal.DELETE))}),
         Category.WORLD_BUSTER,
         108
      );
      var1.add(
         "oblivion_tnt",
         "Oblivion TNT",
         180,
         Fx.all(new Fx[]{Fx.terraform(60, Shape.SHAFT, Pal.DELETE), Fx.mega(120), Fx.delay(80, Fx.blackHole(70, 220, 110))}),
         Category.WORLD_BUSTER,
         91
      );
      var1.add(
         "final_tnt", "Final TNT", 190, Fx.all(new Fx[]{Fx.nuke(170, 400), Fx.delay(90, Fx.mega(170)), Fx.storm(true, 24000)}), Category.WORLD_BUSTER, 413
      );
      var1.add(
         "the_last_tnt",
         "The Last TNT",
         220,
         Fx.all(
            new Fx[]{Fx.mega(190), Fx.delay(60, Fx.chunkWipe(14)), Fx.delay(160, Fx.nuke(190, 900)), Fx.effectArea("tntexpansion:radiation", 4, 12000, 220.0)}
         ),
         Category.WORLD_BUSTER,
         990
      );
      var1.add("coal_tnt", "Coal TNT", 90, Fx.terraform(20, Shape.SPHERE, Pal.of("minecraft:coal_block")), Category.FAMILY_FRIENDLY, 2);
      var1.add("lapis_tnt", "Lapis TNT", 90, Fx.terraform(20, Shape.SPHERE, Pal.of("minecraft:lapis_block")), Category.FAMILY_FRIENDLY, 2);
      var1.add("quartz_tnt", "Quartz TNT", 90, Fx.terraform(20, Shape.SPHERE, Pal.of("minecraft:quartz_block")), Category.FAMILY_FRIENDLY, 2);
      var1.add("netherite_tnt", "Netherite TNT", 120, Fx.terraform(16, Shape.SPHERE, Pal.of("minecraft:netherite_block")), Category.FAMILY_FRIENDLY, 3);
      var1.add(
         "rainbow_tnt",
         "Rainbow TNT",
         90,
         Fx.terraform(
            22,
            Shape.SPHERE,
            Pal.mix(
               new String[]{
                  "minecraft:red_wool",
                  "minecraft:orange_wool",
                  "minecraft:yellow_wool",
                  "minecraft:lime_wool",
                  "minecraft:light_blue_wool",
                  "minecraft:blue_wool",
                  "minecraft:purple_wool",
                  "minecraft:magenta_wool"
               }
            )
         ),
         Category.FAMILY_FRIENDLY,
         2
      );
      var1.add(
         "coral_tnt",
         "Coral TNT",
         100,
         Fx.all(
            new Fx[]{
               Fx.mega(10),
               Fx.terraform(
                  22,
                  Shape.SPHERE,
                  Pal.mix(
                     new String[]{
                        "minecraft:tube_coral_block",
                        "minecraft:brain_coral_block",
                        "minecraft:bubble_coral_block",
                        "minecraft:fire_coral_block",
                        "minecraft:horn_coral_block",
                        "minecraft:sea_lantern"
                     }
                  )
               )
            }
         ),
         Category.FAMILY_FRIENDLY,
         2
      );
      var1.add(
         "sponge_tnt", "Sponge TNT", 80, Fx.blast(Spec.of(32).palette(Pal.DRAIN).replace(Replace.ANY).ragged(0.0F).knockback(0.0)), Category.FAMILY_FRIENDLY, 1
      );
      var1.add(
         "glowstone_tnt",
         "Glowstone TNT",
         80,
         Fx.blast(Spec.of(28).palette(Pal.sparse("minecraft:glowstone", 0.03F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0)),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "smoke_tnt",
         "Smoke Bomb TNT",
         60,
         Fx.all(
            new Fx[]{
               Fx.vanilla(0.5F, false),
               Fx.effectArea("minecraft:blindness", 0, 300, 20.0),
               Fx.effectArea("minecraft:slowness", 1, 300, 20.0),
               Fx.effectArea("minecraft:weakness", 0, 300, 20.0)
            }
         ),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "healing_tnt",
         "Healing TNT",
         60,
         Fx.all(
            new Fx[]{
               Fx.vanilla(0.5F, false),
               Fx.delay(2, Fx.effectArea("minecraft:instant_health", 1, 1, 16.0)),
               Fx.effectArea("minecraft:regeneration", 1, 400, 16.0)
            }
         ),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "halloween_tnt",
         "Halloween TNT",
         100,
         Fx.all(
            new Fx[]{
               Fx.mega(8),
               Fx.blast(Spec.of(18).palette(Pal.sparse("minecraft:jack_o_lantern", 0.04F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.setTime(18000L),
               Fx.mobs("minecraft:zombie", 8, 16.0),
               Fx.mobs("minecraft:skeleton", 8, 16.0),
               Fx.mobs("minecraft:witch", 3, 14.0)
            }
         ),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "witch_tnt",
         "Witch TNT",
         90,
         Fx.all(
            new Fx[]{
               Fx.mega(8),
               Fx.mobs("minecraft:witch", 10, 16.0),
               Fx.effectArea("minecraft:poison", 1, 400, 22.0),
               Fx.effectArea("minecraft:weakness", 1, 600, 22.0)
            }
         ),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "silverfish_tnt",
         "Silverfish TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.mega(10),
               Fx.mobs("minecraft:silverfish", 30, 14.0),
               Fx.blast(Spec.of(16).palette(Pal.sparse("minecraft:infested_stone", 0.15F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent())
            }
         ),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add("vex_tnt", "Vex TNT", 90, Fx.all(new Fx[]{Fx.mega(8), Fx.flyingMobs("minecraft:vex", 16, 18.0, 6.0)}), Category.FAMILY_FRIENDLY, 1);
      var1.add(
         "pet_tnt",
         "Pet TNT",
         80,
         Fx.all(new Fx[]{Fx.mega(4), Fx.mobs("minecraft:wolf", 8, 12.0), Fx.mobs("minecraft:cat", 8, 12.0), Fx.flyingMobs("minecraft:parrot", 6, 12.0, 3.0)}),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "soul_tnt",
         "Soul TNT",
         110,
         Fx.all(
            new Fx[]{
               Fx.mega(16),
               Fx.terraform(30, Shape.CRATER, Pal.layered("minecraft:soul_soil", "minecraft:soul_sand", "minecraft:basalt")),
               Fx.effectArea("minecraft:wither", 0, 200, 26.0)
            }
         ),
         Category.INDUSTRIAL,
         3
      );
      var1.add("starfall_tnt", "Starfall TNT", 100, Fx.all(new Fx[]{Fx.setTime(18000L), Fx.repeat(6, 30, Fx.cometStorm(4, 45.0, 6))}), Category.INDUSTRIAL, 5);
      var1.add(
         "firenado_tnt",
         "Firenado TNT",
         90,
         Fx.all(new Fx[]{Fx.tornado(16, 500), Fx.mega(10, 0.6F), Fx.repeat(5, 40, Fx.scatter(3, 18.0, Fx.mega(4, 0.9F)))}),
         Category.INDUSTRIAL,
         4
      );
      var1.add(
         "hurricane_tnt",
         "Hurricane TNT",
         120,
         Fx.all(new Fx[]{Fx.storm(true, 8000), Fx.scatter(3, 26.0, Fx.tornado(14, 600)), Fx.repeat(10, 25, Fx.lightning(4, 50.0))}),
         Category.HEAVY_ORDNANCE,
         9
      );
      var1.add(
         "crystal_tnt",
         "Crystal TNT",
         90,
         Fx.all(
            new Fx[]{
               Fx.mega(8),
               Fx.delay(
                  10,
                  Fx.grow(
                     24, Shape.CONE, Pal.mix(new String[]{"minecraft:amethyst_block", "minecraft:amethyst_block", "minecraft:glass", "minecraft:quartz_block"})
                  )
               ),
               Fx.delay(10, Fx.scatter(5, 16.0, Fx.grow(12, Shape.CONE, Pal.mix(new String[]{"minecraft:amethyst_block", "minecraft:glass"}))))
            }
         ),
         Category.INDUSTRIAL,
         2
      );
      var1.add(
         "glacier_tnt",
         "Glacier TNT",
         100,
         Fx.all(
            new Fx[]{
               Fx.terraform(30, Shape.PANCAKE, Pal.SNOW),
               Fx.delay(10, Fx.grow(30, Shape.CONE, Pal.ICE)),
               Fx.storm(false, 6000),
               Fx.effectArea("minecraft:slowness", 2, 600, 30.0)
            }
         ),
         Category.INDUSTRIAL,
         3
      );
      var1.add(
         "treasure_tnt",
         "Treasure TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.vanilla(1.0F, false),
               Fx.blast(Spec.of(16).palette(Pal.sparse("minecraft:gold_block", 0.02F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.blast(Spec.of(16).palette(Pal.sparse("minecraft:emerald_block", 0.01F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.blast(Spec.of(16).palette(Pal.sparse("minecraft:diamond_block", 0.005F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.xpOrbs(30, 20, 10.0)
            }
         ),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "party_tnt",
         "Party TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.vanilla(0.5F, false),
               Fx.repeat(4, 15, Fx.scatter(8, 20.0, Fx.vanilla(0.5F, false))),
               Fx.blast(Spec.of(14).palette(Pal.sparse("minecraft:red_wool", 0.05F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.blast(Spec.of(14).palette(Pal.sparse("minecraft:yellow_wool", 0.05F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.blast(Spec.of(14).palette(Pal.sparse("minecraft:lime_wool", 0.05F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.blast(Spec.of(14).palette(Pal.sparse("minecraft:light_blue_wool", 0.05F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.blast(Spec.of(14).palette(Pal.sparse("minecraft:magenta_wool", 0.05F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.flyingMobs("minecraft:parrot", 8, 12.0, 3.0),
               Fx.xpOrbs(10, 20, 12.0)
            }
         ),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "atlantis_tnt",
         "Atlantis TNT",
         110,
         Fx.all(
            new Fx[]{
               Fx.terraform(30, Shape.CRATER, Pal.OCEAN),
               Fx.delay(
                  20, Fx.blast(Spec.of(32).palette(Pal.sparse("minecraft:sea_lantern", 0.03F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent())
               ),
               Fx.delay(
                  20,
                  Fx.blast(Spec.of(32).palette(Pal.sparse("minecraft:brain_coral_block", 0.06F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent())
               ),
               Fx.delay(
                  20,
                  Fx.blast(Spec.of(32).palette(Pal.sparse("minecraft:tube_coral_block", 0.06F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent())
               ),
               Fx.delay(
                  20,
                  Fx.blast(Spec.of(32).palette(Pal.sparse("minecraft:fire_coral_block", 0.04F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent())
               ),
               Fx.delay(30, Fx.mobs("minecraft:guardian", 8, 16.0))
            }
         ),
         Category.INDUSTRIAL,
         4
      );
      var1.add(
         "orbital_strike_tnt",
         "Orbital Strike TNT",
         100,
         Fx.all(
            new Fx[]{
               Fx.repeat(12, 5, Fx.lightning(2, 3.0)), Fx.terraform(5, Shape.SHAFT, Pal.AIR), Fx.delay(60, Fx.mega(28)), Fx.delay(60, Fx.lightning(20, 30.0))
            }
         ),
         Category.HEAVY_ORDNANCE,
         8
      );
      var1.add(
         "supervolcano_tnt",
         "Supervolcano TNT",
         140,
         Fx.all(
            new Fx[]{
               Fx.terraform(40, Shape.CRATER, Pal.VOLCANO),
               Fx.volcano(36, 900),
               Fx.storm(true, 6000),
               Fx.repeat(5, 60, Fx.meteorStorm(5, 60.0, 8)),
               Fx.effectArea("minecraft:blindness", 0, 300, 50.0)
            }
         ),
         Category.HEAVY_ORDNANCE,
         18
      );
      var1.add(
         "spring_tnt",
         "Spring TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.terraform(26, Shape.PANCAKE, Pal.OVERWORLD),
               Fx.delay(10, Fx.grow(22, Shape.DOME, Pal.sparse("minecraft:poppy", 0.12F))),
               Fx.delay(10, Fx.grow(24, Shape.DOME, Pal.sparse("minecraft:oak_leaves", 0.03F))),
               Fx.setTime(1000L),
               Fx.flyingMobs("minecraft:bee", 10, 14.0, 3.0),
               Fx.mobs("minecraft:sheep", 6, 12.0)
            }
         ),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "quasar_tnt",
         "Quasar TNT",
         140,
         Fx.all(new Fx[]{Fx.setTime(18000L), Fx.blackHole(40, 260, 60), Fx.repeat(10, 20, Fx.lightning(6, 60.0)), Fx.delay(260, Fx.mega(50))}),
         Category.HEAVY_ORDNANCE,
         40
      );
      var1.add(
         "blood_tnt",
         "Blood TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.mega(10),
               Fx.blast(Spec.of(22).palette(Pal.sparse("minecraft:red_wool", 0.1F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.blast(Spec.of(18).palette(Pal.sparse("minecraft:redstone_block", 0.03F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.effectArea("minecraft:weakness", 1, 400, 20.0),
               Fx.effectArea("minecraft:slowness", 1, 200, 20.0)
            }
         ),
         Category.INDUSTRIAL,
         3
      );
      var1.add(
         "coke_tnt",
         "Coke TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.vanilla(2.0F, false),
               Fx.terraform(10, Shape.CRATER, Pal.bowl("minecraft:water")),
               Fx.fling(14.0, 2.2, true),
               Fx.repeat(6, 4, Fx.scatter(4, 6.0, Fx.vanilla(0.5F, false)))
            }
         ),
         Category.FAMILY_FRIENDLY,
         2
      );
      var1.add("little_boy_tnt", "Little Boy Nuke", 140, Fx.nuke(85, 150), Category.HEAVY_ORDNANCE, 75);
      var1.add("fat_man_tnt", "Fat Man Nuke", 150, Fx.all(new Fx[]{Fx.nuke(100, 180), Fx.delay(60, Fx.mega(30))}), Category.HEAVY_ORDNANCE, 95);
      var1.add("tnt_x15", "TNT x15", 80, Fx.mega(21), Category.INDUSTRIAL, 4);
      var1.add("tnt_x25", "TNT x25", 80, Fx.mega(26), Category.INDUSTRIAL, 6);
      var1.add("tnt_x75", "TNT x75", 90, Fx.mega(37), Category.HEAVY_ORDNANCE, 10);
      var1.add("tnt_x78", "TNT x78", 90, Fx.mega(38), Category.HEAVY_ORDNANCE, 10);
      var1.add("tnt_x123", "TNT x123", 90, Fx.mega(45), Category.HEAVY_ORDNANCE, 12);
      var1.add("tnt_x128", "TNT x128", 90, Fx.mega(46), Category.HEAVY_ORDNANCE, 13);
      var1.add("tnt_x750", "TNT x750", 100, Fx.mega(76), Category.HEAVY_ORDNANCE, 27);
      var1.add("tnt_x25000", "TNT x25,000", 160, Fx.mega(165), Category.WORLD_BUSTER, 90);
      var1.add(
         "fireball_tnt",
         "Fireball TNT",
         90,
         Fx.all(new Fx[]{Fx.mega(8, 0.5F), Fx.repeat(6, 10, Fx.scatter(5, 28.0, Fx.mega(4, 0.9F))), Fx.flyingMobs("minecraft:ghast", 2, 20.0, 14.0)}),
         Category.INDUSTRIAL,
         4
      );
      var1.add(
         "weak_tnt", "Weak TNT", 60, Fx.all(new Fx[]{Fx.vanilla(1.0F, false), Fx.effectArea("minecraft:weakness", 2, 600, 8.0)}), Category.FAMILY_FRIENDLY, 1
      );
      var1.add(
         "spawn_tnt_house",
         "Spawn TNT House",
         90,
         Fx.all(new Fx[]{Fx.build(Build.HOUSE, 0), Fx.delay(100, Fx.chain("tnt_x5", 8, 4.0, 40, 90))}),
         Category.FAMILY_FRIENDLY,
         2
      );
      var1.add(
         "tnt_destroyer", "TNT Destroyer", 110, Fx.all(new Fx[]{Fx.mega(48), Fx.repeat(5, 20, Fx.scatter(6, 44.0, Fx.mega(10)))}), Category.HEAVY_ORDNANCE, 16
      );
      var1.add(
         "map_destroyer_tnt",
         "TNT Map Destroyer",
         200,
         Fx.all(new Fx[]{Fx.mega(170), Fx.delay(40, Fx.chunkWipe(10)), Fx.repeat(6, 30, Fx.meteorStorm(10, 150.0, 16)), Fx.storm(true, 24000)}),
         Category.WORLD_BUSTER,
         400
      );
      var1.add(
         "tnt_juice",
         "TNT Juice",
         80,
         Fx.all(
            new Fx[]{
               Fx.vanilla(1.5F, false),
               Fx.blast(Spec.of(14).palette(Pal.sparse("minecraft:honey_block", 0.12F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.blast(Spec.of(14).palette(Pal.sparse("minecraft:orange_wool", 0.08F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.effectArea("minecraft:regeneration", 1, 400, 16.0),
               Fx.delay(2, Fx.effectArea("minecraft:instant_health", 1, 1, 16.0))
            }
         ),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add("tnt_jr", "TNT Jr.", 60, Fx.all(new Fx[]{Fx.vanilla(2.5F, false), Fx.chain("mini_tnt", 6, 4.0, 20, 50)}), Category.FAMILY_FRIENDLY, 1);
      var1.add(
         "spicy_sauce_tnt",
         "TNT Spicy Sauce",
         80,
         Fx.all(
            new Fx[]{
               Fx.mega(10, 0.8F),
               Fx.blast(Spec.of(12).palette(Pal.sparse("minecraft:lava", 0.03F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.mobs("minecraft:blaze", 4, 10.0),
               Fx.scatter(6, 14.0, Fx.mega(3, 0.9F))
            }
         ),
         Category.INDUSTRIAL,
         3
      );
      var1.add(
         "old_tnt",
         "Old TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.vanilla(4.0F, true),
               Fx.blast(Spec.of(10).palette(Pal.sparse("minecraft:cobweb", 0.05F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent())
            }
         ),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "google_tnt",
         "TNT Google",
         90,
         Fx.all(
            new Fx[]{
               Fx.mega(8),
               Fx.terraform(4, Shape.SHAFT, Pal.AIR),
               Fx.blast(Spec.of(16).palette(Pal.sparse("minecraft:blue_wool", 0.05F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.blast(Spec.of(16).palette(Pal.sparse("minecraft:red_wool", 0.05F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.blast(Spec.of(16).palette(Pal.sparse("minecraft:yellow_wool", 0.05F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.blast(Spec.of(16).palette(Pal.sparse("minecraft:lime_wool", 0.05F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.blast(Spec.of(16).palette(Pal.sparse("minecraft:glowstone", 0.02F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.xpOrbs(20, 10, 10.0)
            }
         ),
         Category.FAMILY_FRIENDLY,
         2
      );
      var1.add(
         "wave_tnt",
         "Wave TNT",
         90,
         Fx.all(
            new Fx[]{
               Fx.terraform(8, Shape.RING, Pal.AIR),
               Fx.delay(8, Fx.terraform(16, Shape.RING, Pal.AIR)),
               Fx.delay(16, Fx.terraform(24, Shape.RING, Pal.AIR)),
               Fx.delay(24, Fx.terraform(32, Shape.RING, Pal.AIR)),
               Fx.delay(32, Fx.terraform(40, Shape.RING, Pal.AIR)),
               Fx.fling(40.0, 1.6, false)
            }
         ),
         Category.INDUSTRIAL,
         6
      );
      var1.add(
         "random_tnt",
         "Random TNT",
         80,
         Fx.oneOf(
            new Fx[]{
               Fx.chain("lava_tnt", 1, 0.0, 10, 20),
               Fx.chain("water_tnt", 1, 0.0, 10, 20),
               Fx.chain("ice_tnt", 1, 0.0, 10, 20),
               Fx.chain("snow_tnt", 1, 0.0, 10, 20),
               Fx.chain("fire_tnt", 1, 0.0, 10, 20),
               Fx.chain("lightning_tnt", 1, 0.0, 10, 20),
               Fx.chain("tornado_tnt", 1, 0.0, 10, 20),
               Fx.chain("creeper_tnt", 1, 0.0, 10, 20),
               Fx.chain("slime_tnt", 1, 0.0, 10, 20),
               Fx.chain("zombie_tnt", 1, 0.0, 10, 20),
               Fx.chain("skeleton_tnt", 1, 0.0, 10, 20),
               Fx.chain("bee_tnt", 1, 0.0, 10, 20),
               Fx.chain("farm_tnt", 1, 0.0, 10, 20),
               Fx.chain("villager_tnt", 1, 0.0, 10, 20),
               Fx.chain("rainbow_tnt", 1, 0.0, 10, 20),
               Fx.chain("party_tnt", 1, 0.0, 10, 20),
               Fx.chain("xp_tnt", 1, 0.0, 10, 20),
               Fx.chain("firework_tnt", 1, 0.0, 10, 20),
               Fx.chain("teleport_tnt", 1, 0.0, 10, 20),
               Fx.chain("house_tnt", 1, 0.0, 10, 20),
               Fx.chain("mini_tnt", 1, 0.0, 10, 20),
               Fx.chain("tnt_x20", 1, 0.0, 10, 20),
               Fx.chain("meteor_tnt", 1, 0.0, 10, 20),
               Fx.chain("comet_tnt", 1, 0.0, 10, 20),
               Fx.chain("chicken_rain_tnt", 1, 0.0, 10, 20),
               Fx.chain("coke_tnt", 1, 0.0, 10, 20),
               Fx.chain("bubble_tnt", 1, 0.0, 10, 20),
               Fx.chain("prank_tnt", 1, 0.0, 10, 20)
            }
         ),
         Category.FAMILY_FRIENDLY,
         2
      );
      var1.add(
         "chicken_rain_tnt",
         "Chicken Rain TNT",
         80,
         Fx.all(new Fx[]{Fx.vanilla(1.0F, false), Fx.flyingMobs("minecraft:chicken", 40, 24.0, 22.0)}),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add("creeper_army_tnt", "Creeper Army TNT", 80, Fx.all(new Fx[]{Fx.mega(12), Fx.mobs("minecraft:creeper", 60, 30.0)}), Category.INDUSTRIAL, 3);
      var1.add(
         "golem_tnt", "Iron Golem TNT", 90, Fx.all(new Fx[]{Fx.vanilla(1.0F, false), Fx.mobs("minecraft:iron_golem", 6, 8.0)}), Category.FAMILY_FRIENDLY, 1
      );
      var1.add(
         "cobweb_tnt",
         "Cobweb TNT",
         80,
         Fx.all(new Fx[]{Fx.mega(6), Fx.terraform(18, Shape.SPHERE, Pal.sparse("minecraft:cobweb", 0.25F)), Fx.effectArea("minecraft:slowness", 3, 400, 18.0)}),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "bubble_tnt",
         "Bubble TNT",
         80,
         Fx.all(new Fx[]{Fx.vanilla(0.5F, false), Fx.grow(14, Shape.RING, Pal.of("minecraft:glass"))}),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "haunted_tnt",
         "Haunted TNT",
         100,
         Fx.all(
            new Fx[]{
               Fx.mega(8),
               Fx.setTime(18000L),
               Fx.flyingMobs("minecraft:phantom", 10, 20.0, 14.0),
               Fx.flyingMobs("minecraft:vex", 8, 16.0, 4.0),
               Fx.effectArea("minecraft:darkness", 0, 400, 30.0)
            }
         ),
         Category.FAMILY_FRIENDLY,
         2
      );
      var1.add(
         "lucky_tnt",
         "Lucky TNT",
         80,
         Fx.oneOf(
            new Fx[]{
               Fx.xpOrbs(60, 30, 14.0),
               Fx.all(
                  new Fx[]{
                     Fx.vanilla(0.5F, false),
                     Fx.blast(Spec.of(12).palette(Pal.sparse("minecraft:gold_block", 0.01F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent())
                  }
               ),
               Fx.effectArea("minecraft:regeneration", 2, 600, 16.0),
               Fx.mobs("minecraft:creeper", 8, 10.0),
               Fx.lightning(8, 12.0),
               Fx.mega(16),
               Fx.flyingMobs("minecraft:parrot", 8, 10.0, 3.0),
               Fx.chain("party_tnt", 1, 0.0, 10, 20)
            }
         ),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "prank_tnt",
         "Prank TNT",
         80,
         Fx.all(new Fx[]{Fx.vanilla(0.1F, false), Fx.mobs("minecraft:chicken", 1, 1.0), Fx.delay(60, Fx.mega(6))}),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add(
         "bouncy_tnt",
         "Bouncy TNT",
         80,
         Fx.all(new Fx[]{Fx.vanilla(1.0F, false), Fx.coat(12, Pal.of("minecraft:slime_block")), Fx.fling(16.0, 2.4, true)}),
         Category.FAMILY_FRIENDLY,
         1
      );
      var1.add("lava_rain_tnt", "Lava Rain TNT", 100, Fx.all(new Fx[]{Fx.mega(10, 0.4F), Fx.rain("lava_tnt", 14, 30.0, 45.0, 20, 70)}), Category.INDUSTRIAL, 5);
      var1.add(
         "ice_age_tnt",
         "Ice Age TNT",
         120,
         Fx.all(
            new Fx[]{
               Fx.terraform(60, Shape.PANCAKE, Pal.SNOW),
               Fx.delay(10, Fx.scatter(6, 50.0, Fx.grow(18, Shape.CONE, Pal.ICE))),
               Fx.storm(false, 12000),
               Fx.effectArea("minecraft:slowness", 3, 1200, 60.0)
            }
         ),
         Category.HEAVY_ORDNANCE,
         12
      );
      var1.add(
         "zombie_apocalypse_tnt",
         "Zombie Apocalypse TNT",
         110,
         Fx.all(
            new Fx[]{
               Fx.mega(20),
               Fx.setTime(18000L),
               Fx.storm(true, 6000),
               Fx.mobs("minecraft:zombie", 60, 40.0),
               Fx.delay(200, Fx.mobs("minecraft:zombie", 30, 40.0))
            }
         ),
         Category.HEAVY_ORDNANCE,
         6
      );
      var1.add(
         "thunder_god_tnt",
         "Thunder God TNT",
         110,
         Fx.all(new Fx[]{Fx.mega(24), Fx.storm(true, 12000), Fx.repeat(20, 10, Fx.lightning(6, 45.0)), Fx.fling(30.0, 1.4, true)}),
         Category.HEAVY_ORDNANCE,
         14
      );
      var1.add("mini_nuke_tnt", "Mini Nuke TNT", 120, Fx.nuke(32, 60), Category.HEAVY_ORDNANCE, 15);
      var1.add("error_404_tnt", "Error 404 TNT", 100, Fx.error404(), Category.WORLD_BUSTER, 9999);
      var1.add(
         "galaxy_destruction_tnt",
         "Super Ultra Mega Hyper Massive Destruction of the Galaxy TNT",
         300,
         Fx.all(
            new Fx[]{
               Fx.nuke(190, 900),
               Fx.mega(190),
               Fx.mushroomCloud(),
               Fx.setTime(18000L),
               Fx.storm(true, 48000),
               Fx.lightning(60, 150.0),
               Fx.effectArea("tntexpansion:radiation", 4, 12000, 250.0),
               Fx.effectArea("minecraft:wither", 3, 1200, 250.0),
               Fx.fling(60.0, 2.0, true),
               Fx.delay(40, Fx.earthquake(60, 600)),
               Fx.delay(40, Fx.volcano(40, 800)),
               Fx.delay(60, Fx.tsunami(80, 700)),
               Fx.delay(60, Fx.tornado(30, 600)),
               Fx.delay(80, Fx.repeat(10, 40, Fx.meteorStorm(12, 180.0, 18))),
               Fx.delay(80, Fx.repeat(6, 60, Fx.cometStorm(8, 180.0, 18))),
               Fx.delay(100, Fx.chunkWipe(14)),
               Fx.delay(120, Fx.terraform(170, Shape.SPHERE, Pal.DIMENSIONAL)),
               Fx.delay(140, Fx.mobs("minecraft:zombie", 40, 80.0)),
               Fx.delay(160, Fx.blackHole(100, 300, 190)),
               Fx.delay(200, Fx.repeat(12, 25, Fx.scatter(4, 150.0, Fx.mega(30)))),
               Fx.delay(400, Fx.error404())
            }
         ),
         Category.WORLD_BUSTER,
         9999
      );
      defineExpansion49(var1);
      defineExpansion410(var1);
      defineExpansion411(var1);
      defineExpansion412(var1);
      defineExpansion51(var1);
      defineExpansion52(var1);
   }

   private static Fx dread(float var0) {
      return Fx.all(new Fx[]{Fx.sound("scream", var0, 0.4F), Fx.sound("boom", var0, 0.5F)});
   }

   private static Fx nukeRoar(float var0) {
      return Fx.sequence(
         12, new Fx[]{Fx.sound("boom", var0, 0.5F), Fx.sound("thunder", var0, 0.5F), Fx.sound("sonic", var0, 0.5F), Fx.sound("boom", var0, 0.6F)}
      );
   }

   private static Fx dot() {
      return Fx.mega(9);
   }

   private static void defineExpansion49(Tnts var0) {
      var0.add(
         "poison_tnt",
         "TNT Poison",
         80,
         Fx.all(
            new Fx[]{
               Fx.mega(14),
               Fx.terraform(
                  18, Shape.CRATER, Pal.mix(new String[]{"minecraft:slime_block", "minecraft:green_concrete|minecraft:lime_wool", "minecraft:lime_wool"})
               ),
               Fx.repeat(12, 40, Fx.effectArea("minecraft:poison", 2, 200, 32.0)),
               Fx.effectArea("minecraft:nausea|minecraft:slowness", 0, 400, 32.0),
               Fx.effectArea("minecraft:wither", 0, 200, 16.0),
               Fx.mobs("minecraft:cave_spider", 8, 10.0),
               Fx.repeat(4, 50, Fx.sound("lava", 6.0F, 0.5F))
            }
         ),
         Category.INDUSTRIAL,
         4
      );
      var0.add(
         "sandplosion_tnt",
         "TNT Sandplosion",
         90,
         Fx.all(
            new Fx[]{
               Fx.mega(16),
               Fx.blast(
                  Spec.of(26)
                     .shape(Shape.DOME)
                     .palette(Pal.of("minecraft:sand"))
                     .replace(Replace.AIR)
                     .ragged(0.25F)
                     .constructive()
                     .knockback(0.0)
                     .silent()
                     .yOffset(16.0)
               ),
               Fx.delay(
                  30,
                  Fx.blast(
                     Spec.of(20)
                        .shape(Shape.DOME)
                        .palette(Pal.of("minecraft:sandstone|minecraft:sand"))
                        .replace(Replace.AIR)
                        .ragged(0.4F)
                        .constructive()
                        .knockback(0.0)
                        .silent()
                        .yOffset(28.0)
                  )
               ),
               Fx.effectArea("minecraft:blindness", 0, 160, 30.0),
               Fx.mobs("minecraft:husk|minecraft:zombie", 6, 14.0),
               Fx.sound("boom", 10.0F, 0.6F)
            }
         ),
         Category.INDUSTRIAL,
         6
      );
      var0.add(
         "fast_tnt",
         "Fast TNT",
         10,
         Fx.all(
            new Fx[]{
               Fx.vanilla(4.0F, false),
               Fx.repeat(16, 2, Fx.scatter(2, 12.0, Fx.mega(6))),
               Fx.fling(14.0, 2.5, false),
               Fx.effectArea("minecraft:speed", 3, 600, 20.0)
            }
         ),
         Category.INDUSTRIAL,
         4
      );
      var0.add(
         "ivy_mike_nuke",
         "Ivy Mike Nuke",
         160,
         Fx.all(
            new Fx[]{
               Fx.nuke(110, 200),
               Fx.mushroomCloud(),
               Fx.delay(30, Fx.terraform(70, Shape.CRATER, Pal.bowl("minecraft:water"))),
               Fx.delay(60, Fx.tsunami(80, 500)),
               Fx.delay(20, Fx.wave(4, 30.0, 8, Fx.fling(20.0, 1.5, false))),
               nukeRoar(40.0F)
            }
         ),
         Category.HEAVY_ORDNANCE,
         110
      );
      var0.add(
         "castle_bravo_nuke",
         "Castle Bravo Nuke",
         170,
         Fx.all(
            new Fx[]{
               Fx.nuke(140, 400),
               Fx.mushroomCloud(),
               Fx.delay(60, Fx.mega(70)),
               Fx.delay(80, Fx.fallout(230, 900)),
               Fx.effectArea("tntexpansion:radiation", 3, 6000, 230.0),
               Fx.delay(100, Fx.storm(true, 12000)),
               nukeRoar(48.0F),
               Fx.delay(60, nukeRoar(48.0F))
            }
         ),
         Category.HEAVY_ORDNANCE,
         160
      );
      var0.add(
         "tsar_bomba_nuke",
         "Tsar Bomba Nuke",
         200,
         Fx.all(
            new Fx[]{
               Fx.nuke(185, 600),
               Fx.mushroomCloud(),
               Fx.effectArea("minecraft:blindness", 0, 300, 260.0),
               Fx.fling(120.0, 3.5, true),
               Fx.delay(20, Fx.wave(6, 34.0, 10, Fx.mega(16))),
               Fx.delay(40, Fx.setTime(18000L)),
               Fx.delay(40, Fx.storm(true, 24000)),
               Fx.delay(60, Fx.lightning(50, 200.0)),
               nukeRoar(64.0F),
               Fx.delay(50, dread(48.0F))
            }
         ),
         Category.WORLD_BUSTER,
         220
      );
      var0.add(
         "tnt_roulette",
         "TNT Roulette",
         80,
         Fx.all(
            new Fx[]{
               Fx.sequence(
                  10,
                  new Fx[]{
                     Fx.sound("teleport", 3.0F, 0.6F),
                     Fx.sound("teleport", 3.0F, 0.8F),
                     Fx.sound("teleport", 3.0F, 1.0F),
                     Fx.sound("teleport", 3.0F, 1.2F),
                     Fx.sound("teleport", 3.0F, 1.4F),
                     Fx.sound("teleport", 3.0F, 1.6F)
                  }
               ),
               Fx.delay(
                  70,
                  Fx.oneOf(
                     new Fx[]{
                        Fx.all(new Fx[]{Fx.mega(50), Fx.fling(30.0, 3.0, true), dread(24.0F)}),
                        Fx.all(new Fx[]{Fx.vanilla(0.5F, false), Fx.xpOrbs(40, 20, 6.0)}),
                        Fx.all(new Fx[]{Fx.vanilla(0.5F, false), Fx.xpOrbs(40, 20, 6.0)}),
                        Fx.all(new Fx[]{Fx.vanilla(0.5F, false), Fx.xpOrbs(40, 20, 6.0)}),
                        Fx.all(new Fx[]{Fx.vanilla(0.5F, false), Fx.xpOrbs(40, 20, 6.0)}),
                        Fx.all(new Fx[]{Fx.vanilla(0.5F, false), Fx.xpOrbs(40, 20, 6.0)})
                     }
                  )
               )
            }
         ),
         Category.INDUSTRIAL,
         20
      );
      var0.add(
         "coke",
         "Coke",
         60,
         Fx.all(
            new Fx[]{
               Fx.vanilla(2.0F, false),
               Fx.column(18, 3.0, 1, Fx.vanilla(1.5F, false)),
               Fx.fling(16.0, 3.2, true),
               Fx.effectArea("minecraft:speed", 3, 900, 20.0),
               Fx.effectArea("minecraft:jump_boost", 2, 900, 20.0),
               Fx.sound("splash", 8.0F, 1.4F)
            }
         ),
         Category.FAMILY_FRIENDLY,
         2
      );
      var0.add(
         "bucket_of_coke",
         "Bucket Of Coke",
         80,
         Fx.all(
            new Fx[]{
               Fx.mega(10),
               Fx.terraform(20, Shape.CRATER, Pal.bowl("minecraft:water")),
               Fx.coat(24, Pal.of("minecraft:brown_terracotta|minecraft:soul_sand")),
               Fx.delay(20, Fx.tsunami(28, 300)),
               Fx.effectArea("minecraft:speed", 2, 600, 28.0),
               Fx.sound("splash", 16.0F, 0.6F)
            }
         ),
         Category.INDUSTRIAL,
         4
      );
      var0.add(
         "coke_bottle",
         "Coke Bottle",
         80,
         Fx.all(
            new Fx[]{
               Fx.repeat(10, 5, Fx.scatter(5, 10.0, Fx.vanilla(1.0F, false))),
               Fx.repeat(10, 5, Fx.sound("splash", 3.0F, 1.8F)),
               Fx.delay(55, Fx.all(new Fx[]{Fx.mega(14), Fx.fling(18.0, 2.8, true), Fx.sound("boom", 10.0F, 1.2F)})),
               Fx.effectArea("minecraft:haste", 2, 900, 18.0)
            }
         ),
         Category.FAMILY_FRIENDLY,
         3
      );
      var0.add(
         "tnwlss1013_tnt",
         "Tnwlss1013 TNT",
         100,
         Fx.all(
            new Fx[]{
               Fx.pattern("XXXXXXX/...X.../...X.../...X.../...X.../...X.../...X...", 9.0, 4, Fx.mega(9)),
               Fx.delay(40, Fx.lightning(16, 30.0)),
               Fx.delay(50, Fx.ring(13, 40.0, Fx.mega(7))),
               Fx.delay(60, Fx.chain("firework_tnt", 6, 20.0, 10, 30)),
               Fx.sound("beacon", 12.0F, 0.6F)
            }
         ),
         Category.INDUSTRIAL,
         16
      );
      var0.add(
         "user_tnt",
         "User TNT",
         90,
         Fx.all(
            new Fx[]{
               Fx.pattern("...XXX.../...X.X.../...XXX.../....X..../XXXXXXXXX/....X..../....X..../...X.X.../..X...X../.X.....X.", 5.0, 3, Fx.mega(6)),
               Fx.delay(40, Fx.at(0.0, 0.0, -22.0, Fx.lightning(6, 4.0))),
               Fx.delay(30, Fx.mobs("minecraft:villager", 10, 18.0)),
               Fx.xpOrbs(20, 20, 12.0)
            }
         ),
         Category.INDUSTRIAL,
         12
      );
      var0.add(
         "glow_tnt",
         "Glow TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.vanilla(2.0F, false),
               Fx.setTime(18000L),
               Fx.effectArea("minecraft:glowing|minecraft:night_vision", 0, 2400, 80.0),
               Fx.effectArea("minecraft:night_vision", 0, 2400, 40.0),
               Fx.blast(
                  Spec.of(28)
                     .palette(Pal.sparse("minecraft:sea_lantern|minecraft:glowstone", 0.04F))
                     .replace(Replace.SOLID)
                     .ragged(0.0F)
                     .knockback(0.0)
                     .silent()
               ),
               Fx.spiral(30, 30.0, 2.0, 2, Fx.vanilla(1.5F, false)),
               Fx.sound("beacon", 10.0F, 1.2F)
            }
         ),
         Category.FAMILY_FRIENDLY,
         2
      );
      var0.add(
         "lucky_gold_tnt",
         "Lucky Gold TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.sound("beacon", 8.0F, 1.6F),
               Fx.oneOf(
                  new Fx[]{
                     Fx.blast(Spec.of(16).palette(Pal.sparse("minecraft:gold_block", 0.08F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
                     Fx.grow(5, Shape.DOME, Pal.mix(new String[]{"minecraft:gold_block", "minecraft:gold_block", "minecraft:diamond_block"})),
                     Fx.all(new Fx[]{Fx.xpOrbs(200, 40, 8.0), Fx.effectArea("minecraft:luck|minecraft:regeneration", 0, 6000, 16.0)}),
                     Fx.all(
                        new Fx[]{
                           Fx.effectArea("minecraft:absorption|minecraft:resistance", 4, 2400, 16.0),
                           Fx.effectArea("minecraft:regeneration", 2, 600, 16.0),
                           Fx.effectArea("minecraft:strength", 1, 2400, 16.0)
                        }
                     ),
                     Fx.mobs("minecraft:iron_golem", 4, 8.0),
                     Fx.ring(8, 10.0, Fx.chain("treasure_tnt", 1, 0.0, 10, 20)),
                     Fx.all(new Fx[]{Fx.mega(36), Fx.sound("scream", 12.0F, 0.6F)})
                  }
               )
            }
         ),
         Category.FAMILY_FRIENDLY,
         3
      );
      var0.add(
         "pez_tnt",
         "Pez TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.vanilla(2.0F, false),
               Fx.ring(8, 12.0, Fx.column(6, 2.0, 3, Fx.terraform(2, Shape.SPHERE, Pal.mix(WOOLS)))),
               Fx.scatter(14, 18.0, Fx.vanilla(1.0F, false)),
               Fx.effectArea("minecraft:speed", 1, 600, 18.0),
               Fx.sequence(4, new Fx[]{Fx.sound("launch", 4.0F, 1.6F), Fx.sound("launch", 4.0F, 1.8F), Fx.sound("launch", 4.0F, 2.0F)})
            }
         ),
         Category.FAMILY_FRIENDLY,
         2
      );
      var0.add(
         "pez_honey_tnt",
         "Pez (A Candy) Honey TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.vanilla(2.0F, false),
               Fx.coat(22, Pal.of("minecraft:honey_block")),
               Fx.mobs("minecraft:bee", 14, 12.0),
               Fx.effectArea("minecraft:slowness", 3, 600, 24.0),
               Fx.effectArea("minecraft:regeneration", 1, 600, 24.0),
               Fx.ring(6, 9.0, Fx.terraform(2, Shape.SPHERE, Pal.of("minecraft:honey_block")))
            }
         ),
         Category.FAMILY_FRIENDLY,
         2
      );
      var0.add(
         "win_token",
         "Win Token",
         60,
         Fx.all(
            new Fx[]{
               Fx.vanilla(0.5F, false),
               Fx.xpOrbs(100, 40, 10.0),
               Fx.effectArea("minecraft:regeneration", 2, 1200, 16.0),
               Fx.effectArea("minecraft:absorption|minecraft:resistance", 3, 2400, 16.0),
               Fx.effectArea("minecraft:haste", 1, 2400, 16.0),
               Fx.effectArea("minecraft:luck|minecraft:speed", 0, 6000, 16.0),
               Fx.delay(10, Fx.ring(6, 8.0, Fx.chain("firework_tnt", 1, 0.0, 10, 20))),
               Fx.sequence(6, new Fx[]{Fx.sound("beacon", 8.0F, 1.2F), Fx.sound("launch", 6.0F, 1.5F), Fx.sound("beacon", 8.0F, 1.8F)})
            }
         ),
         Category.FAMILY_FRIENDLY,
         1
      );
      var0.add(
         "win_token_tnt",
         "Win Token TNT",
         100,
         Fx.all(
            new Fx[]{
               Fx.pattern("X.....X/X.....X/X..X..X/X.X.X.X/XX...XX/X.....X", 9.0, 4, Fx.mega(12)),
               Fx.delay(30, Fx.ring(10, 45.0, Fx.chain("firework_tnt", 1, 0.0, 10, 30))),
               Fx.delay(40, Fx.xpOrbs(80, 40, 20.0)),
               Fx.sound("beacon", 16.0F, 0.8F)
            }
         ),
         Category.INDUSTRIAL,
         26
      );
      var0.add(
         "dragon_dude_tnt",
         "Dragon Dude TNT",
         100,
         Fx.all(
            new Fx[]{
               Fx.walk(18, 6.0, 3, Fx.mega(8, 0.6F)),
               Fx.walk(18, 6.0, 3, Fx.mega(8, 0.6F)),
               Fx.coat(20, Pal.END),
               Fx.flyingMobs("minecraft:phantom|minecraft:bat", 6, 16.0, 12.0),
               Fx.mobs("minecraft:endermite|minecraft:silverfish", 8, 12.0),
               Fx.repeat(3, 30, Fx.sound("sonic", 16.0F, 0.6F))
            }
         ),
         Category.INDUSTRIAL,
         14
      );
      var0.add(
         "rainbow_firework_tnt",
         "Rainbow TNT Firework",
         80,
         Fx.all(
            new Fx[]{
               Fx.vanilla(1.0F, false),
               Fx.column(6, 6.0, 3, Fx.vanilla(1.0F, false)),
               Fx.delay(20, Fx.at(0.0, 36.0, 0.0, Fx.wave(3, 7.0, 4, Fx.vanilla(2.5F, false)))),
               Fx.delay(30, Fx.coat(24, Pal.mix(WOOLS))),
               Fx.sequence(
                  5,
                  new Fx[]{Fx.sound("launch", 10.0F, 0.8F), Fx.sound("launch", 10.0F, 1.0F), Fx.sound("launch", 10.0F, 1.2F), Fx.sound("thunder", 6.0F, 2.0F)}
               )
            }
         ),
         Category.FAMILY_FRIENDLY,
         2
      );
      var0.add(
         "bomby",
         "Bomby",
         80,
         Fx.all(new Fx[]{Fx.walk(12, 9.0, 25, Fx.all(new Fx[]{Fx.mega(9), Fx.sound("boom", 6.0F, 1.3F)})), Fx.delay(300, Fx.mega(18))}),
         Category.INDUSTRIAL,
         15
      );
      var0.add(
         "kill_tnt",
         "Kill TNT",
         100,
         Fx.all(
            new Fx[]{
               Fx.blast(Spec.of(40).replace(Replace.AIR).damage(5000.0F).knockback(0.0).noParticles().silent()),
               Fx.effectArea("minecraft:instant_damage", 9, 1, 40.0),
               Fx.effectArea("minecraft:wither", 4, 400, 40.0),
               Fx.effectArea("minecraft:darkness", 0, 400, 60.0),
               dread(24.0F),
               Fx.delay(20, Fx.sound("sonic", 24.0F, 0.5F))
            }
         ),
         Category.HEAVY_ORDNANCE,
         5
      );
      var0.add(
         "truck_crash_tnt",
         "Truck Crash",
         80,
         Fx.all(
            new Fx[]{
               Fx.at(0.0, 0.0, -36.0, Fx.pattern("XXX/XXX/XXX/XXX/XXX/XXX/XXX/XXX/XXX/XXX/XXX/XXX", 6.0, 2, Fx.mega(6))),
               Fx.delay(26, Fx.all(new Fx[]{Fx.mega(22), Fx.fling(26.0, 3.0, false), Fx.sound("boom", 16.0F, 0.7F)})),
               Fx.delay(
                  26, Fx.blast(Spec.of(20).palette(Pal.sparse("minecraft:iron_block", 0.03F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent())
               ),
               Fx.repeat(12, 2, Fx.sound("launch", 6.0F, 0.6F))
            }
         ),
         Category.INDUSTRIAL,
         18
      );
      var0.add(
         "pork_eater_tnt",
         "Pork Eater",
         80,
         Fx.all(
            new Fx[]{
               Fx.mega(10),
               Fx.mobs("minecraft:pig", 16, 14.0),
               Fx.delay(40, Fx.mobs("minecraft:hoglin|minecraft:zombified_piglin", 8, 14.0)),
               Fx.delay(40, Fx.mobs("minecraft:piglin_brute", 4, 10.0)),
               Fx.delay(40, Fx.sound("sonic", 12.0F, 0.7F))
            }
         ),
         Category.INDUSTRIAL,
         6
      );
      var0.add("tnt_x50000", "TNT x50,000", 180, Fx.all(new Fx[]{Fx.mega(190), nukeRoar(40.0F)}), Category.WORLD_BUSTER, 130);
      var0.add(
         "tnt_x75000",
         "TNT x75,000",
         190,
         Fx.all(new Fx[]{Fx.mega(205), Fx.delay(40, Fx.wave(3, 60.0, 15, Fx.mega(30))), nukeRoar(48.0F), Fx.delay(40, dread(40.0F))}),
         Category.WORLD_BUSTER,
         165
      );
      var0.add(
         "tnt_x100000",
         "TNT x100,000",
         200,
         Fx.all(
            new Fx[]{
               Fx.mega(220),
               Fx.mushroomCloud(),
               Fx.fling(150.0, 4.0, true),
               Fx.delay(20, Fx.wave(6, 40.0, 12, Fx.mega(26))),
               Fx.delay(100, Fx.ring(16, 120.0, Fx.mega(40))),
               Fx.delay(140, Fx.spiral(40, 200.0, 4.0, 3, Fx.mega(24))),
               Fx.storm(true, 24000),
               Fx.delay(20, Fx.lightning(80, 220.0)),
               Fx.effectArea("minecraft:darkness", 0, 600, 300.0),
               nukeRoar(64.0F),
               Fx.delay(60, dread(64.0F)),
               Fx.delay(120, Fx.repeat(6, 20, Fx.sound("sonic", 48.0F, 0.5F)))
            }
         ),
         Category.WORLD_BUSTER,
         230
      );
      var0.add("tnt_x90", "TNT x90", 90, Fx.all(new Fx[]{Fx.mega(41), Fx.ring(9, 24.0, Fx.mega(9))}), Category.HEAVY_ORDNANCE, 11);
      var0.add(
         "obsidian_destroyer_tnt",
         "Obsidian Destroyer",
         110,
         Fx.all(
            new Fx[]{
               Fx.mega(16),
               Fx.shatter(Fx.terraform(28, Shape.SPHERE, Pal.AIR)),
               Fx.column(8, -6.0, 3, Fx.shatter(Fx.terraform(9, Shape.SPHERE, Pal.AIR))),
               Fx.delay(20, Fx.ring(8, 28.0, Fx.shatter(Fx.terraform(10, Shape.SPHERE, Pal.AIR)))),
               Fx.sound("boom", 16.0F, 0.5F),
               Fx.delay(10, Fx.sound("sonic", 12.0F, 0.8F))
            }
         ),
         Category.HEAVY_ORDNANCE,
         22
      );
      var0.add(
         "bedrock_destroyer_tnt",
         "Bedrock Destroyer",
         120,
         Fx.all(
            new Fx[]{
               Fx.mega(12),
               Fx.column(80, -5.0, 2, Fx.shatter(Fx.terraform(7, Shape.SPHERE, Pal.AIR))),
               Fx.shatter(Fx.terraform(18, Shape.CRATER, Pal.AIR)),
               Fx.repeat(8, 15, Fx.sound("boom", 12.0F, 0.5F)),
               Fx.delay(120, Fx.sound("scream", 16.0F, 0.4F))
            }
         ),
         Category.HEAVY_ORDNANCE,
         26
      );
      var0.add(
         "tnt_dice",
         "TNT Dice",
         80,
         Fx.all(
            new Fx[]{
               Fx.repeat(6, 6, Fx.sound("teleport", 4.0F, 1.5F)),
               Fx.delay(
                  40,
                  Fx.all(
                     new Fx[]{
                        Fx.sound("beacon", 10.0F, 1.0F),
                        Fx.oneOf(
                           new Fx[]{
                              Fx.pattern(".../.X./...", 12.0, 0, dot()),
                              Fx.pattern("X../.../..X", 12.0, 0, dot()),
                              Fx.pattern("X../.X./..X", 12.0, 0, dot()),
                              Fx.pattern("X.X/.../X.X", 12.0, 0, dot()),
                              Fx.pattern("X.X/.X./X.X", 12.0, 0, dot()),
                              Fx.pattern("X.X/X.X/X.X", 12.0, 0, Fx.all(new Fx[]{dot(), Fx.chance(0.5F, Fx.mega(20))}))
                           }
                        )
                     }
                  )
               )
            }
         ),
         Category.INDUSTRIAL,
         12
      );
      var0.add(
         "nuke",
         "Nuke",
         140,
         Fx.all(new Fx[]{Fx.nuke(90, 200), Fx.mushroomCloud(), Fx.delay(40, Fx.fallout(130, 400)), nukeRoar(40.0F)}),
         Category.HEAVY_ORDNANCE,
         85
      );
      var0.add(
         "nuke_100x",
         "Nuke 100X",
         220,
         Fx.all(
            new Fx[]{
               Fx.mushroomCloud(),
               Fx.nuke(150, 900),
               Fx.delay(40, nukeRoar(64.0F)),
               Fx.delay(80, Fx.repeat(10, 60, Fx.all(new Fx[]{Fx.scatter(10, 260.0, Fx.nuke(36, 120)), Fx.sound("boom", 48.0F, 0.5F)}))),
               Fx.effectArea("tntexpansion:radiation", 4, 9000, 320.0),
               Fx.storm(true, 24000)
            }
         ),
         Category.WORLD_BUSTER,
         260
      );
      var0.add(
         "meteor_shower_tnt",
         "Meteor Shower",
         120,
         Fx.all(
            new Fx[]{
               Fx.setTime(18000L),
               Fx.spiral(36, 90.0, 3.0, 8, Fx.meteorStorm(1, 3.0, 9)),
               Fx.delay(300, Fx.cometStorm(6, 60.0, 14)),
               Fx.repeat(6, 50, Fx.sound("launch", 24.0F, 0.5F))
            }
         ),
         Category.HEAVY_ORDNANCE,
         42
      );
      var0.add(
         "volcanic_eruption_tnt",
         "Volcanic Eruption",
         140,
         Fx.all(
            new Fx[]{
               Fx.terraform(36, Shape.CRATER, Pal.VOLCANO),
               Fx.volcano(24, 900),
               Fx.delay(40, Fx.ring(5, 34.0, Fx.volcano(12, 600))),
               Fx.delay(60, Fx.repeat(5, 60, Fx.chain("lava_rain_tnt", 1, 40.0, 10, 20))),
               Fx.earthquake(40, 400),
               Fx.effectArea("minecraft:blindness", 0, 400, 60.0),
               Fx.storm(true, 9000),
               Fx.repeat(8, 30, Fx.all(new Fx[]{Fx.sound("lava", 24.0F, 0.5F), Fx.sound("boom", 24.0F, 0.5F)}))
            }
         ),
         Category.HEAVY_ORDNANCE,
         48
      );
      var0.add(
         "deviantart_tnt",
         "Deviantart TNT",
         90,
         Fx.all(
            new Fx[]{
               Fx.vanilla(2.0F, false),
               Fx.scatter(24, 34.0, Fx.blast(Spec.of(6).palette(Pal.mix(WOOLS)).replace(Replace.SOLID).ragged(0.3F).knockback(0.0).silent())),
               Fx.coat(14, Pal.mix(new String[]{"minecraft:white_concrete|minecraft:white_wool", "minecraft:light_gray_concrete|minecraft:light_gray_wool"})),
               Fx.spiral(20, 26.0, 2.0, 3, Fx.blast(Spec.of(4).palette(Pal.mix(WOOLS)).replace(Replace.SOLID).knockback(0.0).silent()))
            }
         ),
         Category.FAMILY_FRIENDLY,
         3
      );
      var0.add(
         "youtube_tnt",
         "Youtube TNT",
         90,
         Fx.all(
            new Fx[]{
               Fx.pattern("X..../XXX../XXXXX/XXX../X....", 7.0, 3, Fx.mega(8)),
               Fx.delay(20, Fx.ring(20, 30.0, Fx.blast(Spec.of(5).palette(Pal.of("minecraft:red_wool")).replace(Replace.SOLID).knockback(0.0).silent()))),
               Fx.delay(30, Fx.sequence(8, new Fx[]{Fx.sound("beacon", 12.0F, 2.0F), Fx.sound("beacon", 12.0F, 1.5F)})),
               Fx.xpOrbs(10, 30, 16.0)
            }
         ),
         Category.INDUSTRIAL,
         11
      );
      var0.add(
         "corruption_tnt",
         "TNT Corruption",
         120,
         Fx.all(
            new Fx[]{
               Fx.terraform(10, Shape.SPHERE, Pal.DIMENSIONAL),
               Fx.walk(40, 5.0, 5, Fx.terraform(6, Shape.SPHERE, Pal.DIMENSIONAL)),
               Fx.walk(40, 5.0, 5, Fx.terraform(6, Shape.SPHERE, Pal.DIMENSIONAL)),
               Fx.walk(40, 5.0, 5, Fx.terraform(6, Shape.SPHERE, Pal.DIMENSIONAL)),
               Fx.mobs("minecraft:endermite|minecraft:silverfish", 10, 16.0),
               Fx.effectArea("minecraft:darkness", 0, 400, 40.0),
               Fx.effectArea("minecraft:nausea|minecraft:slowness", 0, 300, 40.0),
               Fx.repeat(5, 40, Fx.sound("scream", 12.0F, 0.5F))
            }
         ),
         Category.HEAVY_ORDNANCE,
         36
      );
      var0.add(
         "map_corruption_tnt",
         "TNT Map Corruption",
         160,
         Fx.all(
            new Fx[]{
               Fx.sound("scream", 24.0F, 0.4F),
               Fx.repeat(14, 20, Fx.sound("scream", 24.0F, 0.4F)),
               Fx.setTime(18000L),
               Fx.mega(60),
               Fx.walk(60, 8.0, 4, Fx.terraform(10, Shape.SPHERE, Pal.DIMENSIONAL)),
               Fx.walk(60, 8.0, 4, Fx.terraform(10, Shape.SPHERE, Pal.DIMENSIONAL)),
               Fx.walk(60, 8.0, 4, Fx.terraform(10, Shape.SPHERE, Pal.DIMENSIONAL)),
               Fx.walk(60, 8.0, 4, Fx.terraform(10, Shape.SPHERE, Pal.DELETE)),
               Fx.delay(40, Fx.scatter(8, 120.0, Fx.chance(0.5F, Fx.chunkWipe(0)))),
               Fx.delay(100, Fx.chunkWipe(1)),
               Fx.effectArea("minecraft:darkness", 0, 1200, 150.0),
               Fx.effectArea("minecraft:nausea|minecraft:slowness", 0, 600, 150.0),
               Fx.delay(60, Fx.repeat(6, 40, Fx.sound("sonic", 32.0F, 0.5F)))
            }
         ),
         Category.WORLD_BUSTER,
         500
      );
      var0.add(
         "arrow_tnt",
         "Arrow TNT",
         90,
         Fx.all(
            new Fx[]{
               Fx.pattern("...X.../..XXX../.X.X.X./X..X..X/...X.../...X.../...X.../...X...", 6.0, 3, Fx.mega(7)),
               Fx.mobs("minecraft:skeleton", 8, 14.0),
               Fx.sequence(3, new Fx[]{Fx.sound("launch", 8.0F, 1.6F), Fx.sound("launch", 8.0F, 1.8F), Fx.sound("launch", 8.0F, 2.0F)})
            }
         ),
         Category.INDUSTRIAL,
         10
      );
      var0.add(
         "arrowplosion_tnt",
         "Arrowplosion TNT",
         100,
         Fx.all(
            new Fx[]{
               Fx.mega(10),
               Fx.sequence(
                  3,
                  new Fx[]{
                     Fx.ring(4, 8.0, Fx.mega(5)),
                     Fx.ring(4, 16.0, Fx.mega(6)),
                     Fx.ring(4, 24.0, Fx.mega(7)),
                     Fx.ring(4, 32.0, Fx.mega(8)),
                     Fx.ring(4, 40.0, Fx.mega(9)),
                     Fx.ring(4, 48.0, Fx.mega(10)),
                     Fx.ring(4, 56.0, Fx.mega(12)),
                     Fx.ring(4, 64.0, Fx.all(new Fx[]{Fx.mega(20), Fx.sound("boom", 16.0F, 0.6F)}))
                  }
               ),
               Fx.mobs("minecraft:skeleton|minecraft:stray", 12, 20.0),
               Fx.repeat(8, 3, Fx.sound("launch", 8.0F, 1.4F))
            }
         ),
         Category.HEAVY_ORDNANCE,
         32
      );
      var0.add(
         "tnt_world_destroyer",
         "TNT World Destroyer",
         200,
         Fx.all(
            new Fx[]{
               Fx.mega(180),
               Fx.mushroomCloud(),
               Fx.delay(40, Fx.chunkWipe(8)),
               Fx.delay(60, Fx.walk(30, 20.0, 6, Fx.terraform(20, Shape.SPHERE, Pal.DIMENSIONAL))),
               Fx.delay(60, Fx.walk(30, 20.0, 6, Fx.terraform(20, Shape.SPHERE, Pal.DIMENSIONAL))),
               Fx.delay(80, Fx.repeat(8, 30, Fx.meteorStorm(10, 180.0, 16))),
               Fx.setTime(18000L),
               Fx.storm(true, 24000),
               Fx.effectArea("minecraft:darkness", 0, 1200, 250.0),
               dread(64.0F),
               Fx.delay(40, nukeRoar(64.0F)),
               Fx.delay(100, Fx.repeat(8, 30, Fx.sound("scream", 48.0F, 0.4F)))
            }
         ),
         Category.WORLD_BUSTER,
         320
      );
      var0.add(
         "money_tnt",
         "Money TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.vanilla(1.0F, false),
               Fx.blast(Spec.of(24).palette(Pal.sparse("minecraft:gold_block", 0.04F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.blast(Spec.of(24).palette(Pal.sparse("minecraft:emerald_block", 0.03F)).replace(Replace.SOLID).ragged(0.0F).knockback(0.0).silent()),
               Fx.pattern(".XXX./X.X../.XXX./..X.X/.XXX.", 4.0, 2, Fx.vanilla(2.0F, false)),
               Fx.mobs("minecraft:villager", 6, 12.0),
               Fx.xpOrbs(30, 30, 14.0),
               Fx.sound("beacon", 10.0F, 1.8F)
            }
         ),
         Category.FAMILY_FRIENDLY,
         2
      );
      var0.add(
         "money",
         "Money",
         60,
         Fx.all(
            new Fx[]{
               Fx.grow(
                  6,
                  Shape.DOME,
                  Pal.mix(
                     new String[]{
                        "minecraft:gold_block", "minecraft:emerald_block", "minecraft:gold_block", "minecraft:emerald_block", "minecraft:diamond_block"
                     }
                  )
               ),
               Fx.xpOrbs(100, 50, 8.0),
               Fx.effectArea("minecraft:luck|minecraft:regeneration", 0, 6000, 16.0),
               Fx.sequence(5, new Fx[]{Fx.sound("beacon", 10.0F, 1.0F), Fx.sound("beacon", 10.0F, 1.5F), Fx.sound("beacon", 10.0F, 2.0F)})
            }
         ),
         Category.FAMILY_FRIENDLY,
         1
      );
      var0.add(
         "kaboom_tnt",
         "Kaboom TNT",
         100,
         Fx.all(
            new Fx[]{
               Fx.pattern(
                  "X.X..X..XX...XX...XX..X...X/X.X.X.X.X.X.X..X.X..X.XX.XX/XX..XXX.XX..X..X.X..X.X.X.X/X.X.X.X.X.X.X..X.X..X.X...X/X.X.X.X.XX...XX...XX..X...X",
                  4.0,
                  4,
                  Fx.mega(5)
               ),
               Fx.delay(30, Fx.all(new Fx[]{Fx.mega(26), Fx.fling(30.0, 2.5, true), Fx.sound("boom", 24.0F, 0.6F)}))
            }
         ),
         Category.INDUSTRIAL,
         22
      );
      var0.add(
         "wide_tnt",
         "Wide TNT",
         100,
         Fx.all(new Fx[]{Fx.blast(Spec.of(70).shape(Shape.PANCAKE).ragged(0.15F)), Fx.line(15, 10.0, Fx.mega(8)), Fx.sound("boom", 16.0F, 0.6F)}),
         Category.INDUSTRIAL,
         26
      );
      var0.add(
         "big_tnt",
         "BIG TNT",
         120,
         Fx.all(
            new Fx[]{
               Fx.mega(60),
               Fx.column(6, 16.0, 6, Fx.mega(24)),
               Fx.column(4, -14.0, 6, Fx.mega(20)),
               Fx.sound("boom", 32.0F, 0.5F),
               Fx.delay(30, Fx.sound("sonic", 24.0F, 0.6F))
            }
         ),
         Category.HEAVY_ORDNANCE,
         42
      );
      var0.add(
         "greeny_tnt",
         "Greeny TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.vanilla(2.0F, false),
               Fx.coat(
                  32,
                  Pal.mix(
                     new String[]{
                        "minecraft:green_concrete|minecraft:lime_wool",
                        "minecraft:lime_wool",
                        "minecraft:moss_block|minecraft:lime_wool",
                        "minecraft:grass_block|minecraft:lime_wool"
                     }
                  )
               ),
               Fx.grow(4, Shape.DOME, Pal.of("minecraft:slime_block")),
               Fx.mobs("minecraft:slime", 8, 14.0),
               Fx.delay(60, Fx.mobs("minecraft:creeper", 4, 18.0))
            }
         ),
         Category.FAMILY_FRIENDLY,
         2
      );
      var0.add(
         "alpha_tnt",
         "Alpha TNT",
         90,
         Fx.all(
            new Fx[]{
               Fx.mega(14),
               Fx.coat(30, Pal.mix(new String[]{"minecraft:cobblestone", "minecraft:mossy_cobblestone|minecraft:stone", "minecraft:gravel"})),
               Fx.delay(20, Fx.build(Build.HOUSE, 1)),
               Fx.mobs("minecraft:wolf", 10, 14.0),
               Fx.sound("sonic", 10.0F, 1.2F)
            }
         ),
         Category.INDUSTRIAL,
         8
      );
      var0.add(
         "ring_tnt",
         "Ring TNT",
         90,
         Fx.all(
            new Fx[]{
               Fx.ring(24, 30.0, Fx.mega(10)),
               Fx.delay(20, Fx.ring(12, 18.0, Fx.mega(7))),
               Fx.delay(40, Fx.ring(36, 44.0, Fx.mega(8))),
               Fx.sequence(20, new Fx[]{Fx.sound("boom", 12.0F, 0.8F), Fx.sound("boom", 12.0F, 1.0F), Fx.sound("boom", 12.0F, 0.6F)})
            }
         ),
         Category.INDUSTRIAL,
         22
      );
      var0.add(
         "firey_tnt",
         "Firey TNT",
         90,
         Fx.all(
            new Fx[]{
               Fx.mega(20, 0.8F),
               Fx.spiral(40, 44.0, 3.0, 2, Fx.mega(6, 0.9F)),
               Fx.blast(Spec.of(36).replace(Replace.AIR).ignite(20).knockback(0.0).silent()),
               Fx.mobs("minecraft:blaze", 6, 14.0),
               Fx.delay(40, Fx.ring(8, 30.0, Fx.mega(10, 0.9F))),
               Fx.repeat(5, 30, Fx.all(new Fx[]{Fx.sound("lava", 16.0F, 0.6F), Fx.sound("boom", 12.0F, 0.8F)}))
            }
         ),
         Category.HEAVY_ORDNANCE,
         28
      );
   }

   private static void defineExpansion410(Tnts var0) {
      var0.add(
         "cross_tnt",
         "Cross TNT",
         80,
         Fx.all(new Fx[]{Fx.mega(12), Fx.delay(10, Fx.cross(6, 6.0, Fx.mega(6))), Fx.sound("boom", 10.0F, 0.8F)}),
         Category.INDUSTRIAL,
         14
      );
      var0.add(
         "checkerboard_tnt",
         "Checkerboard TNT",
         90,
         Fx.all(new Fx[]{Fx.grid(5, 9.0, Fx.mega(5)), Fx.delay(20, Fx.grid(4, 9.0, Fx.at(4.5, 0.0, 4.5, Fx.mega(5)))), Fx.sound("boom", 12.0F, 0.7F)}),
         Category.INDUSTRIAL,
         18
      );
      var0.add(
         "ripple_tnt",
         "Ripple TNT",
         90,
         Fx.all(new Fx[]{Fx.mega(10), Fx.wave(7, 6.0, 6, Fx.mega(4)), Fx.repeat(4, 10, Fx.sound("boom", 8.0F, 1.2F))}),
         Category.INDUSTRIAL,
         20
      );
      var0.add(
         "geyser_tnt",
         "Geyser TNT",
         90,
         Fx.all(
            new Fx[]{
               Fx.mega(10),
               Fx.terraform(8, Shape.CRATER, Pal.bowl("minecraft:water")),
               Fx.column(12, 5.0, 3, Fx.all(new Fx[]{Fx.mega(4), Fx.fling(6.0, 1.6, true)})),
               Fx.sequence(6, new Fx[]{Fx.sound("boom", 10.0F, 1.4F), Fx.sound("boom", 10.0F, 1.2F), Fx.sound("boom", 10.0F, 1.0F)})
            }
         ),
         Category.FAMILY_FRIENDLY,
         12
      );
      var0.add(
         "eclipse_tnt",
         "Eclipse TNT",
         120,
         Fx.all(
            new Fx[]{
               Fx.setTime(18000L),
               Fx.mega(18),
               Fx.effectArea("minecraft:blindness", 0, 200, 40.0),
               Fx.flyingMobs("minecraft:phantom", 6, 20.0, 14.0),
               Fx.sequence(10, new Fx[]{Fx.sound("thunder", 16.0F, 0.5F), Fx.sound("scream", 12.0F, 0.6F)})
            }
         ),
         Category.HEAVY_ORDNANCE,
         22
      );
      var0.add("chain_reaction_tnt", "Chain Reaction TNT", 80, Fx.all(new Fx[]{Fx.mega(8), Fx.chain("tnt_x5", 12, 14.0, 20, 70)}), Category.INDUSTRIAL, 24);
   }

   private static Fx sfx(String var0, String var1, float var2, float var3) {
      return Fx.sound("tntexpansion:" + var0 + "|" + var1, var2, var3);
   }

   private static int overhead(double var0) {
      return (int)Math.round((var0 + 100.0) * 134.0 / 200.0);
   }

   private static Fx plane() {
      return Fx.call("flyover", new Object[]{"c130", 100.0, 60.0, 134});
   }

   private static Fx warheadDrop(String var0, int var1, Fx var2) {
      return Fx.all(new Fx[]{Fx.call("drop", new Object[]{var0, 52.0, 0.0, var1}), Fx.delay(var1, var2)});
   }

   private static Fx airStrike(String var0, int var1, double var2, int var4, float var5) {
      ArrayList var6 = new ArrayList();
      var6.add(sfx("red_alert", "scream", 8.0F, 1.0F));

      for (int var7 = 0; var7 < var4; var7++) {
         int var8 = 20 + var7 * 80;
         double var9 = (var7 - (var4 - 1) / 2.0) * var2 * 2.0;
         var6.add(Fx.delay(var8, Fx.at(0.0, 0.0, var9, plane())));
         var6.add(Fx.delay(var8, sfx("air_strike", "launch", var5, 1.0F)));
         int var11 = 0;

         for (int var12 = 0; var12 < var1; var12++) {
            double var13 = (var12 - (var1 - 1) / 2.0) * var2;
            var11 = var8 + overhead(var13);
            var6.add(Fx.delay(var11, Fx.at(var13, 0.0, var9, Fx.rain(var0, 1, 1.0, 55.0, 60, 70))));
         }

         var6.add(Fx.delay(var11 + 60, sfx("big_explosion", "boom", var5, 0.9F)));
      }

      return Fx.all(var6.toArray(new Fx[0]));
   }

   private static void defineExpansion412(Tnts var0) {
      var0.add("air_strike_tnt", "Air Strike TNT", 100, airStrike("tnt_x500", 12, 9.0, 1, 24.0F), Category.HEAVY_ORDNANCE, 90);
      ArrayList var1 = new ArrayList();
      var1.add(sfx("reactor_alarm", "beacon", 10.0F, 1.0F));
      var1.add(Fx.delay(30, plane()));
      var1.add(Fx.delay(30, sfx("air_strike", "launch", 32.0F, 0.9F)));

      for (double var5 : new double[]{-55.0, 0.0, 55.0}) {
         var1.add(
            Fx.delay(
               30 + overhead(var5),
               Fx.at(var5, 0.0, 0.0, warheadDrop("nuke_warhead", 35, Fx.all(new Fx[]{Fx.nuke(70, 120), sfx("nuclear_explosion", "boom", 40.0F, 1.0F)})))
            )
         );
      }

      var1.add(Fx.delay(30 + overhead(55.0) + 40, nukeRoar(40.0F)));
      var0.add("nuclear_strike_tnt", "Nuclear Strike TNT", 120, Fx.all(var1.toArray(new Fx[0])), Category.WORLD_BUSTER, 190);
      var0.add(
         "massive_air_strike_tnt",
         "Massive Air Strike TNT",
         120,
         Fx.all(new Fx[]{airStrike("tnt_x1000", 16, 11.0, 3, 40.0F), Fx.delay(300, sfx("huge_explosion", "thunder", 40.0F, 0.8F))}),
         Category.WORLD_BUSTER,
         220
      );
      var0.add(
         "astronomical_impact_tnt",
         "Massive Astronomical Impact TNT",
         140,
         Fx.all(
            new Fx[]{
               sfx("red_alert", "scream", 10.0F, 0.8F),
               Fx.call("drop", new Object[]{"meteor", 130.0, 70.0, 60}),
               Fx.delay(60, Fx.all(new Fx[]{Fx.shatter(Fx.mega(150)), Fx.earthquake(140, 200), sfx("huge_explosion", "boom", 48.0F, 0.6F), nukeRoar(48.0F)})),
               Fx.delay(140, Fx.repeat(12, 25, Fx.meteorStorm(6, 150.0, 10)))
            }
         ),
         Category.WORLD_BUSTER,
         260
      );
      var0.add(
         "the_big_one_tnt",
         "The Big One TNT",
         40,
         Fx.all(
            new Fx[]{
               Fx.call("giant", new Object[]{"big_one", 100}),
               Fx.repeat(5, 20, Fx.sound("launch", 6.0F, 0.5F)),
               Fx.delay(
                  100,
                  Fx.all(
                     new Fx[]{
                        Fx.mega(160),
                        Fx.fling(90.0, 4.0, true),
                        Fx.delay(10, Fx.chain("tnt_x1000", 80, 200.0, 40, 220)),
                        sfx("huge_explosion", "boom", 48.0F, 0.5F),
                        Fx.delay(30, nukeRoar(48.0F))
                     }
                  )
               )
            }
         ),
         Category.WORLD_BUSTER,
         340
      );
      var0.add(
         "antimatter_bomb_tnt",
         "Catastrophic Hydrogenated Antimatter Bomb",
         100,
         Fx.all(
            new Fx[]{
               sfx("reactor_alarm", "beacon", 16.0F, 0.8F),
               Fx.call("drop", new Object[]{"antimatter_warhead", 110.0, 0.0, 70}),
               Fx.delay(
                  70,
                  Fx.all(
                     new Fx[]{
                        Fx.shatter(Fx.nuke(210, 1200)),
                        Fx.mushroomCloud(),
                        Fx.storm(true, 12000),
                        sfx("brutal_nuke", "boom", 64.0F, 1.0F),
                        Fx.delay(20, sfx("nuclear_explosion", "thunder", 64.0F, 0.7F))
                     }
                  )
               ),
               Fx.delay(110, Fx.fallout(280, 1200)),
               Fx.delay(210, Fx.all(new Fx[]{Fx.mega(200), nukeRoar(64.0F)}))
            }
         ),
         Category.WORLD_BUSTER,
         450
      );
      var0.add(
         "fatal_cataclysm_tnt",
         "Fatal Astronomic Dimensional Existing Cataclysm Brutal TNT",
         200,
         Fx.all(
            new Fx[]{
               Fx.setTime(18000L),
               Fx.storm(true, 24000),
               sfx("red_alert", "scream", 16.0F, 0.7F),
               Fx.delay(40, sfx("reactor_alarm", "beacon", 16.0F, 0.6F)),
               Fx.call("drop", new Object[]{"meteor", 130.0, 70.0, 60}),
               Fx.delay(60, Fx.all(new Fx[]{Fx.shatter(Fx.mega(120)), sfx("huge_explosion", "boom", 64.0F, 0.6F)})),
               Fx.delay(
                  90,
                  Fx.at(70.0, 0.0, 50.0, Fx.all(new Fx[]{Fx.call("drop", new Object[]{"meteor", 130.0, 70.0, 60}), Fx.delay(60, Fx.shatter(Fx.mega(110)))}))
               ),
               Fx.delay(
                  180,
                  Fx.at(-60.0, 0.0, -70.0, Fx.all(new Fx[]{Fx.call("drop", new Object[]{"meteor", 130.0, 70.0, 60}), Fx.delay(60, Fx.shatter(Fx.mega(110)))}))
               ),
               Fx.delay(60, Fx.repeat(12, 30, Fx.all(new Fx[]{Fx.meteorStorm(14, 260.0, 24), sfx("huge_explosion", "boom", 64.0F, 0.6F)}))),
               Fx.delay(120, Fx.repeat(8, 45, Fx.cometStorm(10, 260.0, 20))),
               Fx.delay(300, Fx.all(new Fx[]{Fx.shatter(Fx.nuke(220, 1200)), sfx("brutal_nuke", "sonic", 64.0F, 0.8F)})),
               Fx.delay(500, Fx.all(new Fx[]{Fx.shatter(Fx.mega(200)), nukeRoar(64.0F)}))
            }
         ),
         Category.WORLD_BUSTER,
         666
      );
      var0.add(
         "bunker_buster_tnt",
         "Bunker Buster TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.call("drop", new Object[]{"warhead", 60.0, 0.0, 25}),
               Fx.delay(25, Fx.all(new Fx[]{Fx.shatter(Fx.column(18, -6.0, 4, Fx.mega(9))), sfx("big_explosion", "boom", 16.0F, 1.0F)}))
            }
         ),
         Category.HEAVY_ORDNANCE,
         60
      );
      var0.add(
         "mirv_tnt",
         "MIRV Nuke TNT",
         140,
         Fx.all(
            new Fx[]{
               sfx("reactor_alarm", "beacon", 12.0F, 1.1F),
               Fx.delay(30, sfx("air_strike", "launch", 32.0F, 1.2F)),
               Fx.delay(40, Fx.ring(8, 110.0, Fx.all(new Fx[]{Fx.call("drop", new Object[]{"warhead", 70.0, 0.0, 40}), Fx.delay(40, Fx.nuke(55, 120))}))),
               Fx.delay(
                  60,
                  Fx.all(
                     new Fx[]{
                        Fx.call("drop", new Object[]{"nuke_warhead", 70.0, 0.0, 40}),
                        Fx.delay(40, Fx.all(new Fx[]{Fx.nuke(100, 240), sfx("nuclear_explosion", "boom", 48.0F, 0.9F)}))
                     }
                  )
               )
            }
         ),
         Category.WORLD_BUSTER,
         240
      );
      var0.add(
         "artillery_barrage_tnt",
         "Artillery Barrage TNT",
         100,
         Fx.all(
            new Fx[]{
               sfx("red_alert", "scream", 8.0F, 1.2F),
               Fx.delay(
                  30,
                  Fx.repeat(10, 20, Fx.all(new Fx[]{Fx.scatter(6, 70.0, Fx.rain("tnt_x100", 1, 1.0, 60.0, 55, 65)), sfx("big_explosion", "boom", 24.0F, 1.1F)}))
               )
            }
         ),
         Category.HEAVY_ORDNANCE,
         110
      );
   }

   private static void defineExpansion411(Tnts var0) {
      var0.add(
         "labyrinth_tnt",
         "Labyrinth TNT",
         100,
         Fx.all(
            new Fx[]{
               Fx.pattern(
                  "XXXXXXXXXXX/X...X.....X/X.X.X.XXX.X/X.X...X...X/X.XXXXX.XXX/X.....X...X/XXX.X.XXX.X/X...X...X.X/X.XXXXX.X.X/X.......X.X/XXXXXXXXXXX",
                  4.0,
                  3,
                  Fx.mega(3)
               ),
               Fx.repeat(4, 8, Fx.sound("boom", 8.0F, 1.3F))
            }
         ),
         Category.INDUSTRIAL,
         22
      );
      var0.add(
         "smiley_tnt",
         "Smiley TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.pattern("..XXXXX../.X.....X./X..X.X..X/X.......X/X.X...X.X/X..XXX..X/.X.....X./..XXXXX..", 5.0, 2, Fx.mega(4)),
               Fx.sequence(8, new Fx[]{Fx.sound("boom", 10.0F, 1.6F), Fx.sound("splash", 6.0F, 1.8F)})
            }
         ),
         Category.FAMILY_FRIENDLY,
         12
      );
      Fx[] var1 = new Fx[17];

      for (int var2 = 0; var2 < 16; var2++) {
         var1[var2] = Fx.delay(var2 * 4, Fx.at(var2 * 5.0, 0.0, 0.0, Fx.all(new Fx[]{Fx.mega(4), Fx.sound("boom", 6.0F, 0.9F + var2 * 0.06F)})));
      }

      var1[16] = Fx.delay(70, Fx.at(80.0, 0.0, 0.0, Fx.mega(10)));
      var0.add("domino_tnt", "Domino TNT", 80, Fx.all(var1), Category.INDUSTRIAL, 18);
      var0.add(
         "thunderdome_tnt",
         "Thunderdome TNT",
         100,
         Fx.all(
            new Fx[]{
               Fx.mega(6),
               Fx.terraform(18, Shape.DOME, Pal.of("minecraft:glass")),
               Fx.storm(true, 1200),
               Fx.repeat(10, 12, Fx.lightning(4, 14.0)),
               Fx.sequence(12, new Fx[]{Fx.sound("thunder", 16.0F, 0.6F), Fx.sound("thunder", 16.0F, 0.8F)})
            }
         ),
         Category.HEAVY_ORDNANCE,
         20
      );
      var0.add(
         "pyramid_tnt",
         "Pyramid TNT",
         100,
         Fx.all(
            new Fx[]{
               Fx.mega(8),
               Fx.delay(10, Fx.grow(22, Shape.CONE, Pal.layered("minecraft:sandstone", "minecraft:sandstone", "minecraft:gold_block"))),
               Fx.delay(30, Fx.at(0.0, 3.0, 0.0, Fx.mega(4))),
               Fx.sequence(10, new Fx[]{Fx.sound("boom", 12.0F, 0.6F), Fx.sound("beacon", 10.0F, 0.8F)})
            }
         ),
         Category.FAMILY_FRIENDLY,
         16
      );
      var0.add(
         "ice_spikes_tnt",
         "Ice Spikes TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.mega(7),
               Fx.terraform(16, Shape.PANCAKE, Pal.of("minecraft:snow_block")),
               Fx.scatter(9, 14.0, Fx.grow(5, Shape.CONE, Pal.of("minecraft:packed_ice"))),
               Fx.effectArea("minecraft:slowness", 3, 300, 20.0),
               Fx.sound("splash", 10.0F, 0.5F)
            }
         ),
         Category.FAMILY_FRIENDLY,
         14
      );
      var0.add(
         "vortex_tnt",
         "Vortex TNT",
         100,
         Fx.all(
            new Fx[]{
               Fx.spiral(24, 22.0, 3.0, 2, Fx.mega(4)),
               Fx.delay(50, Fx.all(new Fx[]{Fx.mega(12), Fx.fling(24.0, 2.2, true)})),
               Fx.repeat(6, 8, Fx.sound("sonic", 8.0F, 1.4F))
            }
         ),
         Category.HEAVY_ORDNANCE,
         22
      );
      var0.add(
         "ninja_tnt",
         "Ninja TNT",
         60,
         Fx.all(
            new Fx[]{
               Fx.mega(3),
               Fx.effectArea("minecraft:blindness", 0, 100, 16.0),
               Fx.effectArea("minecraft:invisibility", 0, 400, 16.0),
               Fx.teleport(16.0, 20.0),
               Fx.delay(20, Fx.scatter(6, 18.0, Fx.mega(3))),
               Fx.sound("teleport", 10.0F, 1.2F)
            }
         ),
         Category.FAMILY_FRIENDLY,
         10
      );
   }

   private static void defineExpansion51(Tnts var0) {
      var0.add(
         "spider_nest_tnt",
         "Spider Nest TNT",
         60,
         Fx.all(new Fx[]{Fx.mega(3), Fx.coat(10, Pal.of("minecraft:cobweb")), Fx.delay(10, Fx.mobs("minecraft:cave_spider", 8, 8.0))}),
         Category.FAMILY_FRIENDLY,
         12
      );
      var0.add(
         "honey_trap_tnt",
         "Honey Trap TNT",
         60,
         Fx.all(
            new Fx[]{
               Fx.mega(2),
               Fx.coat(9, Pal.of("minecraft:honey_block")),
               Fx.effectArea("minecraft:slowness", 2, 200, 12.0),
               Fx.delay(10, Fx.flyingMobs("minecraft:bee", 6, 8.0, 4.0))
            }
         ),
         Category.FAMILY_FRIENDLY,
         12
      );
      var0.add(
         "frost_nova_tnt",
         "Frost Nova TNT",
         80,
         Fx.all(
            new Fx[]{
               Fx.mega(4),
               Fx.delay(6, Fx.ring(12, 10.0, Fx.mega(3))),
               Fx.delay(12, Fx.terraform(14, Shape.PANCAKE, Pal.of("minecraft:packed_ice"))),
               Fx.effectArea("minecraft:slowness", 3, 300, 18.0),
               Fx.sound("splash", 10.0F, 0.6F)
            }
         ),
         Category.HEAVY_ORDNANCE,
         16
      );
      var0.add(
         "iron_guard_tnt",
         "Iron Guard TNT",
         60,
         Fx.all(new Fx[]{Fx.mega(2), Fx.delay(10, Fx.mobs("minecraft:iron_golem", 3, 5.0))}),
         Category.FAMILY_FRIENDLY,
         8
      );
      var0.add(
         "trampoline_tnt",
         "Trampoline TNT",
         60,
         Fx.all(new Fx[]{Fx.fling(14.0, 1.8, true), Fx.terraform(5, Shape.PANCAKE, Pal.of("minecraft:slime_block")), Fx.sound("boom", 6.0F, 1.8F)}),
         Category.FAMILY_FRIENDLY,
         8
      );
      var0.add(
         "moat_tnt",
         "Moat TNT",
         100,
         Fx.all(new Fx[]{Fx.mega(8), Fx.delay(20, Fx.terraform(20, Shape.RING, Pal.of("minecraft:lava")))}),
         Category.INDUSTRIAL,
         20
      );
   }

   private static Fx beam(double var0, int var2, double var3, int var5, Fx var6) {
      double var7 = Math.toRadians(var0);
      Fx[] var9 = new Fx[var2];

      for (int var10 = 0; var10 < var2; var10++) {
         double var11 = (var10 + 1) * var3;
         var9[var10] = Fx.delay(var10 * var5, Fx.at(Math.cos(var7) * var11, 0.0, Math.sin(var7) * var11, var6));
      }

      return Fx.all(var9);
   }

   private static Fx giantMeteor(double var0, double var2, int var4) {
      return Fx.at(var0, 0.0, var2, Fx.all(new Fx[]{Fx.call("drop", new Object[]{"meteor", 130.0, 70.0, 60}), Fx.delay(60, Fx.shatter(Fx.mega(var4)))}));
   }

   private static Fx eardrums(int var0, float var1) {
      return Fx.repeat(var0, 6, Fx.all(new Fx[]{sfx("eardrum_burst", "boom", 64.0F, var1), Fx.sound("thunder", 64.0F, 0.5F)}));
   }

   private static void defineExpansion52(Tnts var0) {
      ArrayList var1 = new ArrayList();
      var1.add(sfx("reactor_alarm", "beacon", 16.0F, 1.4F));
      var1.add(
         Fx.delay(
            40,
            Fx.all(new Fx[]{Fx.setTime(6000L), Fx.shatter(Fx.mega(110)), Fx.fling(140.0, 3.0, true), sfx("brutal_nuke", "boom", 64.0F, 1.1F), nukeRoar(64.0F)})
         )
      );

      for (int var2 = 0; var2 < 4; var2++) {
         var1.add(
            Fx.delay(
               70 + var2 * 35, Fx.all(new Fx[]{Fx.ring(14, 125.0 + var2 * 30.0, Fx.mega(14, 0.3F)), sfx("huge_explosion", "boom", 64.0F, 0.9F - var2 * 0.1F)})
            )
         );
      }

      var1.add(Fx.delay(240, Fx.all(new Fx[]{Fx.mega(150, 0.3F), Fx.fling(200.0, 4.0, true), nukeRoar(64.0F)})));
      var0.add("hypernova_tnt", "Hypernova TNT", 160, Fx.all(var1.toArray(new Fx[0])), Category.WORLD_BUSTER, 520);
      ArrayList var13 = new ArrayList();
      var13.add(Fx.setTime(18000L));
      var13.add(Fx.storm(true, 2400));
      var13.add(Fx.mega(40));
      var13.add(sfx("cosmic_drone", "sonic", 48.0F, 1.2F));

      for (int var3 = 0; var3 < 6; var3++) {
         var13.add(
            Fx.delay(
               10 + var3 * 25,
               Fx.all(
                  new Fx[]{
                     beam(var3 * 60.0 + 15.0, 18, 9.0, 2, Fx.shatter(Fx.column(3, -7.0, 1, Fx.mega(6)))),
                     beam(var3 * 60.0 + 15.0, 6, 27.0, 6, Fx.lightning(1, 2.0)),
                     Fx.sound("sonic", 32.0F, 1.6F)
                  }
               )
            )
         );
      }

      var13.add(Fx.delay(170, Fx.repeat(5, 30, Fx.rain("tnt_x1000", 3, 130.0, 70.0, 60, 80))));
      var0.add("gamma_ray_burst_tnt", "Gamma Ray Burst TNT", 140, Fx.all(var13.toArray(new Fx[0])), Category.WORLD_BUSTER, 480);
      ArrayList var14 = new ArrayList();
      var14.add(Fx.mega(18));

      for (int var4 = 0; var4 < 16; var4++) {
         var14.add(
            Fx.delay(
               var4 * 8,
               Fx.all(
                  new Fx[]{
                     beam(var4 * 45.0, 6, 8.0, 0, Fx.mega(5)), beam(var4 * 45.0 + 180.0, 6, 8.0, 0, Fx.mega(5)), Fx.sound("sonic", 12.0F, 1.0F + var4 * 0.05F)
                  }
               )
            )
         );
      }

      var14.add(Fx.delay(140, Fx.all(new Fx[]{Fx.mega(30), Fx.sound("boom", 24.0F, 0.7F)})));
      var0.add("pulsar_tnt", "Pulsar TNT", 120, Fx.all(var14.toArray(new Fx[0])), Category.HEAVY_ORDNANCE, 160);
      var0.add(
         "magnetar_tnt",
         "Magnetar TNT",
         120,
         Fx.all(
            new Fx[]{
               Fx.mega(25),
               Fx.storm(true, 1200),
               Fx.repeat(6, 20, Fx.fling(45.0, 2.5, true)),
               Fx.repeat(12, 10, Fx.lightning(5, 45.0)),
               Fx.delay(15, Fx.teleport(40.0, 30.0)),
               Fx.delay(30, Fx.collapse(26, 900, 1.4)),
               Fx.effectArea("minecraft:nausea", 1, 300, 45.0),
               Fx.repeat(6, 20, Fx.sound("beacon", 16.0F, 0.6F))
            }
         ),
         Category.HEAVY_ORDNANCE,
         140
      );
      ArrayList var15 = new ArrayList();
      var15.add(sfx("red_alert", "scream", 12.0F, 1.1F));

      for (int var5 = 0; var5 < 10; var5++) {
         double var6 = 75.0 - var5 * 7.5;
         var15.add(
            Fx.delay(
               var5 * 6,
               Fx.all(
                  new Fx[]{Fx.at(var6, 0.0, var5 * 3.0, Fx.mega(9)), Fx.at(-var6, 0.0, -var5 * 3.0, Fx.mega(9)), Fx.sound("sonic", 16.0F, 0.8F + var5 * 0.08F)}
               )
            )
         );
      }

      var15.add(
         Fx.delay(62, Fx.all(new Fx[]{Fx.shatter(Fx.mega(130)), Fx.fling(150.0, 3.5, true), sfx("huge_explosion", "boom", 64.0F, 0.7F), nukeRoar(64.0F)}))
      );
      var15.add(Fx.delay(80, Fx.ring(10, 95.0, Fx.rain("tnt_x500", 1, 1.0, 50.0, 40, 60))));
      var15.add(Fx.delay(150, Fx.scatter(24, 70.0, Fx.grow(2, Shape.SPHERE, Pal.of("minecraft:gold_block")))));
      var0.add("neutron_star_collision_tnt", "Neutron Star Collision TNT", 140, Fx.all(var15.toArray(new Fx[0])), Category.WORLD_BUSTER, 380);
      var0.add(
         "red_giant_tnt",
         "Red Giant TNT",
         140,
         Fx.all(
            new Fx[]{
               Fx.setTime(12800L),
               Fx.sequence(
                  25,
                  new Fx[]{
                     Fx.grow(6, Shape.SPHERE, Pal.of("minecraft:magma_block")),
                     Fx.grow(10, Shape.SPHERE, Pal.of("minecraft:magma_block")),
                     Fx.grow(14, Shape.SPHERE, Pal.of("minecraft:magma_block"))
                  }
               ),
               Fx.repeat(4, 25, Fx.sound("lava", 24.0F, 0.5F)),
               Fx.delay(100, Fx.all(new Fx[]{Fx.mega(95, 0.6F), Fx.fling(100.0, 2.5, true), sfx("huge_explosion", "boom", 64.0F, 0.6F)})),
               Fx.delay(130, Fx.terraform(70, Shape.PANCAKE, Pal.bowl("minecraft:lava"), 0.4F)),
               Fx.delay(130, Fx.effectArea("minecraft:wither", 1, 400, 90.0))
            }
         ),
         Category.WORLD_BUSTER,
         300
      );
      var0.add(
         "dark_matter_tnt",
         "Dark Matter TNT",
         120,
         Fx.all(
            new Fx[]{
               Fx.effectArea("minecraft:darkness|minecraft:blindness", 0, 400, 70.0),
               Fx.delay(20, Fx.collapse(40, 2500, 0.6)),
               Fx.delay(40, Fx.blackHole(30, 100, 40)),
               Fx.delay(150, Fx.repeat(4, 10, Fx.scatter(4, 55.0, Fx.mega(11)))),
               Fx.delay(20, sfx("cosmic_drone", "sonic", 32.0F, 0.5F))
            }
         ),
         Category.HEAVY_ORDNANCE,
         200
      );
      var0.add(
         "wormhole_tnt",
         "Wormhole TNT",
         100,
         Fx.all(
            new Fx[]{
               Fx.blackHole(20, 120, 25),
               Fx.delay(20, Fx.teleport(40.0, 150.0)),
               Fx.repeat(6, 20, Fx.sound("teleport", 16.0F, 0.6F)),
               Fx.delay(120, Fx.at(0.0, 0.0, 150.0, Fx.all(new Fx[]{Fx.mega(30), Fx.fling(35.0, 3.0, true), Fx.sound("teleport", 32.0F, 1.4F)})))
            }
         ),
         Category.HEAVY_ORDNANCE,
         120
      );
      var0.add(
         "orbital_railgun_tnt",
         "Orbital Railgun TNT",
         100,
         Fx.all(
            new Fx[]{
               sfx("red_alert", "scream", 10.0F, 1.3F),
               Fx.delay(
                  20,
                  Fx.repeat(
                     8,
                     15,
                     Fx.scatter(1, 70.0, Fx.all(new Fx[]{Fx.shatter(Fx.column(8, -6.0, 1, Fx.mega(6))), Fx.lightning(1, 1.0), Fx.sound("sonic", 32.0F, 1.8F)}))
                  )
               ),
               Fx.delay(150, Fx.all(new Fx[]{Fx.shatter(Fx.column(20, -5.0, 1, Fx.mega(11))), Fx.lightning(3, 2.0), sfx("big_explosion", "boom", 48.0F, 0.8F)}))
            }
         ),
         Category.HEAVY_ORDNANCE,
         260
      );
      var0.add(
         "cosmic_storm_tnt",
         "Cosmic Storm TNT",
         120,
         Fx.all(
            new Fx[]{
               Fx.setTime(18000L),
               Fx.storm(true, 6000),
               Fx.mega(30),
               Fx.repeat(20, 15, Fx.lightning(8, 120.0)),
               Fx.delay(20, Fx.repeat(10, 30, Fx.meteorStorm(6, 140.0, 10))),
               Fx.delay(40, Fx.repeat(6, 50, Fx.cometStorm(5, 160.0, 14))),
               Fx.delay(40, Fx.at(60.0, 0.0, 0.0, Fx.tornado(20, 400))),
               Fx.delay(60, Fx.at(-60.0, 0.0, 30.0, Fx.tornado(20, 400))),
               Fx.repeat(10, 30, Fx.sound("thunder", 32.0F, 0.6F))
            }
         ),
         Category.WORLD_BUSTER,
         350
      );
      var0.add(
         "rogue_planet_tnt",
         "Rogue Planet TNT",
         160,
         Fx.all(
            new Fx[]{
               Fx.setTime(18000L),
               sfx("red_alert", "scream", 16.0F, 0.6F),
               Fx.call("drop", new Object[]{"meteor", 160.0, 0.0, 80}),
               Fx.delay(4, Fx.at(6.0, 0.0, 4.0, Fx.call("drop", new Object[]{"meteor", 160.0, 0.0, 76}))),
               Fx.delay(8, Fx.at(-5.0, 0.0, -6.0, Fx.call("drop", new Object[]{"meteor", 160.0, 0.0, 72}))),
               Fx.delay(80, Fx.all(new Fx[]{Fx.shatter(Fx.mega(180)), Fx.fling(220.0, 5.0, true), eardrums(3, 0.7F), nukeRoar(64.0F)})),
               Fx.delay(100, Fx.earthquake(200, 400)),
               Fx.delay(140, Fx.tsunami(120, 600)),
               Fx.delay(180, Fx.volcano(60, 600)),
               Fx.delay(200, Fx.fallout(250, 1200))
            }
         ),
         Category.WORLD_BUSTER,
         700
      );
      ArrayList var16 = new ArrayList();

      for (int var17 = 0; var17 < 12; var17++) {
         double var7 = Math.toRadians(var17 * 30.0 - 90.0);
         var16.add(
            Fx.delay(
               var17 * 20,
               Fx.all(new Fx[]{Fx.at(Math.cos(var7) * 40.0, 0.0, Math.sin(var7) * 40.0, Fx.mega(6)), Fx.sound("beacon", 32.0F, 0.5F + var17 * 0.1F)})
            )
         );
      }

      var16.add(Fx.delay(160, sfx("red_alert", "scream", 16.0F, 1.0F)));
      var16.add(
         Fx.delay(
            240,
            Fx.all(
               new Fx[]{
                  Fx.setTime(18000L), Fx.nuke(120, 600), Fx.mushroomCloud(), nukeRoar(64.0F), Fx.ring(12, 40.0, Fx.rain("tnt_x5000", 1, 1.0, 60.0, 40, 60))
               }
            )
         )
      );
      var0.add("doomsday_clock_tnt", "Doomsday Clock TNT", 100, Fx.all(var16.toArray(new Fx[0])), Category.WORLD_BUSTER, 400);
      var0.add(
         "big_bang_tnt",
         "Big Bang TNT",
         160,
         Fx.all(
            new Fx[]{
               Fx.setTime(18000L),
               Fx.effectArea("minecraft:blindness", 0, 90, 150.0),
               Fx.collapse(60, 4000, 0.5),
               Fx.blackHole(40, 80, 30),
               sfx("cosmic_drone", "sonic", 48.0F, 0.4F),
               Fx.delay(
                  90,
                  Fx.all(
                     new Fx[]{
                        Fx.setTime(6000L), Fx.shatter(Fx.mega(200)), Fx.fling(220.0, 5.0, true), sfx("brutal_nuke", "boom", 64.0F, 0.8F), eardrums(2, 1.0F)
                     }
                  )
               ),
               Fx.delay(160, Fx.scatter(4, 140.0, Fx.at(0.0, 60.0, 0.0, Fx.grow(9, Shape.SPHERE, Pal.of("minecraft:stone"))))),
               Fx.delay(180, Fx.scatter(3, 140.0, Fx.at(0.0, 70.0, 0.0, Fx.grow(7, Shape.SPHERE, Pal.of("minecraft:end_stone"))))),
               Fx.delay(200, Fx.scatter(3, 140.0, Fx.at(0.0, 55.0, 0.0, Fx.grow(8, Shape.SPHERE, Pal.of("minecraft:netherrack"))))),
               Fx.delay(220, Fx.at(0.0, 90.0, 0.0, Fx.grow(12, Shape.SPHERE, Pal.of("minecraft:glowstone"))))
            }
         ),
         Category.WORLD_BUSTER,
         900
      );
      var0.add(
         "brutal_entropy_cascade_tnt",
         "Brutal Entropy Cascade TNT",
         160,
         Fx.all(
            new Fx[]{
               Fx.setTime(18000L),
               Fx.storm(true, 12000),
               Fx.lightning(40, 70.0),
               Fx.repeat(90, 8, Fx.lightning(6, 160.0)),
               Fx.shatter(Fx.mega(165)),
               sfx("brutal_nuke", "boom", 64.0F, 0.9F),
               nukeRoar(64.0F),
               Fx.delay(
                  5,
                  Fx.ring(
                     5,
                     45.0,
                     Fx.all(
                        new Fx[]{
                           Fx.rain("tnt_x100", 1, 1.0, 25.0, 50, 50), Fx.delay(55, Fx.all(new Fx[]{Fx.mega(25), Fx.chain("tnt_x5000", 2, 220.0, 90, 110)}))
                        }
                     )
                  )
               ),
               Fx.delay(150, eardrums(6, 0.8F)),
               Fx.delay(175, eardrums(4, 0.6F))
            }
         ),
         Category.WORLD_BUSTER,
         1000
      );
      var0.add(
         "multiverse_collapse_tnt",
         "Multiverse Collapse TNT",
         200,
         Fx.all(
            new Fx[]{
               Fx.setTime(18000L),
               Fx.storm(true, 12000),
               sfx("red_alert", "scream", 16.0F, 0.7F),
               Fx.repeat(5, 60, sfx("cosmic_drone", "sonic", 64.0F, 0.5F)),
               Fx.delay(20, Fx.at(80.0, 0.0, 0.0, Fx.blackHole(45, 300, 60))),
               Fx.delay(40, Fx.at(-70.0, 0.0, 60.0, Fx.blackHole(45, 300, 60))),
               Fx.delay(60, Fx.at(0.0, 0.0, -90.0, Fx.blackHole(55, 300, 70))),
               Fx.delay(30, giantMeteor(40.0, 90.0, 100)),
               Fx.delay(120, giantMeteor(-90.0, -40.0, 100)),
               Fx.delay(200, giantMeteor(100.0, -80.0, 110)),
               Fx.delay(30, Fx.earthquake(200, 600)),
               Fx.delay(50, Fx.at(120.0, 0.0, 60.0, Fx.tornado(25, 500))),
               Fx.delay(70, Fx.at(-110.0, 0.0, -90.0, Fx.tornado(25, 500))),
               Fx.delay(90, Fx.at(20.0, 0.0, 140.0, Fx.tornado(25, 500))),
               Fx.delay(60, Fx.repeat(10, 40, Fx.meteorStorm(8, 200.0, 16))),
               Fx.delay(380, Fx.all(new Fx[]{Fx.shatter(Fx.mega(220)), Fx.fling(240.0, 5.0, true), nukeRoar(64.0F), eardrums(4, 0.6F)}))
            }
         ),
         Category.WORLD_BUSTER,
         1200
      );
      ArrayList var18 = new ArrayList();
      var18.add(Fx.setTime(18000L));
      var18.add(dread(64.0F));
      var18.add(Fx.blackHole(130, 300, 220));
      var18.add(Fx.repeat(5, 60, sfx("cosmic_drone", "sonic", 64.0F, 0.4F)));
      var18.add(Fx.repeat(14, 20, Fx.all(new Fx[]{Fx.mega(22), Fx.scatter(3, 40.0, Fx.mega(12))})));
      var18.add(Fx.effectArea("minecraft:slowness", 4, 300, 130.0));
      var18.add(
         Fx.delay(300, Fx.all(new Fx[]{Fx.mushroomCloud(), Fx.fling(200.0, 5.0, true), Fx.ring(12, 120.0, Fx.mega(30)), nukeRoar(64.0F), eardrums(5, 0.5F)}))
      );
      var0.add("ultra_singularity_tnt", "ULTRA HYPERMASSIVE SINGULARITY BLACK HOLE TNT", 200, Fx.all(var18.toArray(new Fx[0])), Category.WORLD_BUSTER, 2500);
      ArrayList var19 = new ArrayList();
      var19.add(Fx.setTime(18000L));
      var19.add(Fx.storm(true, 24000));
      var19.add(sfx("red_alert", "scream", 16.0F, 0.6F));
      var19.add(Fx.delay(40, sfx("reactor_alarm", "beacon", 16.0F, 0.5F)));
      var19.add(Fx.delay(20, plane()));
      var19.add(Fx.delay(20, sfx("air_strike", "launch", 48.0F, 0.8F)));

      for (double var11 : new double[]{-60.0, 0.0, 60.0}) {
         var19.add(
            Fx.delay(
               20 + overhead(var11),
               Fx.at(var11, 0.0, 30.0, warheadDrop("nuke_warhead", 35, Fx.all(new Fx[]{Fx.nuke(70, 120), sfx("nuclear_explosion", "boom", 64.0F, 0.9F)})))
            )
         );
      }

      var19.add(Fx.delay(60, giantMeteor(90.0, -70.0, 110)));
      var19.add(Fx.delay(120, giantMeteor(-100.0, 60.0, 110)));
      var19.add(Fx.delay(180, giantMeteor(30.0, 120.0, 110)));
      var19.add(Fx.delay(80, Fx.repeat(15, 25, Fx.all(new Fx[]{Fx.meteorStorm(10, 240.0, 18), Fx.lightning(6, 200.0)}))));
      var19.add(Fx.delay(120, Fx.repeat(8, 40, Fx.cometStorm(8, 240.0, 18))));
      var19.add(Fx.delay(100, Fx.earthquake(220, 800)));
      var19.add(Fx.delay(160, Fx.volcano(50, 800)));
      var19.add(Fx.delay(220, Fx.tsunami(100, 700)));
      var19.add(Fx.delay(150, Fx.repeat(6, 30, Fx.scatter(4, 200.0, Fx.rain("tnt_x1000", 1, 1.0, 70.0, 60, 80)))));
      var19.add(Fx.delay(200, Fx.ring(8, 130.0, warheadDrop("warhead", 40, Fx.nuke(50, 120)))));
      var19.add(
         Fx.delay(
            300,
            Fx.all(
               new Fx[]{
                  Fx.call("drop", new Object[]{"antimatter_warhead", 110.0, 0.0, 70}),
                  Fx.delay(70, Fx.all(new Fx[]{Fx.shatter(Fx.nuke(180, 1200)), Fx.mushroomCloud(), sfx("brutal_nuke", "boom", 64.0F, 0.9F)}))
               }
            )
         )
      );
      var19.add(Fx.delay(560, Fx.all(new Fx[]{Fx.shatter(Fx.mega(240)), Fx.fling(260.0, 5.0, true), nukeRoar(64.0F), eardrums(6, 0.5F)})));
      var0.add("death_of_all_existence_tnt", "The Death of All Existence TNT", 240, Fx.all(var19.toArray(new Fx[0])), Category.WORLD_BUSTER, 5000);
      String[] var20 = new String[]{
         "apocalypse_tnt",
         "doomsday_tnt",
         "armageddon_tnt",
         "extinction_tnt",
         "world_destroyer_tnt",
         "planet_destroyer_tnt",
         "dimension_destroyer_tnt",
         "reality_breaker_tnt",
         "end_of_the_world_tnt",
         "end_of_everything_tnt",
         "ultimate_tnt",
         "infinity_tnt",
         "god_tnt",
         "annihilation_tnt",
         "oblivion_tnt",
         "final_tnt",
         "the_last_tnt",
         "tnt_x25000",
         "map_destroyer_tnt",
         "error_404_tnt",
         "galaxy_destruction_tnt",
         "tsar_bomba_nuke",
         "tnt_x50000",
         "tnt_x75000",
         "tnt_x100000",
         "nuke_100x",
         "map_corruption_tnt",
         "tnt_world_destroyer",
         "nuclear_strike_tnt",
         "massive_air_strike_tnt",
         "astronomical_impact_tnt",
         "the_big_one_tnt",
         "antimatter_bomb_tnt",
         "fatal_cataclysm_tnt",
         "mirv_tnt",
         "hypernova_tnt",
         "gamma_ray_burst_tnt",
         "neutron_star_collision_tnt",
         "red_giant_tnt",
         "cosmic_storm_tnt",
         "rogue_planet_tnt",
         "doomsday_clock_tnt",
         "big_bang_tnt",
         "brutal_entropy_cascade_tnt",
         "multiverse_collapse_tnt",
         "ultra_singularity_tnt",
         "death_of_all_existence_tnt"
      };
      Fx[] var21 = new Fx[var20.length];

      for (int var22 = 0; var22 < var20.length; var22++) {
         var21[var22] = Fx.chain(var20[var22], 1, 260.0, 160, 180);
      }

      var0.add(
         "absolute_corruption_tnt",
         "THE ABSOLUTE CORRUPTION OF ALL EXISTENCE TNT",
         300,
         Fx.all(
            new Fx[]{
               Fx.setTime(18000L),
               Fx.storm(true, 48000),
               sfx("corruption_scream", "scream", 64.0F, 0.7F),
               dread(64.0F),
               Fx.effectArea("minecraft:darkness|minecraft:blindness", 0, 1200, 400.0),
               Fx.effectArea("minecraft:nausea", 2, 600, 400.0),
               Fx.effectArea("minecraft:wither", 4, 2400, 400.0),
               Fx.mega(60),
               Fx.delay(
                  10,
                  Fx.coat(
                     140,
                     Pal.mix(
                        new String[]{
                           "minecraft:netherrack",
                           "minecraft:obsidian",
                           "minecraft:soul_sand",
                           "minecraft:magma_block",
                           "minecraft:netherrack",
                           "minecraft:obsidian"
                        }
                     )
                  )
               ),
               Fx.delay(20, Fx.terraform(80, Shape.CRATER, Pal.DIMENSIONAL)),
               Fx.delay(30, Fx.mobs("minecraft:wither_skeleton", 16, 90.0)),
               Fx.delay(40, Fx.flyingMobs("minecraft:vex|minecraft:blaze", 12, 60.0, 8.0)),
               Fx.repeat(40, 10, Fx.lightning(8, 250.0)),
               Fx.repeat(6, 40, sfx("corruption_scream", "scream", 64.0F, 0.5F)),
               Fx.delay(40, Fx.all(var21)),
               Fx.delay(190, eardrums(8, 0.4F)),
               Fx.delay(
                  200, Fx.all(new Fx[]{Fx.shatter(Fx.mega(250)), Fx.chunkWipe(10), Fx.effectArea("minecraft:instant_damage", 20, 1, 500.0), nukeRoar(64.0F)})
               ),
               Fx.delay(420, Fx.error404())
            }
         ),
         Category.WORLD_BUSTER,
         1000000000
      );
   }
}
