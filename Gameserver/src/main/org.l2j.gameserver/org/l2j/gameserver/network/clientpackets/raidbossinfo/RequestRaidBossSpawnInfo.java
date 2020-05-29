package org.l2j.gameserver.network.clientpackets.raidbossinfo;

import org.l2j.gameserver.instancemanager.DBSpawnManager;
import org.l2j.gameserver.instancemanager.GrandBossManager;
import org.l2j.gameserver.instancemanager.RaidBossStatus;
import org.l2j.gameserver.network.clientpackets.ClientPacket;
import org.l2j.gameserver.network.serverpackets.raidbossinfo.ExRaidBossSpawnInfo;
import java.util.HashMap;
import java.util.Map;

/**
 * @author THOSS
 */
public class RequestRaidBossSpawnInfo extends ClientPacket {
    private Map<Integer, Integer> _bossIds = new HashMap<Integer, Integer>();

    @Override
    public void readImpl() {
        final int count = readInt();
        for (int i = 0; i < count; i++) {
            final int bossId = readInt();
            // boss state: 1 -> alive : 0 -> dead : 2 -> in battle
            // TODO: how to check if a boss is in combat
            if (GrandBossManager.getInstance().getBossStatus(bossId) > -1) {
                _bossIds.put(bossId, GrandBossManager.getInstance().getBossStatus(bossId));
            } else {
                _bossIds.put(bossId, DBSpawnManager.getInstance().getNpcStatusId(bossId) == RaidBossStatus.ALIVE ? 1 : 0);
            }
        }
    }

    @Override
    public void runImpl() {
        client.sendPacket(new ExRaidBossSpawnInfo(_bossIds));
    }
}
