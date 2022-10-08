package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void BeforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder1() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order1 = orderService.createOrder(memberId, "itemA", 20000);
        Assertions.assertThat(order1.getDiscountPrice()).isEqualTo(1000);
    }

//    @Test // 예외 발생
//    void createOrder2() {
//        Long memberId = 2L;
//        Member member = new Member(memberId, "memberB", Grade.BASIC);
//        memberService.join(member);
//
//        Order order1 = orderService.createOrder(memberId, "itemB", 30000);
//        Assertions.assertThat(order1.getDiscountPrice()).isEqualTo(1000);
//    }
}
