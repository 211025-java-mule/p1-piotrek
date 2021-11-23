package com.revature.p1piotrek;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String countries;
}
