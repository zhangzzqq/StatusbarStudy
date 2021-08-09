package com.databox.im.common;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;

import androidx.annotation.NonNull;
import androidx.annotation.StringDef;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.StringUtils;
import com.databox.im.R;
import com.databox.im.utils.MLog;
import com.databox.im.view.MyDialogUtil;
import com.databox.im.view.MySpecificDialog;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Date：2021/5/29
 * Time：09:56
 * author:Stenven
 **/
public class PermissionRemindUtils {

    private static final String TAG = "PermissionRemindUtils";
    //获取清单文件声明的权限列表
    private static final List<String> PERMISSIONS = PermissionUtils.getPermissions();

    public static final String SMS = "cloudcore.permission-group.SMS";
    public static final String CONTACTS = "cloudcore.permission-group.CONTACTS";
    public static final String LOCATION = "cloudcore.permission-group.LOCATION";
    public static final String MICROPHONE = "cloudcore.permission-group.MICROPHONE";
    public static final String PHONE = "cloudcore.permission-group.PHONE";
    public static final String STORAGE = "cloudcore.permission-group.STORAGE";
    public static final String CAMERA = "cloudcore.permission-group.CAMERA";

    private static final String[] GROUP_CAMERA = new String[]{"android.permission.CAMERA"};
    private static final String[] GROUP_SMS = new String[]{"android.permission.SEND_SMS"};
    private static final String[] GROUP_CONTACTS = new String[]{"android.permission.READ_CONTACTS"};
    private static final String[] GROUP_LOCATION = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    private static final String[] GROUP_MICROPHONE = new String[]{"android.permission.RECORD_AUDIO"};
    private static final String[] GROUP_PHONE = new String[]{"android.permission.CALL_PHONE"};
    private static final String[] GROUP_STORAGE = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

//    public static String[] allPermissions = {
//            Manifest.permission.READ_PHONE_STATE,
//            Manifest.permission.CAMERA,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE,
//            Manifest.permission.READ_EXTERNAL_STORAGE,
//            Manifest.permission.ACCESS_FINE_LOCATION,
//            Manifest.permission.ACCESS_COARSE_LOCATION,
//            Manifest.permission.ACCESS_NETWORK_STATE,
//            Manifest.permission.READ_CONTACTS,
//    };

  /**
   * @Author steven
   * @Description  所有权限
   * @Date  2021/6/1 15:14
   * @Param
   *
   * Manifest.permission.READ_PHONE_STATE,
   * 设备标识 DEVICE_ID
   *
   * Sim Serial Number
   *
   * ANDROID_ID
   *
   * Installtion ID
   * @return
   *
   *
   *  ACCESS_NETWORK_STATE
   *  获取网络信息状态，如当前的网络连接是否有效
   *
   **/
    public static String[] allPermissions = {

            Manifest.permission.CAMERA, //相册
            Manifest.permission.WRITE_EXTERNAL_STORAGE, //存储
            Manifest.permission.READ_EXTERNAL_STORAGE, //存储
            Manifest.permission.ACCESS_FINE_LOCATION, //定位
            Manifest.permission.ACCESS_COARSE_LOCATION, //定位
            Manifest.permission.ACCESS_NETWORK_STATE, //网络状态
    };

    public static String[] allPermissions_user = {
            Manifest.permission.CAMERA, //相册
            Manifest.permission.WRITE_EXTERNAL_STORAGE, //存储
            Manifest.permission.READ_EXTERNAL_STORAGE, //存储
    };

    public static String[] allPermissions_rider = {
//            Manifest.permission.CAMERA, //相册
            Manifest.permission.WRITE_EXTERNAL_STORAGE, //存储
            Manifest.permission.READ_EXTERNAL_STORAGE, //存储
    };



