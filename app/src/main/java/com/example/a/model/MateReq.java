package com.example.a.model;
import com.example.a.model.DogDetails;
import com.example.a.model.MateInfo;

import java.io.Serializable;
import java.util.Date;

public class MateReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer mateReqId;

    private Date mateReqDate;

    private DogDetails dogId;

    private MateInfo reqId;

    public MateReq() {
    }

    public MateReq(Integer mateReqId) {
        this.mateReqId = mateReqId;
    }

    public Integer getMateReqId() {
        return mateReqId;
    }

    public void setMateReqId(Integer mateReqId) {
        this.mateReqId = mateReqId;
    }

    public Date getMateReqDate() {
        return mateReqDate;
    }

    public void setMateReqDate(Date mateReqDate) {
        this.mateReqDate = mateReqDate;
    }

    public DogDetails getDogId() {
        return dogId;
    }

    public void setDogId(DogDetails dogId) {
        this.dogId = dogId;
    }

    public MateInfo getReqId() {
        return reqId;
    }

    public void setReqId(MateInfo reqId) {
        this.reqId = reqId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mateReqId != null ? mateReqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateReq)) {
            return false;
        }
        MateReq other = (MateReq) object;
        if ((this.mateReqId == null && other.mateReqId != null) || (this.mateReqId != null && !this.mateReqId.equals(other.mateReqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webwoof.MateReq[ mateReqId=" + mateReqId + " ]";
    }

}

