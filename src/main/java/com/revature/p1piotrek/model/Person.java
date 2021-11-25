package com.revature.p1piotrek.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
@Component
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String countries;
}
