package com.qianfanyun.module_rxjava.bean;

import com.qianfanyun.module_base.api.BaseApiBean;

/**
 * @author ArcherYc
 * @date on 2019/4/12  09:19
 * @mail 247067345@qq.com
 */
public class TranslationBean {

    private String from;
    private String to;
    private String vendor;
    private String out;
    private int errNo;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public int getErrNo() {
        return errNo;
    }

    public void setErrNo(int errNo) {
        this.errNo = errNo;
    }

    @Override
    public String toString() {
        return "Content{" +
                "from=" + from + '\n' +
                "to=" + to + '\n' +
                "vendor=" + vendor + '\n' +
                "out=" + out + '\n' +
                "errNo=" + errNo + '\n' +
                '}';
    }

}
