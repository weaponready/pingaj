package org.pingaj.app.config;

/**
 * Creator: JimmyLin
 * DateTime: 14-8-14 下午9:38
 * Summary:
 */
public class Config {

    private String mp4Dir;
    private String ffmpegPath;

    private String host;

    private String profileId;

    private String activityNewsPath;
    private String reportNewsPath;

    private String instrumentWorkPath;
    private String childrenWorkPath;
    private String classicWorkPath;
    private String latestWorkPath;

    private String gloriesPath;
    private String storyAlbumPath;
    private String exchangeAlbumPath;

    private String soundOfDadePath;

    public Integer sunshine;

    public String getSoundOfDadePath() {
        return soundOfDadePath;
    }

    public void setSoundOfDadePath(String soundOfDadePath) {
        this.soundOfDadePath = soundOfDadePath;
    }


    public String getStoryAlbumPath() {
        return storyAlbumPath;
    }

    public void setStoryAlbumPath(String storyAlbumPath) {
        this.storyAlbumPath = storyAlbumPath;
    }

    public String getExchangeAlbumPath() {
        return exchangeAlbumPath;
    }

    public void setExchangeAlbumPath(String exchangeAlbumPath) {
        this.exchangeAlbumPath = exchangeAlbumPath;
    }

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

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getGloriesPath() {
        return gloriesPath;
    }

    public void setGloriesPath(String gloriesPath) {
        this.gloriesPath = gloriesPath;
    }

    public String getMp4Dir() {
        return mp4Dir;
    }

    public void setMp4Dir(String mp4Dir) {
        this.mp4Dir = mp4Dir;
    }

    public String getFfmpegPath() {
        return ffmpegPath;
    }

    public void setFfmpegPath(String ffmpegPath) {
        this.ffmpegPath = ffmpegPath;
    }

    public Integer getSunshine(){
        return this.sunshine;
    }

    public void setSunshine(Integer sunshine){
        this.sunshine = sunshine;
    }
}
