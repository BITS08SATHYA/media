package com.social.media.services;

import com.social.media.models.SocialUser;
import com.social.media.repoitories.SocialUserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class SocialService {
    
    private SocialUserRepository socialUserRepository;


    public List<SocialUser> getAllUsers() {
        return socialUserRepository.findAll();
    }

    public SocialUser saveUser(SocialUser socialUser) {
        return socialUserRepository.save(socialUser);
    }
}
