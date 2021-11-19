package com.revature.p1piotrek;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@ToString
@Component
public class Person {
    private String name;
    private List<Country> countries;
}
