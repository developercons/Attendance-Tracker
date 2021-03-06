package com.attendance_tracker.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "UserDetails")
@Table(name = "user_details")
public class APIUserDetails extends AbstractEntity implements UserDetails {

    // region PROPERTIES
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "non_expired")
    private Boolean accountNonExpired;

    @Column(name = "non_locked")
    private Boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    private Boolean credentialsNonExpired;

    @Column(name = "enabled")
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "user_user_details_fk"))
    private User user;

    @OneToOne
    @JoinColumn(name = "creator_id", nullable = false, foreignKey = @ForeignKey(name = "owner_user_details_fk"))
    private Owner creator;
    // endregion

    //region GETTERS / SETTERS
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }
    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }
    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Owner getCreator() {
        return creator;
    }
    public void setCreator(Owner creator) {
        this.creator = creator;
    }
    //endregion

    // region IMPLEMENTATIONS
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired == null ? false : this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked == null ? false : this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired == null ? false : this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled == null ? false : this.enabled;
    }
    // endregion

    //region EQUALS / HASHCODE / TOSTRING
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final APIUserDetails that = (APIUserDetails) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(username, that.username)
                .append(passwordHash, that.passwordHash)
                .append(accountNonExpired, that.accountNonExpired)
                .append(accountNonLocked, that.accountNonLocked)
                .append(credentialsNonExpired, that.credentialsNonExpired)
                .append(enabled, that.enabled)
                .append(roles, that.roles )
                .append(user, that.user)
                .append(creator, that.creator)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(username)
                .append(passwordHash)
                .append(accountNonExpired)
                .append(accountNonLocked)
                .append(credentialsNonExpired)
                .append(enabled)
                .append(roles)
                .append(user)
                .append(creator)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("username", username)
                .append("passwordHash", passwordHash)
                .append("accountNonExpired", accountNonExpired)
                .append("accountNonLocked", accountNonLocked)
                .append("credentialsNonExpired", credentialsNonExpired)
                .append("enabled", enabled)
                .append("roles ", roles)
                .append("user", user)
                .append("creator", creator)
                .toString();
    }
    //endregion
}
