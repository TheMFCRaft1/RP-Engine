package com.themfcraft.rpengine.procedures;

import net.minecraft.client.gui.widget.TextFieldWidget;

import java.util.HashMap;
import java.util.Calendar;

public class SetPhoneTimeProcedure {
	public static void execute(HashMap guistate) {
		if (guistate == null)
			return;
		if (guistate.get("text:label_time") instanceof TextFieldWidget)
			((TextFieldWidget) guistate.get("text:label_time")).setText(new java.text.SimpleDateFormat("yyyy MM dd").format(Calendar.getInstance().getTime()));
	}
}
