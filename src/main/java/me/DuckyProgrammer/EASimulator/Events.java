package me.DuckyProgrammer.EASimulator;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Events implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("easimulator.chat")) {
            player.sendMessage(ChatColor.RED + "You need to buy access to chat.");
            player.sendMessage(ChatColor.RED + "You can buy access at " + Main.sendChat);
            event.setCancelled(true);
            return;
        }
        for (Player loopPlayer : player.getServer().getOnlinePlayers()) {
            if (!loopPlayer.hasPermission("easimulator.viewchat")) {
                player.sendMessage(ChatColor.RED + "You need to buy access to view chat.");
                player.sendMessage(ChatColor.RED + "You can buy access at " + Main.viewChat);
                event.getRecipients().remove(loopPlayer);
            }
        }
    }
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("easimulator.break")) {
            player.sendMessage(ChatColor.RED + "You need to buy access to break blocks.");
            player.sendMessage(ChatColor.RED + "You can buy access at " + Main.placeBlock);
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("easimulator.place")) {
            player.sendMessage(ChatColor.RED + "You need to buy access to place blocks.");
            player.sendMessage(ChatColor.RED + "You can buy access at " + Main.breakBlock);
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("easimulator.move")) {
            player.sendMessage(ChatColor.RED + "You need to buy access to move.");
            player.sendMessage(ChatColor.RED + "You can buy access at " + Main.move);
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("easimulator.see")) {
            player.sendMessage(ChatColor.RED + "You need to buy access to see.");
            player.sendMessage(ChatColor.RED + "You can buy access at " + Main.see);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, Integer.MAX_VALUE, 255, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 255, false, false));
        }
        if (!player.hasPermission("easimulator.jump")) {
            player.sendMessage(ChatColor.RED + "You need to buy access to jump.");
            player.sendMessage(ChatColor.RED + "You can buy access at " + Main.jump);
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 200, false, false));
        }
        if (!player.hasPermission("easimulator.health")) {
            player.sendMessage(ChatColor.RED + "You need to buy access to health.");
            player.sendMessage(ChatColor.RED + "You can buy access at " + Main.health);
            AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            assert attribute != null;
            attribute.setBaseValue(1);
        }
    }
    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player player)) {
            return;
        }
        if (!player.hasPermission("easimulator.attack")) {
            player.sendMessage(ChatColor.RED + "You need to buy access to attack.");
            player.sendMessage(ChatColor.RED + "You can buy access at " + Main.attack);
        }
    }
    @EventHandler
    public void onCraft(CraftItemEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (!player.hasPermission("easimulator.craft")) {
            player.sendMessage(ChatColor.RED + "You need to buy access to craft.");
            player.sendMessage(ChatColor.RED + "You can buy access at " + Main.craft);
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void inventoryOpen(InventoryOpenEvent event) {
        Player player = (Player) event.getPlayer();
        if (!player.hasPermission("easimulator.inventory")) {
            player.sendMessage(ChatColor.RED + "You need to buy access to open inventories.");
            player.sendMessage(ChatColor.RED + "You can buy access at " + Main.inventory);
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onCrouch(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("easimulator.crouch")) {
            player.sendMessage(ChatColor.RED + "You need to buy access to crouch.");
            player.sendMessage(ChatColor.RED + "You can buy access at " + Main.crouch);
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onSprint(PlayerToggleSprintEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("easimulator.sprint")) {
            player.sendMessage(ChatColor.RED + "You need to buy access to sprint.");
            player.sendMessage(ChatColor.RED + "You can buy access at " + Main.sprint);
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onRegen(EntityRegainHealthEvent event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }
        if (!player.hasPermission("easimulator.regen")) {
            player.sendMessage(ChatColor.RED + "You need to buy access to regen.");
            player.sendMessage(ChatColor.RED + "You can buy access at " + Main.regen);
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onEat(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("easimulator.eat")) {
            player.sendMessage(ChatColor.RED + "You need to buy access to eat.");
            player.sendMessage(ChatColor.RED + "You can buy access at " + Main.eat);
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onItemHold(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("easimulator.itemhold")) {
            player.sendMessage(ChatColor.RED + "You need to buy access to hold items.");
            player.sendMessage(ChatColor.RED + "You can buy access at " + Main.itemhold);
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("easimulator.command")) {
            player.sendMessage(ChatColor.RED + "You need to buy access to use commands.");
            player.sendMessage(ChatColor.RED + "You can buy access at " + Main.command);
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onPickup(EntityPickupItemEvent event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }
        if (!player.hasPermission("easimulator.pickup")) {
            player.sendMessage(ChatColor.RED + "You need to buy access to pickup items.");
            player.sendMessage(ChatColor.RED + "You can buy access at " + Main.pickup);
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("easimulator.drop")) {
            player.sendMessage(ChatColor.RED + "You need to buy access to drop items.");
            player.sendMessage(ChatColor.RED + "You can buy access at " + Main.drop);
            event.setCancelled(true);
        }
    }
}
