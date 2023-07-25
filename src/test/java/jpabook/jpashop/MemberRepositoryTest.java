package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    
    @Test
    @DisplayName("Check DB READ")
    @Transactional
    public void testMember() throws Exception{
        //given
        Member member = new Member();
        member.setName("memberA");
        //when

        long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);
        //then

        Assertions.assertThat(member.getId()).isEqualTo(findMember.getId());
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
        Assertions.assertThat(member).isEqualTo(findMember);




    }
}
