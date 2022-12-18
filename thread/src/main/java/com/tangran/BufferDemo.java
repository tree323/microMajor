package com.tangran;

import java.nio.ByteBuffer;

/**
 * @ Author     ：tangran
 * @ Date       ：Created in 3:39 下午 2022/12/18
 */
public class BufferDemo {
    public static void main(String[] args) {
        // 构建一个byte字节缓冲区，容量是4
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        System.out.println(String.format( "初始化：capacity容量：%s，position位置：%s。limit限制：%s", byteBuffer.capacity(), byteBuffer.position(), byteBuffer.limit()));
        // 写入3字节的数据
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 2);
        byteBuffer.put((byte) 3);
        System.out.println(String.format( "写入3字节后：capacity容量：%s，position位置：%s。limit限制：%s", byteBuffer.capacity(), byteBuffer.position(), byteBuffer.limit()));
        // 转换为读取模式（不调用flip方法，也是可以读取的，但是position记录读取的位置不对）
        System.out.println("开始读取");
        byteBuffer.flip();
        byte a = byteBuffer.get();
        byte b = byteBuffer.get();
        System.out.println(a + b);

        // rewind()重置position为0
        // mark() 标记position位置
        // reset() 重置position为上次mark() 标记的位置
    }
}
