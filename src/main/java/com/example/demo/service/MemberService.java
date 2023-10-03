package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.demo.repository.MemberRepository;
import com.example.demo.entity.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	
	public Member save(Member member) {
		Member savedMember = memberRepository.save(member);
		return savedMember;
	}
	
	public Member update(Member member) {
		Member updateMember = null;
		try {
			Member existMember = getMember(member.getId());
			if (!ObjectUtils.isEmpty(existMember)) {
				updateMember = memberRepository.save(member);
			}
			
		} catch (Exception e) {
			log.info("[Fail] e : " + e.toString());
		} finally {
			return updateMember;
		}
	}
	
	public List<Member> getMembers() {
		return memberRepository.findAll();
	}
	
	public Member getMember(Long id) throws Exception {
		Member member = memberRepository.findById(id).orElseThrow(() -> new Exception());
		return memberRepository.findById(id).get();
	}
	
	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}
}
