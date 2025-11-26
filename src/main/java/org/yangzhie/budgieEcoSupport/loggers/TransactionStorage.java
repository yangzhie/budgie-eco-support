package org.yangzhie.budgieEcoSupport.loggers;

import java.util.*;

public class TransactionStorage {
    private final Map<UUID, List<TransactionRecord>> data = new HashMap<>();

    // Add a transaction
    public void add(UUID owner, TransactionRecord record) {
        data.computeIfAbsent(owner, k -> new ArrayList<>()).add(record);
    }

    // Get all transactions for a player
    public List<TransactionRecord> get(UUID owner) {
        return data.getOrDefault(owner, new ArrayList<>());
    }

    // Save/load from JSON
    public Map<UUID, List<TransactionRecord>> getAll() {
        return data;
    }
}
