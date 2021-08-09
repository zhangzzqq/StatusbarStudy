/*
 * Copyright 2016 jeasonlzy(廖子尧)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.databox.im.common;

import android.os.Environment;

/**
 * @Author steven
 * @Description 接口请求类
 * <p>
 * 其中type:
 * 0: 登录验证
 * 1: 注册验证
 * 2: 修改密码验证
 * 其他：身份验证
 **/
public class Urls {

    /**
     * 通用
     */
    //正式环境
//    public static final String SERVER = "http://api.city-lights.cn:9189";
//    public static final String SERVERMAP = "http://api.city-lights.cn:9199";
    //测试环境
    public static final String SERVER = "http://192.168.31.230:9188";
    public static final String SERVERMAP = "http://dev.city-lights.cn:9198";

    public static final String UPLOAD_IMG = SERVER + "/upload/upload";//上传图片
    public static final String UPLOAD_GET_ANDROID_VERSION = SERVER + "/android/version";//获取安卓版本号
    public static final String XYD_PHOTO_FILE_PATH =
            Environment.getExternalStorageDirectory().getPath();

    //三个端隐私协议
    public static final String MERCHANT_PRIVACY_CONTENT = "http://106.15.182.9/magic_mirror/privacy.html";
    //商家端协议
    public static final String MERCHANT_MERCHANT_SERVICE_AGREEMENT = "http://106.15.182.9/magic_mirror/service.html";
    //消费者协议
    public static final String MERCHANT_CUSTOMER_SERVICE_AGREEMENT = "http://api.city-star.top:9189/pic/docs/magic_mirror_rules_customer.html";
    //骑手协议
    public static final String MERCHANT_RIDER_SERVICE_AGREEMENT = "http://api.city-lights.cn:9189/pic/docs/magic_mirror_rules_rider.html";
    //商家开店协议
    public static final String MERCHANT_MERCHANT_OPEN_SHOP_AGREEMENT = "http://api.city-lights.cn:9189/pic/docs/magic_mirror_operation_rules_merchant_appendix.html";

    /**
     * 地址管理
     */
    public static final String URL_ADDRESS_SEL_BY_USER = SERVER + "/address/selectByUser";//查询用户地址列表
    public static final String URL_ADDRESS_SEL_BY_ID = SERVER + "/address/selectByID";//根据ID查询地址
    public static final String URL_ADDRESS_SEL_DEFAULT = SERVER + "/address/getDefaultAddress";//查询用户默认地址
    public static final String URL_ADDRESS_INSERT = SERVER + "/address/insert";//新增地址
    public static final String URL_ADDRESS_UPDATE = SERVER + "/address/update";//更新地址
    public static final String URL_ADDRESS_DELETE_BY_ID = SERVER + "/address/deleteByID";//根据ID删除地址
    public static final String URL_ADDRESS_FEEDBACK = SERVER + "/address/reportMissing";//报告缺失地址
    public static final String URL_MERCHANT_MAP_DELIVERY_INFO = SERVERMAP + "/map/getDeliveryInfo";//获取配送信息
    public static final String URL_MERCHANT_MAP_SEARCH_BY_NAME = SERVER + "/map/searchByName";//商家根据名称模糊查询
    public static final String URL_MERCHANT_MAP_SEARCH_BY_GPS = SERVER + "/map/searchByGPS";//根据GPS查询周边设施
    public static final String URL_GET_CITY_LIST = SERVER + "/city/getCityList";//获取城市列表
    public static final String URL_GET_ZONES_BY_CITY = SERVER + "/zone/getZonesByCityID";//获取片区列表

