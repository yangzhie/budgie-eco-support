package org.yangzhie.budgieEcoSupport.utils;

import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// Chat utils for player
public class ChatUtils {
    private final static String prefix = "&7[&aEco&fSupport&7]";

    // Overload
    public static void sendMessage(CommandSender sender, String message, boolean prefixShown) {
        TextComponent textComponent = toTextComponent(message);

        if (prefixShown) {
            textComponent = toTextComponent(prefix).append(textComponent);
        }

        sendComponent(sender, textComponent);
    }

    // Component message
    private static void sendComponent(CommandSender sender, TextComponent component) {
        if (sender instanceof Player player) { // Auto player creation (intf)
            player.sendMessage(component);
        } else {
            return; // TODO
        }
    }

    // Convert string to TextComponent + parse colors & hex
    public static TextComponent toTextComponent(String string) {
        TextComponent tc = LegacyComponentSerializer.builder().character('&').hexCharacter('#').build().deserialize(string);
        return tc;
    }
}
