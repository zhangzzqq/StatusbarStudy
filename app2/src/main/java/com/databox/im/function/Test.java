//package com.databox.im.function;
//
//import android.Manifest;
//import android.os.Build;
//import android.os.Bundle;
//import android.view.View;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.viewpager.widget.ViewPager;
//
//import com.databox.im.function.main.AppInfoFragment;
//import com.databox.im.function.main.HomeFragment;
//import com.databox.im.R;
//import com.databox.im.utils.ScreenUtils;
//import com.databox.im.view.BaseFragmentPagerAdapter;
//import com.databox.im.view.CustomMainTabItem;
//import com.google.android.material.tabs.TabLayout;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class Test extends AppCompatActivity {
//
//    private TabLayout tabLayout;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.d_activity_main);
//        initView();
//        ScreenUtils.setStatusBarTransparent(getWindow());
//        requestPermissions();
//    }
//
//    private void requestPermissions() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
//        }
//    }
//
//    private void initView() {
//        tabLayout = findViewById(R.id.tabLayout);
//        final ViewPager viewPager = findViewById(R.id.viewPager);
//        createTab();
//        ArrayList<Fragment> fragments = new ArrayList<>();
//        fragments.add(new HomeFragment());
//        fragments.add(new AppInfoFragment());
//        viewPager.setAdapter(new BaseFragmentPagerAdapter(getSupportFragmentManager(),null,fragments));
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                int position = tab.getPosition();
//                if (position == 1) {
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
//                        getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility);
//                    }
//                } else {
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
//                        getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility);
//                    }
//                }
//
//                viewPager.setCurrentItem(position,false);
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//    }
//
//
//    private void createTab(){
//
//        List<Integer> mTitles = new ArrayList<>();
//        List<Integer> sDrawable = new ArrayList<>();
//
//        mTitles.add(R.string.chat);
//        mTitles.add(R.string.contacts);
//        mTitles.add(R.string.mine);
//
//        sDrawable.add(R.drawable.d_tab_main_selector);
//        sDrawable.add(R.drawable.d_tab_info_selector);
//        sDrawable.add(R.drawable.d_tab_info_selector);
//
//        CustomMainTabItem.create()
//                .setContext(this)
//                .setTabLayout(tabLayout)
//                .setTitleList(mTitles)
//                .setIconList(sDrawable)
//                .build();
//    }
//}