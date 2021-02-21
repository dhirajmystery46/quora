package com.upgrad.quora.service.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;


@Entity
@Table(name = "answer", schema = "quora")
@NamedQueries(
        {
                @NamedQuery(name = "answerByUuid", query = "select u from AnswerEntity u where u.uuid = :uuid")
        }
)
public class AnswerEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getUuid () {
        return uuid;
    }

    public void setUuid (String uuid) {
        this.uuid = uuid;
    }

    public String getAns () {
        return ans;
    }

    public void setAns (String ans) {
        this.ans = ans;
    }

    public ZonedDateTime getDate () {
        return date;
    }

    public void setDate (ZonedDateTime date) {
        this.date = date;
    }

    public UserEntity getUser () {
        return user;
    }

    public void setUser (UserEntity user) {
        this.user = user;
    }

    public QuestionEntity getQues () {
        return ques;
    }

    public void setQues (QuestionEntity ques) {
        this.ques = ques;
    }

    @Column(name = "UUID")
    @NotNull
    @Size(max = 64)
    private String uuid;

    @Column(name = "ans")
    @NotNull
    private String ans;

    @Column(name = "date")
    @NotNull
    private ZonedDateTime date;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private QuestionEntity ques;

    @Override
    public boolean equals(Object obj) {
        return new EqualsBuilder().append(this, obj).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this).hashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }


}
