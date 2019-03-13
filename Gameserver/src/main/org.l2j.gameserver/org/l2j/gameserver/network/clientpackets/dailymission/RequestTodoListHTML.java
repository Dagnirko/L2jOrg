/*
 * This file is part of the L2J Mobius project.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.l2j.gameserver.network.clientpackets.dailymission;

import org.l2j.gameserver.network.clientpackets.IClientIncomingPacket;

import java.nio.ByteBuffer;

/**
 * @author Mobius
 */
public class RequestTodoListHTML extends IClientIncomingPacket {
    @SuppressWarnings("unused")
    private int _tab;
    @SuppressWarnings("unused")
    private String _linkName;

    @Override
    public void readImpl(ByteBuffer packet) {
        _tab = packet.get();
        _linkName = readString(packet);
    }

    @Override
    public void runImpl() {
    }
}