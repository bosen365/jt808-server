package org.yzh.protocol.commons.transform.attribute;

import io.netty.buffer.ByteBuf;

/**
 * IO 状态位，定义见表 32
 * length 2
 */
public class IoState {

    public static final int id = 0x2a;

    public static int id() {
        return id;
    }

    private int value;

    public IoState() {
    }

    public IoState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static class Schema implements io.github.yezhihao.protostar.Schema<IoState> {

        public static final Schema INSTANCE = new Schema();

        private Schema() {
        }

        @Override
        public IoState readFrom(ByteBuf input) {
            IoState message = new IoState();
            message.value = input.readUnsignedShort();
            return message;
        }

        @Override
        public void writeTo(ByteBuf output, IoState message) {
            output.writeShort(message.value);
        }
    }
}