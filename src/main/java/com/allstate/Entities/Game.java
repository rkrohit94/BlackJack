package com.allstate.Entities;

import com.allstate.enums.Action;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by localadmin on 23/01/17.
 */

@Entity
@Table(name = "games")
@Data
public class Game {

    private int id;
    private Date modified;
    private String status;
    private int version;

    @Column(name = "dealer_card")
    private String dealerCard;
    @Column(name ="player_card")
    private String playerCard;
    @Column(name ="player_card_value")
    private Integer playerCardValue;
    @Column(name ="dealer_card_value")
    private Integer dealerCardValue;

    private Date created;
    private int bet_amount;
    private Action action;
    private User user;


    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @Column(nullable = false, columnDefinition = "ENUM('HIT', 'STATE')")
    @Enumerated(EnumType.STRING)
    public Action getAction() {
        return action;
    }
    public void setAction(Action action) {
        this.action = action;
    }


    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }

}