    /**
     * 消费者端
     */
    public static final String URL_LOGIN_NOTE = SERVER + "/user/login_sms";//短信验证登录
    public static final String URL_SMS_SEND = SERVER + "/user/login_sms_send";// 用户短信验证码发送
    public static final String URL_LOGIN_PASSWORD = SERVER + "/user/login_password";//用户密码登录
    public static final String URL_USER_QUERY = SERVER + "/user/mine";//查询用户
    public static final String URL_LOGIN_REGISTER = SERVER + "/user/register";//用户注册
    public static final String URL_SET_PASSWORD = SERVER + "/user/set_password";//用户设置密码
    public static final String URL_SUBMIT_ORDER = SERVER + "/user/orderSubmit";//新建订单
    public static final String URL_PRODUCTS_LIST = SERVER + "/user/productsList";//商品查询列表
    public static final String URL_GET_PRODUCT_QUOTA = SERVER + "/user/getSalesQuantityQuotaInfo";//商品购买限额信息
    public static final String URL_MERCHANT_PRODUCTS_SELECT = SERVER + "/user/merchantProductsSelect";//商家店铺展示
    public static final String URL_USER_INFO_UPDATE = SERVER + "/user/userInfoUpdate";//用户信息更新
    public static final String URL_USER_COLLECT_PRODUCT = SERVER + "/user/productCollect";//商品收藏
    public static final String URL_USER_PRODUCT_THEME = SERVER + "/user/productsThemeCategoryList";//商品主题品类查询
    public static final String URL_CANCEL_COLLECT_PRODUCT = SERVER + "/user/cancleProductCollect";//商品取消收藏
    public static final String URL_USER_PRODUCTS_CATEGORY = SERVER + "/user/productsCategoryList";//商品品类查询
    public static final String URL_USER_PRODUCT_COLLECT_SELECT = SERVER + "/user/productCollectSelect";//收藏商品查询
    public static final String URL_SEARCH_PRODUCTS_NAME = SERVER + "/user/searchProductsByName";//商品关键字搜索
    public static final String URL_SORT_PRODUCTS_LIST = SERVER + "/user/productsOrderList";//商品排序列表查询
    public static final String URL_USER_ARRIVAL_TIME = SERVER + "/user/expectArrivalTimeTable";//堂食自取预计到店时间
    public static final String URL_USER_ARRIVAL_LATER_TIME = SERVER + "/user/expectArrivalTimeOtherDay";//堂食自取预计他日到店时间
    public static final String URL_USER_DELIVERY_TOADY_TIME = SERVER + "/user/expectDeliveryTimeTable";//外卖今日预计送达时间
    public static final String URL_USER_ORDER_DETAIL = SERVER + "/user/selectOrder";//订单详情查询
    public static final String URL_USER_COMPLETE_ORDER = SERVER + "/user/orderComplete";//完成订单
    public static final String URL_USER_ORDER_LIST = SERVER + "/user/selectOrderByUserID";//消费者订单查询
    public static final String URL_COUPON_AVAILABLE_COUPON = SERVER + "/coupon/selectUserCoupon";//获取用户所有可使用优惠券
    public static final String URL_COUPON_SELECT_MAX_COUPON = SERVER + "/coupon/selectByCustomerToPay";//获取用户最大优惠券
    public static final String URL_COUPON_AVAILABLE_FREIGHT = SERVER + "/coupon/selectUserWaybillCoupon";//获取用户可使用运费券
    public static final String URL_COUPON_SELECT_MAX_FREIGHT = SERVER + "/coupon/selectByDeliveryFee";//获取用户最大运费券
    public static final String URL_COUPON_FREIGHT_BY_PWD = SERVER + "/coupon/selecWaybillCouponByCode";//根据密码获取运费券
    public static final String URL_GET_ORDER_BOX_FEE = SERVER + "/user/calcOrderBoxFee";//计算订单餐盒费
    public static final String URL_USER_ORDER_PAY = SERVER + "/user/orderPay";//待支付订单支付
    public static final String URL_USER_SELECT_BY_ID = SERVER + "/user/productSelectById";//指定商品查询

