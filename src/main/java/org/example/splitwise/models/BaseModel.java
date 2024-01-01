package org.example.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass //this annotation is used to say that this is the super class for all the model class
@EntityListeners(AuditingEntityListener.class) //listeners to the jpa auditing which is enabled at main of the application with Enablejpaauditing annotation
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This is basically to auto-populate id field with the long values.
    private Long id;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
}