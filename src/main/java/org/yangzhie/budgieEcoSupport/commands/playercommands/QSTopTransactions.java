package org.yangzhie.budgieEcoSupport.commands.playercommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.yangzhie.budgieEcoSupport.loggers.TransactionRecord;
import org.yangzhie.budgieEcoSupport.loggers.TransactionStorage;
import org.yangzhie.budgieEcoSupport.utils.ChatUtils;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class QSTopTransactions {
    int limit = 10;

    // Inject shared storage
    private final TransactionStorage storage;
    public QSTopTransactions(TransactionStorage storage) {
        this.storage = storage;
    }

    // QS Command
    public void qsTopTransactions(CommandSender sender) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return;
        } else {
            // Get UUID
            UUID owner = player.getUniqueId();

            // Get storage
            List<TransactionRecord> transactions = storage.get(owner);

            // Case: empty records
            if (transactions.isEmpty()) {
                player.sendMessage("You have no recorded transactions.");
                return;
            }

            // Sort transactions + display to player
            transactions.sort(Comparator.comparingDouble(transaction -> transaction.earned));
            for(int i = 0; i < 10; ++i) {
                TransactionRecord record = transactions.get(i);
                ChatUtils.sendMessage(sender, record.item, true);
            }
        }
    }
}
