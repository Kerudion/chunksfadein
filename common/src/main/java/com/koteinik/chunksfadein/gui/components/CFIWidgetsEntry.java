package com.koteinik.chunksfadein.gui.components;

import java.util.List;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.ContainerObjectSelectionList.Entry;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;

public class CFIWidgetsEntry extends Entry<CFIWidgetsEntry> {
	private static final int SPACING_X = 4;
	private static final int BUTTON_W = 180;

	private final List<AbstractWidget> widgets;
	private final Screen parent;

	public CFIWidgetsEntry(List<AbstractWidget> widgets, Screen parent) {
		this.widgets = widgets;
		this.parent = parent;
	}

	@Override
	public List<? extends GuiEventListener> children() {
		return widgets;
	}

	@Override
	public List<? extends NarratableEntry> narratables() {
		return widgets;
	}

	@Override
	public void render(GuiGraphics context, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
		for (int i = 0; i < widgets.size(); i++) {
			AbstractWidget widget = widgets.get(i);

			int gridX = i;
			if (widgets.size() > 1 && i == 0)
				gridX = -1;

			widget.setPosition(calculateX(gridX), y);
			widget.render(context, mouseX, mouseY, tickDelta);
		}
	}

	private int calculateX(int column) {
		int halfScreen = parent.width / 2;

		return column == 0
			? halfScreen - BUTTON_W / 2
			: halfScreen + BUTTON_W * (column - (column < 0 ? 0 : 1)) + SPACING_X * column;
	}
}
