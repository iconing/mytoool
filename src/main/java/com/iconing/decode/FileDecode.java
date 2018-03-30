package com.iconing.decode;

import java.io.*;
import java.util.Base64;

public class FileDecode {

    /**
     * 对base64编码的文件进行解码。
     * @param base64File 要解码的文件
     * @param destFile 解码出来的文件
     * @throws IOException 数据读取异常的时候，抛出io异常
     */
    public void decode(String base64File, String destFile) throws IOException {
        Base64.Decoder decoder = Base64.getDecoder();
        try(InputStream in = decoder.wrap(new FileInputStream(base64File));
            OutputStream out1 = new FileOutputStream(destFile)) {
            int rl;
            byte[] readByte = new byte[1024];
            while((rl = in.read(readByte)) != -1) {
                out1.write(readByte, 0, rl);
                out1.flush();
            }
            in.close();
            out1.close();
        }
    }
}