    /**
     * @Author steven
     * @Description  定位权限
     * @Date  2021/6/1 15:13
     * @Param
     * @return
     **/
    public static String[] locationPermissions = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_NETWORK_STATE,
    };

    /**
     * @Author steven
     * @Description  相册权限
     * @Date  2021/6/1 15:24
     * @Param
     * @return 
     **/
    public static String[] cameraPermissions = {
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
    };
    
    /**
     * @Author steven
     * @Description  拨打电话权限
     * @Date  2021/6/1 17:17
     * @Param 
     * @return 
     **/
    public static String[] phonePermissions = {
            Manifest.permission.CALL_PHONE,
    };



    /**
     * 权限申请弹框提示信息
     *
     * @param activity
     * @param callback
     * @param permissions
     * @return
     */
    public static void permission(Activity activity, OnPermissionGrantCallback callback, @PermissionType String... permissions) {

        Map<String, String> map = PermissionRemindUtils.getPermissionDesMap(permissions);

        permission(activity, map, callback, permissions);
    }

    /**
     * @param activity
     * @param map         null:表示不弹权限申请用处信息框或无效权限 key:权限名，可以是单个权限或权限组名 value:申请该权限或权限组的用处信息
     * @param callback
     * @param permissions
     */
    public static void permission(Activity activity, Map<String, String> map, final OnPermissionGrantCallback callback, @PermissionType String... permissions) {
        //表示不弹权限申请用处信息框或无效权限
        if (null == map) {
            permissionNoRemind(callback, permissions);
            return;
        }

        if (activity == null) {
            MLog.e(TAG + " activity == null");
            callback.onDenied();
            return;
        }
        //需要申请的权限（单个权限或权限组）
        Set<String> deniedPermission = map.keySet();
        if (ObjectUtils.isEmpty(deniedPermission)) {
            callback.onGranted();
            return;
        }
        MLog.e(TAG + " deniedPermission：" + deniedPermission);

        StringBuilder sb = new StringBuilder();
        int i = 0;
        Set<String> manifestPermission = new LinkedHashSet<String>();

        for (String groupType : deniedPermission) {
            i++;
            String msg = map.get(groupType);
            sb.append(i).append("、").append(msg).append("\n");
            //权限组包含的所有权限
            String[] arrayPermission = PermissionRemindUtils.getPermissions(groupType);
            Collections.addAll(manifestPermission, arrayPermission);
        }
        String remindMsg = null;
        String sbStr = sb.toString();

        int endIndex = sbStr.lastIndexOf("\n");
        if (deniedPermission.size() == 1) {
            remindMsg = sbStr.substring(2, endIndex);
        } else {
            remindMsg = sbStr.substring(0, endIndex);
        }
        String[] permissionArray = manifestPermission.toArray(new String[manifestPermission.size()]);
        permissionWithRemind(activity, remindMsg, callback, permissionArray);

    }

    /**
     * 权限申请弹框提示
     *
     * @param activity
     * @param remindMsg
     * @param callback
     * @param permission
     */
    private static void permissionWithRemind(Activity activity, String remindMsg, final OnPermissionGrantCallback callback, final String... permission) {
        //权限申请未通过，弹框提示
        final List<String> buttons = new ArrayList<>();
        buttons.add("拒绝");
        buttons.add("允许");
        MyDialogUtil myDialogUtil = new MyDialogUtil(activity);
        myDialogUtil.showSingleDialog(activity, "权限申请", remindMsg,
                buttons, false, false, new MySpecificDialog.MyDialogCallBack() {
                    @Override
                    public void onLeftBtnFun(Dialog dialog) {
                        callback.onDenied();
                        dialog.dismiss();
                    }

                    @SuppressLint("WrongConstant")
                    @Override
                    public void onRightBtnFun(Dialog dialog) {
                        PermissionUtils.permission(permission).callback(new PermissionUtils.SimpleCallback() {
                            @Override
                            public void onGranted() {
                                callback.onGranted();
                            }

                            @Override
                            public void onDenied() {
                                callback.onDenied();

                            }
                        }).request();
                        dialog.dismiss();
                    }
                });

    }

    /**
     * 权限申请不弹框
     *
     * @param callback
     * @param permission
     * @return
     */
    @SuppressLint("WrongConstant")
    private static void permissionNoRemind(final OnPermissionGrantCallback callback, @PermissionType String... permission) {

        Set<String> manifestPermission = new LinkedHashSet<String>();
        for (String groupType : permission) {
            //权限组包含的所有权限
            String[] arrayPermission = PermissionRemindUtils.getPermissions(groupType);
            Collections.addAll(manifestPermission, arrayPermission);
        }
        String[] permissionArray = manifestPermission.toArray(new String[manifestPermission.size()]);
        PermissionUtils.permission(permissionArray).callback(new PermissionUtils.SimpleCallback() {
            @Override
            public void onGranted() {
                callback.onGranted();
            }

            @Override
            public void onDenied() {
                callback.onDenied();
            }
        }).request();
    }

    /**
     * 获取权限组
     *
     * @param permission
     * @return
     */
    private static String[] getPermissions(String permission) {

        switch (permission) {
            case CONTACTS:
                return GROUP_CONTACTS;
            case SMS:
                return GROUP_SMS;
            case STORAGE:
                return GROUP_STORAGE;
            case LOCATION:
                return GROUP_LOCATION;
            case PHONE:
                return GROUP_PHONE;
            case MICROPHONE:
                return GROUP_MICROPHONE;
            case CAMERA:
                return GROUP_CAMERA;
            default:
                return new String[]{permission};
        }

    }


    /**
     * 获取请求权限中需要申请的权限和其相应用处信息
     *
     * @param permissions
     * @return key:权限名，可以是单个权限或权限组名 value:申请该权限或权限组的用处信息
     */
    public static Map<String, String> getPermissionDesMap(@NonNull String... permissions) {

        MLog.e(TAG + " permissions.length：" + permissions.length);
        //无效权限组
        if (ObjectUtils.isEmpty(permissions)) {
            MLog.e("无效权限,请确认权限是否正确或是否已在清单文件声明");
            return null;
        }

        Set<String> deniedPermissions = PermissionRemindUtils.getDeniedPermissionGroup(permissions);
        //无效权限组，即不在清单文件中
        if (null == deniedPermissions) {
            MLog.e("无效权限,请确认权限是否正确或是否已在清单文件声明");
            return null;
        }

        Map<String, String> map = new HashMap<String, String>();
        for (String permission : deniedPermissions) {
            String remindMsg = PermissionRemindUtils.getPermissionDes(permission);
            map.put(permission, remindMsg);
        }

        return map;

    }

    /**
     * 获取未通过的权限列表
     *
     * @param permissions
     * @return
     */
    private static Set<String> getDeniedPermissionGroup(String... permissions) {
        //无效权限（不在清单文件中）
        boolean isInvalid = true;
        LinkedHashSet<String> deniedPermissions = new LinkedHashSet<String>();

        for (int length = permissions.length, i = 0; i < length; ++i) {
            String permission = permissions[i];
            //权限组或单个权限
            String[] groupPermission = PermissionRemindUtils.getPermissions(permission);
            for (String aPermission : groupPermission) {
                //检查清单文件声明权限
                if (!PERMISSIONS.contains(aPermission)) {
                    MLog.e(TAG + "无效权限,请确认权限是否正确或是否已在清单文件声明：" + aPermission);
                    continue;
                }
                isInvalid = false;
                //权限未通过
                if (!PermissionUtils.isGranted(aPermission)) {
                    MLog.e(TAG + " denied：" + permission);
                    deniedPermissions.add(permission);
                    break;
                }
                MLog.e(TAG + " granted：" + permission);
            }
        }
        //无效权限（不在清单文件中）
        if (isInvalid) {
            return null;
        }

        return deniedPermissions;
    }

    /**
     * 获取请求权限相应的提示信息
     *
     * @param permission
     * @return
     */
    private static String getPermissionDes(String permission) {

        String remindMsg = null;
        switch (permission) {
            case STORAGE:
                remindMsg = StringUtils.getString(R.string.permission_storage_des);
                break;
            case CAMERA:
                remindMsg = StringUtils.getString(R.string.permission_camera_des);
                break;
            case LOCATION:
                remindMsg = StringUtils.getString(R.string.permission_location_des);
                break;
            case MICROPHONE:
                remindMsg = StringUtils.getString(R.string.permission_microphone_des);
                break;
            case CONTACTS:
                remindMsg = StringUtils.getString(R.string.permission_contacts_des);
                break;
            case PHONE:
//                String temp = ObjectUtils.isEmpty(Constant.CALL_PHONE) ? "功能" : Constant.CALL_PHONE;
//                remindMsg = String.format(StringUtils.getString(R.string.permission_phone_des), temp);
//                Constant.CALL_PHONE = null;
                break;
            case SMS:
                remindMsg = StringUtils.getString(R.string.permission_sms_des);
                break;
            default:
                //单个权限申请扩展
                break;
        }

        return remindMsg;
    }

    /**
     * 判断权限是否已申请过
     * 特别说明：
     * 使用PermissionUtils三方框架权限申请时，如果要调用PermissionUtils.isGranted(permissionGroup)
     * 要确保申请的权限或权限组已经在清单文件声明过，不然会恒为false
     *
     * @param permissions
     * @return
     */
    public static boolean isGranted(String... permissions) {
        if (ObjectUtils.isEmpty(permissions)) {
            return false;
        }
        Set<String> deniedPermissions = PermissionRemindUtils.getDeniedPermissionGroup(permissions);
        if (null == deniedPermissions) return false;

        return ObjectUtils.isEmpty(deniedPermissions);
    }


    /**
     * 自定义权限组类型
     */
    @StringDef({SMS, MICROPHONE, STORAGE, CONTACTS, PHONE, LOCATION, CAMERA})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionType {
    }

    /**
     * 弹框提示回调
     */
    public interface OnPermissionGrantCallback {
        void onGranted();

        void onDenied();
    }


//    /**
//     * 同权限组中个别权限申请
//     *
//     * @param activity
//     * @param permissions 自定义权限组合：如 {@link com.szrcb.emobile.android.privacy.PermissionRemindUtils#SMS}
//     * @param callback
//     */
//
//    public static void permission(Activity activity, @PermissionType String[] permissions, final OnPermissionGrantCallback callback) {
//
//        if (PermissionUtils.isGranted(permissions)) {
//            MLog.e(TAG + " 权限申请通过：" + Arrays.toString(permissions));
//            callback.onGranted();
//            return;
//        }
//        String remindMsg = null;
//        if (Arrays.equals(GROUP_SMS, permissions)) {
//            remindMsg = activity.getString(R.string.permission_sms_des);
//        }
//        MLog.e(TAG + " 权限未申请通过：" + Arrays.toString(permissions));
//        permissionWithRemind(activity, remindMsg, callback, permissions);
//    }


}

