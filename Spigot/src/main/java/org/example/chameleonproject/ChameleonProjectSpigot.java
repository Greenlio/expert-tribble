package org.example.chameleonproject;

import dev.hypera.chameleon.spigot.SpigotChameleon;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChameleonProjectSpigot extends JavaPlugin {

    private SpigotChameleon chameleon;

    @Override
    public void onEnable() {
        try {
            chameleon = new SpigotChameleon(ChameleonProject.class, this);
            chameleon.onEnable();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        chameleon.onDisable();
    }

}
