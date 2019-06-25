package ua.ternopil.igorbendera.domain;

import java.util.Date;
import java.util.Objects;

public class Subscribe {
    private Integer id;
    private Integer userId;
    private Integer magazineId;
    private Date purchaseDate;

    public Subscribe(Integer id, Integer userId, Integer magazineId, Date purchaseDate) {
        this.id = id;
        this.userId = userId;
        this.magazineId = magazineId;
        this.purchaseDate = purchaseDate;
    }

    public Subscribe(Integer userId, Integer magazineId, Date purchaseDate) {
        this.userId = userId;
        this.magazineId = magazineId;
        this.purchaseDate = purchaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMagazineId() {
        return magazineId;
    }

    public void setMagazineId(Integer magazineId) {
        this.magazineId = magazineId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscribe subscribe = (Subscribe) o;
        return userId.equals(subscribe.userId) &&
                magazineId.equals(subscribe.magazineId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, magazineId);
    }

    @Override
    public String toString() {
        return "Subscribe{" +
                "id=" + id +
                ", userId=" + userId +
                ", magazineId=" + magazineId +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
