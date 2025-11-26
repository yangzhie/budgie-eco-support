package org.yangzhie.budgieEcoSupport.utils;

import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.yangzhie.budgieEcoSupport.BudgieEcoSupport;

import java.util.logging.Level;

public class LogUtils {
    // Convert TC to text then log
    public static void log(Level level, Object message) {
        String text = switch (message) {
            case null -> null;
            case TextComponent tc -> PlainTextComponentSerializer.plainText().serialize(tc);
            case String s -> s;
            default -> String.valueOf(message);
        };

        if (text != null && !text.isBlank()) {
            BudgieEcoSupport.instance().getLogger().log(level, text);
        }
    }
}
