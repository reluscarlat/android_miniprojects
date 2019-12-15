package com.example.android.mywok2;

public class FamilyMember {
    private String member;
    private String translatedMember;
    private int memberImage;

    public FamilyMember(String member, String translatedMember, int memberImage) {
        this.member = member;
        this.translatedMember = translatedMember;
        this.memberImage = memberImage;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getTranslatedMember() {
        return translatedMember;
    }

    public void setTranslatedMember(String translatedMember) {
        this.translatedMember = translatedMember;
    }

    public int getMemberImage() {
        return memberImage;
    }

    public void setMemberImage(int memberImage) {
        this.memberImage = memberImage;
    }
}
