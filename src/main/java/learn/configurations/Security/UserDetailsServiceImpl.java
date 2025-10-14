package learn.configurations.Security;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.cache.CacheProperties.Redis;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import learn.WebConcepts.Spring.redisCache.CacheEventPublisher;
import learn.WebConcepts.Spring.redisCache.CacheUpdateListener;
import learn.testConstants.RedisContants;
import learn.testRepo.UserRepo;
import learn.testService.UserService;
import learn.testVOs.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;
    private CacheEventPublisher cacheEventPublisher;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO userVO = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return User.builder()
                .username(userVO.getUsername())
                .password(userVO.getPassword())
                .roles("USER")
                .build();
    }

    @Override
    public UserVO saveUser(UserVO userVO) {
        Optional<UserVO> optUserVO = userRepo.findByUsername(userVO.getUsername());
        UserVO vo = userVO;
        if (optUserVO.isPresent()) {
            vo = optUserVO.get();
        }
        vo.setPassword(passwordEncoder.encode(userVO.getPassword()));
        vo = userRepo.save(vo);
        cacheEventPublisher.publishEvent(RedisContants.FETCH_USERS, RedisContants.USER, true);
        return vo;
    }

    @Override
    @Cacheable(cacheNames = RedisContants.SINGLE_USER, key = "#username")
    public UserVO getUser(String username) {
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + " not found!"));
    }

    @Override
    @CacheUpdateListener(cacheName = RedisContants.FETCH_USERS, key = RedisContants.USER)
    @Cacheable(cacheNames = RedisContants.FETCH_USERS, key = RedisContants.USER)
    public List<UserVO> getAllUsers() {
    	log.info("getting users from DB");
        return userRepo.findAll();
    }

}
