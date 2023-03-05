package com.mall.common.constant;

public class WareConstant {
    public enum PurchaseStatusEnum{
        CREATED(0, "CREATED"),
        ASSIGNED(1, "ASSIGNED"),
        RECIEVED(2, "RECIEVED"),
        FINISHED(3, "FINISHED"),
        HASERROR(4, "HASERROR");

        PurchaseStatusEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        private int code;
        private String msg;

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    public enum PurchaseDetailStatusEnum{
        CREATED(0, "CREATED"),
        ASSIGNED(1, "ASSIGNED"),
        BUYING(2, "BUYING"),
        FINISHED(3, "FINISHED"),
        HASERROR(4, "HASERROR");

        PurchaseDetailStatusEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        private int code;
        private String msg;

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
