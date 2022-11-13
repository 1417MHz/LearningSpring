package hello.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {
    // Lombok이 특정 필드의 Getter와 Setter를 만들어준다

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("kim");
        helloLombok.setAge(20);

        String name = helloLombok.getName();
        int age = helloLombok.getAge();
        System.out.println("name = " + name + " / age = " + age);

    }
}
