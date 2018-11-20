package org.l2j.gameserver.network.l2.s2c;

import gnu.trove.iterator.TIntIntIterator;
import gnu.trove.map.TIntIntMap;
import gnu.trove.map.hash.TIntIntHashMap;

import org.l2j.gameserver.data.xml.holder.InstantZoneHolder;
import org.l2j.gameserver.model.Player;

/**
 * @author Bonux
**/
public class ExInzoneWaitingInfo extends L2GameServerPacket
{
	private final boolean _openWindow;
	private int _currentInzoneID = -1;
	private TIntIntMap _instanceTimes;

	public ExInzoneWaitingInfo(Player player, boolean openWindow)
	{
		_openWindow = openWindow;
		_instanceTimes = new TIntIntHashMap();

		if(player.getActiveReflection() != null)
			_currentInzoneID = player.getActiveReflection().getInstancedZoneId();

		int limit;
		for(int i : player.getInstanceReuses().keySet())
		{
			limit = InstantZoneHolder.getInstance().getMinutesToNextEntrance(i, player);
			if(limit > 0)
				_instanceTimes.put(i, limit * 60);
		}
	}

	protected void writeImpl()
	{
		writeByte(_openWindow);
		writeInt(_currentInzoneID);
		writeInt(_instanceTimes.size());

		TIntIntIterator iterator = _instanceTimes.iterator();
		while(iterator.hasNext())
		{
			iterator.advance();
			writeInt(iterator.key());
			writeInt(iterator.value());
		}
	}
}