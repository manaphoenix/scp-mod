package com.skythecodemaster.scp.common.datagen;

import com.skythecodemaster.scp.common.registry.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {
  public Recipes(DataGenerator generator) {
    super(generator);
  }

  @Override
  protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
    // Add shapeless scpenium.
    ShapelessRecipeBuilder.shapeless(ItemRegistry.SCPENIUM.get(),10)
      .requires(Tags.Items.INGOTS_IRON)
      .requires(Tags.Items.STORAGE_BLOCKS_IRON)
      .group("skysscp")
      .unlockedBy("has_item", has(Items.IRON_INGOT))
      .save(consumer);

    // Add old door recipe
    ShapedRecipeBuilder.shaped(ItemRegistry.LIGHT_DOOR_OLD_ITEM.get())
      .pattern("ii ")
      .pattern("si ")
      .pattern("ii ")
      .define('i', Tags.Items.INGOTS_IRON)
      .define('s', ItemRegistry.SCPENIUM.get())
      .group("skysscp")
      .unlockedBy("has_item", has(ItemRegistry.SCPENIUM.get()))
      .save(consumer);

  }
}
