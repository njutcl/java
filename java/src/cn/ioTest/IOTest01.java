package cn.ioTest;

import java.io.*;
/*
1.创建源
2.选择流
3.操作（读取）
4.释放资源
*/


public class IOTest01 {
    public static void  main(String[] args){
        File src=new File("D:\\LTC\\学习\\java\\src\\abc.txt");
        InputStream is=null;
        try {
 is=new FileInputStream(src);
//
          int temp;
          while ((temp=is.read())!=-1)
          {
              System.out.println((char)temp);
          }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(null!=is)
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
