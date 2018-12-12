package org.lanqiao.domain;

import java.util.Date;

/*客户*/
public class Customer {
    private int CustomerId;
    private String CustomerName;
    private String CustomerPwd;
    private String Customertruename;
    private String CustomerSex;
    private String CustomerTel;
    private String CustomerEmail;
    private String CustomerAddr;
    private Date CTime;
    private Date RTime;
    private String CustomerQues;
    private String CustomerAnswer;
    private int CustomerLogTime;
    private Date CustomerLastLogT;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerPwd, String customertruename, String customerSex, String customerTel, String customerEmail, String customerAddr, Date CTime, Date RTime, String customerQues, String customerAnswer, int customerLogTime, Date customerLastLogT) {
        CustomerId = customerId;
        CustomerName = customerName;
        CustomerPwd = customerPwd;
        Customertruename = customertruename;
        CustomerSex = customerSex;
        CustomerTel = customerTel;
        CustomerEmail = customerEmail;
        CustomerAddr = customerAddr;
        this.CTime = CTime;
        this.RTime = RTime;
        CustomerQues = customerQues;
        CustomerAnswer = customerAnswer;
        CustomerLogTime = customerLogTime;
        CustomerLastLogT = customerLastLogT;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerPwd() {
        return CustomerPwd;
    }

    public void setCustomerPwd(String customerPwd) {
        CustomerPwd = customerPwd;
    }

    public String getCustomertruename() {
        return Customertruename;
    }

    public void setCustomertruename(String customertruename) {
        Customertruename = customertruename;
    }

    public String getCustomerSex() {
        return CustomerSex;
    }

    public void setCustomerSex(String customerSex) {
        CustomerSex = customerSex;
    }

    public String getCustomerTel() {
        return CustomerTel;
    }

    public void setCustomerTel(String customerTel) {
        CustomerTel = customerTel;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public String getCustomerAddr() {
        return CustomerAddr;
    }

    public void setCustomerAddr(String customerAddr) {
        CustomerAddr = customerAddr;
    }

    public Date getCTime() {
        return CTime;
    }

    public void setCTime(Date CTime) {
        this.CTime = CTime;
    }

    public Date getRTime() {
        return RTime;
    }

    public void setRTime(Date RTime) {
        this.RTime = RTime;
    }

    public String getCustomerQues() {
        return CustomerQues;
    }

    public void setCustomerQues(String customerQues) {
        CustomerQues = customerQues;
    }

    public String getCustomerAnswer() {
        return CustomerAnswer;
    }

    public void setCustomerAnswer(String customerAnswer) {
        CustomerAnswer = customerAnswer;
    }

    public int getCustomerLogTime() {
        return CustomerLogTime;
    }

    public void setCustomerLogTime(int customerLogTime) {
        CustomerLogTime = customerLogTime;
    }

    public Date getCustomerLastLogT() {
        return CustomerLastLogT;
    }

    public void setCustomerLastLogT(Date customerLastLogT) {
        CustomerLastLogT = customerLastLogT;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerId=" + CustomerId +
                ", CustomerName='" + CustomerName + '\'' +
                ", CustomerPwd='" + CustomerPwd + '\'' +
                ", Customertruename='" + Customertruename + '\'' +
                ", CustomerSex='" + CustomerSex + '\'' +
                ", CustomerTel='" + CustomerTel + '\'' +
                ", CustomerEmail='" + CustomerEmail + '\'' +
                ", CustomerAddr='" + CustomerAddr + '\'' +
                ", CTime=" + CTime +
                ", RTime=" + RTime +
                ", CustomerQues='" + CustomerQues + '\'' +
                ", CustomerAnswer='" + CustomerAnswer + '\'' +
                ", CustomerLogTime=" + CustomerLogTime +
                ", CustomerLastLogT=" + CustomerLastLogT +
                '}';
    }
}
