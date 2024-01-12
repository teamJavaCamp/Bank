package com.bank.data;

import com.bank.model.MemberDTO;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class MemberData {

    private static Map<String, MemberDTO> memberMap;

    public MemberData(){
        memberMap = new HashMap<String, MemberDTO>();
    }


    public MemberDTO getMember(String id){
        return memberMap.get(id);
    }

    public Map<String, MemberDTO> getMemberMap() { // 회원 맵 전달
        return memberMap;
    }

    public void addMember(String username, MemberDTO member) { // 회원 추가
        memberMap.put(username, member);
    }

    public void removeMember(String username) { // 회원 삭제
        memberMap.remove(username);
    }

    public void showMembers() {
        Iterator<String> keyIter = memberMap.keySet().iterator();

        while(keyIter.hasNext()) {
            String key = keyIter.next();
            MemberDTO value = memberMap.get(key);
            System.out.println(value);
        }
    }








}
