package effective.chapter01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @ClassName: Item09
 * @Author chengfei
 * @DateTime 2022/4/28 13:36
 * @TODO:
 **/
public class Item09 {
    public static void main(String[] args) throws IOException {
        TryFinally();
//        TryWithResources();
    }

    static void TryFinally() throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter("E:\\tmp\\tmp.txt"));
        try {
            Scanner scanner = new Scanner(System.in);
            try {
                out.write(scanner.nextLine());
            }finally {
                scanner.close();
            }
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    static void TryWithResources(){
        try(BufferedWriter out = new BufferedWriter(new FileWriter("E:\\tmp\\tmp.txt"));
            Scanner scanner = new Scanner(System.in)) {
            out.write(scanner.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
