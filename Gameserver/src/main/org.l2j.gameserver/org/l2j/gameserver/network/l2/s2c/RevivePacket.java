package org.l2j.gameserver.network.l2.s2c;

import org.l2j.gameserver.model.GameObject;

/**
 * sample
 * 0000: 0c  9b da 12 40                                     ....@
 *
 * format  d
 */
public class RevivePacket extends L2GameServerPacket
{
	private int _objectId;

	public RevivePacket(GameObject obj)
	{
		_objectId = obj.getObjectId();
	}

	@Override
	protected final void writeImpl()
	{
		writeInt(_objectId);
	}
}