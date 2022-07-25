package woozxn.springcore;

import woozxn.springcore.member.Grade;
import woozxn.springcore.member.Member;
import woozxn.springcore.member.MemberService;
import woozxn.springcore.order.Order;
import woozxn.springcore.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
