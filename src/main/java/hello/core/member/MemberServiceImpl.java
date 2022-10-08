package hello.core.member;

// 멤버 서비스 구현체
public class MemberServiceImpl implements MemberService {

    // 의존관계가 인터페이스 뿐만 아니라 구현체를 의존하고 있음(추상화와 구현체 둘 다)
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;

    // 해결을 위해 의존관계를 외부에서 주입(구현체가 아닌 추상화에만 집중)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

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
