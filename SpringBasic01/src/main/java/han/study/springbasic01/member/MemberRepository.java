package han.study.springbasic01.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
