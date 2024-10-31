package com.koteinik.chunksfadein.platform;

import java.io.File;

import com.koteinik.chunksfadein.ChunksFadeIn;
import com.koteinik.chunksfadein.core.SemanticVersion;
import com.koteinik.chunksfadein.platform.services.IPlatformHelper;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.fml.ModList;

public class NeoForgePlatformHelper implements IPlatformHelper {
    @Override
    public boolean isForge() {
        return true;
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public File getConfigDirectory() {
        return new File(Minecraft.getInstance().gameDirectory, "config");
    }

    @Override
    public SemanticVersion getModVersion() {
        try {
            return new SemanticVersion(ModList.get().getModContainerById("chunksfadein").get().getModInfo().getVersion().toString(), false);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public SemanticVersion getMinecraftVersion() {
        try {
            return new SemanticVersion(ModList.get().getModContainerById("minecraft").get().getModInfo().getVersion().toString(), false);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public KeyMapping registerKeyBind(KeyMapping mapping) {
        ChunksFadeIn.KEYLIST.add(mapping);
        return mapping;
    }
}
