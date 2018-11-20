package org.l2j.gameserver.network.l2.s2c;

import org.l2j.gameserver.model.Servitor;

public class ExPartyPetWindowUpdate extends L2GameServerPacket
{
	private int owner_obj_id, npc_id, _type, curHp, maxHp, curMp, maxMp, level;
	private int obj_id = 0;
	private String _name;

	public ExPartyPetWindowUpdate(Servitor summon)
	{
		obj_id = summon.getObjectId();
		owner_obj_id = summon.getPlayer().getObjectId();
		npc_id = summon.getNpcId() + 1000000;
		_type = summon.getServitorType();
		_name = summon.getName();
		curHp = (int) summon.getCurrentHp();
		maxHp = summon.getMaxHp();
		curMp = (int) summon.getCurrentMp();
		maxMp = summon.getMaxMp();
		level = summon.getLevel();
	}

	@Override
	protected final void writeImpl()
	{
		writeInt(obj_id);
		writeInt(npc_id);
		writeInt(_type);
		writeInt(owner_obj_id);
		writeString(_name);
		writeInt(curHp);
		writeInt(maxHp);
		writeInt(curMp);
		writeInt(maxMp);
		writeInt(level);
	}
}