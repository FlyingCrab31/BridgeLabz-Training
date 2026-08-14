package org.example.contactapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseContactDTO {
    private int contactId;
    private String contactName;
    private String contactNumber;
    private String email;
    private String imgUrl;
}
