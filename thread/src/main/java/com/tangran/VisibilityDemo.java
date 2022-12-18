package com.tangran;

import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：tangran
 * @ Date       ：Created in 1:14 下午 2021/11/28
 */
public class VisibilityDemo {
    // -server 变成死循环，没加就是正常（内存可见性）
    // 通过设置jvm的参数，打印出jit编译的内容(这里说的编译非class文件 ， 底层汇编级别)通过可视化工具jitwatch进行查看
    // -server -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -XX:+LogCompilation -XX:LogFile=jit.log
    // 关闭jit优化：-Djava.compiler=NONE
    private boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        VisibilityDemo demo = new VisibilityDemo();
        new Thread(new Runnable() {
            public void run() {
                int i = 0;
                // class -> 运行时jit编译 -> 汇编指令 -> 指令重排序
                while (demo.flag) {
                    i++;
                }
//                -> 重排序
//                if (demo.flag){
//                    while (true){
//                        i++
//                    }
//                }
                System.out.println(i);
            }
        }).start();

        TimeUnit.SECONDS.sleep(2);
        // 设置flag为false，使上面的线程结束while循环
        demo.flag = false;
        System.out.println("被置为false");

    }
}
