package woozxn.springcore.discount;

import org.springframework.stereotype.Component;
import woozxn.springcore.member.Grade;
import woozxn.springcore.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
