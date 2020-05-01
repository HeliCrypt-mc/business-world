package fr.pokediamond.businessworld;

import org.bukkit.plugin.java.JavaPlugin;
import fr.pokediamond.businessworld.commands.CommandTest;
import fr.pokediamond.businessworld.commands.GameCommand;

public class Main extends JavaPlugin {
    
    @Override
    public void onEnable() {
        getLogger().info("Le plugin BusinessWorld vient de s'allumer");
        final CommandTest cmdTest = new CommandTest();
        getCommand("test").setExecutor(cmdTest);
        getCommand("alert").setExecutor(cmdTest);
        

        final GameCommand cmdGame = new GameCommand();
        getCommand("mine").setExecutor(cmdGame);
        getCommand("village").setExecutor(cmdGame);
        getCommand("moneygivechrono").setExecutor(cmdGame);
    }

    @Override
    public void onDisable() {
        getLogger().info("Le plugin BusinessWorld vient de s'eteindre");
    }
}
