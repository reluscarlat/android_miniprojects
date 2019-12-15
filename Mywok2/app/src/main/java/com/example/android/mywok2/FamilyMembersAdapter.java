package com.example.android.mywok2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FamilyMembersAdapter extends ArrayAdapter<FamilyMember> {
    public FamilyMembersAdapter(Context context, List<FamilyMember> members) {
        super(context, 0 , members);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View familyMemberView = convertView;
        if(familyMemberView == null) {
            familyMemberView = LayoutInflater.from(getContext()).inflate(R.layout.family_item, parent, false);
        }
        TextView familyMember = familyMemberView.findViewById(R.id.family_member);
        TextView translatedFamilyMember = familyMemberView.findViewById(R.id.family_member_translated);
        ImageView familyMemberImage = familyMemberView.findViewById(R.id.family_member_image);

        familyMember.setText(getItem(position).getMember());
        translatedFamilyMember.setText(getItem(position).getTranslatedMember());
        familyMemberImage.setImageResource(getItem(position).getMemberImage());

        return familyMemberView;
    }
}
