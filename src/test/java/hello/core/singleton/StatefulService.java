package hello.core.singleton;

public class StatefulService {

//    public int price; // 상태를 유지하는 필드
//
//    public void order(String name, int price) {
//        System.out.println("name = " + name + " price = " + price);
//        this.price = price; // 여기가 문제
//    }
//
//    public int getPrice() {
//        return price;
//    }


    // 해결 방법
    // 객체의 상태를 유지(stateful)하지 않고 무상태(stateless)하게 설계하면 된다
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }

}
