package edu.miu.badge.services.impl;

import edu.miu.badge.domains.User;
import edu.miu.badge.dto.RequestUserDTO;
import edu.miu.badge.dto.ResponseMemberDTO;

import edu.miu.badge.dto.ResponseUserDTO;
import edu.miu.badge.repositories.MemberRepository;
import edu.miu.badge.repositories.UserRepository;
import edu.miu.badge.services.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseMemberDTO login(RequestUserDTO user) {
//        Optional<User> user1 = userRepository.findByUsername(user.getUsername());
//        if(user1.isPresent()){
//            if(user.getPassword().equals(user1.get().getPassword())){
//                 Member member = memberRepository.findById(user1.get().getMemberId()).orElse(null);
//                 if (member == null) {
//                     throw new ResourceNotFoundException("Member with id " + user1.get().getMemberId() + " not found");
//                 }
//                    return modelMapper.map(member, ResponseMemberDTO.class);
//            }
//            throw new ResourceNotFoundException("Invalid password");
//        }
//        throw new ResourceNotFoundException("User not found");
        return null;
    }

    @Override
    public ResponseUserDTO getUserDetailsByUsername(String userName) {
        User userEntity = userRepository.findByUsername(userName);
        if(userEntity == null) throw new UsernameNotFoundException(userName);
        return modelMapper.map(userEntity, ResponseUserDTO.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username);
        if(userEntity == null) throw new UsernameNotFoundException("Username is not found");
        return new org.springframework.security.core.userdetails.User(userEntity.getUsername(), userEntity.getPassword(), true, true, true,true, new ArrayList<>());
    }
}
