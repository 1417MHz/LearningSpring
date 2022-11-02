package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;


@Configuration
@ComponentScan(
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    // 컴포넌트 스캔을 사용하면 @Configuration 이 붙은 설정 정보도 자동으로 등록되기 때문에,
    // AppConfig, TestConfig 등 앞서 만들어두었던 설정 정보도 함께 등록되고, 실행되어 버린다. 그래서
    // excludeFilters 를 이용해서 설정정보는 컴포넌트 스캔 대상에서 제외했다.

    // 수동 빈 등록 vs 자동 빈 등록
    // 두 등록에서 빈 이름이 충돌하면, 예외는 발생하지 않고 수동 빈 등록이 우선권을 갖게 되어 수동 빈이 자동 빈을 오버라이딩 해버린다.
    // 다만 최근 스프링 부트는 이 경우 오류가 발생하도록 기본값이 변경되었다.
    // 스프링 부트를 통한 실행(CoreApplication)으로 실행해보면 알 수 있다.
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
