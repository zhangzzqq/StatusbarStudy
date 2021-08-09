package com.databox.im.view;

import android.app.Dialog;
import android.content.Context;

import java.util.List;

/**
 * @time: 2020/9/10
 * @Author: weichenghong
 * @Description:
 */
public class MyDialogUtil {
    public MyDialogUtil(Context context) {
        super();
    }

    public void showSingleDialog(final Context context, String title, String content, List<String> buttons,
                                 boolean setCanceledOnTouchOutside, boolean back, final MySpecificDialog.MyDialogCallBack myDialogCallBack) {

        switch (buttons.size()) {
            case 0:
                break;
            case 1:
                String strCenter = getButtonsName(buttons.get(0));

                MySpecificDialog mySpecificDialog = new MySpecificDialog.Builder(context)
                        .strTitle(title).strMessage(content)
                        .strCenter(strCenter)
                        .setCanceledOnTouchOutside(setCanceledOnTouchOutside)
                        .setCancelable(back)
                        .myDialogCallBack(new MySpecificDialog.MyDialogCallBack() {
                            @Override
                            public void onLeftBtnFun(Dialog dialog) {
                                myDialogCallBack.onLeftBtnFun(dialog);
                            }

                            @Override
                            public void onRightBtnFun(Dialog dialog) {
                                myDialogCallBack.onRightBtnFun(dialog);
                            }
                        }).buildDialog();
                mySpecificDialog.showDialog();
                break;
            case 2:
                String strLeft = getButtonsName(buttons.get(0));
                String strRighet = getButtonsName(buttons.get(1));

                MySpecificDialog mySpecificDialog2 = new MySpecificDialog.Builder(context)
                        .strTitle(title).strMessage(content)
                        .strLeft(strLeft)
                        .strRight(strRighet)
                        .setCanceledOnTouchOutside(setCanceledOnTouchOutside)
                        .setCancelable(back)
                        .myDialogCallBack(new MySpecificDialog.MyDialogCallBack() {
                            @Override
                            public void onLeftBtnFun(Dialog dialog) {
                                myDialogCallBack.onLeftBtnFun(dialog);
                            }

                            @Override
                            public void onRightBtnFun(Dialog dialog) {
                                myDialogCallBack.onRightBtnFun(dialog);
                            }
                        }).buildDialog();
                mySpecificDialog2.showDialog();
                break;
            default:
                break;
        }

    }

    private String getButtonsName(String s) {
        String Name = s;
        switch (s) {
            case "confirm":
                Name = "确认";
                break;
            case "cancel":
                Name = "取消";
                break;
            case "callphone":
                Name = "拨打";
                break;
        }
        return Name;
    }
}
