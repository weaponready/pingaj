package org.pingaj.app.config;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-14 下午9:38
 * Summary:
 */
public class Config {

    private String host;

    private String activityNewsPath;
    private String reportNewsPath;

    private String instrumentWorkPath;
    private String childrenWorkPath;
    private String classicWorkPath;
    private String latestWorkPath;

    public String getActivityNewsPath() {
        return activityNewsPath;
    }

    public void setActivityNewsPath(String activityNewsPath) {
        this.activityNewsPath = activityNewsPath;
    }

    public String getReportNewsPath() {
        return reportNewsPath;
    }

    public void setReportNewsPath(String reportNewsPath) {
        this.reportNewsPath = reportNewsPath;
    }

    public String getInstrumentWorkPath() {
        return instrumentWorkPath;
    }

    public void setInstrumentWorkPath(String instrumentWorkPath) {
        this.instrumentWorkPath = instrumentWorkPath;
    }

    public String getChildrenWorkPath() {
        return childrenWorkPath;
    }

    public void setChildrenWorkPath(String childrenWorkPath) {
        this.childrenWorkPath = childrenWorkPath;
    }

    public String getClassicWorkPath() {
        return classicWorkPath;
    }

    public void setClassicWorkPath(String classicWorkPath) {
        this.classicWorkPath = classicWorkPath;
    }

    public String getLatestWorkPath() {
        return latestWorkPath;
    }

    public void setLatestWorkPath(String latestWorkPath) {
        this.latestWorkPath = latestWorkPath;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
