package com.fourav.medal.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties( ignoreUnknown = true )
public class MedalObject implements Serializable {
    private String contentId;
    private String rawFileUrl;
    private String unbrandedFileUrl;
    private String contentTitle;
    private String contentViews;
    private String contentLikes;
    private String categoryId;
    private String videoLengthSeconds;
    private String createdTimestamp;
    private String directClipUrl;
    private String embedIframeCode;
    private String credits;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getRawFileUrl() {
        return rawFileUrl;
    }

    public void setRawFileUrl(String rawFileUrl) {
        this.rawFileUrl = rawFileUrl;
    }

    public String getUnbrandedFileUrl() {
        return unbrandedFileUrl;
    }

    public void setUnbrandedFileUrl(String unbrandedFileUrl) {
        this.unbrandedFileUrl = unbrandedFileUrl;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContentViews() {
        return contentViews;
    }

    public void setContentViews(String contentViews) {
        this.contentViews = contentViews;
    }

    public String getContentLikes() {
        return contentLikes;
    }

    public void setContentLikes(String contentLikes) {
        this.contentLikes = contentLikes;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getVideoLengthSeconds() {
        return videoLengthSeconds;
    }

    public void setVideoLengthSeconds(String videoLengthSeconds) {
        this.videoLengthSeconds = videoLengthSeconds;
    }

    public String getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(String createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getDirectClipUrl() {
        return directClipUrl;
    }

    public void setDirectClipUrl(String directClipUrl) {
        this.directClipUrl = directClipUrl;
    }

    public String getEmbedIframeCode() {
        return embedIframeCode;
    }

    public void setEmbedIframeCode(String embedIframeCode) {
        this.embedIframeCode = embedIframeCode;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "MedalObject{" +
                "contentId='" + contentId + '\'' +
                ", rawFileUrl='" + rawFileUrl + '\'' +
                ", unbrandedFileUrl='" + unbrandedFileUrl + '\'' +
                ", contentTitle='" + contentTitle + '\'' +
                ", contentViews='" + contentViews + '\'' +
                ", contentLikes='" + contentLikes + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", videoLengthSeconds='" + videoLengthSeconds + '\'' +
                ", createdTimestamp='" + createdTimestamp + '\'' +
                ", directClipUrl='" + directClipUrl + '\'' +
                ", embedIframeCode='" + embedIframeCode + '\'' +
                ", credits='" + credits + '\'' +
                '}';
    }
}


