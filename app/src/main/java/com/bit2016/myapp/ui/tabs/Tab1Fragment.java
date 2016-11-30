package com.bit2016.myapp.ui.tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bit2016.myapp.R;

/**
 * Created by bit-user on 2016-11-30.
 */

public class Tab1Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab1, container, false); // R은 리소스 컴파일러가 자동으로 아이디를 쭈욱 모아두는것?
    }
}
