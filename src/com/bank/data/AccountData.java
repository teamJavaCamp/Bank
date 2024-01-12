package com.bank.data;

import com.bank.model.AccountDTO;

import java.util.ArrayList;
import java.util.List;

public class AccountData {

    private static List<AccountDTO> accList;

    public AccountData(){
        accList = new ArrayList<AccountDTO>();
    }

    public List<AccountDTO> getList(){
        return accList;
    }


    public void addAccount(AccountDTO acc){
        accList.add(acc);
    }   // 리스트에 계좌 추가






}
