package com.smartCity.objects.message;

import com.smartCity.objects.users.Admins;
import com.smartCity.objects.users.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "AdminMessages")
public class AdminMessages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MessageID")
    private Integer messageID;

    @Column(name = "Topic")
    private String topic;

    @Column(name = "Message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "AdminID")
    private Admins admin;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;
}
