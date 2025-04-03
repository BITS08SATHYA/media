package com.social.media.configs;

import com.social.media.models.Post;
import com.social.media.models.SocialGroup;
import com.social.media.models.SocialProfile;
import com.social.media.models.SocialUser;
import com.social.media.repoitories.SocialGroupRepository;
import com.social.media.repoitories.SocialPostRepository;
import com.social.media.repoitories.SocialProfileRepository;
import com.social.media.repoitories.SocialUserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class DataInitializer {

    private final SocialUserRepository userRepository;
    private final SocialGroupRepository groupRepository;
    private final SocialProfileRepository profileRepository;
    private final SocialPostRepository postRepository;

    @Bean
    public CommandLineRunner init() {
        return args -> {
//            Create some users
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

//            Save users to the database
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

//            Create some groups
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

//             Add users to groups
            group1.getSocialUsers().add(user1);
            group1.getSocialUsers().add(user2);

            group2.getSocialUsers().add(user2);
            group2.getSocialUsers().add(user3);

            //            save groups to the database
            groupRepository.save(group1);
            groupRepository.save(group2);

//            Associate users with groups
            user1.getSocialGroups().add(group1);
            user2.getSocialGroups().add(group1);
            user2.getSocialGroups().add(group2);
            user3.getSocialGroups().add(group2);

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);



//            Create some posts
            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();

//            Association posts with users
            post1.setSocialUser(user1);
            post2.setSocialUser(user2);
            post3.setSocialUser(user3);

            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);

            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            profile1.setUser(user1);
            profile2.setUser(user2);
            profile3.setUser(user3);

            profileRepository.save(profile1);
            profileRepository.save(profile2);
            profileRepository.save(profile3);



        };
    }


}
