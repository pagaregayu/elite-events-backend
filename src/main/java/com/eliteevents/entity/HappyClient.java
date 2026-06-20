package com.eliteevents.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "happy_clients")
public class HappyClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientName;
    private String eventName;
    private String eventType;
    private Integer rating;
    private String review;

    // 4 image slots
    private String mediaUrl1;
    private String mediaType1;

    private String mediaUrl2;
    private String mediaType2;

    private String mediaUrl3;
    private String mediaType3;

    private String mediaUrl4;
    private String mediaType4;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }

    public String getMediaUrl1() { return mediaUrl1; }
    public void setMediaUrl1(String mediaUrl1) { this.mediaUrl1 = mediaUrl1; }

    public String getMediaType1() { return mediaType1; }
    public void setMediaType1(String mediaType1) { this.mediaType1 = mediaType1; }

    public String getMediaUrl2() { return mediaUrl2; }
    public void setMediaUrl2(String mediaUrl2) { this.mediaUrl2 = mediaUrl2; }

    public String getMediaType2() { return mediaType2; }
    public void setMediaType2(String mediaType2) { this.mediaType2 = mediaType2; }

    public String getMediaUrl3() { return mediaUrl3; }
    public void setMediaUrl3(String mediaUrl3) { this.mediaUrl3 = mediaUrl3; }

    public String getMediaType3() { return mediaType3; }
    public void setMediaType3(String mediaType3) { this.mediaType3 = mediaType3; }

    public String getMediaUrl4() { return mediaUrl4; }
    public void setMediaUrl4(String mediaUrl4) { this.mediaUrl4 = mediaUrl4; }

    public String getMediaType4() { return mediaType4; }
    public void setMediaType4(String mediaType4) { this.mediaType4 = mediaType4; }
}