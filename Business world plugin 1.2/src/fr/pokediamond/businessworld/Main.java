package fr.pokediamond.businessworld;

import org.bukkit.plugin.java.JavaPlugin;
import fr.pokediamond.businessworld.commands.CommandTest;
import fr.pokediamond.businessworld.commands.GameCommand;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("Le plugin BusinessWorld vient de s'allumer");
		getCommand("test").setExecutor(new CommandTest());
		getCommand("alert").setExecutor(new CommandTest());
		
		getCommand("mine").setExecutor(new GameCommand());
		getCommand("village").setExecutor(new GameCommand());
		getCommand("moneygivechrono").setExecutor(new GameCommand());
		
		
		
	}

	@Override
	public void onDisable() {
		System.out.println("Le plugin BusinessWorld vient de s'eteindre");
	}
}
