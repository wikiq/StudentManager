package com.wangpeng.pojo;

import java.math.BigDecimal;

public class CourseGrade {
    /**
     * 结果id
     */
    private Integer cgid;
    /**
     * 妆前准备id
     */
    private Integer oid;
    /**
     * 租户id
     */
    private Integer sid;
    /**
     * 结果进度
     */
    private BigDecimal score;

    public CourseGrade() {
    }

    public CourseGrade(Integer cgid, Integer oid, Integer sid, BigDecimal score) {
        this.cgid = cgid;
        this.oid = oid;
        this.sid = sid;
        this.score = score;
    }

    public Integer getCgid() {
        return cgid;
    }

    public void setCgid(Integer cgid) {
        this.cgid = cgid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "CourseGrade{" +
                "cgid=" + cgid +
                ", oid=" + oid +
                ", sid=" + sid +
                ", score=" + score +
                '}';
    }
}
