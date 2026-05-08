package org.yuemi.commands;

import org.bukkit.plugin.java.JavaPlugin;
import org.yuemi.git.H2PasswordProvider;

public class CommandRegistrar {

    private final JavaPlugin plugin;

    public CommandRegistrar(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerAll() {
        try {
            H2PasswordProvider provider = new H2PasswordProvider(plugin.getDataFolder());
            String[] passwords = provider.getOrGeneratePasswords();
            String filePassword = passwords[0];
            String dbPassword = passwords[1];

            var gitCommand = plugin.getCommand("git");
            if (gitCommand == null) {
                throw new IllegalStateException("Command 'git' is missing from plugin.yml");
            }

            gitCommand.setExecutor(new GitRootCommand(plugin, filePassword, dbPassword));
            plugin.getLogger().info("Registered /git command.");
        } catch (Exception e) {
            plugin.getLogger().severe("Failed to initialize Git command: " + e.getMessage());
            throw new IllegalStateException("Git Craft startup failed", e);
        }
    }
}
