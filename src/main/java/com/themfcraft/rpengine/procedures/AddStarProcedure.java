package com.themfcraft.rpengine.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraft.entity.Entity;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.command.CommandSource;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class AddStarProcedure {
	public static void execute(CommandContext<CommandSource> arguments) {
		{
			Entity _ent = (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "name");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity());
			Scoreboard _sc = _ent.world.getScoreboard();
			ScoreObjective _so = _sc.getObjective("stars");
			if (_so == null)
				_so = _sc.addObjective("stars", ScoreCriteria.DUMMY, new StringTextComponent("stars"), ScoreCriteria.RenderType.INTEGER);
			_sc.getOrCreateScore(_ent.getScoreboardName(), _so).setScorePoints((int) (new Object() {
				public int getScore(String score, Entity _ent) {
					Scoreboard _sc = _ent.world.getScoreboard();
					ScoreObjective _so = _sc.getObjective(score);
					if (_so != null)
						return _sc.getOrCreateScore(_ent.getScoreboardName(), _so).getScorePoints();
					return 0;
				}
			}.getScore("stars", (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "name");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity())) + 1));
		}
	}
}
