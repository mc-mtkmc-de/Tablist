package de.tab.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

public class Tablist extends JavaPlugin implements Listener {
	
	private static Tablist plugin;
	
	private final long TABLIST_DELAY = 1*20;
	
	Scoreboard board;
	
	@Override
	public void onEnable() {
		plugin = this;
			
			board = Bukkit.getScoreboardManager().getNewScoreboard();
		
			board.registerNewTeam("00000Owner");
			board.registerNewTeam("00001Admin");
			board.registerNewTeam("00002Dev");
			board.registerNewTeam("00003MBuilder");
			board.registerNewTeam("00004Builder");
			board.registerNewTeam("00005Azubi");
			board.registerNewTeam("00006Mod");
			board.registerNewTeam("00007Sup");
			board.registerNewTeam("00008Freund");
			board.registerNewTeam("00009YT+");
			board.registerNewTeam("00010Champ");
			board.registerNewTeam("00011Drache");
			board.registerNewTeam("00012Titan");
			board.registerNewTeam("00013YT");
			board.registerNewTeam("00014Legende");
			board.registerNewTeam("00015Ultra");
			board.registerNewTeam("00016Premium");
			board.registerNewTeam("00017Spieler");
			
			board.getTeam("00000Owner").setPrefix("§a[Owner]");
			board.getTeam("00001Admin").setPrefix("§c[Admin]");
			board.getTeam("00002Dev").setPrefix("§b[Dev]");
			board.getTeam("00003MBuilder").setPrefix("§2[MBuilder]");
			board.getTeam("00004Builder").setPrefix("§a[Builder]");
			board.getTeam("00005Azubi").setPrefix("§d[Azubi]");
			board.getTeam("00006Mod").setPrefix("§3[Mod]");
			board.getTeam("00007Sup").setPrefix("§2[Sup]");
			board.getTeam("00008Freund").setPrefix("§c[Freund]");
			board.getTeam("00009YT+").setPrefix("§5[YT§4+§5]");
			board.getTeam("00010Champ").setPrefix("§e[champ]");
			board.getTeam("00011Drache").setPrefix("§4[Drache]");
			board.getTeam("00012Titan").setPrefix("§9[Titan]");
			board.getTeam("00013YT").setPrefix("§5[YT]");
			board.getTeam("00014Legende").setPrefix("§c[Legende]");
			board.getTeam("00015Ultra").setPrefix("§b[Ultra]");
			board.getTeam("00016Premium").setPrefix("§6[Premium]");
			board.getTeam("00017Spieler").setPrefix("§7[Spieler]");
			
			Bukkit.getPluginManager().registerEvents(this, this);
			
			
		}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		setPrefix(event.getPlayer());
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Tablist.getPlugin(), new Runnable() {
			
			@Override
			public void run() {
				for (Player player : Bukkit.getOnlinePlayers()) {
					setPrefix(player);
					
				}
				
			}

		}, 0, TABLIST_DELAY);
		
	}
	
	private void setPrefix(Player p) {
		
		String team = "";
		
		if(p.hasPermission("tab.owner")) {
			team = "00000Owner";
		} else if(p.hasPermission("tab.admin")) {
			team = "00001Admin";
		} else if(p.hasPermission("tab.dev")) {
			team = "00002Dev";
		} else if(p.hasPermission("tab.mbuilder")) {
			team = "00003MBuilder";
		} else if(p.hasPermission("tab.builder")) {
			team = "00004Builder";
		} else if(p.hasPermission("tab.azubi")) {
			team = "00005Azubi";
		} else if(p.hasPermission("tab.mod")) {
			team = "00006Mod";
		} else if(p.hasPermission("tab.sup")) {
			team = "00007Sup";
		} else if(p.hasPermission("tab.freund")) {
			team = "00008Freund";
		} else if(p.hasPermission("tab.yt+")) {
			team = "00009YT+";
		} else if(p.hasPermission("tab.champ")) {
			team = "00010Champ";
		}  else if(p.hasPermission("tab.drache")) {
			team = "00011Drache";
		} else if(p.hasPermission("tab.titan")) {
			team = "00012Titan";
		} else if(p.hasPermission("tab.yt")) {
			team = "00013YT";
		} else if(p.hasPermission("tab.legende")) {
			team = "00014Legende";
		} else if(p.hasPermission("tab.ultra")) {
			team = "00015Ultra";
		} else if(p.hasPermission("tab.premium")) {
			team = "00016Premium";
		} else {
			team = "00017Spieler";
		}
		
		board.getTeam(team).addPlayer(p);;
		p.setDisplayName(board.getTeam(team).getPrefix() + p.getName());
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			all.setScoreboard(board);
		}
		
	}
	
	public static Tablist getPlugin() {
		return plugin;
		
	}

}
