package woozxn.springcore;

import woozxn.springcore.discount.DiscountPolicy;
import woozxn.springcore.discount.FixDiscountPolicy;
import woozxn.springcore.member.MemberRepository;
import woozxn.springcore.member.MemberService;
import woozxn.springcore.member.MemberServiceImpl;
import woozxn.springcore.member.MemoryMemberRepository;
import woozxn.springcore.order.OrderService;
import woozxn.springcore.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), new FixDiscountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
