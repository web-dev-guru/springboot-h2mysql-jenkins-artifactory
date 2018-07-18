package com.aws.devops.bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="fund_profile")
public class FundProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name="datecreated")
    private Date dateCreated;
    @Temporal(TemporalType.DATE)
    @Column(name="lastupdated")
    private Date lastUpdated;
    @Column(name="fundnum")
    private String fundNum;
    @Column(name="fundname")
    private String fundName;
    @Column(name="price")
    private BigDecimal dailyPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getFundNum() {
        return fundNum;
    }

    public void setFundNum(String fundNum) {
        this.fundNum = fundNum;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public BigDecimal getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(BigDecimal dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public FundProfile() {

    }

    public FundProfile(Date dateCreated, Date lastUpdated, String fundNum, String fundName, BigDecimal dailyPrice) {

        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
        this.fundNum = fundNum;
        this.fundName = fundName;
        this.dailyPrice = dailyPrice;
    }
}
