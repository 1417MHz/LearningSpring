package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 주문 서비스 인터페이스 구현체
@Component
@RequiredArgsConstructor // Lombok
public class OrderServiceImpl implements OrderService {

    // 새로운 할인 정책을 적용함으로서 OCP 위반(서비스 계층의 코드는 변경 되어선 안 된다!)
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // 추상(인터페이스) 뿐만 아니라 구체(구현) 클래스에도 의존하고 있다. 그러모로 DIP도 위반

    // 의존관계를 외부에서 주입
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 추상화에 의존
//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    } // Lombok이 final이 적혀있는 필드를 이용해 알아서 생성자 코드를 만들어줌

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
