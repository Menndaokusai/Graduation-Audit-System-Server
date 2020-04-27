package com.example.demo.model;

public class Voting_Record {

    private int voteId;
    private String username;
    private int num;

    public Voting_Record() {
    }

    public Voting_Record(int voteId, String username, int num) {
        this.voteId = voteId;
        this.username = username;
        this.num = num;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Voting_Record{" +
                "voteId=" + voteId +
                ", username='" + username + '\'' +
                ", num=" + num +
                '}';
    }
}
