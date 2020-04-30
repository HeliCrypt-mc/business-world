package fr.pokediamond.businessworld.commands;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pokediamond.businessworld.Main;


public class GameCommand implements CommandExecutor {

    private final Mine mine;

    public GameCommand() {
        mine = new Mine(false, false);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return false;
        }
        final Player player = (Player) sender;
        
        if(cmd.getName().equalsIgnoreCase("mine")) {
            if(!(args.length == 1)) {
                player.sendMessage("§2[BusinessWorld] §eSyntaxe incorrecte");
                return true;

            } else {

                if(args[0].equalsIgnoreCase("p")) {
                    Location minep = new Location(Bukkit.getWorld("world"), 9973, 43, 9994);
                    mine.setMineP(true);
                    player.teleport(minep);
                    player.sendMessage("§2[BusinessWorld] §eVous venez d'etre teleporte a la mine des pauvres !");
                    player.sendMessage("§2[BusinessWorld] §3[Prix: 5$/min]");
                    Timer minepa = new Timer();
                    minepa.schedule(new TimerTask() {
                        
                        @Override
                        public void run() {
                            if(!mine.getMineP()) {
                                player.sendMessage("le timer s'est arrêté");
                                minepa.cancel();
                            }
                            Bukkit.dispatchCommand(player, "eco take " + player.getName() + " 5");
                            player.sendMessage("§2[BusinessWorld] §e5 dollars ont été envoyés a la banque pour le paiement de votre prochaine minute dans la mine.");
                            
                        }
                    }, 0, 1000*60);

                } else if(args[0].equalsIgnoreCase("r")) {
                    Location miner = new Location(Bukkit.getWorld("world"), 11000, 30, 11000);
                    mine.setMineR(true);
                    player.teleport(miner);
                    player.sendMessage("§2[BusinessWorld] §eVous venez d'etre teleporté la mine des riches !");
                    player.sendMessage("§2[BusinessWorld] §3[Prix: 25$/min]");
                    Timer minera = new Timer();
                    minera.schedule(new TimerTask() {
                        
                        @Override
                        public void run() {
                            if(!mine.getMineR()) {
                                player.sendMessage("le timer s'est arrêté");
                                minera.cancel();
                            }
                            Bukkit.dispatchCommand(player, "eco take " + player.getName() + " 25");
                            player.sendMessage("§2[BusinessWorld] §e25 dollars ont ete envoyes a la banque pour le paiement de votre prochaine minute dans la mine.");
                            
                            
                        }
                    }, 0, 1000*60);
                }
            }

        } else if(cmd.getName().equalsIgnoreCase("village")) {
            mine.setMineP(false);
            mine.setMineR(false);
            Location village = new Location(Bukkit.getWorld("world"), 73, 69, 72);
            player.teleport(village);
            player.sendMessage("§2[BusinessWorld] §eVous venez d'etre teleporté au village !");
            player.sendMessage("§2[BusinessWorld] §eVos paiements pour la visite de la mine ce sont arretes");
            return true;

        } else if(cmd.getName().equalsIgnoreCase("moneygivechrono")) {
            Timer moneygive = new Timer();
            moneygive.schedule(new TimerTask() {
                
                @Override
                public void run() {
                    Bukkit.dispatchCommand(player, "eco give * 100");
                }
            }, 10*60*1000, 10*60*1000); // 10 minutes
        }
        return false;
    }
}
