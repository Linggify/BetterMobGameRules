package com.github.linggify.minecraft.bettermobgamerules.mixin;

import com.github.linggify.minecraft.bettermobgamerules.logic.Explosion_BetterMobGameRules;
import net.minecraft.world.level.Explosion;
import org.spongepowered.asm.mixin.*;

/**
 * Allow disabling block interaction for any interaction type
 */
@Mixin(Explosion.class)
public class ExplosionMixin implements Explosion_BetterMobGameRules {

    @Shadow @Final private Explosion.BlockInteraction blockInteraction;

    @Unique
    private boolean betterMobGameRules$allowBlockInteraction = true;

    public void betterMobGameRules$allowBlockInteraction(boolean flag) {
        this.betterMobGameRules$allowBlockInteraction = flag;
    }

    /**
     * @author linggify
     * @reason Allow disabling block interaction after explosion has been created
     */
    @Overwrite
    public boolean interactsWithBlocks() {
        return this.betterMobGameRules$allowBlockInteraction && this.blockInteraction != Explosion.BlockInteraction.KEEP;
    }
}
