package org.l2j.gameserver.network.l2.s2c;

import org.l2j.mmocore.StaticPacket;

@StaticPacket
public class ExNewSkillToLearnByLevelUp extends L2GameServerPacket  {
	public static final L2GameServerPacket STATIC = new ExNewSkillToLearnByLevelUp();

	private ExNewSkillToLearnByLevelUp()  {  }

	@Override
	protected void writeImpl() {  }
}
