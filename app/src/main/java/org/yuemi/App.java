package org.yuemi;

import org.bukkit.plugin.java.JavaPlugin;
import org.yuemi.commands.CommandRegistrar;
import org.bstats.bukkit.Metrics;

public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getLogger().info("Enabling Git Craft on " + getServer().getVersion() + " with Java " + System.getProperty("java.version") + ".");
        new CommandRegistrar(this).registerAll();
        setupMetrics();
        getLogger().info("Git Craft Plugin enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Git Craft Plugin disabled.");
    }

    private void setupMetrics() {
        int pluginId = 26264;
        Metrics metrics = new Metrics(this, pluginId);
    }
}
