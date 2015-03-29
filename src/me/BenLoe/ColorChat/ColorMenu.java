package me.BenLoe.ColorChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ColorMenu {

	public static void open(Player p){
		Inventory inv = Bukkit.createInventory(null, 4 * 9, ChatColor.BLUE + "Color Menu");
	    MenuItem.createMenu(inv, p);
	    p.openInventory(inv);
	}
}
