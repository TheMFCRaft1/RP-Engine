package com.themfcraft.rpengine.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.client.gui.widget.TextFieldWidget;

import java.util.HashMap;

import com.themfcraft.rpengine.network.RpEngineModVariables;

public class SetPhoneTimeProcedure {
	public static void execute(IWorld world, HashMap guistate) {
		if (guistate == null)
			return;
		if (guistate.get("text:time") instanceof TextFieldWidget)
			((TextFieldWidget) guistate.get("text:time")).setText(RpEngineModVariables.MapVariables.get(world).time);
	}
}
