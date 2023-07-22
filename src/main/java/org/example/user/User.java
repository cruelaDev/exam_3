package org.example.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.common.BaseEntity;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity<UUID> {
    private UUID id;
    private String firstName;
    private String LastName;
    private String username;
    private String password;
    private boolean active;
}
