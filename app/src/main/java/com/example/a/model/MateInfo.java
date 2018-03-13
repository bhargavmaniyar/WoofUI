package com.example.a.model;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.example.a.model.DogDetails;
import com.example.a.model.MateReq;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


/**
 *
 * @author A
 */

public class MateInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer mateInfoId;

    private Date mateDate;

    private DogDetails dogId2;

    private DogDetails dogId;

    private Collection<MateReq> mateReqCollection;

    public MateInfo() {
    }

    public MateInfo(Integer mateInfoId) {
        this.mateInfoId = mateInfoId;
    }

    public Integer getMateInfoId() {
        return mateInfoId;
    }

    public void setMateInfoId(Integer mateInfoId) {
        this.mateInfoId = mateInfoId;
    }

    public Date getMateDate() {
        return mateDate;
    }

    public void setMateDate(Date mateDate) {
        this.mateDate = mateDate;
    }

    public DogDetails getDogId2() {
        return dogId2;
    }

    public void setDogId2(DogDetails dogId2) {
        this.dogId2 = dogId2;
    }

    public DogDetails getDogId() {
        return dogId;
    }

    public void setDogId(DogDetails dogId) {
        this.dogId = dogId;
    }


    public Collection<MateReq> getMateReqCollection() {
        return mateReqCollection;
    }

    public void setMateReqCollection(Collection<MateReq> mateReqCollection) {
        this.mateReqCollection = mateReqCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mateInfoId != null ? mateInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateInfo)) {
            return false;
        }
        MateInfo other = (MateInfo) object;
        if ((this.mateInfoId == null && other.mateInfoId != null) || (this.mateInfoId != null && !this.mateInfoId.equals(other.mateInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webwoof.MateInfo[ mateInfoId=" + mateInfoId + " ]";
    }

}
