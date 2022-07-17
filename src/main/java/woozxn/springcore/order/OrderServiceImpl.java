package woozxn.springcore.order;

import woozxn.springcore.discount.DiscountPolicy;
import woozxn.springcore.discount.FixDiscountPolicy;
import woozxn.springcore.member.Member;
import woozxn.springcore.member.MemberRepository;
import woozxn.springcore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
