package db.models;

import javax.persistence.*;

@Entity
@Table(name = "\"right\"")
public class Right {

    @Id
    @SequenceGenerator( name = "RightSequence", sequenceName = "right_id_seq", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "RightSequence")
    private Long id;

    @Column(nullable = false)
    private Boolean write;

    @Column(nullable = false)
    private Boolean invite;

    @Column(nullable = false)
    private Boolean exclude;

    @Column(nullable = false)
    private Boolean remove;

    @Column(nullable = false)
    private Boolean rule;   //change right

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getChat() {
        return chat;
    }

    public void setChat(User chat) {
        this.chat = chat;
    }

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private User chat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getWrite() {
        return write;
    }

    public void setWrite(Boolean write) {
        this.write = write;
    }

    public Boolean getInvite() {
        return invite;
    }

    public void setInvite(Boolean invite) {
        this.invite = invite;
    }

    public Boolean getExclude() {
        return exclude;
    }

    public void setExclude(Boolean exclude) {
        this.exclude = exclude;
    }

    public Boolean getRemove() {
        return remove;
    }

    public void setRemove(Boolean remove) {
        this.remove = remove;
    }

    public Boolean getRule() {
        return rule;
    }

    public void setRule(Boolean rule) {
        this.rule = rule;
    }
}
