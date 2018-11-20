package org.l2j.gameserver.network.l2.s2c;

import org.l2j.gameserver.model.base.Element;

/**
 * @author Bonux
**/
public class ExAttributeEnchantResultPacket extends L2GameServerPacket
{
	private final boolean _isWeapon;
	private final Element _element;
	private final int _oldValue;
	private final int _newValue;
	private final int _usedStones;
	private final int _failedStones;

	public ExAttributeEnchantResultPacket(boolean isWeapon, Element element, int oldValue, int newValue, int usedStones, int failedStones)
	{
		_isWeapon = isWeapon;
		_element = element;
		_oldValue = oldValue;
		_newValue = newValue;
		_usedStones = usedStones;
		_failedStones = failedStones;
	}

	@Override
	protected final void writeImpl()
	{
		writeShort(0x00); // TODO
		writeShort(0x00); // TODO
		writeByte(_isWeapon ? 0x01 : 0x00); // Armor - 0x00 / Weapon - 0x01
		writeShort(_element.getId()); // Element
		writeShort(_oldValue);
		writeShort(_newValue);
		writeShort(_usedStones);
		writeShort(_failedStones);
	}
}