package com.databox.im.common;


import android.os.Environment;

import com.databox.im.BuildConfig;


/**
 * Date：2021/5/10
 * Time：15:53
 * author:Stenven
 *
 *  用户id 保存用 int 值
 **/
public class Constant {

    /**
     *  公共部分
     *
     * 下面两行代码功能相同
     */

    // 是否开启打印日志模式
    public static final boolean IS_DEBUG = BuildConfig.DEBUG;
//    public static final boolean IS_DEBUG = true;
    // 是否开启保存日志模式
//    public static final boolean is_debugEnabled = BuildConfig.debugEnabled;
//    public static final String BUGLY_APPID = BuildConfig.bugly_appid;
    public static final String DEFAULT_TAG = "DataBoxAndroid";
    public static final int verificationTime = 5 * 60 * 1000;
    public static final int finalCode = 9001; //activityresult 请求码和返回码
//    public static final boolean debugEnabled = BuildConfig.debugEnabled;
    public static final int REQUEST_CODE_SAVE_IMG =10; //权限请求码
//    public static final int REQUEST_CODE_SAVE_IMG =10;

    public static final int CHECK_VALUE_NOUPDATE = 54;
    public static final int CHECK_VALUE_UPDATEABLE = 55;
    public static final int CHECK_VALUE_FORCEUPDATE = 56;
    public static final int CHECK_VALUE_LATER_UPGRADE = 57;
    public static final String URL_APK_DOWNLOAD = "http://download.city-lights.cn/magic_mirror/index.html";
    public static final String URL_APK_DOWNLOAD_TEST = "http://106.15.182.9/magic_mirror/android/test/magic_mirror_test.apk";

    public static final String REMINDR_LATER = "REMINDR_LATER" ;
    public static final int INTERVAL_TIME = 1 ;

//    public static final String merchant_token = "loginToken";
//    public static final String rider_token = "loginToken";
//    public static final String user_token = "loginToken";
//    public static final String rider_id = "loginId";
//    public static final String user_id = "loginId";
//    public static final String merchant_id = "loginId";
    public static final String  loginToken= "loginToken";
    public static final String loginId = "loginId";
    /**
     * @Author steven
     * @Description  打印机参数
     * @Date  2021/7/12 14:41
     * @Param
     * @return
     **/
    //芯烨云
    public static final String xinyeUser = "product@data-box.com.cn";
    public static final String xinyeUserKey = "6c399e0570be4816aa0cb805cde56409";
    //飞鹅
    public static final String feieUser = "product@data-box.com.cn";
    public static final String feieUserKey = "ub63MB5CwrfdEm78";
    //佳博
    public static final String jiaboUser = "6FEC10B5712B8A4A0E000234B8418345";
    public static final String jiaboUserKey = "PPHXYRDUITGOFC7B17L7FURPCDVSWK4B";
    //得力
    public static final String deliUser = "43255189";
    public static final String deliUserKey = "015105e6b552b36cd6bd8ce57fd3c468db04fa59";

    /**
     * 商家端sharedpreference保存的数据
     */

    public static final String merchant_name = "商家端";


    public static final String merchant_check_status= "merchant_check_status";
    public static final String merchant_check_status_success= "success";
    public static final String XYD_PHOTO_FILE_PATH = Environment.getExternalStorageDirectory().getPath()
            + "/BOSPad/xydPhotos/";
    public static final String PHOTO_FILE_PATH = Environment.getExternalStorageDirectory()
            .getPath() + "/BOSPad/photos/";//本地图片

    public static final String merchant_shop_id= "merchant_shop_id";
    public static final String invitation_code_merchant = "推广码";
    public static final String phone_merchant = "手机号";
    public static final String bleDeviceData  = "bleDeviceData";
    public static final String printerCloudObj = "printerCloudObj";
    public static final String printerType  = "printerType";
    public static final String printerBrandType  = "printerBrandType";
    public static final String cloudPrinterKey = "cloudPrinterKey";
    public static final String cloudPrinterSecret = "cloudPrinterSecret";



    /**
     * 消费者端sharedpreference保存的数据
     */

    public static final String user_name = "消费者端";
    public static final String invitation_code = "推广码";
    public static final String phone = "手机号";
    public static final String shop_id = "商家展示id";
    public static final String city = "aoiname";
    public static final String name = "昵称";
    public static final String is_shop = "0";//0未点击商家展示-1点击商家展示



    /**
     * 骑手端sharedpreference保存的数据
     */

    public static final String rider_name = "骑手端";
    public static final String invitation_code_rider = "推广码";
    public static final String phone_rider = "手机号";


}
