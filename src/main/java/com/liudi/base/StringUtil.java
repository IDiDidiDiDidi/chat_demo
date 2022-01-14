//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.liudi.base;

import cn.hutool.core.text.StrFormatter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil extends StringUtils {
    private static Pattern linePattern = Pattern.compile("_(\\w)");
    private static Pattern humpPattern = Pattern.compile("[A-Z]");
    public static final ObjectMapper mapper = new ObjectMapper();
    private static final String NULLSTR = "";
    private static final char SEPARATOR = '_';

    public StringUtil() {
    }

    public static <T> T nvl(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }

    public static boolean isEmpty(Collection<?> coll) {
        return isNull(coll) || coll.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    public static boolean isEmpty(Object[] objects) {
        return isNull(objects) || objects.length == 0;
    }

    public static boolean isNotEmpty(Object[] objects) {
        return !isEmpty(objects);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return isNull(map) || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static boolean isEmpty(String str) {
        return isNull(str) || "".equals(str.trim());
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }

    public static Boolean isNullObj(Object object) {
        if (object != null) {
            if (object instanceof String) {
                String str = (String)object;
                return isNotEmpty(str) ? true : false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static boolean isArray(Object object) {
        return isNotNull(object) && object.getClass().isArray();
    }

    public static String trim(String str) {
        return str == null ? "" : str.trim();
    }

    public static String substring(String str, int start) {
        if (str == null) {
            return "";
        } else {
            if (start < 0) {
                start += str.length();
            }

            if (start < 0) {
                start = 0;
            }

            return start > str.length() ? "" : str.substring(start);
        }
    }

    public static String substring(String str, int start, int end) {
        if (str == null) {
            return "";
        } else {
            if (end < 0) {
                end += str.length();
            }

            if (start < 0) {
                start += str.length();
            }

            if (end > str.length()) {
                end = str.length();
            }

            if (start > end) {
                return "";
            } else {
                if (start < 0) {
                    start = 0;
                }

                if (end < 0) {
                    end = 0;
                }

                return str.substring(start, end);
            }
        }
    }

    public static String format(String template, Object... params) {
        return !isEmpty(params) && !isEmpty(template) ? StrFormatter.format(template, params) : template;
    }

    public static String toUnderScoreCase(String str) {
        if (str == null) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            boolean preCharIsUpperCase = true;
            boolean curreCharIsUpperCase = true;
            boolean nexteCharIsUpperCase = true;

            for(int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);
                if (i > 0) {
                    preCharIsUpperCase = Character.isUpperCase(str.charAt(i - 1));
                } else {
                    preCharIsUpperCase = false;
                }

                curreCharIsUpperCase = Character.isUpperCase(c);
                if (i < str.length() - 1) {
                    nexteCharIsUpperCase = Character.isUpperCase(str.charAt(i + 1));
                }

                if (preCharIsUpperCase && curreCharIsUpperCase && !nexteCharIsUpperCase) {
                    sb.append('_');
                } else if (i != 0 && !preCharIsUpperCase && curreCharIsUpperCase) {
                    sb.append('_');
                }

                sb.append(Character.toLowerCase(c));
            }

            return sb.toString();
        }
    }

    public static boolean inStringIgnoreCase(String str, String... strs) {
        if (str != null && strs != null) {
            String[] var2 = strs;
            int var3 = strs.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                String s = var2[var4];
                if (str.equalsIgnoreCase(trim(s))) {
                    return true;
                }
            }
        }

        return false;
    }

    public static String convertToCamelCase(String name) {
        StringBuilder result = new StringBuilder();
        if (name != null && !name.isEmpty()) {
            if (!name.contains("_")) {
                return name.substring(0, 1).toUpperCase() + name.substring(1);
            } else {
                String[] camels = name.split("_");
                String[] var3 = camels;
                int var4 = camels.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    String camel = var3[var5];
                    if (!camel.isEmpty()) {
                        result.append(camel.substring(0, 1).toUpperCase());
                        result.append(camel.substring(1).toLowerCase());
                    }
                }

                return result.toString();
            }
        } else {
            return "";
        }
    }

    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        } else {
            s = s.toLowerCase();
            StringBuilder sb = new StringBuilder(s.length());
            boolean upperCase = false;

            for(int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c == '_') {
                    upperCase = true;
                } else if (upperCase) {
                    sb.append(Character.toUpperCase(c));
                    upperCase = false;
                } else {
                    sb.append(c);
                }
            }

            return sb.toString();
        }
    }

    public static String lineToHump(String str) {
        if (null != str && !"".equals(str)) {
            str = str.toLowerCase();
            Matcher matcher = linePattern.matcher(str);
            StringBuffer sb = new StringBuffer();

            while(matcher.find()) {
                matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
            }

            matcher.appendTail(sb);
            str = sb.toString();
            str = str.substring(0, 1).toUpperCase() + str.substring(1);
            return str;
        } else {
            return str;
        }
    }

    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();

        while(matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }

        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String humpToLine2(String str) {
        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }

    public static String toLowerCaseFirstOne(String s) {
        if (StringUtils.isBlank(s)) {
            return s;
        } else {
            return Character.isLowerCase(s.charAt(0)) ? s : Character.toLowerCase(s.charAt(0)) + s.substring(1);
        }
    }

    public static String toUpperCaseFirstOne(String s) {
        if (StringUtils.isBlank(s)) {
            return s;
        } else {
            return Character.isUpperCase(s.charAt(0)) ? s : Character.toUpperCase(s.charAt(0)) + s.substring(1);
        }
    }

    public static String getString(Object object) {
        return getString(object, "");
    }

    public static String getString(Object object, String defaultValue) {
        if (null == object) {
            return defaultValue;
        } else {
            try {
                return object.toString();
            } catch (Exception var3) {
                return defaultValue;
            }
        }
    }

    public static int getInt(Object object) {
        return getInt(object, -1);
    }

    public static int getInt(Object object, Integer defaultValue) {
        if (null == object) {
            return defaultValue;
        } else {
            try {
                return Integer.parseInt(object.toString());
            } catch (Exception var3) {
                return defaultValue;
            }
        }
    }

    public static Long getLong(Object object) {
        return getLong(object, 0L);
    }

    public static Long getLong(Object object, Long defaultValue) {
        if (null == object) {
            return defaultValue;
        } else {
            try {
                return Long.parseLong(object.toString());
            } catch (Exception var3) {
                return defaultValue;
            }
        }
    }

    public static Double getDouble(Object object) {
        return getDouble(object, 0.0D);
    }

    public static Double getDouble(Object object, Double defaultValue) {
        if (null == object) {
            return defaultValue;
        } else {
            try {
                return Double.parseDouble(object.toString());
            } catch (Exception var3) {
                return defaultValue;
            }
        }
    }

    public static Float getFloat(Object object) {
        return getFloat(object, 0.0F);
    }

    public static Float getFloat(Object object, Float defaultValue) {
        if (null == object) {
            return defaultValue;
        } else {
            try {
                return Float.parseFloat(object.toString());
            } catch (Exception var3) {
                return defaultValue;
            }
        }
    }

    public static boolean getBoolean(Object object) {
        return getBoolean(object, false);
    }

    public static boolean getBoolean(Object object, Boolean defaultValue) {
        if (null == object) {
            return defaultValue;
        } else {
            try {
                return Boolean.parseBoolean(object.toString());
            } catch (Exception var3) {
                return defaultValue;
            }
        }
    }

    public static boolean parseBoolean(Object object) {
        if (null == object) {
            return false;
        } else if (object instanceof Boolean) {
            return (Boolean)object;
        } else {
            String str = object.toString().toLowerCase();
            if ("1".equals(str)) {
                return true;
            } else {
                return "true".equals(str);
            }
        }
    }

    public static String[] splitString(String str, String separator) {
        return StringUtils.splitByWholeSeparator(str, separator);
    }

    public static boolean isNumericAndDot(String str) {
        if (str != null && !str.trim().equals("")) {
            Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]*([Ee]{1}[0-9]+)?");
            Matcher isNum = pattern.matcher(str);
            return isNum.matches();
        } else {
            return false;
        }
    }

    public static boolean isNullOrEmpty(Object obj) {
        try {
            if (obj == null) {
                return true;
            } else if (obj instanceof CharSequence) {
                return ((CharSequence)obj).length() == 0;
            } else if (obj instanceof Collection) {
                return ((Collection)obj).isEmpty();
            } else if (obj instanceof Map) {
                return ((Map)obj).isEmpty();
            } else if (!(obj instanceof Object[])) {
                return false;
            } else {
                Object[] object = (Object[])((Object[])obj);
                if (object.length == 0) {
                    return true;
                } else {
                    boolean empty = true;

                    for(int i = 0; i < object.length; ++i) {
                        if (!isNullOrEmpty(object[i])) {
                            empty = false;
                            break;
                        }
                    }

                    return empty;
                }
            }
        } catch (Exception var4) {
            return true;
        }
    }

    public static String[] mergeStringArray(String[] a, String[] b) {
        if (a.length != 0 && !isEmpty((Object[])a)) {
            if (b.length != 0 && !isEmpty((Object[])b)) {
                String[] c = new String[a.length + b.length];

                int i;
                for(i = 0; i < a.length; ++i) {
                    c[i] = a[i];
                }

                for(i = 0; i < b.length; ++i) {
                    c[a.length + i] = b[i];
                }

                return c;
            } else {
                return a;
            }
        } else {
            return b;
        }
    }

    public static List<String> splitStr(String str, String spiltStr) {
        List<String> list = new ArrayList();
        if (str != null && str.indexOf(spiltStr) > -1) {
            String[] ids = str.split(spiltStr);
            String[] var4 = ids;
            int var5 = ids.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String tempId = var4[var6];
                list.add(tempId);
            }
        } else {
            list.add(str);
        }

        return list;
    }

    public static String parseString(Object object) {
        return null == object ? "" : String.valueOf(object);
    }

    public static String[] explode(String string, String splitRegex, String trimStr, boolean filterEmpty) {
        List<String> list = new ArrayList(0);
        if (isEmpty(string)) {
            return new String[0];
        } else {
            if ("\\".equals(splitRegex)) {
                splitRegex = "\\\\";
            }

            String[] var5 = string.split(splitRegex);
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                String str = var5[var7];
                if (!filterEmpty || !isEmpty(str)) {
                    if (null != trimStr) {
                        list.add(trim(str));
                    } else {
                        list.add(str);
                    }
                }
            }

            return (String[])collection2array(String.class, list);
        }
    }

    public static String[] explode(String string, String splitRegex) {
        return explode(string, splitRegex, " ", true);
    }

    public static String[] explode(String string) {
        return explode(string, ",", " ", true);
    }

    public static <T> T[] collection2array(Class<T> classType, Collection<T> collection) {
        if (null == collection) {
            array(classType, 0);
        }

        return collection.toArray(array(classType, collection.size()));
    }

    public static <T> T[] array(Class<T> classType, int length) {
        return (T[]) Array.newInstance(classType, length);
    }

    public static String trim(String str, String trimStr) {
        if (null == str) {
            return "";
        } else {
            String regexLeft = "^(" + trimStr + ")*";
            str = str.replaceFirst(regexLeft, "");
            String regexRight = "(" + trimStr + ")*$";
            str = str.replaceFirst(regexRight, "");
            return str;
        }
    }

    public static String stringify(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException var2) {
            return null;
        }
    }

    public static <T> T convertJSON(Object obj, Class<T> classType) {
        return mapper.convertValue(obj, classType);
    }

    public static ObjectNode objectNode() {
        return mapper.createObjectNode();
    }

    public static ArrayNode arrayNode() {
        return mapper.createArrayNode();
    }

    public static ArrayNode arrayNode(ObjectNode nodes) {
        ArrayNode array = arrayNode();
        Iterator iterator = nodes.elements();

        while(iterator.hasNext()) {
            array.add((JsonNode)iterator.next());
        }

        return array;
    }

    public static JsonNode parseJSON(String json) {
        if (null == json) {
            return null;
        } else {
            try {
                return mapper.readTree(json);
            } catch (Exception var2) {
                return null;
            }
        }
    }

    public static boolean isMatcher(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public static String stringConcat(Object... objects) {
        StringBuilder sb = new StringBuilder();
        Object[] var2 = objects;
        int var3 = objects.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Object object = var2[var4];
            if (null != object) {
                sb.append(object);
            }
        }

        return sb.toString();
    }
}
