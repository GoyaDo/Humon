package com.ysmjjsy.goya.jpa.base;

import com.ysmjjsy.goya.jpa.generator.SnowflakeIdGenerator;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description Jpa Entity
 * @className  BaseJpaEntity
 * @author 77394
 * @date  2024/3/27 10:47
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseJpaEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 2771139807736092947L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId",type = SnowflakeIdGenerator.class)
    private Long id;

    @Column(
            nullable = false,
            length = 32
    )
    @CreatedBy
    private @Nullable Long createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private @Nullable LocalDateTime createdDate;

    @Column(
            nullable = false,
            length = 32
    )
    @LastModifiedBy
    private @Nullable Long lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private @Nullable LocalDateTime lastModifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nullable
    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(@Nullable Long createdBy) {
        this.createdBy = createdBy;
    }

    @Nullable
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(@Nullable LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Nullable
    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(@Nullable Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Nullable
    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(@Nullable LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return "BaseJpaEntity{" +
                "id=" + id +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                ", lastModifiedBy=" + lastModifiedBy +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseJpaEntity that)) return false;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getCreatedBy() != null ? !getCreatedBy().equals(that.getCreatedBy()) : that.getCreatedBy() != null)
            return false;
        if (getCreatedDate() != null ? !getCreatedDate().equals(that.getCreatedDate()) : that.getCreatedDate() != null)
            return false;
        if (getLastModifiedBy() != null ? !getLastModifiedBy().equals(that.getLastModifiedBy()) : that.getLastModifiedBy() != null)
            return false;
        return getLastModifiedDate() != null ? getLastModifiedDate().equals(that.getLastModifiedDate()) : that.getLastModifiedDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCreatedBy() != null ? getCreatedBy().hashCode() : 0);
        result = 31 * result + (getCreatedDate() != null ? getCreatedDate().hashCode() : 0);
        result = 31 * result + (getLastModifiedBy() != null ? getLastModifiedBy().hashCode() : 0);
        result = 31 * result + (getLastModifiedDate() != null ? getLastModifiedDate().hashCode() : 0);
        return result;
    }
}
