package com.example.android.mywok2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        System.out.println("---------------------- CREATE ----------------------");
        setContentView(R.layout.activity_family);

        List<FamilyMember> familyMembers = new ArrayList<>();
        familyMembers.add(new FamilyMember("Tata","Father", R.drawable.family_father));
        familyMembers.add(new FamilyMember("Mama", "Mother", R.drawable.family_mother));
        familyMembers.add(new FamilyMember("Fiu","Son", R.drawable.family_son));
        familyMembers.add(new FamilyMember("Fica","Daughter", R.drawable.family_daughter));
        familyMembers.add(new FamilyMember("Frate mai mare","Older brother", R.drawable.family_older_brother));
        familyMembers.add(new FamilyMember("Frate mai mic","Younger brother", R.drawable.family_younger_brother));
        familyMembers.add(new FamilyMember("Sora mai mare","Older Sister", R.drawable.family_older_sister));
        familyMembers.add(new FamilyMember("Sora mai mica","Younger Sister", R.drawable.family_younger_sister));
        familyMembers.add(new FamilyMember("Bunic", "Grandfather", R.drawable.family_grandfather));
        familyMembers.add(new FamilyMember("Bunica", "GrandMother", R.drawable.family_grandmother));

        FamilyMembersAdapter familyMembersAdapter = new FamilyMembersAdapter(this, familyMembers);
        ListView familiMembersListView = findViewById(R.id.family_members_list_view);
        familiMembersListView.setAdapter(familyMembersAdapter);
    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        System.out.println("---------------------- START ----------------------");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        System.out.println("---------------------- RESUME ----------------------");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        System.out.println("---------------------- PAUSE ----------------------");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        System.out.println("---------------------- STOP ----------------------");
//    }
}
