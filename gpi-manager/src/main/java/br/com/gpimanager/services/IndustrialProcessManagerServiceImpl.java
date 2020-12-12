package br.com.gpimanager.services;

import br.com.gpimanager.domains.process.IndustrialProcess;
import br.com.gpimanager.domains.process.IndustrialProcessDto;
import br.com.gpimanager.domains.process.IndustrialProcessDtoBuilder;
import br.com.gpimanager.domains.process.IndustrialProcessRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IndustrialProcessManagerServiceImpl implements IndustrialProcessManagerService {

    private final IndustrialProcessRepository repository;

    public IndustrialProcessManagerServiceImpl(IndustrialProcessRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<IndustrialProcessDto> listAllProcesses() {
        List<IndustrialProcess> all = repository.findAll();

        return all.stream()
                .map(IndustrialProcessDtoBuilder::build)
                .collect(Collectors.toList());
    }

    @Override
    public synchronized IndustrialProcessDto saveIndustrialProcess(IndustrialProcessDto industrialProcessDto) {
        IndustrialProcess saved = repository.save(IndustrialProcessDtoBuilder
                .buildDtoToIndustrialProcess(industrialProcessDto));

        return IndustrialProcessDtoBuilder.build(saved);
    }

    @Override
    @Transactional
    public synchronized List<IndustrialProcessDto> saveIndustrialProcess(List<IndustrialProcessDto> industrialProcessDtoList) {
        List<IndustrialProcess> industrialProcessesSaved = repository.saveAll(industrialProcessDtoList.stream()
                .map(IndustrialProcessDtoBuilder::buildDtoToIndustrialProcess)
                .collect(Collectors.toList()));

        return industrialProcessesSaved.stream()
                .map(IndustrialProcessDtoBuilder::build)
                .collect(Collectors.toList());
    }

}
