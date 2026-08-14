package org.example.contactapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.contactapp.dto.response.ResponseContactDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactId;

    @Column(nullable = false)
    private String contactName;

    @Column(nullable = false,unique = true)
    private String contactNumber;

    @Column(unique = true)
    private String email;

    private String imgUrl;

    public ResponseContactDTO toDto(Contact this){
        return ResponseContactDTO.builder().contactId(this.getContactId())
                .contactName(this.getContactName())
                .contactNumber(this.getContactNumber())
                .email(this.getEmail())
                .imgUrl(this.getImgUrl())
                .build();
    }
}
