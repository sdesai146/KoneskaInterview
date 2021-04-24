package com.koneska.interview.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class HeartRateRaw {
   // @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    @JsonProperty("start_time")
    private  LocalDateTime startTime;

    @JsonProperty("end_time")
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private  LocalDateTime endTime;

    private LocalDate monitoringDate;

    @JsonProperty("bpm")
    double bpm;

    public HeartRateRaw() {
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public double getBpm() {
        return bpm;
    }

    @JsonSetter("start_time")
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        this.monitoringDate = startTime.toLocalDate();
    }

    @JsonSetter("end_time")
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @JsonSetter("bpm")
    public void setBpm(double bpm) {
        this.bpm = bpm;
    }

    public LocalDate getMonitoringDate() {
        return monitoringDate;
    }

    @Override
    public String toString() {
        return "HeartRateRaw{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", monitoringDate=" + monitoringDate +
                ", bpm=" + bpm +
                "}\n";
    }
}
