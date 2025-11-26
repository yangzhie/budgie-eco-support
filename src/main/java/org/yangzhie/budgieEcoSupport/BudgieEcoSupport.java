package org.yangzhie.budgieEcoSupport;

import org.bukkit.plugin.java.JavaPlugin;

public final class BudgieEcoSupport extends JavaPlugin {
    static BudgieEcoSupport budgieEcoSupportPlugin;

    public static BudgieEcoSupport instance() {
        return BudgieEcoSupport.budgieEcoSupportPlugin;
    }

    @Override
    public void onEnable() {
        BudgieEcoSupport.budgieEcoSupportPlugin = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
