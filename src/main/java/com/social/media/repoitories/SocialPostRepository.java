package com.social.media.repoitories;

import com.social.media.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialPostRepository extends JpaRepository<Post, Long> {
}
