package com.example.recyclickprojek.Util;

import android.text.Html;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.example.recyclickprojek.R;

public class Util {
    public static void pindahFragment(FragmentManager fragmentManager, Fragment fragmentTujuan){
        fragmentManager.beginTransaction().replace(R.id.id_frame_layout,fragmentTujuan).commit();
    }
    public static void setCustomColorText(TextView mTextViewTarget , String oldText , String coloredText , String coloredHex){
        mTextViewTarget.setText(Html.fromHtml(oldText + "<font color=\"#" +  coloredHex + "\">" + coloredText));
    }

}
