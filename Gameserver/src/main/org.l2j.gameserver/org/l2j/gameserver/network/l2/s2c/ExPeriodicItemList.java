package org.l2j.gameserver.network.l2.s2c;

public final class ExPeriodicItemList extends L2GameServerPacket
{
    private final int _result;
    private final int _objectID;
    private final int _period;

    public ExPeriodicItemList(int result, int objectID, int period)
    {
        _result = result;
        _objectID = objectID;
        _period = period;
    }

    @Override
    protected void writeImpl()
    {
        writeInt(_result);
        writeInt(_objectID);
        writeInt(_period);
    }
}