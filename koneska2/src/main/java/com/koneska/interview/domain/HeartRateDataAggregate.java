package com.koneska.interview.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class HeartRateDataAggregate {
 /*
 {
    "date": "03/10/2021",
    "bpm": {
      "min": 67,
      "max": 90,
      "median": 80
    }
  }

  */
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate date;
    private Bpm bpm;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Bpm getBpm() {
        return bpm;
    }

    public void setBpm(Bpm bpm) {
        this.bpm = bpm;
    }

    public static class Bpm {
        double min;
        double max;
        double median;

        public Bpm(double min, double max, double median) {
            this.min = min;
            this.max = max;
            this.median = median;
        }

        public Bpm() {
        }

        public double getMin() {
            return min;
        }

        public void setMin(double min) {
            this.min = min;
        }

        public double getMax() {
            return max;
        }

        public void setMax(double max) {
            this.max = max;
        }

        public double getMedian() {
            return median;
        }

        public void setMedian(double median) {
            this.median = median;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Bpm bpm = (Bpm) o;
            return Double.compare(bpm.min, min) == 0 && Double.compare(bpm.max, max) == 0 && Double.compare(bpm.median, median) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(min, max, median);
        }

        @Override
        public String toString() {
            return "Bpm{" +
                    "min=" + min +
                    ", max=" + max +
                    ", median=" + median +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeartRateDataAggregate aggregate = (HeartRateDataAggregate) o;
        return Objects.equals(date, aggregate.date) && Objects.equals(bpm, aggregate.bpm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, bpm);
    }

    @Override
    public String toString() {
        return "HeartRateDataAggregate{" +
                "date=" + date +
                ", bpm=" + bpm +
                '}';
    }
}
