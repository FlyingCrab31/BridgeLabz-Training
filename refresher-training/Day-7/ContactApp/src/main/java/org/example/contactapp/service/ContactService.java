package org.example.contactapp.service;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.contactapp.dto.request.RequestContactDTO;
import org.example.contactapp.dto.response.ResponseContactDTO;
import org.example.contactapp.entity.Contact;
import org.example.contactapp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@AllArgsConstructor
@Builder
public class ContactService {

    @Autowired
    private final ContactRepository contactRepository;

    public ResponseContactDTO getContactById(int id){
        return contactRepository.findById(id).orElseThrow().toDto();
    }

    public ResponseContactDTO addContact(Contact contact){
        return contactRepository.save(contact).toDto();
    }

    public ResponseContactDTO updateContactDetail(int id, Contact contact){
        return contactRepository.save(contact).toDto();
    }

    public void deleteContactById(int id){
        contactRepository.deleteById(id);
    }

    public List<ResponseContactDTO> getAllContacts(){
        List<Contact> contacts = contactRepository.findAll();
        List<ResponseContactDTO> contactDTOList = new ArrayList<>();
        for(Contact key: contacts){
            contactDTOList.add(key.toDto());
        }
        return contactDTOList;
    }

}
