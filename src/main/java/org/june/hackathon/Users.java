package org.june.hackathon;

import javax.persistence.*;

/**

 * Created by anshu on 5/6/16.
 */
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
    @SequenceGenerator(
            name="user_seq",
            sequenceName="user_sequence",
            allocationSize=20
    )
    @Column(name = "id")
    private Integer userId;
    @Column(name = "name")
    private String userName;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "password")
    private String password;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "logged_in")
    private Boolean isLoggedIn;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getisLoggedIn() {
        return isLoggedIn;
    }

    public void setisLoggedIn(Boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
