package com.example.BikeServiceApplication.Security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.example.BikeServiceApplication.Domain.User;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private String ud_id;
    private String ud_username;
    private String ud_email;
    private Optional<String> ud_phoneNo;
    private Optional<String> ud_paymentMode;
    private Optional<String> ud_address;

    @JsonIgnore
    private String ud_password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(String id, String username, String email, String password,
                           Collection<? extends GrantedAuthority> authorities, Optional<String> phoneNo, Optional<String> paymentMode,
                           Optional<String> address) {
        this.ud_id = id;
        this.ud_username = username;
        this.ud_email = email;
        this.ud_password = password;
        this.authorities = authorities;
        this.ud_phoneNo = phoneNo;
        this.ud_paymentMode = paymentMode;
        this.ud_address = address;
    }

    public static UserDetailsImpl build(Optional<User> userOpt) {
        User user = userOpt.get();
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());

        Optional<String> phoneNoOpt = Optional.ofNullable(user.getPhone_no());
        Optional<String> paymentModeOpt = Optional.ofNullable(user.getPayment_mode()).map(Enum::name);
//     PaymentMode enum to a string using the name() method before returning it as an optional
//     Optional.ofNullable(user.getPayment_mode());
        Optional<String> addressOpt = Optional.ofNullable(user.getAddress());

        return new UserDetailsImpl(user.getUser_id(), user.getUser_name(), user.getEmail(), user.getPassword(), authorities, phoneNoOpt,
                paymentModeOpt, addressOpt);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getId() {
        return ud_id;
    }

    public String getEmail() {
        return ud_email;
    }

    public Optional<String> getPhoneNo() {
        return ud_phoneNo;
    }

    public Optional<String> getPaymentMode() {
        return ud_paymentMode;
    }

    public Optional<String> getAddress() {
        return ud_address;
    }

    @Override
    public String getPassword() {
        return ud_password;
    }

    @Override
    public String getUsername() {
        return ud_username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(ud_id, user.ud_id);
    }
}

