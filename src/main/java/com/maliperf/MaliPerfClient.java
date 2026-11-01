package com.maliperf;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaliPerfClient implements ClientModInitializer {
    public static final String MOD_ID = "maliperf";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    private int tickCounter = 0;

    @Override
    public void onInitializeClient() {
        LOGGER.info("[MaliPerf] Otimizador de Pipeline Mali/Vulkan Carregado.");

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            tickCounter++;
            if (tickCounter >= 6000) { 
                tickCounter = 0;
                System.gc();
            }
        });
    }
}
