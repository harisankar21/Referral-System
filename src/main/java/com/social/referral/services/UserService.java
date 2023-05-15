package com.social.referral.services;

import com.social.referral.dto.UserDTO;
import com.social.referral.entities.Company;
import com.social.referral.entities.User;
import com.social.referral.repository.CompanyRepository;
import com.social.referral.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CompanyService companyService;


    public List<UserDTO> getUsers(){
        List<UserDTO> usersDto=new ArrayList<>();
        List<User> users= userRepository.getUsersByisActive(1);
        for (User user:users) {
            usersDto.add(getUserDto(user));
        }
        return usersDto;
    }

    @Transactional
    public String addUser(UserDTO userDTO){
        String name= userDTO.getCompany();
        User user= getUserEntity(userDTO);
        user.setIsActive(1);
        user.setCreatedTime(new Date());
        userRepository.save(user);
        return "success";
    }


    @Transactional
    public String updateUser(UserDTO userDTO) throws Exception {
        String name= userDTO.getCompany();
        User repoUser=userRepository.findById(userDTO.getId()).orElse(new User());
        if(repoUser.getId() == null)
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"User Not Found");
        User user= getUserEntity(userDTO);
        if(user.getIsActive()==0)
        {
            user.setDeactivatedTime(new Date());
        }
        userRepository.save(user);
        return "success";

    }

    public UserDTO getUser(Integer id) {
        User repoUser=userRepository.findById(id).orElse(new User());

        UserDTO user = new UserDTO().toBuilder().id(repoUser.getId()).email(repoUser.getEmail()).tag(repoUser.getTag()).mobileNo(repoUser.getMobileNo()).company(repoUser.getCompany().getName()).isActive(repoUser.getIsActive()).createdTime(repoUser.getCreatedTime()).name(repoUser.getName()).deactivatedTime(repoUser.getDeactivatedTime()).build();
        return user;
    }

    private UserDTO getUserDto(User repoUser) {

        UserDTO user = new UserDTO().toBuilder().id(repoUser.getId()).email(repoUser.getEmail()).tag(repoUser.getTag()).mobileNo(repoUser.getMobileNo()).company(repoUser.getCompany().getName()).isActive(repoUser.getIsActive()).createdTime(repoUser.getCreatedTime()).name(repoUser.getName()).deactivatedTime(repoUser.getDeactivatedTime()).build();
        return user;
    }

    private User getUserEntity(UserDTO userDTO) {

        if(companyRepository.findByName(userDTO.getCompany())==null)
            companyService.addCompany(userDTO.getCompany());
        Company company=companyRepository.findByName(userDTO.getCompany());
        User user= new User().toBuilder().id(userDTO.getId()).email(userDTO.getEmail()).tag(userDTO.getTag()).mobileNo(userDTO.getMobileNo()).company(company).isActive(userDTO.getIsActive()).createdTime(userDTO.getCreatedTime()).name(userDTO.getName()).deactivatedTime(userDTO.getDeactivatedTime()).build();
        return user;
    }
}
