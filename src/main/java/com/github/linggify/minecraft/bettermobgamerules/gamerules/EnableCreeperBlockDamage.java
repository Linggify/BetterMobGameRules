package com.github.linggify.minecraft.bettermobgamerules.gamerules;

import com.github.linggify.minecraft.bettermobgamerules.BetterMobGameRules;
import com.github.linggify.minecraft.bettermobgamerules.logic.Explosion_BetterMobGameRules;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Gamerule that allows/disallows creepers to destroy blocks
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = BetterMobGameRules.MODID)
public class EnableCreeperBlockDamage {

    public static final GameRules.Key<GameRules.BooleanValue> RULE_CREEPER_BLOCK_DAMAGE_ENABLED;

    static {
        RULE_CREEPER_BLOCK_DAMAGE_ENABLED = GameRules.register("allowCreeperBlockDamage", GameRules.Category.MOBS, GameRules.BooleanValue.create(true));
    }

    @SubscribeEvent
    public static void onExplode(ExplosionEvent.Start event) {

        // If block damage is not allowed, change the explosion interaction type if exploder is a creeper
        if (!event.getLevel().getGameRules().getBoolean(RULE_CREEPER_BLOCK_DAMAGE_ENABLED)) {
            if (event.getExplosion().getExploder() instanceof Creeper) {
                ((Explosion_BetterMobGameRules) event.getExplosion()).betterMobGameRules$allowBlockInteraction(false);
            }
        }
    }
}
