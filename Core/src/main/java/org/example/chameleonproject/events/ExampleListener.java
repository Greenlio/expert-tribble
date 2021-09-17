package org.example.chameleonproject.events;

import dev.hypera.chameleon.core.events.impl.common.UserJoinEvent;
import dev.hypera.chameleon.core.events.listener.ChameleonListener;
import dev.hypera.chameleon.core.events.listener.EventHandler;
import net.kyori.adventure.text.Component;

public class ExampleListener implements ChameleonListener {

	@EventHandler
	public void onJoin(UserJoinEvent event) {
		event.getPlayer().sendMessage(Component.text("Welcome to my server!"));
	}

}