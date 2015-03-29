package me.BenLoe.ColorChat;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum MenuItem{
	
	BLACK(9, "Black"), DARK_BLUE(10, "Dark Blue"), DARK_GREEN(11, "Dark Green"), DARK_AQUA(12, "Dark Aqua"), DARK_RED(13, "Dark Red"), DARK_PURPLE(14, "Dark Purple"), GOLD(15, "Gold"), BLUE(16, "Blue"), GREEN(17, "Green"), AQUA(20, "Aqua"), RED(21, "Red"), LIGHT_PURPLE(22, "Light Purple"), YELLOW(23, "Yellow"), WHITE(24, "White"), BOLD(31, "Bold");

private final String name;
private final int i;

private MenuItem(int i, String name){
	this.i = i;
	this.name = name;
}
@SuppressWarnings("incomplete-switch")
public String getMessageCodes(){
	switch(this){
	case AQUA:{
		return "§b§l";
	}
	case BLACK:{
		return "§0§l";
	}
	case DARK_AQUA:{
		return "§3§l";
	}
	case BLUE:{
		return "§9§l";
	}
	case DARK_BLUE:{
		return "§1§l";
	}
	case DARK_GREEN:{
		return "§2§l";
	}
	case DARK_PURPLE:{
		return "§5§l";
	}
	case DARK_RED:{
		return "§4§l";
	}
	case GOLD:{
		return "§6§l";
	}
	case GREEN:{
		return "§a§l";
	}
	case LIGHT_PURPLE:{
		return "§d§l";
	}
	case RED:{
		return "§c§l";
	}
	case WHITE:{
		return "§f§l";
	}
	case YELLOW:{
		return "§e§l";
	}
	}
	return "§f§l";
}

@SuppressWarnings("incomplete-switch")
public String getChatColor(){
	switch(this){
	case AQUA:{
		return "§b";
	}
	case BLACK:{
		return "§0";
	}
	case DARK_AQUA:{
		return "§3";
	}
	case BLUE:{
		return "§9";
	}
	case DARK_BLUE:{
		return "§1";
	}
	case DARK_GREEN:{
		return "§2";
	}
	case DARK_PURPLE:{
		return "§5";
	}
	case DARK_RED:{
		return "§4";
	}
	case GOLD:{
		return "§6";
	}
	case GREEN:{
		return "§a";
	}
	case LIGHT_PURPLE:{
		return "§d";
	}
	case RED:{
		return "§c";
	}
	case WHITE:{
		return "§f";
	}
	case YELLOW:{
		return "§e";
	}
	}
	return "§f";
}

public void wasClicked(Player p){
	if (this == BOLD){
		if (p.hasPermission("ChatColor.bold")){
		if (Files.getDataFile().contains(p.getName() + ".bold")){
			if (Files.getDataFile().getBoolean(p.getName() + ".bold")){
				p.sendMessage("§c§lBold Deactivated");
				Files.getDataFile().set(p.getName() + ".bold", false);
				Files.saveDataFile();
				p.closeInventory();
			}else{
				p.sendMessage("§a§lBold Activated");
				Files.getDataFile().set(p.getName() + ".bold", true);
				Files.saveDataFile();
				p.closeInventory();
			}
		}else{
			p.sendMessage("§a§lBold Activated");
			Files.getDataFile().set(p.getName() + ".bold", true);
			Files.saveDataFile();
			p.closeInventory();
		}
		}else{
			p.sendMessage(ChatColor.RED + "This feature is only for staff.");
			p.closeInventory();
		}
	}else{
	p.sendMessage(ChatColor.GREEN + "Chat color has been changed to " + this.getChatColor() + this.name + ChatColor.GREEN + "!");
	Files.getDataFile().set(p.getName() + ".color", this.name);
	Files.saveDataFile();
	p.closeInventory();
	}
}

public static MenuItem getColor(Player p){
	if (Files.getDataFile().contains(p.getName() + ".color")){
		for (MenuItem m : values()){
			if (m.name == Files.getDataFile().getString(p.getName() + ".color")){
				return m;
			}
		}
	}
	return MenuItem.WHITE;
}

@SuppressWarnings("deprecation")
public ItemStack getItemFor(Player p){
	switch(this){
	case BOLD:{
		if (Files.getDataFile().contains(p.getName() + ".bold")){
			if (Files.getDataFile().getBoolean(p.getName() + ".bold")){
				ItemStack item = new ItemStack(351, 1, (short) 10);
				ItemMeta itemm = item.getItemMeta();
				itemm.setDisplayName("§c§lDeactivate Bold");
				item.setItemMeta(itemm);
				return item;
			}
		}
		ItemStack item = new ItemStack(351, 1, (short) 8);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName("§a§lActivated Bold");
		item.setItemMeta(itemm);
		return item;
	}
	case AQUA:{
		ItemStack item = new ItemStack(57, 1, (short) 0);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(this.getChatColor() + "Change chat color to " + this.name);
		item.setItemMeta(itemm);
		return item;
	}
	case BLACK:{
		ItemStack item = new ItemStack(35, 1, (short) 15);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(this.getChatColor() + "Change chat color to " + this.name);
		item.setItemMeta(itemm);
		return item;
	}
	case DARK_AQUA:{
		ItemStack item = new ItemStack(35, 1, (short) 9);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(this.getChatColor() + "Change chat color to " + this.name);
		item.setItemMeta(itemm);
		return item;
	}
	case BLUE:{
		ItemStack item = new ItemStack(35, 1, (short) 3);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(this.getChatColor() + "Change chat color to " + this.name);
		item.setItemMeta(itemm);
		return item;
	}
	case DARK_BLUE:{
		ItemStack item = new ItemStack(35, 1, (short) 11);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(this.getChatColor() + "Change chat color to " + this.name);
		item.setItemMeta(itemm);
		return item;
	}
	case DARK_GREEN:{
		ItemStack item = new ItemStack(35, 1, (short) 13);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(this.getChatColor() + "Change chat color to " + this.name);
		item.setItemMeta(itemm);
		return item;
	}
	case DARK_PURPLE:{
		ItemStack item = new ItemStack(35, 1, (short) 10);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(this.getChatColor() + "Change chat color to " + this.name);
		item.setItemMeta(itemm);
		return item;
	}
	case DARK_RED:{
		ItemStack item = new ItemStack(35, 1, (short) 14);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(this.getChatColor() + "Change chat color to " + this.name);
		item.setItemMeta(itemm);
		return item;
	}
	case GOLD:{
		ItemStack item = new ItemStack(41, 1, (short) 0);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(this.getChatColor() + "Change chat color to " + this.name);
		item.setItemMeta(itemm);
		return item;
	}
	case GREEN:{
		ItemStack item = new ItemStack(35, 1, (short) 5);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(this.getChatColor() + "Change chat color to " + this.name);
		item.setItemMeta(itemm);
		return item;
	}
	case LIGHT_PURPLE:{
		ItemStack item = new ItemStack(35, 1, (short) 6);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(this.getChatColor() + "Change chat color to " + this.name);
		item.setItemMeta(itemm);
		return item;
	}
	case RED:{
		ItemStack item = new ItemStack(152, 1, (short) 0);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(this.
		getChatColor() + "Change chat color to " + this.name);
		item.setItemMeta(itemm);
		return item;
	}
	case WHITE:{
		ItemStack item = new ItemStack(35, 1, (short) 0);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(this.getChatColor() + "Change chat color to " + this.name);
		item.setItemMeta(itemm);
		return item;
	}
	case YELLOW:{
		ItemStack item = new ItemStack(35, 1, (short) 4);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(this.getChatColor() + "Change chat color to " + this.name);
		item.setItemMeta(itemm);
		return item;
	}
	}
	return new ItemStack(Material.AIR);
}

public int getSlot(){
	return this.i;
}
public static MenuItem getItemFromSlot(int slot){
	for (MenuItem m : values()){
			if (slot == m.i){
				return m;
		}
	}
	return MenuItem.WHITE;
}
public static boolean wasAItem(int slot){
	for (MenuItem m : values()){
			if (slot == m.i){
				return true;
		}
	}
	return false;
}

public static Inventory createMenu(Inventory inv, Player p){
	for (MenuItem m : values()){
			inv.setItem(m.getSlot(), m.getItemFor(p));
		}
	return inv;
}


}

