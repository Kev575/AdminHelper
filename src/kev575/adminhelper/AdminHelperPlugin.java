package kev575.adminhelper;

import kev575.adminhelper.api.AdminHelper;
import kev575.adminhelper.api.AdminHelper1_8_R3;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AdminHelperPlugin extends JavaPlugin {

	private static AdminHelper api;
	
	public AdminHelper getAPI() throws NullPointerException {
		if (api == null)
			throw new NullPointerException("AdminHelper (external-API-access): You can only use this API in v1_8_R1, v1_8_R2, v1_8_R3 and v1_9_R1!");
		return api;
	}
	
	@Override
	public void onEnable() {
		String version = Bukkit.getServer().getClass().getPackage().getName().replace(".",  ",").split(",")[3];
		if (version.equals("v1_8_R3")) {
			api = new AdminHelper1_8_R3(this);
		} else if (version.equals("v1_8_R2")) {
			api = new AdminHelper1_8_R3(this);
		} else if (version.equals("v1_8_R1")) {
			api = new AdminHelper1_8_R3(this);
		} else if (version.equals("v1_9_R1")) {
			api = new AdminHelper1_8_R3(this);
		} else {
			api = null;
		}
		if (api == null) {
			setEnabled(false);
			throw new IllegalStateException("You can only use this plugin in v1_8_R1, v1_8_R2, v1_8_R3 and v1_9_R1!");
		}
		saveDefaultConfig();
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
					p.sendMessage(getConfig().getString("getip.me").replace("%p", p.getName()).replace("&", "§").replace("%ip", api.getIP(p)));
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
				sender.sendMessage("§3IPv4 of §e" + p.getName() + "§8: §a" + api.getIP(p));
			}
		}
		if (cmd.getName().equalsIgnoreCase("getping")) {
			if (args.length == 0) {
				if (sender instanceof Player) {
					Player p = (Player) sender;
					if (!p.hasPermission("adminhelper.getping")) {p.sendMessage("§cYou don't have the permission to do that.");return true;}
					p.sendMessage("§3Ping of §eyou§8: §a" + api.getPing(p));
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
				sender.sendMessage("§3Ping of §e" + p.getName() + "§8: §a" + api.getPing(p));
			}
		}
		if (cmd.getName().equalsIgnoreCase("getlang")) {
			if (args.length == 0) {
				if (sender instanceof Player) {
					Player p = (Player) sender;
					if (!p.hasPermission("adminhelper.getlang")) {p.sendMessage("§cYou don't have the permission to do that.");return true;}
					p.sendMessage("§3Selected language of §eyou§8: §a" + api.getLanguage(p));
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
				sender.sendMessage("§3Selected language of §e" + p.getName() + "§8: §a" + api.getLanguage(p));
			}
		}
		return true;
	}
	
}
