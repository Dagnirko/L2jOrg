package org.l2j.gameserver.network.l2.s2c;

public class GMHidePacket extends L2GameServerPacket
{
	private final int obj_id;

	public GMHidePacket(int id)
	{
		obj_id = id; //TODO хз чей id должен посылатся, нужно эксперементировать
	}

	@Override
	protected void writeImpl()
	{
		writeInt(obj_id);
	}
}