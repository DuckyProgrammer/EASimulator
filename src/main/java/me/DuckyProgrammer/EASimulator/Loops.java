package me.DuckyProgrammer.EASimulator;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class Loops implements Runnable {

    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("easimulator.see")) {
                player.removePotionEffect(PotionEffectType.BLINDNESS);
                player.removePotionEffect(PotionEffectType.DARKNESS);
            }
            if (player.hasPermission("easimulator.jump")) {
                player.removePotionEffect(PotionEffectType.JUMP);
            }
            if (player.hasPermission("easimulator.health")) {
                AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                assert attribute != null;
                attribute.setBaseValue(20);
            }
        }
    }

}
