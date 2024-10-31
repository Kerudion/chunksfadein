package com.koteinik.chunksfadein.config;

import com.koteinik.chunksfadein.MathUtils;
import com.moandjiezana.toml.Toml;

public class ConfigEntryDoubleLimitable extends ConfigEntry<Double> {
    private final double max;
    private final double min;

    public ConfigEntryDoubleLimitable(double min, double max, double defaultValue, String configKey) {
        super(defaultValue, configKey, Type.DOUBLE);
        this.max = max;
        this.min = min;
    }

    @Override
    public void load(Toml toml) {
        Double tomlValue = (Double) type.get(toml, configKey);

        if (tomlValue == null)
            tomlValue = defaultValue;

        value = tomlValue;
        clampValue();
        pollListeners();
    }

    @Override
    public Double set(Double value) {
        super.value = value;
        clampValue();
        pollListeners();

        return super.value;
    }

    private void clampValue() {
        value = MathUtils.clamp(value, min, max);
    }
}
