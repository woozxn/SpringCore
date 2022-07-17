package woozxn.springcore.discount;

import woozxn.springcore.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
