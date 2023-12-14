package han.study.springbasic01;

import han.study.springbasic01.discount.DiscountPolicy;
import han.study.springbasic01.discount.FixDiscountPolicy;
import han.study.springbasic01.member.MemberRepository;
import han.study.springbasic01.member.MemberService;
import han.study.springbasic01.member.MemberServiceImpl;
import han.study.springbasic01.member.MemoryMemberRepository;
import han.study.springbasic01.order.OrderService;
import han.study.springbasic01.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
