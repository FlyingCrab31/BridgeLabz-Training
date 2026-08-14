package org.example.contactapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateRequestDTO {
    private String contactName;
    private String contactNumber;
    private String email;
    private String imgUrl;
}
