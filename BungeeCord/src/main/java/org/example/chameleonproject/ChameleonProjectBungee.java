package org.example.chameleonproject;

import dev.hypera.chameleon.bungeecord.BungeeCordChameleon;
import net.md_5.bungee.api.plugin.Plugin;

public final class ChameleonProjectBungee extends Plugin {

    private BungeeCordChameleon chameleon;

    @Override
    public void onEnable() {
        try {
            chameleon = new BungeeCordChameleon(ChameleonProject.class, this);
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
