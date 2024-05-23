package com.cotech.helpdesk.service;

import com.cotech.helpdesk.jpa.status.StatusEntity;
import com.cotech.helpdesk.jpa.status.StatusRepository;
import com.cotech.helpdesk.model.Status;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusService {

    private final StatusRepository statusRepository;
    private final ModelMapper mapper;

    public List<Status> getAvailableStatuses(){
        List<StatusEntity> entities = this.statusRepository.findAll();
        List<Status> statusList = new ArrayList<>();
        for(StatusEntity entity : entities){
            statusList.add(this.mapper.map(entity, Status.class));
        }
        return statusList;
    }
}