    /**
     * 商家端
     */
    public static final String URL_LOGIN_MERCHANT_PASSWORD = SERVER + "/owner/login_password";//商家密码登录
    public static final String URL_LOGIN_MERCHANT_NOTE = SERVER + "/owner/login_sms";//商家短信登录
    public static final String URL_MERCHANT_NOTE_SEND = SERVER + "/owner/login_sms_send";//商家短信发送
    public static final String URL_MERCHANT_UpLOAD = SERVER + "/merchant/upload";//商家入驻
    public static final String URL_MERCHANT_REGISTER = SERVER + "/owner/register";//商家注册
    public static final String URL_MERCHANT_SET_PASSWORD = SERVER + "/owner/set_password";//商家设置密码
    //    public static final String URL_MERCHANT_UPATE = SERVER + "/owner/update";//更新商家
    public static final String URL_MERCHANT_SAVE_GOODS = SERVER + "/product/insert";//保存商品
    public static final String URL_MERCHANT_UPDATE_GOODS = SERVER + "/product/update";//更新商品
    public static final String URL_MERCHANT_SELECT_CATE2 = SERVER + "/product/category2Select";//查询二级分类
    public static final String URL_MERCHANT_SELECT_CATE1 = SERVER + "/product/category1Select";//查询一级分类
    public static final String URL_MERCHANT_Change_SALE = SERVER + "/product/changeSaleStatus";//商品上下架
    public static final String URL_MERCHANT_BATCH_DELETE = SERVER + "/product/batchDelete";//批量删除
    public static final String URL_MERCHANT_Goods_DELETE = SERVER + "/product/delete";//单个删除
    public static final String URL_MERCHANT_Goods_ALL = SERVER + "/product/select_by_merchantId";//获取所有商品
    public static final String URL_MERCHANT_BATCH_LINE = SERVER + "/product/batch_changeSaleStatus";//商品批量上架下架
    public static final String URL_MERCHANT_All_OFFLine = SERVER + "/product/select_offSale";//获取所有下架商品
    public static final String URL_MERCHANT_All_Store = SERVER + "/product/select_stockLack";//获取所有0库存商品
    public static final String URL_MERCHANT_UPDATE_MESSAGE = SERVER + "/owner/update";//更新商家
    public static final String URL_MERCHANT_GET_MESSAGE = SERVER + "/owner/mine";//查询商家
    public static final String URL_MERCHANT_GET_ORDER_NEW_TYPE_SELECT = SERVER + "/merchant/orderNewTypeSelect";//商家新订单类型查询
    public static final String URL_MERCHANT_ORDER_NEW_SELECT = SERVER + "/merchant/orderNewSelect";//查询商家所有订单
    public static final String URL_MERCHANT_GET_ORDER_GOING = SERVER + "/merchant/orderOngoingSelect";//查询商家进行中订单
    public static final String URL_MERCHANT_GET_ORDER_COMPLETE = SERVER + "/merchant/orderCompletedSelect";//查询商家已完成订单
    public static final String URL_MERCHANT_GET_ORDER_CANCELED = SERVER + "/merchant/orderCanceledSelect";//查询商家已取消订单
    public static final String URL_MERCHANT_PUT_ORDER_CANCEL = SERVER + "/merchant/orderCancle";//商家取消订单
    public static final String URL_MERCHANT_PUT_ORDER_PREPARED = SERVER + "/merchant/orderPrepared";//商家备货完成
    //外卖开店说明 安卓端使用html,可不需要使用此接口
//    public static final String URL_MERCHANT_OPEN_SHOP_INSTRUCTION = SERVER + "/merchant/wordCat";
//    public static final String URL_MERCHANT_ORDERSTATUSCHANGE = SERVER + "/merchant/orderStatusChange";//商家开启或停止接单
    public static final String URL_MERCHANT_PUSH_SENDMSG = SERVER + "/push/sendMsg";//发送推送 还没有做 暂没有用到
    public static final String URL_MERCHANT_TODAY_ORDER_SUM = SERVER + "/operation/ordersTodaySumSelect";//今日订单量
    public static final String URL_MERCHANT_ORDER_SUM_SELECT = SERVER + "/operation/ordersTodayIncome";//今日订单收入
    public static final String URL_MERCHANT_APPROVE = SERVER + "/merchant/approve";//商家审核批准 还没有做
    //    public static final String URL_MERCHANT_ORDER_DETAIL_SELECT = SERVER + "/merchant/select";//商家订单详情查询 //已经去掉
    public static final String URL_MERCHANT_PRINTER_INSERT = SERVER + "/printer/insert";//新建打印机
    public static final String URL_MERCHANT_SELECT_BY_MERCHANTID = SERVER + "/printer/selectByMerchantId";//获取打印机
    public static final String URL_MERCHANT_PRINTER_UPDATE = SERVER + "/printer/update";//编辑打印机
    public static final String URL_MERCHANT_ORDER_DETAIL = SERVER + "/merchant/selectOrder";//订单详情查询
    public static final String URL_UPDATE_PRINT = SERVER + "/printer/orderUpdatePrint";//设置订单打印标记
    public static final String URL_MERCHANT_NO_PRINT_ORDER_SELECT = SERVER + "/printer/merchantNoPrintOrderSelect";//获取商家未打印订单
    public static final String URL_MERCHANT_PRINT_DELETE = SERVER + "/printer/delete";//解绑打印机
    //云打印机
    public static final String URL_MERCHANT_ADD_PRINTERS = "https://open.xpyun.net/api/openapi/xprinter/addPrinters";//芯烨 添加打印机
    public static final String URL_MERCHANT_PRINT = "https://open.xpyun.net/api/openapi/xprinter/print";//芯烨 打印小票
    public static final String URL_MERCHANT_ADD_PRINTERS_FEIE = "http://api.feieyun.cn/Api/Open/";//飞鹅 添加打印机
    public static final String URL_MERCHANT_ADD_PRINTERS_JIABO = "https://api.poscom.cn/apisc/adddev";//佳博 添加打印机
    public static final String URL_MERCHANT_PRINT_JIABO = "https://api.poscom.cn/apisc/sendMsg";//佳博打印机 打印
    public static final String URL_MERCHANT_deli_add_print = "https://deli-open.10ss.net/addprint";//得力打印机  添加打印机
    public static final String URL_MERCHANT_deli_print = "https://deli-open.10ss.net";//得力打印机 打印

