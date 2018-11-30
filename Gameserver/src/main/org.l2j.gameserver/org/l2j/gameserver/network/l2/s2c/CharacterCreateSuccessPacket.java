package org.l2j.gameserver.network.l2.s2c;

import org.l2j.mmocore.StaticPacket;

@StaticPacket
public class CharacterCreateSuccessPacket extends L2GameServerPacket {

	public static final L2GameServerPacket STATIC = new CharacterCreateSuccessPacket();

	private CharacterCreateSuccessPacket() { }

	@Override
	protected final void writeImpl()
	{
		writeInt(0x01);
	}

	@Override
	protected int packetSize() {
		return super.packetSize() + 4;
	}
}