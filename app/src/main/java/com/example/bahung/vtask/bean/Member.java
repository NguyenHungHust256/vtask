package com.example.bahung.vtask.bean;

/**
 * Created by bahung on 07/04/2018.
 **/

public class Member {
    private String name;
    private String gmail;
    private String phoneNumber;
    private String company;

    public Member(String name, String gmail, String phoneNumber, String company) {
        this.name = name;
        this.gmail = gmail;
        this.phoneNumber = phoneNumber;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public String getGmail() {
        return gmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCompany() {
        return company;
    }
}
