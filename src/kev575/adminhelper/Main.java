package kev575.adminhelper;

import kev575.adminhelper.api.AdminHelperAPI;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("getip")) {
			if (args.length == 0) {
				if (sender instanceof Player) {
					Player p = (Player) sender;
					if (!p.hasPermission("adminhelper.getip")) {p.sendMessage("§cYou don't have the permission to do that.");return true;}
					p.sendMessage("§3IPv4 of §e" + p.getName() + "§8: §a" + new AdminHelperAPI(this).getIP(p));
				} else {
					sender.sendMessage("/getip <Player>");
				}
			} else if (args.length == 1) {
				if (!sender.hasPermission("adminhelper.getip.others")) {sender.sendMessage("§cYou don't have the permission to do that.");return true;}
				OfflinePlayer of = Bukkit.getOfflinePlayer(args[0]);
				if (!of.hasPlayedBefore()) {
					sender.sendMessage("§cThis player never played before on this server.");
					return true;
				}
				if (!of.isOnline()) {
					sender.sendMessage("§cThis player is not online.");
					return true;
				}
				Player p = (Player) of;
				p.sendMessage("§3IPv4 of §e" + p.getName() + "§8: §a" + new AdminHelperAPI(this).getIP(p));
			}
		}
		if (cmd.getName().equalsIgnoreCase("getping")) {
			if (args.length == 0) {
				if (sender instanceof Player) {
					Player p = (Player) sender;
					if (!p.hasPermission("adminhelper.getping")) {p.sendMessage("§cYou don't have the permission to do that.");return true;}
					p.sendMessage("§3Ping of §e" + p.getName() + "§8: §a" + new AdminHelperAPI(this).getPing(p));
				} else {
					sender.sendMessage("/getping <Player>");
				}
			} else if (args.length == 1) {
				if (!sender.hasPermission("adminhelper.getping.others")) {sender.sendMessage("§cYou don't have the permission to do that.");return true;}
				OfflinePlayer of = Bukkit.getOfflinePlayer(args[0]);
				if (!of.hasPlayedBefore()) {
					sender.sendMessage("§cThis player never played before on this server.");
					return true;
				}
				if (!of.isOnline()) {
					sender.sendMessage("§cThis player is not online.");
					return true;
				}
				Player p = (Player) of;
				p.sendMessage("§3Ping of §e" + p.getName() + "§8: §a" + new AdminHelperAPI(this).getPing(p));
			}
		}
		if (cmd.getName().equalsIgnoreCase("getlang")) {
			if (args.length == 0) {
				if (sender instanceof Player) {
					Player p = (Player) sender;
					if (!p.hasPermission("adminhelper.getlang")) {p.sendMessage("§cYou don't have the permission to do that.");return true;}
					p.sendMessage("§3Selected language of §e" + p.getName() + "§8: §a" + new AdminHelperAPI(this).getLanguage(p));
				} else {
					sender.sendMessage("/getlang [Player]");
				}
			} else if (args.length == 1) {
				if (!sender.hasPermission("adminhelper.getlang.others")) {sender.sendMessage("§cYou don't have the permission to do that.");return true;}
				OfflinePlayer of = Bukkit.getOfflinePlayer(args[0]);
				if (!of.hasPlayedBefore()) {
					sender.sendMessage("§cThis player never played before on this server.");
					return true;
				}
				if (!of.isOnline()) {
					sender.sendMessage("§cThis player is not online.");
					return true;
				}
				Player p = (Player) of;
				p.sendMessage("§3Selected language of §e" + p.getName() + "§8: §a" + new AdminHelperAPI(this).getLanguage(p));
			}
		}
		return true;
	}
	
}
