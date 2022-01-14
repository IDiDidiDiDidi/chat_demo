package com.liudi.base;

public enum CompareEnum {
    EQ("0", "相等", "="),
    NE("1", "不等于", "<>"),
    GT("2", "大于", ">"),
    GE("3", "大于等于", ">="),
    LT("4", "小于", "<"),
    LE("5", "小于等于", "<="),
    LIKE("6", "包含", "like"),
    ISNOTNUll("7", "不为空", "is not null"),
    ISNULL("8", "为空", "is null");

    private String code;
    private String message;
    private String rule;

    private CompareEnum(String code, String message, String rule) {
        this.code = code;
        this.message = message;
        this.rule = rule;
    }

    public static String getNameByCode(String code) {
        CompareEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            CompareEnum compareEnum = var1[var3];
            if (code.equals(compareEnum.getCode())) {
                return compareEnum.getMessage();
            }
        }

        return null;
    }

    public static String getRuleByCode(String code) {
        CompareEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            CompareEnum compareEnum = var1[var3];
            if (code.equals(compareEnum.getCode())) {
                return compareEnum.getRule();
            }
        }

        return null;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getRule() {
        return this.rule;
    }
}
