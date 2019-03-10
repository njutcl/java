package cn.thread;

//Lambda表达式  简化线程的使用
public class LamdaThread {
    //    静态内部类
    static class Test implements Runnable {
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("一边打游戏");
            }
        }


    }

    public static void main(String[] args) {
        new Thread(new Test()).start();
//局部内部类
        class Test2 implements Runnable {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("一边打球");
                }
            }
        }
        new Thread(new Test2()).start();
//匿名内部类 必须借助接口或者父类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("一边听歌");
                }
            }
        }).start();

        //jdk8简化 lambda
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("一边吃饭");
            }
        }).start();


    }
}