package com.feifei.c3_JMM;

/**
  * @Todo:
  * @DateTime: 2021/5/1 20:36
  * @author :乱序执行的证明
 */
public class T02_Disorder1Thread {
    private static int x = 0, y = 0;
    private static int a = 0, b =0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for(;;) {
            i++;
            x = 0;
            a = 0;

            Thread thread = new Thread() {
                @Override
                public void run() {
                    a = 1;
                    x = a;
                }
            };
            thread.start();
            thread.join();

            String result = "第" + i + "次 (" + x + "）";
            if(x == 0) {
                System.err.println(result);
                break;
            } else {
                //System.out.println(result);
            }
        }
    }


    public static void shortWait(long interval){
        long start = System.nanoTime();
        long end;
        do{
            end = System.nanoTime();
        }while(start + interval >= end);
    }
}