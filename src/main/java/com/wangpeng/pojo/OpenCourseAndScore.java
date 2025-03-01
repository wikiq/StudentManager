package com.wangpeng.pojo;

public class OpenCourseAndScore extends OpenCourse {

    /**
     * 结果进度
     */
    private Integer score;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "OpenCourseAndScore{" +
                "score=" + score +
                '}';
    }
}
