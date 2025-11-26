package org.yangzhie.budgieEcoSupport;

import org.bukkit.plugin.java.JavaPlugin;
import org.yangzhie.budgieEcoSupport.loggers.TransactionLogger;
import org.yangzhie.budgieEcoSupport.loggers.TransactionStorage;

public final class BudgieEcoSupport extends JavaPlugin {
    static BudgieEcoSupport budgieEcoSupportPlugin;
    private TransactionStorage transactionStorage;

    public static BudgieEcoSupport instance() {
        return BudgieEcoSupport.budgieEcoSupportPlugin;
    }

    @Override
    public void onEnable() {
        BudgieEcoSupport.budgieEcoSupportPlugin = this;

        // Pass storage into listener
        transactionStorage = new TransactionStorage();
        getServer().getPluginManager().registerEvents(
                new TransactionLogger(transactionStorage),
                this
        );
    }

    public TransactionStorage getTransactionStorage() {
        return transactionStorage;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
