package com.koteinik.chunksfadein.hooks;

import com.koteinik.chunksfadein.gui.SettingsScreen;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import net.minecraft.client.gui.screen.Screen;

public class ModMenuHook implements ModMenuApi {
    @Override
    public ConfigScreenFactory<? extends Screen> getModConfigScreenFactory() {
        return SettingsScreen::new;
    }
}
