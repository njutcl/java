package ball;

import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame {
   Image ball=Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk=Toolkit.getDefaultToolkit().getImage("images/desk.jpg");

    double x=100;//横坐标
    double y=100;//纵坐标
    boolean right=true;
   double degree=3.14/3;//弧度

          //画窗口的方法
    public  void paint(Graphics g) {
//        System.out.println("画一次");
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int) x, (int) y, null);
        x = x + 10 * Math.cos(degree);
        y = y + 10 * Math.sin(degree);
    if(y>500-40-30||y<40+40)
    {
        degree=-degree;
    }
    if(x<40||x>856-40-30){
        degree=3.14-degree;
    }

    }


           //窗口加载
    void launchFrame() {
        setSize(856, 500);
        setLocation(50, 50);
        setVisible(true);


//重画窗口，每秒画25次
        while (true) {
            repaint();
            try {
                Thread.sleep(40);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
    //main方法是程序执行的入口
    public static void main(String[] args) {
        System.out.println("桌球小游戏");
        BallGame game = new BallGame();
        game.launchFrame();

    }



}
