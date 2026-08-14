package org.example.contactapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestContactDTO {
    @NotBlank
    private String contactName;

    @NotBlank
    @Size(min = 10,max = 10)
    private String contactNumber;

    @Email
    private String email;
    private String imgUrl;
}
