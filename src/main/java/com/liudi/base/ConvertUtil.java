//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.liudi.base;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class ConvertUtil {
    public static int UNIT_STEP = 4;
    public static String[] CN_UNITS = new String[]{"个", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千", "万"};
    public static String[] CN_CHARS = new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    public ConvertUtil() {
    }

    public static String toStr(Object value, String defaultValue) {
        if (null == value) {
            return defaultValue;
        } else {
            return value instanceof String ? (String)value : value.toString();
        }
    }

    public static String toStr(Object value) {
        return toStr(value, (String)null);
    }

    public static Character toChar(Object value, Character defaultValue) {
        if (null == value) {
            return defaultValue;
        } else if (value instanceof Character) {
            return (Character)value;
        } else {
            String valueStr = toStr(value, (String)null);
            return StringUtil.isEmpty(valueStr) ? defaultValue : valueStr.charAt(0);
        }
    }

    public static Character toChar(Object value) {
        return toChar(value, (Character)null);
    }

    public static Byte toByte(Object value, Byte defaultValue) {
        if (value == null) {
            return defaultValue;
        } else if (value instanceof Byte) {
            return (Byte)value;
        } else if (value instanceof Number) {
            return ((Number)value).byteValue();
        } else {
            String valueStr = toStr(value, (String)null);
            if (StringUtil.isEmpty(valueStr)) {
                return defaultValue;
            } else {
                try {
                    return Byte.parseByte(valueStr);
                } catch (Exception var4) {
                    return defaultValue;
                }
            }
        }
    }

    public static Byte toByte(Object value) {
        return toByte(value, (Byte)null);
    }

    public static Short toShort(Object value, Short defaultValue) {
        if (value == null) {
            return defaultValue;
        } else if (value instanceof Short) {
            return (Short)value;
        } else if (value instanceof Number) {
            return ((Number)value).shortValue();
        } else {
            String valueStr = toStr(value, (String)null);
            if (StringUtil.isEmpty(valueStr)) {
                return defaultValue;
            } else {
                try {
                    return Short.parseShort(valueStr.trim());
                } catch (Exception var4) {
                    return defaultValue;
                }
            }
        }
    }

    public static Short toShort(Object value) {
        return toShort(value, (Short)null);
    }

    public static Number toNumber(Object value, Number defaultValue) {
        if (value == null) {
            return defaultValue;
        } else if (value instanceof Number) {
            return (Number)value;
        } else {
            String valueStr = toStr(value, (String)null);
            if (StringUtil.isEmpty(valueStr)) {
                return defaultValue;
            } else {
                try {
                    return NumberFormat.getInstance().parse(valueStr);
                } catch (Exception var4) {
                    return defaultValue;
                }
            }
        }
    }

    public static Number toNumber(Object value) {
        return toNumber(value, (Number)null);
    }

    public static Integer toInt(Object value, Integer defaultValue) {
        if (value == null) {
            return defaultValue;
        } else if (value instanceof Integer) {
            return (Integer)value;
        } else if (value instanceof Number) {
            return ((Number)value).intValue();
        } else {
            String valueStr = toStr(value, (String)null);
            if (StringUtil.isEmpty(valueStr)) {
                return defaultValue;
            } else {
                try {
                    return Integer.parseInt(valueStr.trim());
                } catch (Exception var4) {
                    return defaultValue;
                }
            }
        }
    }

    public static Integer toInt(Object value) {
        return toInt(value, (Integer)null);
    }

    public static Integer[] toIntArray(String str) {
        return toIntArray(",", str);
    }

    public static Long[] toLongArray(String str) {
        return toLongArray(",", str);
    }

    public static Integer[] toIntArray(String split, String str) {
        if (StringUtil.isEmpty(str)) {
            return new Integer[0];
        } else {
            String[] arr = str.split(split);
            Integer[] ints = new Integer[arr.length];

            for(int i = 0; i < arr.length; ++i) {
                Integer v = toInt(arr[i], 0);
                ints[i] = v;
            }

            return ints;
        }
    }

    public static Long[] toLongArray(String split, String str) {
        if (StringUtil.isEmpty(str)) {
            return new Long[0];
        } else {
            String[] arr = str.split(split);
            Long[] longs = new Long[arr.length];

            for(int i = 0; i < arr.length; ++i) {
                Long v = toLong(arr[i], (Long)null);
                longs[i] = v;
            }

            return longs;
        }
    }

    public static String[] toStrArray(String str) {
        return toStrArray(",", str);
    }

    public static String[] toStrArray(String split, String str) {
        return str.split(split);
    }

    public static Long toLong(Object value, Long defaultValue) {
        if (value == null) {
            return defaultValue;
        } else if (value instanceof Long) {
            return (Long)value;
        } else if (value instanceof Number) {
            return ((Number)value).longValue();
        } else {
            String valueStr = toStr(value, (String)null);
            if (StringUtil.isEmpty(valueStr)) {
                return defaultValue;
            } else {
                try {
                    return (new BigDecimal(valueStr.trim())).longValue();
                } catch (Exception var4) {
                    return defaultValue;
                }
            }
        }
    }

    public static Long toLong(Object value) {
        return toLong(value, (Long)null);
    }

    public static Double toDouble(Object value, Double defaultValue) {
        if (value == null) {
            return defaultValue;
        } else if (value instanceof Double) {
            return (Double)value;
        } else if (value instanceof Number) {
            return ((Number)value).doubleValue();
        } else {
            String valueStr = toStr(value, (String)null);
            if (StringUtil.isEmpty(valueStr)) {
                return defaultValue;
            } else {
                try {
                    return (new BigDecimal(valueStr.trim())).doubleValue();
                } catch (Exception var4) {
                    return defaultValue;
                }
            }
        }
    }

    public static Double toDouble(Object value) {
        return toDouble(value, (Double)null);
    }

    public static Float toFloat(Object value, Float defaultValue) {
        if (value == null) {
            return defaultValue;
        } else if (value instanceof Float) {
            return (Float)value;
        } else if (value instanceof Number) {
            return ((Number)value).floatValue();
        } else {
            String valueStr = toStr(value, (String)null);
            if (StringUtil.isEmpty(valueStr)) {
                return defaultValue;
            } else {
                try {
                    return Float.parseFloat(valueStr.trim());
                } catch (Exception var4) {
                    return defaultValue;
                }
            }
        }
    }

    public static Float toFloat(Object value) {
        return toFloat(value, (Float)null);
    }

    public static Boolean toBool(Object value, Boolean defaultValue) {
        if (value == null) {
            return defaultValue;
        } else if (value instanceof Boolean) {
            return (Boolean)value;
        } else {
            String valueStr = toStr(value, (String)null);
            if (StringUtil.isEmpty(valueStr)) {
                return defaultValue;
            } else {
                valueStr = valueStr.trim().toLowerCase();
                byte var4 = -1;
                switch(valueStr.hashCode()) {
                case 48:
                    if (valueStr.equals("0")) {
                        var4 = 6;
                    }
                    break;
                case 49:
                    if (valueStr.equals("1")) {
                        var4 = 5;
                    }
                    break;
                case 3521:
                    if (valueStr.equals("no")) {
                        var4 = 4;
                    }
                    break;
                case 3548:
                    if (valueStr.equals("ok")) {
                        var4 = 3;
                    }
                    break;
                case 119527:
                    if (valueStr.equals("yes")) {
                        var4 = 2;
                    }
                    break;
                case 3569038:
                    if (valueStr.equals("true")) {
                        var4 = 0;
                    }
                    break;
                case 97196323:
                    if (valueStr.equals("false")) {
                        var4 = 1;
                    }
                }

                switch(var4) {
                case 0:
                    return true;
                case 1:
                    return false;
                case 2:
                    return true;
                case 3:
                    return true;
                case 4:
                    return false;
                case 5:
                    return true;
                case 6:
                    return false;
                default:
                    return defaultValue;
                }
            }
        }
    }

    public static Boolean toBool(Object value) {
        return toBool(value, (Boolean)null);
    }

    public static <E extends Enum<E>> E toEnum(Class<E> clazz, Object value, E defaultValue) {
        if (value == null) {
            return defaultValue;
        } else if (clazz.isAssignableFrom(value.getClass())) {
            E myE = (E) value;
            return myE;
        } else {
            String valueStr = toStr(value, (String)null);
            if (StringUtil.isEmpty(valueStr)) {
                return defaultValue;
            } else {
                try {
                    return Enum.valueOf(clazz, valueStr);
                } catch (Exception var5) {
                    return defaultValue;
                }
            }
        }
    }

    public static <E extends Enum<E>> E toEnum(Class<E> clazz, Object value) {
        return toEnum(clazz, value, (E) null);
    }

    public static BigInteger toBigInteger(Object value, BigInteger defaultValue) {
        if (value == null) {
            return defaultValue;
        } else if (value instanceof BigInteger) {
            return (BigInteger)value;
        } else if (value instanceof Long) {
            return BigInteger.valueOf((Long)value);
        } else {
            String valueStr = toStr(value, (String)null);
            if (StringUtil.isEmpty(valueStr)) {
                return defaultValue;
            } else {
                try {
                    return new BigInteger(valueStr);
                } catch (Exception var4) {
                    return defaultValue;
                }
            }
        }
    }

    public static BigInteger toBigInteger(Object value) {
        return toBigInteger(value, (BigInteger)null);
    }

    public static BigDecimal toBigDecimal(Object value, BigDecimal defaultValue) {
        if (value == null) {
            return defaultValue;
        } else if (value instanceof BigDecimal) {
            return (BigDecimal)value;
        } else if (value instanceof Long) {
            return new BigDecimal((Long)value);
        } else if (value instanceof Double) {
            return new BigDecimal((Double)value);
        } else if (value instanceof Integer) {
            return new BigDecimal((Integer)value);
        } else {
            String valueStr = toStr(value, (String)null);
            if (StringUtil.isEmpty(valueStr)) {
                return defaultValue;
            } else {
                try {
                    return new BigDecimal(valueStr);
                } catch (Exception var4) {
                    return defaultValue;
                }
            }
        }
    }

    public static BigDecimal toBigDecimal(Object value) {
        return toBigDecimal(value, (BigDecimal)null);
    }

    public static String utf8Str(Object obj) {
        return str(obj, CharsetConstant.CHARSET_UTF_8);
    }

    public static String str(Object obj, String charsetName) {
        return str(obj, Charset.forName(charsetName));
    }

    public static String str(Object obj, Charset charset) {
        if (null == obj) {
            return null;
        } else if (obj instanceof String) {
            return (String)obj;
        } else if (!(obj instanceof byte[]) && !(obj instanceof Byte[])) {
            return obj instanceof ByteBuffer ? str((ByteBuffer)obj, charset) : obj.toString();
        } else {
            return str((Object)((Byte[])((Byte[])obj)), (Charset)charset);
        }
    }

    public static String str(byte[] bytes, String charset) {
        return str(bytes, StringUtil.isEmpty(charset) ? Charset.defaultCharset() : Charset.forName(charset));
    }

    public static String str(byte[] data, Charset charset) {
        if (data == null) {
            return null;
        } else {
            return null == charset ? new String(data) : new String(data, charset);
        }
    }

    public static String str(ByteBuffer data, String charset) {
        return data == null ? null : str(data, Charset.forName(charset));
    }

    public static String str(ByteBuffer data, Charset charset) {
        if (null == charset) {
            charset = Charset.defaultCharset();
        }

        return charset.decode(data).toString();
    }

    public static String toSBC(String input) {
        return toSBC(input, (Set)null);
    }

    public static String toSBC(String input, Set<Character> notConvertSet) {
        char[] c = input.toCharArray();

        for(int i = 0; i < c.length; ++i) {
            if (null == notConvertSet || !notConvertSet.contains(c[i])) {
                if (c[i] == ' ') {
                    c[i] = 12288;
                } else if (c[i] < 127) {
                    c[i] += 'ﻠ';
                }
            }
        }

        return new String(c);
    }

    public static String toDBC(String input) {
        return toDBC(input, (Set)null);
    }

    public static String toDBC(String text, Set<Character> notConvertSet) {
        char[] c = text.toCharArray();

        for(int i = 0; i < c.length; ++i) {
            if (null == notConvertSet || !notConvertSet.contains(c[i])) {
                if (c[i] == 12288) {
                    c[i] = ' ';
                } else if (c[i] > '\uff00' && c[i] < '｟') {
                    c[i] -= 'ﻠ';
                }
            }
        }

        String returnString = new String(c);
        return returnString;
    }

    public static String digitUppercase(double n) {
        String[] fraction = new String[]{"角", "分"};
        String[] digit = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[][] unit = new String[][]{{"元", "万", "亿"}, {"", "拾", "佰", "仟"}};
        String head = n < 0.0D ? "负" : "";
        n = Math.abs(n);
        String s = "";

        int integerPart;
        for(integerPart = 0; integerPart < fraction.length; ++integerPart) {
            s = s + (digit[(int)(Math.floor(n * 10.0D * Math.pow(10.0D, (double)integerPart)) % 10.0D)] + fraction[integerPart]).replaceAll("(零.)+", "");
        }

        if (s.length() < 1) {
            s = "整";
        }

        integerPart = (int)Math.floor(n);

        for(int i = 0; i < unit[0].length && integerPart > 0; ++i) {
            String p = "";

            for(int j = 0; j < unit[1].length && n > 0.0D; ++j) {
                p = digit[integerPart % 10] + unit[1][j] + p;
                integerPart /= 10;
            }

            s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + s;
        }

        return head + s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "").replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");
    }

    public static String getCNNum(int srcNum) {
        String desCNNum = "";
        if (srcNum <= 0) {
            desCNNum = "零";
        } else {
            while(srcNum > 0) {
                int singleDigit = srcNum % 10;
                desCNNum = CN_CHARS[singleDigit] + desCNNum;
                srcNum /= 10;
            }
        }

        return desCNNum;
    }

    public static String cvt(String num, boolean isColloquial) {
        int decimal = 0;
        StringBuffer strs = new StringBuffer(32);
        long integer;
        String[] result_1;
        if (num.indexOf(".") > -1) {
            result_1 = num.split("\\.");
            integer = Long.parseLong(result_1[0]);
            decimal = Integer.parseInt(result_1[1]);
        } else {
            integer = Long.parseLong(num);
        }

        result_1 = convert(integer, isColloquial);
        String[] var7 = result_1;
        int var8 = result_1.length;

        for(int var9 = 0; var9 < var8; ++var9) {
            String str1 = var7[var9];
            strs.append(str1);
        }

        if (decimal == 0) {
            return strs.toString();
        } else {
            String result_2 = getCNNum(decimal);
            strs.append("点");
            strs.append(result_2);
            return strs.toString();
        }
    }

    public static String[] convert(long num, boolean isColloquial) {
        if (num < 10L) {
            return new String[]{CN_CHARS[(int)num]};
        } else {
            char[] chars = String.valueOf(num).toCharArray();
            if (chars.length > CN_UNITS.length) {
                return new String[0];
            } else {
                boolean isLastUnitStep = false;
                ArrayList<String> cnchars = new ArrayList(chars.length * 2);

                int chSize;
                String cnChar;
                for(chSize = chars.length - 1; chSize >= 0; --chSize) {
                    char ch = chars[chSize];
                    cnChar = CN_CHARS[ch - 48];
                    int unitPos = chars.length - chSize - 1;
                    String cnUnit = CN_UNITS[unitPos];
                    boolean isZero = ch == '0';
                    boolean isZeroLow = chSize + 1 < chars.length && chars[chSize + 1] == '0';
                    boolean isUnitStep = unitPos >= UNIT_STEP && unitPos % UNIT_STEP == 0;
                    if (isUnitStep && isLastUnitStep) {
                        int size = cnchars.size();
                        cnchars.remove(size - 1);
                        if (!CN_CHARS[0].equals(cnchars.get(size - 2))) {
                            cnchars.add(CN_CHARS[0]);
                        }
                    }

                    if (isUnitStep || !isZero) {
                        cnchars.add(cnUnit);
                        isLastUnitStep = isUnitStep;
                    }

                    if (!isZero || !isZeroLow && !isUnitStep) {
                        cnchars.add(cnChar);
                        isLastUnitStep = false;
                    }
                }

                Collections.reverse(cnchars);
                chSize = cnchars.size();
                String chEnd = (String)cnchars.get(chSize - 1);
                if (CN_CHARS[0].equals(chEnd) || CN_UNITS[0].equals(chEnd)) {
                    cnchars.remove(chSize - 1);
                }

                if (isColloquial) {
                    cnChar = (String)cnchars.get(0);
                    String chSecond = (String)cnchars.get(1);
                    if (cnChar.equals(CN_CHARS[1]) && chSecond.startsWith(CN_UNITS[1])) {
                        cnchars.remove(0);
                    }
                }

                return (String[])cnchars.toArray(new String[0]);
            }
        }
    }

    public static String covertStr(String num, String beforeStr, String afterStr) {
        String str = cvt(num, true);
        return beforeStr + str + afterStr;
    }
}
