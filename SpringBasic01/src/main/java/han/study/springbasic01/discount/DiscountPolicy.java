package han.study.springbasic01.discount;

import han.study.springbasic01.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
