package com.sjl22951227.onlineboard.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;
    @Column(length = 20, nullable = false)
    private String username;
    @Column(length = 20, nullable = false)
    private String password;
    @Column(length = 20, nullable = false)
    private String name_first;
    @Column(length = 20, nullable = false)
    private String name_last;
//    @Column(length = 20, nullable = false)
//    private String nickname;
    @Column(length = 40,nullable = false)
    private String email;

    @Column
    private LocalDateTime registrationDate;
    @Column
    private LocalDateTime lastLoginDate;
//    private Integer credit;
//    private Integer level;
//    private String status;
//    private String profilePicturePath;

    public User(String username, String password, String name_first, String name_last, String nickname, String email) {
        this.username = username;
        this.password = password;
        this.name_first = name_first;
        this.name_last = name_last;
//        this.nickname = nickname;
        this.email = email;
        this.lastLoginDate=LocalDateTime.now();
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName_first() {
        return name_first;
    }

    public void setName_first(String name_first) {
        this.name_first = name_first;
    }

    public String getName_last() {
        return name_last;
    }

    public void setName_last(String name_last) {
        this.name_last = name_last;
    }

//    public String getNickname() {
//        return nickname;
//    }
//
//    public void setNickname(String nickname) {
//        this.nickname = nickname;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

//    public Integer getCredit() {
//        return credit;
//    }
//
//    public void setCredit(Integer credit) {
//        this.credit = credit;
//    }
//
//    public Integer getLevel() {
//        return level;
//    }
//
//    public void setLevel(Integer level) {
//        this.level = level;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getProfilePicturePath() {
//        return profilePicturePath;
//    }
//
//    public void setProfilePicturePath(String profilePicturePath) {
//        this.profilePicturePath = profilePicturePath;
//    }
}
