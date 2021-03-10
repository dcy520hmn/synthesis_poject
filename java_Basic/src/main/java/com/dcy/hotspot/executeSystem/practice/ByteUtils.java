package com.dcy.hotspot.executeSystem.practice;

/**
 * Bytes数组处理工具
 * @author
 */
public class ByteUtils {
    public static int bytes2Int(byte[] b, int start, int len) {
        int sum = 0;
        int end = start + len;
        for (int i = start; i < end; i++) {
            int n = ((int) b[i]) & 0xff;
            n <<= (--len) * 8;
            sum = n + sum;
        }
        return sum;
    }

    /**
     * 将int转成byte，存到数组最后一位
     * @param value
     * @param len
     * @return
     */
    public static byte[] int2Bytes(int value, int len) {
        byte[] b = new byte[len];
        for (int i = 0; i < len; i++) {
            b[len - i - 1] = (byte) ((value >> 8 * i) & 0xff);
        }
        return b;
    }

    public static String bytes2String(byte[] b, int start, int len) {
        return new String(b, start, len);
    }

    public static byte[] string2Bytes(String str) {
        return str.getBytes();
    }

    /**
     * 字节替换
     * @param originalBytes 原字节
     * @param offset 偏移量，从哪里开始替换。
     * @param len 替换长度
     * @param replaceBytes 要替换的字节
     * @return
     */
    public static byte[] bytesReplace(byte[] originalBytes, int offset, int len, byte[] replaceBytes) {
        //计算新字节数组的长度。减去原来占位
        byte[] newBytes = new byte[originalBytes.length + (replaceBytes.length - len)];
        //保存offet之前的字节
        System.arraycopy(originalBytes, 0, newBytes, 0, offset);
        //添加要替换的字节
        System.arraycopy(replaceBytes, 0, newBytes, offset, replaceBytes.length);
        //保存替换长度之后的字节
        System.arraycopy(originalBytes, offset + len, newBytes, offset + replaceBytes.length, originalBytes.length - offset - len);
        return newBytes;
    }

}