package com.itbeezh.lottery.welfare.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by szwb004 on 2017-07-10.
 */
@Entity
@Table(name = "dchistorydata")
public class DCHistoryData {

    @Id
    @Column(name = "dchistoryserialno", nullable = false)
    String dcHistorySerialNo;

    @Column(name = "dcred1", nullable = false)
    int dcRed1;

    @Column(name = "dcred2", nullable = false)
    int dcRed2;

    @Column(name = "dcred3", nullable = false)
    int dcRed3;

    @Column(name = "dcred4", nullable = false)
    int dcRed4;

    @Column(name = "dcred5", nullable = false)
    int dcRed5;

    @Column(name = "dcred6", nullable = false)
    int dcRed6;

    @Column(name = "dcblue", nullable = false)
    int dcBlue;

    @Column(name = "dckjdate", nullable = false)
    String dcKjDate;

    @Column(name = "dcsmall")
    int dcSmall;

    @Column(name = "dcbig")
    int dcBig;

    @Column(name = "dcbefore")
    int dcBefore;

    @Column(name = "dcmid")
    int dcMid;

    @Column(name = "dcafter")
    int dcAfter;

    @Column(name = "dcodd")
    int dcOdd;

    @Column(name = "dceven")
    int dcEven;

    @Column(name = "dcgap1")
    int dcGap1;

    @Column(name = "dcgap2")
    int dcGap2;

    @Column(name = "dcgap3")
    int dcGap3;

    @Column(name = "dcgap4")
    int dcGap4;

    @Column(name = "dcgap5")
    int dcGap5;

    public String getDcHistorySerialNo() {
        return dcHistorySerialNo;
    }

    public void setDcHistorySerialNo(String dcHistorySerialNo) {
        this.dcHistorySerialNo = dcHistorySerialNo;
    }

    public int getDcRed1() {
        return dcRed1;
    }

    public void setDcRed1(int dcRed1) {
        this.dcRed1 = dcRed1;
    }

    public int getDcRed2() {
        return dcRed2;
    }

    public void setDcRed2(int dcRed2) {
        this.dcRed2 = dcRed2;
    }

    public int getDcRed3() {
        return dcRed3;
    }

    public void setDcRed3(int dcRed3) {
        this.dcRed3 = dcRed3;
    }

    public int getDcRed4() {
        return dcRed4;
    }

    public void setDcRed4(int dcRed4) {
        this.dcRed4 = dcRed4;
    }

    public int getDcRed5() {
        return dcRed5;
    }

    public void setDcRed5(int dcRed5) {
        this.dcRed5 = dcRed5;
    }

    public int getDcRed6() {
        return dcRed6;
    }

    public void setDcRed6(int dcRed6) {
        this.dcRed6 = dcRed6;
    }

    public int getDcBlue() {
        return dcBlue;
    }

    public void setDcBlue(int dcBlue) {
        this.dcBlue = dcBlue;
    }

    public String getDcKjDate() {
        return dcKjDate;
    }

    public void setDcKjDate(String dcKjDate) {
        this.dcKjDate = dcKjDate;
    }

    public int getDcSmall() {
        return dcSmall;
    }

    public void setDcSmall(int dcSmall) {
        this.dcSmall = dcSmall;
    }

    public int getDcBig() {
        return dcBig;
    }

    public void setDcBig(int dcBig) {
        this.dcBig = dcBig;
    }

    public int getDcBefore() {
        return dcBefore;
    }

    public void setDcBefore(int dcBefore) {
        this.dcBefore = dcBefore;
    }

    public int getDcMid() {
        return dcMid;
    }

    public void setDcMid(int dcMid) {
        this.dcMid = dcMid;
    }

    public int getDcAfter() {
        return dcAfter;
    }

    public void setDcAfter(int dcAfter) {
        this.dcAfter = dcAfter;
    }

    public int getDcOdd() {
        return dcOdd;
    }

    public void setDcOdd(int dcOdd) {
        this.dcOdd = dcOdd;
    }

    public int getDcEven() {
        return dcEven;
    }

    public void setDcEven(int dcEven) {
        this.dcEven = dcEven;
    }

    public int getDcGap1() {
        return dcGap1;
    }

    public void setDcGap1(int dcGap1) {
        this.dcGap1 = dcGap1;
    }

    public int getDcGap2() {
        return dcGap2;
    }

    public void setDcGap2(int dcGap2) {
        this.dcGap2 = dcGap2;
    }

    public int getDcGap3() {
        return dcGap3;
    }

    public void setDcGap3(int dcGap3) {
        this.dcGap3 = dcGap3;
    }

    public int getDcGap4() {
        return dcGap4;
    }

    public void setDcGap4(int dcGap4) {
        this.dcGap4 = dcGap4;
    }

    public int getDcGap5() {
        return dcGap5;
    }

    public void setDcGap5(int dcGap5) {
        this.dcGap5 = dcGap5;
    }
}
