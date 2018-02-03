public class ICSHandler {
    private int sequence;
    private String startDate, startTime, endDate, endTime, dtStampDate, dtStampTime,
            id, creationDate, creationTime, lastModifiedDate, lastModifiedTime, location, status, summary, transparency;

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public void setDtStampDate(String dtStampDate) {
        this.dtStampDate = dtStampDate;
    }
    public void setDtStampTime(String dtStampTime) {
        this.dtStampTime = dtStampTime;
    }
    public void setUID(String id) {
        this.id = id;
    }
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public void setTransparency(String transparency) {
        this.transparency = transparency;
    }

    public String getStartDate() {
        return startDate;
    }
    public String getStartTime() {
        return startTime;
    }
    public String getEndDate() {
        return endDate;
    }
    public String getEndTime() {
        return endTime;
    }
    public String getDtStampDate() {
        return dtStampDate;
    }
    public String getDtStampTime() {
        return dtStampTime;
    }
    public String getUID() {
        return id;
    }
    public String getCreationDate() {
        return creationDate;
    }
    public String getCreationTime() {
        return creationTime;
    }
    public String getLastModifiedDate() {
        return lastModifiedDate;
    }
    public String getLastModifiedTime() {
        return lastModifiedTime;
    }
    public String getLocation() {
        return location;
    }
    public int getSequence() {
        return sequence;
    }
    public String getStatus() {
        return status;
    }
    public String getSummary() {
        return summary;
    }
    public String getTransparency() {
        return transparency;
    }
}
