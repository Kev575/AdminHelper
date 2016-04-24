package kev575.adminhelper.api;

import java.lang.reflect.Method;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public abstract class AdminHelper {
	private Plugin p;
	
	public AdminHelper(Plugin p) {
		if (p == null) return;
		if (!p.isEnabled()) {
			throw new IllegalStateException("AdminHelper: Plugin " + p.getName() + " is not enabled.");
		}
		this.p = p;
	}
	
	public Plugin getPlugin() {
		return p;
	}
	
	public abstract String getIP(Player p);
	public abstract void spectate(Player p, Entity e);
	public abstract int getPing(Player p);
	public abstract String getLanguage(Player p);
	protected Method getMethod(String name, Class<?> clazz) {for (Method m : clazz.getDeclaredMethods()) {if (m.getName().equals(name))return m;}return null;}
}
