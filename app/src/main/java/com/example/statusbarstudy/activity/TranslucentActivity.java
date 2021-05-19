/*
 * Tencent is pleased to support the open source community by making QMUI_Android available.
 *
 * Copyright (C) 2017-2018 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the MIT License (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://opensource.org/licenses/MIT
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.statusbarstudy.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.statusbarstudy.R;
import com.qmuiteam.qmui.arch.QMUIActivity;
import com.qmuiteam.qmui.arch.annotation.LatestVisitRecord;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;


/**
 * 沉浸式状态栏的调用示例。
 * Created by Kayo on 2016/12/12.
 */

@LatestVisitRecord
public class TranslucentActivity extends QMUIActivity {

    QMUITopBarLayout mTopBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        View root = LayoutInflater.from(this).inflate(R.layout.activity_translucent, null);
      setContentView(R.layout.activity_translucent);
        mTopBar = findViewById(R.id.topbar);
//        QMUISkinManager skinManager = QMUISkinManager.defaultInstance(this);
//        setSkinManager(skinManager);
        initTopBar();

    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
            }
        });
        mTopBar.setTitle("沉浸式状态栏示例");

        mTopBar.addRightImageButton(R.mipmap.icon_topbar_overflow, R.id.topbar_right_change_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        showBottomSheet();
                    }
                });
        View view = LayoutInflater.from(TranslucentActivity.this).
                inflate(R.layout.layout_image, null);

        mTopBar.addRightView(view,R.id.topbar_right_view);


    }






}
