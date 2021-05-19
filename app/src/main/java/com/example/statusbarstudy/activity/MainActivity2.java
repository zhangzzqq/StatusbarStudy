package com.example.statusbarstudy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.statusbarstudy.R;
import com.qmuiteam.qmui.arch.QMUIActivity;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

import java.text.SimpleDateFormat;
import java.util.Locale;


public class MainActivity2 extends QMUIActivity {
    private QMUITopBarLayout mTopBar;
    private TextView mVersionTextView;
    private QMUIGroupListView mAboutGroupListView;
    private TextView mCopyrightTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test2);
        QMUIStatusBarHelper.translucent(this);
        QMUIStatusBarHelper.setStatusBarLightMode(this);
        mTopBar = findViewById(R.id.topbar);
        mVersionTextView = findViewById(R.id.version);
        mAboutGroupListView = findViewById(R.id.about_list);
        mCopyrightTextView = findViewById(R.id.copyright);

        initTopBar();

        QMUIGroupListView.newSection(MainActivity2.this)
                .addItemView(mAboutGroupListView.createItemView("123"), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .addItemView(mAboutGroupListView.createItemView("456"), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .addTo(mAboutGroupListView);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy", Locale.CHINA);
        String currentYear = dateFormat.format(new java.util.Date());
        mCopyrightTextView.setText("789");



    }



    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                popBackStack();
            }
        });

        mTopBar.setTitle("test");
    }

//    @Override
//    public TransitionConfig onFetchTransitionConfig() {
//        return SCALE_TRANSITION_CONFIG;
//    }
//
//    @Override
//    protected SwipeBackLayout.ViewMoveAction dragViewMoveAction() {
//        return SwipeBackLayout.MOVE_VIEW_TOP_TO_BOTTOM;
//    }


}
