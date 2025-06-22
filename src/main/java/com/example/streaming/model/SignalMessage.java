package com.example.streaming.model;

public class SignalMessage {
    private String from;
    private String to;
    private String type;
    private String sdp;

    public SignalMessage() {}

    // Getters & Setters

    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }

    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getSdp() { return sdp; }
    public void setSdp(String sdp) { this.sdp = sdp; }

    @Override
    public String toString() {
        return "SignalMessage{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", type='" + type + '\'' +
                ", sdp[length]=" + (sdp != null ? sdp.length() : 0) +
                '}';
    }
}
