package com.bank.manager;

import com.bank.data.AccountData;
import com.bank.data.MemberData;
import com.bank.model.AccountDTO;
import com.bank.model.MemberDTO;

import java.util.Scanner;

public class MemberManager {

    private Scanner sc = new Scanner(System.in);
    private MemberData memberData = new MemberData();     //회원 데이터
    private AccountData accData = new AccountData();
    public MemberManager(){}

    public void signUp(){
        System.out.println("===== 회원가입 =====");
        System.out.print("이름 : ");
        String name = sc.nextLine();

        System.out.print("나이 : ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("성별 : ");
        char gender = sc.nextLine().charAt(0);

        System.out.print("id : ");
        String id = sc.nextLine();

        if(!memberData.getMemberMap().containsKey(id)){

            System.out.print("password : ");
            String pwd = sc.nextLine();

            MemberDTO member = new MemberDTO(name, age, gender, id, pwd);

            memberData.addMember(id, member);
            creatAccount(member);

            System.out.println();
            System.out.println(" ** 회원가입이 완료되었습니다. **");
            System.out.println();

        }

    }

    public String signIn(){               //로그인

        System.out.print("id : ");
        String id = sc.nextLine();
        if(memberData.getMemberMap().containsKey(id)){
            System.out.print("password : ");
            String pwd = sc.nextLine();
            MemberDTO member = memberData.getMember(id);

            if(member.getPwd().equals(pwd)){
                System.out.println();
                System.out.println(" ** 로그인에 성공하였습니다 **");
                System.out.println();
                return id;

            }else {
                System.out.println();
                System.out.println(" ** 비밀번호가 틀립니다. ** ");
                System.out.println();
            }

        }else {
            System.out.println();
            System.out.println(" ** 등록된 아이디가 없습니다. ** ");
            System.out.println();
        }
        return "";

    }

    public MemberDTO memberSignin(String id){
        return memberData.getMember(id);
    } //회원객체 전달

    public void creatAccount(MemberDTO member){
        int[] accNum = new int [7];
        String accN = "";

        for(int i = 0; i < accData.getList().size() + 1; i++){
            accN = "";

            for(int j = 0; j < accNum.length; j++){
                accNum[j] = (int) (Math.random() * 9);
                accN += accNum[j]+"";
            }

            for(int k = 0; k < i; k++){
                if(accData.getList().get(k).getAccNum().equals(accN)){
                    i--;
                    break;
                }
            }
        }
                //계좌번호 난수 생성

        AccountDTO acc = new AccountDTO(accN, 0);

        accData.addAccount(acc); //리스트에 담기
        member.setAccount(acc); //회원정보에 계좌정보저장

    }

    public void showMemberAll(){
        memberData.showMembers();
    }   //회원 전체 조회


    public void showMyProduct(MemberDTO member){
        System.out.println(member.getProduct());
    }                                           // 내 가입 상품 조회

    public void editInfo(){

        System.out.print("변경할 회원 아이디 : ");
        String id = sc.nextLine();

        if(memberData.getMemberMap().containsKey(id)){
            MemberDTO member = memberData.getMember(id);
            while(true) {

                System.out.println("===== 회원 정보 변경 =====");

                System.out.println("1. 이름");
                System.out.println("2. 나이");
                System.out.println("3. 성별");
                System.out.println("4. 패스워드");
                System.out.println("0. 뒤로");

                System.out.print("변경할 정보를 고르세요 : ");
                int select = sc.nextInt();
                sc.nextLine();

                switch (select) {
                    case 1:
                        System.out.print("변경할 이름 : ");
                        String name = sc.nextLine();
                        member.setName(name);

                        System.out.println();
                        System.out.println(" ** 변경이 완료되었습니다. ** ");
                        System.out.println();
                        break;

                    case 2:
                        System.out.print("변경할 나이 : ");
                        int age = sc.nextInt();
                        member.setAge(age);

                        System.out.println();
                        System.out.println(" ** 변경이 완료되었습니다. ** ");
                        System.out.println();
                        break;

                    case 3:
                        System.out.println("변경할 성별 : ");
                        char gender = sc.nextLine().charAt(0);
                        member.setGender(gender);

                        System.out.println();
                        System.out.println(" ** 변경이 완료되었습니다. ** ");
                        System.out.println();
                        break;

                    case 4:
                        System.out.println("변경할 비밀번호 : ");
                        String pwd = sc.nextLine();
                        member.setPwd(pwd);

                        System.out.println();
                        System.out.println(" ** 변경이 완료되었습니다. ** ");
                        System.out.println();
                        break;

                    case 0:
                        return;

                    default:
                        System.out.println();
                        System.out.println(" ** 잘못된 입력입니다. ** ");
                        System.out.println();
                        break;
                }
            }

        }else {
            System.out.println();
            System.out.println(" ** 회원을 찾을 수 없습니다. **");
            System.out.println();
        }
    }
}
