package org.example.chameleonproject;

import dev.hypera.chameleon.minestom.MinestomChameleon;
import net.minestom.server.extensions.Extension;

public class ChameleonProjectMinestom extends Extension {

    private MinestomChameleon chameleon;

    @Override
    public void initialize() {
        try {
            chameleon = new MinestomChameleon(ChameleonProject.class, this);
            chameleon.onEnable();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void terminate() {
        chameleon.onDisable();
    }

}
