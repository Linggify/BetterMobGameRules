package com.github.linggify.minecraft.bettermobgamerules.gamerules;

import com.github.linggify.minecraft.bettermobgamerules.logic.Explosion_BetterMobGameRules;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = "bettermobgamerules")
public class EnableGhastBlockDamage {

    public static final GameRules.Key<GameRules.BooleanValue> RULE_GHAST_BLOCK_DAMAGE_ENABLED;

    static {
        RULE_GHAST_BLOCK_DAMAGE_ENABLED = GameRules.register("allowGhastBlockDamage", GameRules.Category.MOBS, GameRules.BooleanValue.create(true));
    }

    @SubscribeEvent
    public static void onExplode(ExplosionEvent.Start event) {
        // If block damage is not allowed, change the explosion interaction type if exploder is a ghast
        if (!event.getLevel().getGameRules().getBoolean(RULE_GHAST_BLOCK_DAMAGE_ENABLED)) {
            if (event.getExplosion().getExploder() instanceof LargeFireball) {
                LargeFireball fireball = (LargeFireball) event.getExplosion().getExploder();
                if (fireball.getOwner() instanceof Ghast) {
                    ((Explosion_BetterMobGameRules) event.getExplosion()).betterMobGameRules$allowBlockInteraction(false);
                }
            }
        }
    }
}
