package uk.ac.ed.notify.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rgood on 20/10/2015.
 */
@Entity
@Table(name="TOPIC_SUBSCRIPTIONS")
@NamedQueries({
        @NamedQuery(name = "TopicSubscription.findBySubscriberId", query = "SELECT a FROM TopicSubscription a WHERE a.subscriberId = (?1)")
})
public class TopicSubscription {

    //TODO Add status value validation
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",
            strategy = "uuid")
    @Column(name="SUBSCRIPTION_ID", nullable = false)
    private String subscriptionId;

    @Column(name="SUBSCRIBER_ID", nullable = false)
    private String subscriberId;

    @Column(name="TOPIC", nullable = false)
    private String topic;


    @Column(name="STATUS", nullable = false)
    private String status;

    @JsonSerialize(using=DatePartSerializer.class)
    @Column(name="LAST_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
