package com.social.media.repoitories;

import com.social.media.models.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  SocialUserRepository extends JpaRepository<SocialUser, Long> {
}
