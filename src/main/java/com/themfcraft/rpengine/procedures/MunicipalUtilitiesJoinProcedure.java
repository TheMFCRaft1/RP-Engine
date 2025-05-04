package com.themfcraft.rpengine.procedures;

import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

public class MunicipalUtilitiesJoinProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _entityTeam = entity;
			ScorePlayerTeam _pt = _entityTeam.world.getScoreboard().getTeam("municipal_utilities");
			if (_pt != null) {
				if (_entityTeam instanceof PlayerEntity)
					_entityTeam.world.getScoreboard().addPlayerToTeam(((PlayerEntity) _entityTeam).getGameProfile().getName(), _pt);
				else
					_entityTeam.world.getScoreboard().addPlayerToTeam(_entityTeam.getCachedUniqueIdString(), _pt);
			}
		}
	}
}
