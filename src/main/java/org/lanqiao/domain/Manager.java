package org.lanqiao.domain;

import java.util.Date;
//管理员信息
public class Manager {
    private int AdminId;//编号
    private String AdminName;//姓名
    private String AdminPwd;//密码
    private int AdminFlag;//权限
    private Date Ctime;//创建时间
    private Date Rtime;//修改时间

    public Manager() {
    }

    public Manager(int adminId, String adminName, String adminPwd, int adminFlag, Date ctime, Date rtime) {
        AdminId = adminId;
        AdminName = adminName;
        AdminPwd = adminPwd;
        AdminFlag = adminFlag;
        Ctime = ctime;
        Rtime = rtime;
    }

    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int adminId) {
        AdminId = adminId;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    public String getAdminPwd() {
        return AdminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        AdminPwd = adminPwd;
    }

    public int getAdminFlag() {
        return AdminFlag;
    }

    public void setAdminFlag(int adminFlag) {
        AdminFlag = adminFlag;
    }

    public Date getCtime() {
        return Ctime;
    }

    public void setCtime(Date ctime) {
        Ctime = ctime;
    }

    public Date getRtime() {
        return Rtime;
    }

    public void setRtime(Date rtime) {
        Rtime = rtime;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "AdminId=" + AdminId +
                ", AdminName='" + AdminName + '\'' +
                ", AdminPwd='" + AdminPwd + '\'' +
                ", AdminFlag=" + AdminFlag +
                ", Ctime=" + Ctime +
                ", Rtime=" + Rtime +
                '}';
    }
}
