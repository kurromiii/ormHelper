package com.mftplus.orm.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@Entity (name = "PersonEntity")
@Table (name = "person_tbl")
public class Person {
    @Id
    @SequenceGenerator(name = "personSeq",sequenceName = "person_seq",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "personSeq")
    private int id;

    @Column(name = "username",length = 10,unique = true,nullable = false)
    private String userName;

    @Column(name = "password",length = 10,unique = true,nullable = false)
    private String passWord;

}
