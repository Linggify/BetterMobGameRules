package com.github.linggify.minecraft.bettermobgamerules.gamerules;

import net.minecraft.world.level.GameRules;

/**
 * Baseclass for all custom game rules
 * @param <T>
 */
public class BetterMobGameRule<T extends GameRules.Value<T>> {

    private GameRules.Key<T> key;
    private final String target;
    private final GameRules.Category category;
    private final GameRules.Type<T> type;

    /**
     * Creates a new Gamerule with the given parameters
     * @param target
     * @param category
     * @param type
     */
    public BetterMobGameRule(String target, GameRules.Category category, GameRules.Type<T> type) {
        this.target = target;
        this.category = category;
        this.type = type;
    }

    public void register() {
        this.key = GameRules.register(this.target, this.category, this.type);
    }
}
