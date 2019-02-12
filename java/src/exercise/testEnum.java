package exercise;

public class testEnum {
    enum Season {
        spring, summer, autumn, winter
    }

    enum week {
        星期一, 星期二, 星期三, 星期四, 星期五, 星期六, 星期日
    }

    public static void main(String[] args) {
        System.out.println(Season.spring);

        Season a = Season.autumn;

        switch (a) {
            case spring:
                System.out.println("春天来了");
                break;
            case summer:
                System.out.println("夏天来了");
                break;
            case autumn:
                System.out.println("秋天");
                break;
            case winter:
                System.out.println("冬天");
                break;

        }
    }

}
