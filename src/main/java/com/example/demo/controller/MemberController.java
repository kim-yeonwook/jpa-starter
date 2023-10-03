package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MemberService;
import com.example.demo.service.RoleService;
import com.example.demo.entity.Member;
import com.example.demo.entity.MemberHistory;
import com.example.demo.entity.Role;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	private final RoleService roleService;
	
	
	@PostMapping("/member")
	public ResponseEntity<Member> save() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("1996-05-10");
//        List<MemberHistory> memberHistoryList = new ArrayList<MemberHistory>();
//        memberHistoryList.add(new MemberHistory().builder().loginType("WEB").build());
//        memberHistoryList.add(new MemberHistory().builder().loginType("MOBILE").build());

        Role role = roleService.getRole(1l);
        
        Member member = Member.builder()
                .name("kimyeonwook")
                .email("dsudnr96@naver.com")
                .nickname("ywkims")
                .age(27)
                .birthday(date)
                .role(role)
//                .memberHistory(memberHistoryList)
                .build();
        member.getMemberHistory().add(new MemberHistory().builder().loginType("WEB").build());
        member.getMemberHistory().add(new MemberHistory().builder().loginType("MOBILE").build());
        
        
        Member savedMember = memberService.save(member);
        return new ResponseEntity<>(savedMember, HttpStatus.OK);
	}
	
	@PutMapping("/member")
	public ResponseEntity<Member> update() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("1996-05-10");
        Member member = Member.builder()
                .id(1l)
                .name("kimyeonwook")
                .email("dsudnr96@naver.com")
                .nickname("ywkims")
                .age(27)
                .birthday(date)
                .build();
        Member updatedMember = memberService.update(member);
		if (!ObjectUtils.isEmpty(updatedMember)) {
			return new ResponseEntity<>(updatedMember, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(member, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/member/{id}")
	public ResponseEntity<Long> delete(@PathVariable("id") Long id) throws Exception {
		memberService.getMember(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	@GetMapping("/member/{id}")
	public ResponseEntity<Member> findOne(@PathVariable("id") Long id) throws Exception {
		Member oneMember = memberService.getMember(id);
		return new ResponseEntity<>(oneMember, HttpStatus.OK);
	}
	
	@GetMapping("/members")
	public ResponseEntity<List<Member>> findAll() {
		List<Member> allMember = memberService.getMembers();
		return new ResponseEntity<>(allMember, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/test")
	public ResponseEntity<List<Member>> test(@RequestBody Member member) {
		List<Member> allMember = memberService.getMembers();
		return new ResponseEntity<>(allMember, HttpStatus.OK);
		
	}
}
