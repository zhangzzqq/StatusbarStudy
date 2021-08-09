
## 状态栏

1设置状态栏透明
setStatusBarTransparent

2设置状态栏文字颜色
 //图标颜色
                if (position == 1) {
                    //黑色样式
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                        getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility);
                    }
                } else {
                    //白色样式
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                        getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility);
                    }
                }

                





Android 沉浸式状态栏的实现

1 设置状态栏透明（布局会自动顶上去）
2 设置状态栏图标颜色
3 增加占位状态栏
（这样布局内容不会被顶上去）

ViewGroup rootView = (ViewGroup) mActivity.getWindow().getDecorView().findViewById(android.R.id.content);
rootView.setPadding(0, getStatusBarHeight(mActivity), 0, 0);
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
    //5.0 以上直接设置状态栏颜色
    activity.getWindow().setStatusBarColor(color);
} else {
    //根布局添加占位状态栏
    ViewGroup decorView = (ViewGroup) mActivity.getWindow().getDecorView();
    View statusBarView = new View(activity);
    ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            getStatusBarHeight(activity));
    statusBarView.setBackgroundColor(color);
    decorView.addView(statusBarView, lp);
}


