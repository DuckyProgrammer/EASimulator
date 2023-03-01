package me.DuckyProgrammer.EASimulator;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {

    public static String mainStore;
    public static String sendChat;
    public static String viewChat;
    public static String breakBlock;
    public static String placeBlock;
    public static String move;
    public static String see;
    public static String attack;
    public static String craft;
    public static String inventory;
    public static String jump;
    public static String crouch;
    public static String health;
    public static String sprint;
    public static String regen;
    public static String eat;
    public static String itemhold;
    public static String command;
    public static String pickup;
    public static String drop;

    public void onEnable() {
        getLogger().info("EASimulator has been enabled!");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        mainStore = getConfig().getString("store");
        sendChat = getConfig().getString("sendChat");
        viewChat = getConfig().getString("viewChat");
        breakBlock = getConfig().getString("breakBlock");
        placeBlock = getConfig().getString("placeBlock");
        move = getConfig().getString("move");
        see = getConfig().getString("see");
        attack = getConfig().getString("attack");
        craft = getConfig().getString("craft");
        inventory = getConfig().getString("inventory");
        jump = getConfig().getString("jump");
        crouch = getConfig().getString("crouch");
        health = getConfig().getString("health");
        sprint = getConfig().getString("sprint");
        regen = getConfig().getString("regen");
        eat = getConfig().getString("eat");
        itemhold = getConfig().getString("itemhold");
        command = getConfig().getString("command");
        pickup = getConfig().getString("pickup");
        drop = getConfig().getString("drop");
        getServer().getPluginManager().registerEvents(new Events(), this);
        getServer().getScheduler().scheduleSyncRepeatingTask(this, new Loops(), 0, 10);
        Objects.requireNonNull(getCommand("announce")).setExecutor(new Announce());
    }
}