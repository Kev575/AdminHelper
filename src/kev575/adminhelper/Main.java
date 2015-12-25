package kev575.adminhelper;

import kev575.adminhelper.api.AdminHelperAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
					if (!p.hasPermission("adminhelper.getip")) {p.sendMessage(ChatColor.translateAlternateColorCodes('$', "$cYou don't have the permission to do that."));return true;}
					p.sendMessage(ChatColor.translateAlternateColorCodes('$', "$3IPv4 of $eyou$8: $a" + new AdminHelperAPI(this).getIP(p)));
				} else {
					sender.sendMessage("/getip <Player>");
				}
			} else if (args.length == 1) {
				if (!sender.hasPermission("adminhelper.getip.others")) {sender.sendMessage(ChatColor.translateAlternateColorCodes('$', "$cYou don't have the permission to do that."));return true;}
				OfflinePlayer of = Bukkit.getOfflinePlayer(args[0]);
				if (!of.hasPlayedBefore()) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('$', "$cThis player never played before on this server."));
					return true;
				}
				if (!of.isOnline()) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('$', "$cThis player is not online."));
					return true;
				}
				Player p = (Player) of;
				sender.sendMessage(ChatColor.translateAlternateColorCodes('$', "$3IPv4 of $e" + p.getName() + "$8: $a" + new AdminHelperAPI(this).getIP(p)));
			}
		}
		if (cmd.getName().equalsIgnoreCase("getping")) {
			if (args.length == 0) {
				if (sender instanceof Player) {
					Player p = (Player) sender;
					if (!p.hasPermission("adminhelper.getping")) {p.sendMessage(ChatColor.translateAlternateColorCodes('$', "$cYou don't have the permission to do that."));return true;}
					p.sendMessage(ChatColor.translateAlternateColorCodes('$', "$3Ping of $eyou$8: $a" + new AdminHelperAPI(this).getPing(p)));
				} else {
					sender.sendMessage("/getping <Player>");
				}
			} else if (args.length == 1) {
				if (!sender.hasPermission("adminhelper.getping.others")) {sender.sendMessage(ChatColor.translateAlternateColorCodes('$', "$cYou don't have the permission to do that."));return true;}
				OfflinePlayer of = Bukkit.getOfflinePlayer(args[0]);
				if (!of.hasPlayedBefore()) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('$', "$cThis player never played before on this server."));
					return true;
				}
				if (!of.isOnline()) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('$', "$cThis player is not online."));
					return true;
				}
				Player p = (Player) of;
				sender.sendMessage(ChatColor.translateAlternateColorCodes('$', "$3Ping of $e" + p.getName() + "$8: $a" + new AdminHelperAPI(this).getPing(p)));
			}
		}
		if (cmd.getName().equalsIgnoreCase("getlang")) {
			if (args.length == 0) {
				if (sender instanceof Player) {
					Player p = (Player) sender;
					if (!p.hasPermission("adminhelper.getlang")) {p.sendMessage(ChatColor.translateAlternateColorCodes('$', "$cYou don't have the permission to do that."));return true;}
					p.sendMessage(ChatColor.translateAlternateColorCodes('$', "$3Selected language of $eyou$8: $a" + new AdminHelperAPI(this).getLanguage(p)));
				} else {
					sender.sendMessage("/getlang [Player]");
				}
			} else if (args.length == 1) {
				if (!sender.hasPermission("adminhelper.getlang.others")) {sender.sendMessage(ChatColor.translateAlternateColorCodes('$', "$cYou don't have the permission to do that."));return true;}
				OfflinePlayer of = Bukkit.getOfflinePlayer(args[0]);
				if (!of.hasPlayedBefore()) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('$', "$cThis player never played before on this server."));
					return true;
				}
				if (!of.isOnline()) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('$', "$cThis player is not online."));
					return true;
				}
				Player p = (Player) of;
				sender.sendMessage(ChatColor.translateAlternateColorCodes('$', "$3Selected language of $e" + p.getName() + "$8: $a" + new AdminHelperAPI(this).getLanguage(p)));
			}
		}
		return true;
	}
	
}
