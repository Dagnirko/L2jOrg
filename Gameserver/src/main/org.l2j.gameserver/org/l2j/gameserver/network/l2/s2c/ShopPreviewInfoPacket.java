package org.l2j.gameserver.network.l2.s2c;

import java.util.Map;

import org.l2j.gameserver.model.items.Inventory;

public class ShopPreviewInfoPacket extends L2GameServerPacket
{
	private Map<Integer, Integer> _itemlist;

	public ShopPreviewInfoPacket(Map<Integer, Integer> itemlist)
	{
		_itemlist = itemlist;
	}

	@Override
	protected void writeImpl()
	{
		writeInt(Inventory.PAPERDOLL_MAX);

		// Slots
		for(int PAPERDOLL_ID : Inventory.PAPERDOLL_ORDER)
			writeInt(getFromList(PAPERDOLL_ID));
	}

	private int getFromList(int key)
	{
		return ((_itemlist.get(key) != null) ? _itemlist.get(key) : 0);
	}
}