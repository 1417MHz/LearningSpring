package hello.core.member;

// 멤버 서비스 구현체
public class MemberServiceImpl implements MemberService {

    // 의존관계가 인터페이스 뿐만 아니라 구현체를 의존하고 있음(추상화와 구체화 둘 다)
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 다형성으로 인해 MemberRepository 구현체 속 메소드를 호출

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
