package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o() {
        // given
        Member member = new Member(1L, "MemberVIP", Grade.VIP);

        // when
        int discountPrice = discountPolicy.discount(member, 10000);

        // then
        assertThat(discountPrice).isEqualTo(1000);
        // 계산된 할인값이 맞는가

    }

    @Test
    @DisplayName("VIP가 아닐 경우 할인이 적용되지 않는다")
    void vip_x() {
        // given
        Member member = new Member(2L, "MemberBASIC", Grade.BASIC);

        // when
        int discountPrice = discountPolicy.discount(member, 20000);

        // then
        assertThat(discountPrice).isEqualTo(0);

    }
}
