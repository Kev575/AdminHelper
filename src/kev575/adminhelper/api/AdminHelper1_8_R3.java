package kev575.adminhelper.api;

import java.lang.reflect.Field;
import java.net.InetSocketAddress;

import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class AdminHelper1_8_R3 extends AdminHelper {

	public AdminHelper1_8_R3(Plugin p) {
		super(p);
	}

	@Override
	public String getIP(Player p) {
		InetSocketAddress a = p.getAddress();
		return a.getAddress().getHostAddress();
	}
	
	@Override
	public void spectate(Player p, Entity e) {
		p.setGameMode(GameMode.SPECTATOR);
		((CraftPlayer)p).getHandle().setSpectatorTarget((net.minecraft.server.v1_8_R3.Entity) e);
	}
	
	@Override
	public int getPing(Player p) {
		return ((CraftPlayer)p).getHandle().ping;
	}
	
	@Override
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
}
