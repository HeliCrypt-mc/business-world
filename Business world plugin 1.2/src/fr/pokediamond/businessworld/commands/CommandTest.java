package fr.pokediamond.businessworld.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(!(sender instanceof Player)) {
			return false;
		}
			Player player = (Player)sender;
			
			if(cmd.getName().equalsIgnoreCase("bw test")) {
				player.sendMessage("Bravo tu as reussi le test");
				return true;
			}
			if(cmd.getName().equalsIgnoreCase("bw alert")) {
				if(args.length == 0) {
					player.sendMessage("la commande est : /bw alert <message>");
				}else{
					StringBuilder bc = new StringBuilder();
					for(String part : args) {
						bc.append(part + " ");
					}
					Bukkit.broadcastMessage("[" + player.getName() + "] " + bc.toString());
				}
				return true;
			}
		return false;
	}
}
