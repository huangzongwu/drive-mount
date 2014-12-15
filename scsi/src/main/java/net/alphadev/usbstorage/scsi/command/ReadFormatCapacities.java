/**
 * Copyright © 2014 Jan Seeger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.alphadev.usbstorage.scsi.command;

import net.alphadev.usbstorage.util.BitStitching;

import java.nio.ByteOrder;

/**
 * @author Jan Seeger <jan@alphadev.net>
 */
public class ReadFormatCapacities extends ScsiCommand {
    private static final byte READ_FORMAT_CAPACITIES = 0x23;

    @Override
    public byte[] asBytes() {
        byte[] retval = new byte[10];
        retval[0] = READ_FORMAT_CAPACITIES; // opcode
        BitStitching.setBytesFromShort((short) getExpectedAnswerLength(), retval, 7, ByteOrder.BIG_ENDIAN);
        return retval;
    }

    @Override
    public int getExpectedAnswerLength() {
        return 12;
    }
}
