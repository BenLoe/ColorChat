package me.BenLoe.ColorChat;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	public final Events events = new Events(this);
	public final Files files = new Files(this);
	
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(new Events(this), this);
		saveDefaultConfig();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd,
			String Label, String[] args){
		if (sender instanceof Player){
			Player p = (Player) sender;
			if (Label.equalsIgnoreCase("ChatColor")){
				if (p.hasPermission("ChatColor.use")){
					ColorMenu.open(p);
				}else{
					p.sendMessage(ChatColor.RED + "To be able to color your chat, you must be a " + ChatColor.BLUE + "Demi-God" + ChatColor.RED + " or above.");
				}
			}
		}
		return true;
	}
}
