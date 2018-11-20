package org.l2j.gameserver.network.l2.s2c;

import org.l2j.gameserver.model.Creature;
import org.l2j.gameserver.model.GameObject;
import org.l2j.gameserver.model.Player;

public class MyTargetSelectedPacket extends L2GameServerPacket
{
	private final boolean _success;
	private int _objectId;
	private int _color;
	private final boolean _actionMenu;

	/**
	 * @param objectId of the target
	 * @param color difference to the target. name color is calculated from that
	 */
	public MyTargetSelectedPacket(int objectId, int color, boolean actionMenu)
	{
		_success = true;
		_objectId = objectId;
		_color = color;
		_actionMenu = actionMenu;
	}

	public MyTargetSelectedPacket(int objectId, int color)
	{
		this(objectId, color, false);
	}

	public MyTargetSelectedPacket(Player player, GameObject target, boolean actionMenu)
	{
		_success = true;
		_objectId = target.getObjectId();
		if(target.isCreature())
			_color = player.getLevel() - ((Creature) target).getLevel();
		else
			_color = 0;
		_actionMenu = actionMenu;
	}

	public MyTargetSelectedPacket(Player player, GameObject target)
	{
		this(player, target, false);
	}

	@Override
	protected final void writeImpl()
	{
		writeInt(_success ? 0x01 : 0x00);
		if(_success)
		{
			writeInt(_objectId);
			writeShort(_color);
			writeInt(_actionMenu ? 0x03 : 0x00);
		}
	}
}