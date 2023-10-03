package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.entity.MemberHistory;
import com.example.demo.entity.Role;
import com.example.demo.repository.MemberHistoryRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.RoleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@DataJpaTest
public class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    MemberHistoryRepository memberHistoryRepository;

    @Test
    @DisplayName("Member insert ~ delete Test")
    public void insertMember() throws ParseException {
        Role role = Role.builder()
                .code("ADMIN")
                .name("관리자")
                .build();

        role = roleRepository.save(role);
        
        Member member = Member.builder()
                .name("kimyeonwook")
                .age(27)
                .email("dsudnr96@naver.com")
                .nickname("nickname")
                .role(role)
                .birthday(new SimpleDateFormat("yyyyMMdd").parse("19960510"))
                .build();

        member = memberRepository.save(member);


        MemberHistory memberHistory = MemberHistory.builder()
                .loginType("WEB")
                .build();

        member.add(memberHistory);

        memberHistoryRepository.save(memberHistory);

        // lazy fetch entity에 toString을 사용하면 entity를 가져오기 위해 read메서드 실행
        // read 메서드 진행시 logback 설정이 debug일시 entity의 toString을 호출
        // 이렇게 되면 toString이 재귀적으로 호출되 stackoverflow 에러 발생
        // 이러한 이유 때문에 lazy fetch entity에 toSting을 사용하는 것은 바람직하지 않음
        List<Member> list = memberRepository.findAll();
        System.out.println(list.get(0).getId());
        System.out.println(list.get(0).getNickname());
        System.out.println(list.get(0).getName());
        System.out.println(list.get(0).getEmail());
        System.out.println(list.get(0).getBirthday());
        list.get(0).getMemberHistory().forEach(a->System.out.println(a.getId()+" "+a.getLoginType()));
        System.out.println(list.get(0).getRole().getId());
        System.out.println(list.get(0).getRole().getCode());
        System.out.println(list.get(0).getRole().getName());
    }
}