    /**
     * 骑手端
     */
    public static final String URL_LOGIN_RIDER_PASSWORD = SERVER + "/rider/login_password";//骑手密码登录
    public static final String URL_LOGIN_RIDER_NOTE = SERVER + "/rider/login_sms";//短信登录
    public static final String URL_RIDER_SEND_NOTE = SERVER + "/rider/login_sms_send";//短信发送
    public static final String URL_RIDER_QUERY = SERVER + "/rider/mine";//骑手查询
    public static final String URL_RIDER_RIGSTER = SERVER + "/rider/register";//骑手注册
    public static final String URL_RIDER_SET_PASSWORD = SERVER + "/rider/set_password";//骑手设置密码
    public static final String URL_RIDER_UPDATE_MESSAGE = SERVER + "/rider/riderInfoUpdate";//骑手信息更新
    public static final String URL_RIDER_ENROLL = SERVER + "/rider/enroll";//骑手报名
    public static final String URL_RIDER_COMPLAIN = SERVER + "/waybill/complain";//投诉
    public static final String URL_RIDER_COMPLETE_ORDER = SERVER + "/waybill/selectDeliveredWaybills";//已完成订单列表
    public static final String URL_RIDER_GET_TASK_NEARBY_LIST = SERVER + "/waybill/selectNewWaybillsNearby";//获取附近新运单列表
    public static final String URL_RIDER_GET_ACCEPTED_TASK_LIST = SERVER + "/waybill/selectAcceptedWaybills";//待取货列表
    public static final String URL_RIDER_GET_PICKED_UP_LIST = SERVER + "/waybill/selectPickedupWaybills";//待送达列表
    public static final String URL_RIDER_ACCEPTED_TASK = SERVER + "/waybill/accept";//骑手接单
    public static final String URL_RIDER_TAKE_DELIVERY = SERVER + "/waybill/pickup";//骑手取货
    public static final String URL_RIDER_COMPLETE_TASK = SERVER + "/waybill/delivered";//骑手送达
}