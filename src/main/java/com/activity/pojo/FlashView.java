package com.activity.pojo;

import java.util.Date;

public class FlashView {
    private Integer flashViewId;

    private Integer sequenceNumber;

    private String viewUpUrl;

    private String viewDownUrl;

    private String jumpUrl;

    private Date createTime;

    private String deleteFlag;

    private String operator;

    private Date operationTime;

    public Integer getFlashViewId() {
        return flashViewId;
    }

    public void setFlashViewId(Integer flashViewId) {
        this.flashViewId = flashViewId;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getViewUpUrl() {
        return viewUpUrl;
    }

    public void setViewUpUrl(String viewUpUrl) {
        this.viewUpUrl = viewUpUrl == null ? null : viewUpUrl.trim();
    }

    public String getViewDownUrl() {
        return viewDownUrl;
    }

    public void setViewDownUrl(String viewDownUrl) {
        this.viewDownUrl = viewDownUrl == null ? null : viewDownUrl.trim();
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl == null ? null : jumpUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
}