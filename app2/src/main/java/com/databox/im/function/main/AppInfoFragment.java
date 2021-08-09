package com.databox.im.function.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.databox.im.R;
import com.databox.im.utils.BaseUtils;
import com.databox.im.utils.ClipUtils;
import com.databox.im.view.TitleLayout;


public class AppInfoFragment extends Fragment {

    private static final String TAG = AppInfoFragment.class.getSimpleName();
    TextView didTv;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
//        getContext().registerReceiver(reciver, new IntentFilter("com.jiguang.demo.register"));
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.d_fragment_appinfo, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TitleLayout titleLayout = view.findViewById(R.id.title_bar);
        titleLayout.getBackIv().setVisibility(View.GONE);

        TextView tvPkg = view.findViewById(R.id.tv_pkg);
        tvPkg.setText("包名：" + getContext().getPackageName());
        view.findViewById(R.id.iv_pkg_copy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipUtils.copyText(v.getContext(), getContext().getPackageName());
            }
        });

        TextView appKeyTv = view.findViewById(R.id.tv_appKey_text);
        appKeyTv.setText(BaseUtils.getAppKey(getContext()));
        view.findViewById(R.id.iv_appkey_copy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipUtils.copyText(v.getContext(), BaseUtils.getAppKey(getContext()));
            }
        });

        TextView versionTv = view.findViewById(R.id.tv_version_text);
        versionTv.setText("v" + BaseUtils.getVersion(getContext()));
    }

    @Override
    public void onDestroyView() {
//        getContext().unregisterReceiver(reciver);
        super.onDestroyView();
    }

    private final BroadcastReceiver reciver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e(TAG, "onReceive register");
//            if(didTv!=null){
//                didTv.setText(BaseUtils.getDeviceId(getContext()));
//            }
        }
    };
}