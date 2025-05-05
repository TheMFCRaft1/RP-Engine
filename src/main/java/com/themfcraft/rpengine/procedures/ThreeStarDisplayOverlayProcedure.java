package com.themfcraft.rpengine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ThreeStarDisplayOverlayProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static boolean execute(Entity entity) {
		return execute(null, entity);
	}

	private static boolean execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return false;
		if (new Object() {
			public int getScore(String score, Entity _ent) {
				Scoreboard _sc = _ent.world.getScoreboard();
				ScoreObjective _so = _sc.getObjective(score);
				if (_so != null)
					return _sc.getOrCreateScore(_ent.getScoreboardName(), _so).getScorePoints();
				return 0;
			}
		}.getScore("stars", entity) == 3) {
			return true;
		} else {
			return false;
		}
	}
}
