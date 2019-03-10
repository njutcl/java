package cn.thread;

public class web12306 implements Runnable {

    private int ticketNums=99;
    public void run(){
        while (true){
            if(ticketNums<0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
        }
    }
public static void main(String []args){
        web12306 web=new web12306();

        new Thread(web,"刘天畅").start();
        new Thread(web,"周杰伦").start();
        new Thread(web,"梅西").start();


}
}
