package org.example.chameleonproject;

import dev.hypera.chameleon.core.Chameleon;
import dev.hypera.chameleon.core.Plugin;
import dev.hypera.chameleon.core.configuration.Configuration;
import dev.hypera.chameleon.core.configuration.JsonConfiguration;
import dev.hypera.chameleon.core.configuration.YamlConfiguration;
import dev.hypera.chameleon.core.data.PluginData;
import dev.hypera.chameleon.core.utils.logging.ChameleonLogger;
import org.example.chameleonproject.commands.ExampleCommand;
import org.example.chameleonproject.events.ExampleListener;
import org.jetbrains.annotations.NotNull;

public class ChameleonProject extends Plugin {

    private static Configuration yamlConfig;
    private static Configuration jsonTest;
    private final ChameleonLogger logger;

    public ChameleonProject(Chameleon chameleon) {
        super(chameleon);
        logger = chameleon.getLogger(this.getClass());
    }

    @Override
    public void onEnable() {
        long startTime = System.currentTimeMillis();
        logger.info("&aStarting...");
        yamlConfig = new YamlConfiguration(chameleon, "config.yml", true);
        jsonTest = new JsonConfiguration(chameleon, "test.json", true);

        chameleon.registerCommand(new ExampleCommand());
        chameleon.getEventDispatcher().registerListener(new ExampleListener());
        logger.info("&aSuccessfully started on %s, took %sms", chameleon.getPlatformData().getName(), System.currentTimeMillis() - startTime);
    }

    @Override
    public @NotNull PluginData getData() {
        return PluginData.builder().name("ChameleonProject").version("0.2.0-SNAPSHOT").author("Me, Myself and I");
    }

    @Override
    public void onDisable() {

    }

}
