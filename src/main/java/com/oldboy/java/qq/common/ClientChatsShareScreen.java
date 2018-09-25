package com.oldboy.java.qq.common;

import com.oldboy.java.qq.util.DataUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

public class ClientChatsShareScreen extends BaseMessage {

    private BufferedImage img;
    private String senderAddr;

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public int getMessageType() {
        return CLIENT_TO_SERVER_SHARE_SCREEN;
    }
    public byte[] popPack() throws Exception {

        ByteArrayOutputStream baos = new ByteArrayOutputStream() ;
        //消息类型:1byte
        baos.write(getMessageType());

        ImageIO.write(img,"jpg",baos);
        return baos.toByteArray();
    }
}
