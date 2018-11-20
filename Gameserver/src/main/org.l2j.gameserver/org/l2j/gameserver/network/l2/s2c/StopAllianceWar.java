package org.l2j.gameserver.network.l2.s2c;

public class StopAllianceWar extends L2GameServerPacket
{
	private String _allianceName;
	private String _char;

	public StopAllianceWar(String alliance, String charName)
	{
		_allianceName = alliance;
		_char = charName;
	}

	@Override
	protected final void writeImpl()
	{
		writeString(_allianceName);
		writeString(_char);
	}
}