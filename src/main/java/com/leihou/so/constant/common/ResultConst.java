package com.leihou.so.constant.common;

/**
 * 
 * 类名: ResultCode</br> 
 * 包名：com.freegou.dJStore.constant </br> 
 * 描述: 返回的编码</br>
 * 发布版本号：</br>
 * 开发人员： ruibiaozhong</br>
 * 创建时间： 2016年10月19日
 */
public class ResultConst {

	public static class status {

        /**
		 * 失败
		 */
		public static final String FALSE = "false";
		
		/**
		 * 成功
		 */
		public static final String TRUE = "true";
	}
	
	
	public static class code {
		
		/**
		 * 成功
		 */
		public static final String SUCCESS = "200";

		/**
		 * 本已成功
		 */
		public static final String ALREADY_SUCCESS = "2001";
		
		/**
		 * 授权成功
		 */
//		public static final String SUCCESS_AUTHORIZED = "201";
		
		
		
		/**
		 * 未授权（token合法，但是没有访问某个资源的权限）
		 */
		public static final String UNAUTHORIZED = "401";

		/**
		 * token不能为空（需要传递token但是没有传递）
		 */
		public static final String UNAUTHORIZED_NO_TOKEN = "4010";
		
		/**
		 * 不合法的token（系统无法解析）
		 */
		public static final String UNAUTHORIZED_INVALID = "4011";
		
		/**
		 * token已经失效（过期）
		 */
		public static final String UNAUTHORIZED_EXPIRED = "4012";
		
		/**
		 * token合法，但是用户还没有绑定我们系统的用户信息
		 */
		public static final String UNAUTHORIZED_UNREGIST = "4013";
		
		
		
		
		/**
		 * 找不到资源
		 */
		public static final String NOT_FIND_RESOURCE = "404";
		
		
		/**
		 * 微信授权失败
		 */
		public static final String WEIXIN_UNAUTHORIZED = "451";

		/**
		 * 系统异常
		 */
		public static final String EXCEPTION = "500";
		
		/**
		 * 验证错误
		 */
		public static final String INVALID = "501";

		/**
		 * 订单已经支付
		 */
		public static final String ORDER_ALREADY_PAY = "600";


		/**
		 * 请勿重复兑换
		 */
		public static final String CANTONFAIR_COUPON_REPETITION = "700";

		/**
		 * 兑换券已失效
 		 */
		public static final String CANTONFAIR_COUPON_EXPIRED = "701";

		/**
		 * 活动还没有开始
		 */
		public static final String CANTONFAIR_COUPON_NOT_START = "702";


		/**
		 * 活动已经结束
		 */
		public static final String CANTONFAIR_COUPON_NOT_EXPIRED = "703";

		/**
		 *  兑换券不存在
		 */
		public static final String COUPON_NOT_EXIST = "704";

		/**
		 *  卡券已过期
		 */
		public static final String COUPON_FREEZE_OR_INVALID= "705";

		/**
		 *  卡券尚未到使用时间
		 */
		public static final String COUPON_NOT_IN_VERIFT_TIME = "706";

		/**
		 *  卡券不可用于当前核销点
		 */
		public static final String COUPON_NOT_CORRECT_STATION = "707";

		/**
		 *  核销权限审核中，请联系CPASS管理人员
		 */
		public static final String PLATFORM_VERIFIER_REVIEWING = "708";

		/**
		 *  核销权限已过期，请联系CPASS管理人员
		 */
		public static final String PLATFORM_VERIFIER_EXPIRED = "709";


		/**
		 * 用户已经获取优惠券
		 */
		public static final String CANTONFAIR_CUSTOMER_ALREADY_GET_COUPON = "800";

		/**
		 * 账号已被占用
		 */
		public static final String USERNAME_EXIST = "901";

		/**
		 * 微信授权的手机号已有CPASS账号，且CPASS账号被其他微信绑定
		 */
		public static final String WX_TELEPHONE_HAS_BINDED = "902";

		/**
		 * 使用密码登录时未设置密码
		 */
		public static final String NO_SET_PASSWORD = "903";

		/**
		 * 发送短信操作过于频繁
		 */
		public static final String SEND_MESSAGE_TRY_PERMIT = "904";


	}
	
}
