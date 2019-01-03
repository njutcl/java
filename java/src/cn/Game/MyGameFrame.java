package cn.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

//import static java.awt.Font.BOLD;

//主窗口


public class MyGameFrame extends Frame {
    Image planeImg = GameUtil.getImage("images/ball.png");
    Image bg = GameUtil.getImage("images/bg.jpg");
    //    int planeX = 250, planeY = 250;
    Plane plane = new Plane(planeImg, 300, 250);

    Shell[] shells = new Shell[50];
    Explode bao;
    Date startTime = new Date();
    Date endTime;
    int period;

    public void paint(Graphics g)//自动调用，相当于画笔
    {

// 0.2       Color c = g.getColor();
//        Font f = g.getFont();
//        g.setColor(Color.BLUE);
//         g.drawLine(100, 100, 300, 300);
//        g.drawRect(100, 100, 300, 300);
//        g.drawOval(100, 100, 300, 300);
//        g.fillRect(100, 100, 40, 40);
//        g.setFont(new Font("宋体", Font.BOLD, 50));
//        g.drawString("我是谁", 100, 100);
//        g.setColor(c);
//        g.setFont(f);

        g.drawImage(bg, 0, 0, null);
// 0.4       g.drawImage(plane, planeX, planeY, null);
//        planeX++;

        plane.drawSelf(g);//画飞机

        //画出所有炮弹
        for (int i = 0; i < shells.length; i++) {
            shells[i].draw(g);
            boolean peng = shells[i].getRect().intersects(plane.getRect());
            if (peng) {
                plane.live = false;
                if (bao == null) {
                    bao = new Explode(plane.x, plane.y);
                    endTime = new Date();
                    period = (int) (endTime.getTime() - startTime.getTime())/1000;
                }

                bao.draw(g);
            }

            //计时功能，给出提示
            if(!plane.live){
                Color c=g.getColor();
                g.setColor(Color.red);
                Font f=new Font("宋体",Font.BOLD,50);
                g.setFont(f);
                g.drawString("时间："+period+"秒",(int)plane.x,(int)plane.y);
                g.setColor(c);
            }

        }

    }

    class PaintThread extends Thread {
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class KetMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane.minusDirection(e);
        }
    }

    //初始化窗口
    public void launchFrame() {
        this.setTitle("飞机小游戏");
        this.setVisible(true);
        this.setSize(Constant.GameWidth, Constant.GameHeight);
        this.setLocation(600, 300);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        new PaintThread().start();  //启动重画窗口的线程
        addKeyListener(new KetMonitor());//增加键盘的监听
//初始化50个炮弹

        for (int i = 0; i < shells.length; i++) {
            shells[i] = new Shell();
        }
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();

    }

    private Image offScreenImage = null;

    public void update(Graphics g) {
        if (offScreenImage == null)
            offScreenImage = this.createImage(500, 500);//这是游戏窗口的宽度和高度

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}
