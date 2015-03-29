package me.BenLoe.ColorChat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Events implements Listener{

	public static Main plugin;
	public Events(Main instance){
		plugin = instance;
	}
	
	@EventHandler (priority = EventPriority.LOW)
	public void playerChat(AsyncPlayerChatEvent event){
		Player p = event.getPlayer();
		boolean bold = false;
		if (Files.getDataFile().contains(p.getName() + ".bold")){
			if (Files.getDataFile().getBoolean(p.getName() + ".bold")){
				bold = true;
			}
		}
		if (Files.getDataFile().contains(p.getName() + ".color")){
			if (bold){
				event.setMessage(MenuItem.getColor(p).getMessageCodes() + event.getMessage());
			}else{
			event.setMessage(MenuItem.getColor(p).getChatColor() + event.getMessage());
			}
		}else{
			if (bold){
				event.setMessage("§l" + event.getMessage());
			}
		}
	}
	
	@EventHandler
	public void clickItem(InventoryClickEvent event){
		if (event.getInventory().getName().contains("Color")){
			if (MenuItem.wasAItem(event.getRawSlot())){
				MenuItem.getItemFromSlot(event.getRawSlot()).wasClicked((Player) event.getWhoClicked());
			}
		}
	}
	
}
