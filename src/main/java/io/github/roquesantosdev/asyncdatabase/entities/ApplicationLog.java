package io.github.roquesantosdev.asyncdatabase.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "application_log")
public class ApplicationLog {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "log_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime date;
    @Column(name = "log_message")
    private String message;

    public ApplicationLog(LocalDateTime date, String message) {
        this.date = date;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("[ID : %d, Date : %s, Message : %s]", id, date, message);
    }
}