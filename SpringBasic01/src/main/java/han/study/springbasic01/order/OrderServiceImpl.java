package han.study.springbasic01.order;

import han.study.springbasic01.discount.DiscountPolicy;
import han.study.springbasic01.discount.FixDiscountPolicy;
import han.study.springbasic01.discount.RateDiscountPolicy;
import han.study.springbasic01.member.Member;
import han.study.springbasic01.member.MemberRepository;
import han.study.springbasic01.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private MemberRepository memberRepository;
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
