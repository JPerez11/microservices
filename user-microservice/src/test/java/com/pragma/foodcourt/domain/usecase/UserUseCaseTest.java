package com.pragma.foodcourt.domain.usecase;

import com.pragma.foodcourt.domain.model.RoleModel;
import com.pragma.foodcourt.domain.model.UserModel;
import com.pragma.foodcourt.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class UserUseCaseTest {

    @Mock
    IUserPersistencePort userPersistencePort;

    @InjectMocks
    UserUseCase userUseCase;

    @Test
    void shouldSaveUser() {
        //Given
        RoleModel roleModel = new RoleModel(1L, "ADMIN", "PLACE MANAGER");
        UserModel userModel = new UserModel(1L,
                "Name",
                "LastName",
                12345,
                "12345",
                "test@gmail.com",
                "12345",
                roleModel);

        //When
        when(userPersistencePort.saveUser(userModel)).thenReturn(userModel);
        userUseCase.saveUser(userModel);

        //Then
        verify(userPersistencePort).saveUser(userModel);
    }

    @Test
    void shouldRegisterUser() {
        //Given
        RoleModel roleModel = new RoleModel();
        roleModel.setId(1L);
        roleModel.setName("ADMIN");
        roleModel.setDescription("PLACE MANAGER");

        UserModel userModel = new UserModel();
        userModel.setId(1L);
        userModel.setName("Admin");
        userModel.setLastName("Admin");
        userModel.setDocument(12345);
        userModel.setPhone("+57123456");
        userModel.setEmail("admin@gmail.com");
        userModel.setPassword("admin123");
        userModel.setIdRole(roleModel);

        //When
        when(userPersistencePort.registerUser(userModel)).thenReturn(userModel);
        userUseCase.registerUser(userModel);

        //Then
        verify(userPersistencePort).registerUser(userModel);
    }

    @Test
    void shouldGetAllUsers() {
        //Given
        RoleModel roleModel = new RoleModel();
        roleModel.setId(1L);
        roleModel.setName("ADMIN");
        roleModel.setDescription("PLACE MANAGER");

        UserModel userModel1 = new UserModel();
        userModel1.setId(1L);
        userModel1.setName("Admin");
        userModel1.setLastName("Admin");
        userModel1.setDocument(123456);
        userModel1.setPhone("+57123456");
        userModel1.setEmail("admin@gmail.com");
        userModel1.setPassword("admin123");
        userModel1.setIdRole(roleModel);

        UserModel userModel2 = new UserModel(2L,
                "Name",
                "LastName",
                12345,
                "12345",
                "test@gmail.com",
                "12345",
                roleModel);

        List<UserModel> userModelList = new ArrayList<>();
        userModelList.add(userModel1);
        userModelList.add(userModel2);

        //When
        when(userPersistencePort.getAllUsers()).thenReturn(userModelList);
        List<UserModel> result = userUseCase.getAllUsers();

        //Then
        assertEquals(userModelList, result);
        assertEquals(userModelList.get(0).getId(), result.get(0).getId());
        assertEquals(userModelList.get(0).getName(), result.get(0).getName());
        assertEquals(userModelList.get(0).getLastName(), result.get(0).getLastName());
        assertEquals(userModelList.get(0).getDocument(), result.get(0).getDocument());
        assertEquals(userModelList.get(0).getPhone(), result.get(0).getPhone());
        assertEquals(userModelList.get(0).getEmail(), result.get(0).getEmail());
        assertEquals(userModelList.get(0).getPassword(), result.get(0).getPassword());
        assertEquals(userModelList.get(0).getIdRole(), result.get(0).getIdRole());

        assertEquals(roleModel.getId(), result.get(1).getIdRole().getId());
        assertEquals(roleModel.getName(), result.get(1).getIdRole().getName());
        assertEquals(roleModel.getDescription(), result.get(1).getIdRole().getDescription());

        //Verify
        verify(userPersistencePort).getAllUsers();
    }

}