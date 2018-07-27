package com.gw.idea.stock.entity;

/**
 * Created by dell on 2018/7/26.
 */
public class KLineTarget {
    private String code;
    private String date;
    private double open;
    private double close;
    private double max;
    private double min;
    private long other;

    public KLineTarget(String code, String date, double open, double close, double max, double min, long other) {
        this.code = code;
        this.date = date;
        this.open = open;
        this.close = close;
        this.max = max;
        this.min = min;
        this.other = other;
    }

    public KLineTarget(String code, String date, String open, String close, String max, String min, String other) {
        this.code = code;
        this.date = date;
        this.open = Double.valueOf(open);
        this.close = Double.valueOf(close);
        this.max = Double.valueOf(max);
        this.min = Double.valueOf(min);
        this.other = Long.valueOf(other);
    }

    public KLineTarget(String code,String[] attrs) {
        this(code,attrs[0], attrs[1], attrs[2], attrs[3], attrs[4], attrs[5]);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public long getOther() {
        return other;
    }

    public void setOther(long other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "KLineTarget{" +
                "code='" + code + '\'' +
                ", date='" + date + '\'' +
                ", open=" + open +
                ", close=" + close +
                ", max=" + max +
                ", min=" + min +
                ", other=" + other +
                '}';
    }
}
