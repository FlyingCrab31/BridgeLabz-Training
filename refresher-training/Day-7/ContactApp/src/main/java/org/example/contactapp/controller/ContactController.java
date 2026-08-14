package org.example.contactapp.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.contactapp.dto.request.RequestContactDTO;
import org.example.contactapp.dto.request.UpdateRequestDTO;
import org.example.contactapp.dto.response.ResponseContactDTO;
import org.example.contactapp.entity.Contact;
import org.example.contactapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@AllArgsConstructor
public class ContactController {

    @Autowired
    private final ContactService contactService;

    @GetMapping("/contact/{id}")
    public ResponseContactDTO getContactById(@PathVariable(value = "id") int id){
        return contactService.getContactById(id);
    }

    @PostMapping("/contact")
    public ResponseContactDTO addContact(@RequestBody RequestContactDTO requestContactDTO){
        Contact contact = Contact.builder()
                .contactName(requestContactDTO.getContactName())
                .contactNumber(requestContactDTO.getContactNumber())
                .email(requestContactDTO.getEmail())
                .imgUrl(requestContactDTO.getImgUrl())
                .build();
        return contactService.addContact(contact);
    }

    @PatchMapping("/contact/{id}")
    public ResponseContactDTO updateContactDetail(@PathVariable(value = "id") int id,
                                                  @RequestBody UpdateRequestDTO updateRequestDTO){

        ResponseContactDTO contactDTO = getContactById(id);
        if(updateRequestDTO.getContactName() != null){
            contactDTO.setContactName(updateRequestDTO.getContactName());
        }
        if(updateRequestDTO.getContactNumber() !=null){
            contactDTO.setContactNumber(updateRequestDTO.getContactNumber());
        }
        if(updateRequestDTO.getEmail() !=null){
            contactDTO.setEmail(updateRequestDTO.getEmail());
        }
        if(updateRequestDTO.getImgUrl() !=null){
            contactDTO.setImgUrl(updateRequestDTO.getImgUrl());
        }
        Contact contact = Contact.builder()
                .contactId(contactDTO.getContactId())
                .contactName(contactDTO.getContactName())
                .contactNumber(contactDTO.getContactNumber())
                .email(contactDTO.getEmail())
                .imgUrl(contactDTO.getImgUrl())
                .build();

        return contactService.updateContactDetail(id, contact);

    }

    @DeleteMapping("/contact/{id}")
    public void deleteContactById(@PathVariable(value = "id") int id){
        contactService.deleteContactById(id);
    }

    @GetMapping("/contacts")
    public List<ResponseContactDTO> getAllContacts(){
        return contactService.getAllContacts();
    }
}
