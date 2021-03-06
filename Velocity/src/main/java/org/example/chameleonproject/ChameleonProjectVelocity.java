package org.example.chameleonproject;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import dev.hypera.chameleon.velocity.VelocityChameleon;
import dev.hypera.chameleon.velocity.VelocityPlugin;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

@Plugin(
        id = "chameleonproject",
        name = "ChameleonProject",
        version = "1.0-SNAPSHOT"
)
public class ChameleonProjectVelocity implements VelocityPlugin {

    private final ProxyServer server;
    private final Path dataDirectory;
    private VelocityChameleon chameleon;

    @Inject
    public ChameleonProjectVelocity(ProxyServer server, @DataDirectory Path dataDirectory)  {
        this.server = server;
        this.dataDirectory = dataDirectory;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        try {
            chameleon = new VelocityChameleon(ChameleonProject.class, this);
            chameleon.onEnable();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }
    }

    @Subscribe
    public void onProxyShutdown(ProxyShutdownEvent event) {
        chameleon.onDisable();
    }

    @Override
    public @NotNull ProxyServer getServer() {
        return server;
    }

    @Override
    public @NotNull Path getDataDirectory() {
        return dataDirectory;
    }

}
