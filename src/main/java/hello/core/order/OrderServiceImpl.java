package hello.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService {
	
	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;
	
	//테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
	
    @Autowired
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}


	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		 
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
}
