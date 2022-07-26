package woozxn.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import woozxn.springcore.discount.DiscountPolicy;
import woozxn.springcore.discount.FixDiscountPolicy;
import woozxn.springcore.discount.RateDiscountPolicy;
import woozxn.springcore.member.MemberRepository;
import woozxn.springcore.member.MemberService;
import woozxn.springcore.member.MemberServiceImpl;
import woozxn.springcore.member.MemoryMemberRepository;
import woozxn.springcore.order.OrderService;
import woozxn.springcore.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), new FixDiscountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
    }
}
