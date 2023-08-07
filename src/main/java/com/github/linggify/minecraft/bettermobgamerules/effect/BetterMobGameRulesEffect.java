package com.github.linggify.minecraft.bettermobgamerules.effect;

import com.github.linggify.minecraft.bettermobgamerules.gamerules.BetterMobGameRule;
import net.minecraft.world.level.GameRules;

public abstract class BetterMobGameRulesEffect<T, R> {

    private final boolean isEventListener;

    private final Class<T> dataClass;

    private final Class<R> ruleClass;

    /**
     * Creates a new BetterMobGameRulesEffect
     */
    public BetterMobGameRulesEffect(boolean isEventListener, Class<T> dataClass, Class<R> ruleClass) {
        this.isEventListener = isEventListener;
        this.dataClass = dataClass;
        this.ruleClass = ruleClass;
    }

    /**
     *
     * @return whether this effect must be registered as an event listener
     */
    public boolean isEventListener() {
        return this.isEventListener;
    }

    public T getConfigData() {
        return null;
    }

    public R getRulesData() {
        return null;
    }
}
