package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

// 이렇게 애플리케이션으로 테스트하는 방식은 좋지 않다. JUnit 테스트를 사용하자
public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        // id 뒤에 L이 붙은 이유는 Long 타입이라 그럼
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // id를 통해 멤버를 찾음
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

        // 이러한 테스트 방식은 눈으로 직접 검증해야 한다는 단점이 있음
    }
}
