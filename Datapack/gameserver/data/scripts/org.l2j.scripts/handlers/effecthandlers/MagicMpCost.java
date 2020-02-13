package handlers.effecthandlers;

import org.l2j.gameserver.model.StatsSet;
import org.l2j.gameserver.model.actor.Creature;
import org.l2j.gameserver.model.effects.AbstractEffect;
import org.l2j.gameserver.model.items.instance.Item;
import org.l2j.gameserver.engine.skill.api.Skill;
import org.l2j.gameserver.network.serverpackets.ExChangeMpCost;
import org.l2j.gameserver.util.MathUtil;

/**
 * @author Sdw
 */
public class MagicMpCost extends AbstractEffect {
	public final int magicType;
	public final double power;
	
	public MagicMpCost(StatsSet params) {
		magicType = params.getInt("type", 0);
		power = params.getDouble("power", 0);
	}
	
	@Override
	public void onStart(Creature effector, Creature effected, Skill skill, Item item) {
		effected.getStats().mergeMpConsumeTypeValue(magicType, (power / 100) + 1, MathUtil::mul);
		effected.sendPacket(new ExChangeMpCost(power, magicType));
	}
	
	@Override
	public void onExit(Creature effector, Creature effected, Skill skill) {
		effected.getStats().mergeMpConsumeTypeValue(magicType, (power / 100) + 1, MathUtil::div);
		effected.sendPacket(new ExChangeMpCost(-power, magicType));
	}
}
