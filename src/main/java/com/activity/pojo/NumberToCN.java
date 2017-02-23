package com.activity.pojo;


 
 import java.math.BigDecimal;
 
 /**
  * 数字转换为汉语中人民币的大写<br>
  * 
  * @author hongten
  * @contact hongtenzone@foxmail.com
0  * @create 2013-08-13
  */
 public class NumberToCN {
     /**
      * 汉语中数字大写
      */
     private static final String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆",
             "伍", "陆", "柒", "捌", "玖" };
     /**
      * 汉语中货币单位大写，这样的设计类似于占位符
      */
     private static final String[] CN_UPPER_MONETRAY_UNIT = { "分", "角", "元",
             "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾",
             "佰", "仟" };
     /**
      * 特殊字符：整
      */
     private static final String CN_FULL = "整";
     /**
      * 特殊字符：负
      */
     private static final String CN_NEGATIVE = "负";
     /**
      * 金额的精度，默认值为2
      */
     private static final int MONEY_PRECISION = 2;
     /**
      * 特殊字符：零元整
      */
     private static final String CN_ZEOR_FULL = "零元" + "整";
 
     /**
      * 把输入的金额转换为汉语中人民币的大写
      * 
      * @param numberOfMoney
      *            输入的金额
      * @return 对应的汉语大写
      */
     public static String number2CNMontrayUnit(BigDecimal numberOfMoney) {
         StringBuffer sb = new StringBuffer();
         // -1, 0, or 1 as the value of this BigDecimal is negative, zero, or
         // positive.
         int signum = numberOfMoney.signum();
         // 零元整的情况
         if (signum == 0) {
             return CN_ZEOR_FULL;
         }
         //这里会进行金额的四舍五入
         long number = numberOfMoney.movePointRight(MONEY_PRECISION)
                 .setScale(0, 4).abs().longValue();
         // 得到小数点后两位值
         long scale = number % 100;
         int numUnit = 0;
         int numIndex = 0;
         boolean getZero = false;
         // 判断最后两位数，一共有四中情况：00 = 0, 01 = 1, 10, 11
         if (!(scale > 0)) {
             numIndex = 2;
         }
         return "1";
     }
}