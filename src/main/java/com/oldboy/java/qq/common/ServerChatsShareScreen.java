package com.oldboy.java.qq.common;

import com.oldboy.java.qq.util.DataUtil;

import java.io.ByteArrayOutputStream;

public class ServerChatsShareScreen extends BaseMessage{

    private byte[] senderAddrBytes;
    private byte[] bufferImageBytes;


    public byte[] getSendAddrBytes() {
        return senderAddrBytes;
    }

    public void setSendAddrBytes(byte[] sendAddrBytes) {
        this.senderAddrBytes = sendAddrBytes;
    }

    public byte[] getBufferImageBytes() {
        return bufferImageBytes;
    }

    public void setBufferImageBytes(byte[] bufferImageBytes) {
        this.bufferImageBytes = bufferImageBytes;
    }

    public int getMessageType() {
        return SERVER_TO_CLIENT_SHARE_SCREEN;
    }

    public byte[] popPack() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //消息类型
        baos.write(getMessageType());
        //发送地址长度
        baos.write(senderAddrBytes.length);
        //发送地址
        baos.write(senderAddrBytes);

        //消息长度
        baos.write(DataUtil.int2Bytes(bufferImageBytes.length));
        baos.write(bufferImageBytes);

        return baos.toByteArray();
    }
}
