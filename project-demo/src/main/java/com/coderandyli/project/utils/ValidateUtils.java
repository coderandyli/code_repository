package com.coderandyli.project.utils;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtils {

	// 密码只能是6-20位英文或数字
	public static boolean isPassword(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{6,20}$");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	// 只能是6-20位英文或数字混合
	public static boolean isMixNumberAndCode(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^(?![^a-zA-Z]+$)(?!\\D+$).{6,20}$");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	// 手机号校验，只能是9位的。
	public static boolean isPhoneNo(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	// 手机号校验，1开头的11位数字。
	public static boolean isPhoneNumber(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[1][0-9]{10}$");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	// 姓名校验，2-8位字符。
	public static boolean isName(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		String regex = "[\u4e00-\u9fa5]{2,8}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	public static boolean isEmail(String email) {
		if (StringUtils.isEmpty(email)) {
			return false;
		}
		boolean tag = true;
		final String pattern1 = "^[A-Za-z0-9\\u4e00-\\u9fa5_.-]+@[a-zA-Z0-9\\u4e00-\\u9fa5_-]+(\\.[a-zA-Z0-9_-]+)+$";
		final Pattern pattern = Pattern.compile(pattern1);
		final Matcher mat = pattern.matcher(email);
		if (!mat.find()) {
			tag = false;
		}
		return tag;
	}

	/*
	 * 验证身份证号码 居民身份证号码15位或18位，最后一位可能是数字或字母
	 * 
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean isCardID(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		String regex = "((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65|71|81|82|91)\\d{4})((((19|20)(([02468][048])|([13579][26]))0229))|((20[0-9][0-9])|(19[0-9][0-9]))((((0[1-9])|(1[0-2]))((0[1-9])|(1\\d)|(2[0-8])))|((((0[1,3-9])|(1[0-2]))(29|30))|(((0[13578])|(1[02]))31))))((\\d{3}(x|X))|(\\d{4}))";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	// 校验第一位汉字，第二位英文
	public static boolean isCarFrontNo(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		String regex = "^[\u4e00-\u9fa5]{1}[a-zA-Z]{1}[a-zA-Z0-9]{1,9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	// 吨位校验，可有一位小数。
	public static boolean isCarLoad(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		String regex = "^\\d+(\\.(\\d){1}){0,1}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	// 价格校验，可有两位小数。
	public static boolean isPrice(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		String regex = "\\d+(\\.(\\d){0,2}){0,1}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	// 数字校验
	public static boolean isNum(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^\\d+$");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	// 验证是否是模拟测试
	public static boolean validMock(int mock) {
		if (mock == 0 || mock == 1) {
			return true;
		}
		return false;
	}

	public static int validStringEmptyAndNull(String... args) {
		for (int i = 0; i < args.length; i++) {
			String str = args[i];
			if (str == null || "".equals(str.trim())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 名字，名称（中英文数字-（））
	 * 
	 * @param string
	 * @return
	 */
	public static boolean checkString(String string) {

		String regEx = "[`~!@#$%^&*+=|{}':;',\\[\\]<>/?~！@#￥%……&*——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(string);

		return m.find();
	}

	/**
	 * 需求，备注，textarea（中英文数字-（）' " , ; <>）
	 * 
	 * @param string
	 * @return
	 */
	public static boolean checkIntroduction(String string) {

		String regEx = "[`~!@#$%^&*+=|{}:\\[\\]./?~！@#￥%……&*——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(string);

		return m.find();
	}
	
	/**
	 * 地址（中英文数字-（）,）
	 * 
	 * @param string
	 * @return
	 */
	public static boolean checkAddress(String string) {
		String regEx = "[`~!@#$%^&*+=|{}':;'\\[\\].<>/?~！@#￥%……&*——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(string);

		return m.find();
	}

	/**
	 * 联系电话（数字-（））
	 * 
	 * @param string
	 * @return
	 */
	public static boolean checkContactNumber(String string) {
		String regEx = "[`~!@#$%^&*+=|{}':;'\\[\\].<>/?~！@#￥%……&*——+|{}【】‘；：”“’。，、？\\u4e00-\\u9fa5_a-zA-Z]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(string);

		return m.find();
	}

	// 手机号校验，1开头的11位数字。
	public static boolean checkURL(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("(ht|f)tp(s?)\\:\\/\\/[0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*(:(0-9)*)*(\\/?)([a-zA-Z0-9\\-\\.\\?\\,\\'\\/\\\\\\+&amp;%\\$#_]*)?");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	public static void main(String args[]) {
		System.out.println(checkURL("https://www.baidu.com"));
	}
}
