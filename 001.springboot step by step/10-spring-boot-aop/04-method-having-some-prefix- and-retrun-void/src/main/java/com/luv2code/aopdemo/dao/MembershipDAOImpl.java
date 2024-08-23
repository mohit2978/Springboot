package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public void addSillyMember() {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");

    }

    @Override
    public void add() {
        System.out.println("simple add aspect should run before it");
    }

    @Override
    public int addVersion() {
        System.out.println("No expect should run as int return type method although add* satisfied");
        return 0;
    }
}
