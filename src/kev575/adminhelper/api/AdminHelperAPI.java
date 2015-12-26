package kev575.adminhelper.api;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;

import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.Packet;

import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class AdminHelperAPI {

	private Plugin p;
	
	public AdminHelperAPI(Plugin p) {
		if (p == null) return;
		if (!p.isEnabled()) {
			new Exception("[AdminHelperAPI] Plugin " + p.getName() + " is not enabled.");
		}
		this.p = p;
	}
	
	public Plugin getPlugin() {
		return p;
	}
	
	/**
	 * 
	 * REQUIRES NO EXACT VERSION of Spigot
	 * 
	 * @param p Player
	 * @return 0.0.0.0 to 255.255.255.255
	 */
	public String getIP(Player p) {
		InetSocketAddress a = p.getAddress();
		return a.getAddress().getHostAddress();
	}
	
	/**
	 * 
	 * REQUIRES v1_8_R3 of Spigot
	 * 
	 * @param p Player
	 * @param e Which entity sould be spectated from <b>p</b>
	 */
	public void spectate(Player p, Entity e) {
		p.setGameMode(GameMode.SPECTATOR);
		((CraftPlayer)p).getHandle().setSpectatorTarget((net.minecraft.server.v1_8_R3.Entity) e);
	}
	
	/**
	 * 
	 * REQUIRES v1_8_R3 of Spigot
	 * 
	 * @return ping of @parm p; type int; ping >= 0  
	 */
	public int getPing(Player p) {
		return ((CraftPlayer)p).getHandle().ping;
	}
	/**
	 * 
	 * REQUIRES v1_8_R3 of Spigot
	 * 
	 * @return lang e.g. en_US, fr_FR or de_DE
	 */
	public String getLanguage(Player p) {
		try {Object ep = getMethod("getHandle", p.getClass()).invoke(p, (Object[]) null);
		Field f = ep.getClass().getDeclaredField("locale");
		f.setAccessible(true);
		String language = (String) f.get(ep);
		return language;}
		catch (Exception e) {
			return null;
		}
	}
	private Method getMethod(String name, Class<?> clazz) {for (Method m : clazz.getDeclaredMethods()) {if (m.getName().equals(name))return m;}return null;}
	
	@SuppressWarnings("rawtypes")
	public void sendPacket(Player player, Packet packet) {
		getHandle(player).playerConnection.sendPacket(packet);
	}
	
	public EntityPlayer getHandle(Player player) {
		return ((CraftPlayer)player).getHandle();
	}
	
}
