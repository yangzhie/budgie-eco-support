package org.yangzhie.budgieEcoSupport.loggers;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransactionLogger implements Listener {
    private TransactionStorage storage;

    public TransactionLogger(TransactionStorage storage) {
        this.storage = storage;
    }

    private Pattern transactionMessage = Pattern.compile(
            // Yes, the non-space between "purchased" and (\\d+) is intentional (plugin fault)
            "(.+) purchased(\\d+) (.+) from your shop and you earned \\$([0-9.]+) \\(\\$([0-9.]+) in taxes\\)"
    );

    @EventHandler
    public void chat(AsyncPlayerChatEvent event) {
        String rawChat = ChatColor.stripColor(event.getMessage());
        Matcher matcher = transactionMessage.matcher(rawChat);

        if (!matcher.find()) {
            return;
        } else {
            // Extract parts from transaction
            String buyer = matcher.group(1);
            int amount = Integer.parseInt(matcher.group(2));
            String item = matcher.group(3);
            double earned = Double.parseDouble(matcher.group(4));
            double tax = Double.parseDouble(matcher.group(5));

            // Log transaction into storage
            UUID owner = event.getPlayer().getUniqueId();
            storage.add(owner, new TransactionRecord(
                    buyer,
                    amount,
                    item,
                    earned,
                    tax,
                    System.currentTimeMillis()
            ));
        }
    }
}
