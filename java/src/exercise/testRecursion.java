package exercise;

import java.io.File;

public class testRecursion {


    public static void main(String[] args) {
        File f = new File("D:\\LTC\\大二上");
        File f1 = new File("user.dir");
        printFile(f,0);
    }

    static void printFile(File file,int level) {
        for(int i=0;i<level;i++){
            System.out.print("-");
        }
        System.out.println(file.getName());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File temp : files) {
                printFile(temp,level+1);
            }
        }
    }
}