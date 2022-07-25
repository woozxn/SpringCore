package woozxn.springcore;

import woozxn.springcore.discount.FixDiscountPolicy;
import woozxn.springcore.member.MemberService;
import woozxn.springcore.member.MemberServiceImpl;
import woozxn.springcore.member.MemoryMemberRepository;
import woozxn.springcore.order.OrderService;
import woozxn.springcore.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
