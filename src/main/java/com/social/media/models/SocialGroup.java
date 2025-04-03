package com.social.media.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SocialGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "socialGroups")
    private Set<SocialUser> socialUsers = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
