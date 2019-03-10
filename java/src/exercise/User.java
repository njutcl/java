package exercise;

public class User {
    int id;
    String name;
    String pwd;
    static String company = "KFC";

    static {
        System.out.println("执行类的初始化工作");
        company = "小留同学";
        printCompany();
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;

    }

//    public User(int id, String name, String company) {
//        this.id = id;
//        this.name = name;
//        this.company = company;
//    }

//    public void login() {
//        System.out.println("登录:" + name);
//    }

    public static void printCompany() {
        System.out.println(company);
    }

    public void test(User u) {
        u.name = "messi";
    }

    public void test2(User u) {
        u = new User(200, "gg");
    }


    public static void main(String[] args) {
        User u1 = new User(100, "dovahkiin");
        u1.test(u1);
        System.out.println(u1.name);
        u1.test2(u1);
        System.out.println(u1.name);
        User u2 = new User(101, "messy");
        User.printCompany();
        User.company = "alipay";
        User.printCompany();

    }

}