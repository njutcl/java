package cn.ioTest;

import java.io.*;

public class Copy {
    public static void main(String[] args) {
        copy("src/abc.txt","src/dest.txt");
    }

    public static void copy(String srcPath, String destPath) {

        //创建源
        File src = new File("D:\\LTC\\学习\\java\\src\\abc.txt");
        File dest = new File("D:\\LTC\\学习\\java\\src\\dest.txt");
        //选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            //操作（分段读取）
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //分别关闭  先打开的后关闭
            try {
                if (null != os)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            if (null != is)
                is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

