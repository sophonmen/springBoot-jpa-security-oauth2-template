package com.backend.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend.domain.Type;
import com.backend.dto.TypeDTO;
import com.backend.helper.ResponseList;
import com.backend.service.TypeService;
import com.backend.service.TypeServiceImpl;

/**
 * Created by sophon on 7/9/17.
 */
@Controller
@RequestMapping("api/type")
public class TypeController {

    @Autowired
    private TypeService service;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<TypeDTO> create(@RequestBody TypeDTO typeDTO) {
        Type f = TypeServiceImpl.convert(typeDTO);
        service.save(f);
        typeDTO.setId(f.getId());
        return new ResponseEntity<>(typeDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TypeDTO> getById(@PathVariable Long id) {
        Type type = service.findById(id);
        if (type == null) {
            throw new ObjectNotFoundException(Type.class, "Object not found");
        }
        TypeDTO typeDTO= TypeServiceImpl.convert(type);
        return new ResponseEntity<>(typeDTO, HttpStatus.OK);

    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<ResponseList<TypeDTO>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TypeDTO> delete(@PathVariable Long id) throws javassist.tools.rmi.ObjectNotFoundException {
        Type type = service.delete(id);
        TypeDTO typeDTO = TypeServiceImpl.convert(type);
        return new ResponseEntity<>(typeDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TypeDTO> update(@PathVariable Long id, @RequestBody TypeDTO typeDTO) {
        Type type = TypeServiceImpl.convert(typeDTO);
        type.setId(id);
        service.update(type);
        typeDTO.setId(id);
        return new ResponseEntity<>(typeDTO, HttpStatus.OK);
    }
}
