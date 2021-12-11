package tech.jhipster.sample.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.MapsIdUserProfileWithDTO;
import tech.jhipster.sample.repository.MapsIdUserProfileWithDTORepository;
import tech.jhipster.sample.repository.UserRepository;
import tech.jhipster.sample.service.MapsIdUserProfileWithDTOService;
import tech.jhipster.sample.service.dto.MapsIdUserProfileWithDTODTO;
import tech.jhipster.sample.service.mapper.MapsIdUserProfileWithDTOMapper;

/**
 * Service Implementation for managing {@link MapsIdUserProfileWithDTO}.
 */
@Service
@Transactional
public class MapsIdUserProfileWithDTOServiceImpl implements MapsIdUserProfileWithDTOService {

    private final Logger log = LoggerFactory.getLogger(MapsIdUserProfileWithDTOServiceImpl.class);

    private final MapsIdUserProfileWithDTORepository mapsIdUserProfileWithDTORepository;

    private final MapsIdUserProfileWithDTOMapper mapsIdUserProfileWithDTOMapper;

    private final UserRepository userRepository;

    public MapsIdUserProfileWithDTOServiceImpl(
        MapsIdUserProfileWithDTORepository mapsIdUserProfileWithDTORepository,
        MapsIdUserProfileWithDTOMapper mapsIdUserProfileWithDTOMapper,
        UserRepository userRepository
    ) {
        this.mapsIdUserProfileWithDTORepository = mapsIdUserProfileWithDTORepository;
        this.mapsIdUserProfileWithDTOMapper = mapsIdUserProfileWithDTOMapper;
        this.userRepository = userRepository;
    }

    @Override
    public Mono<MapsIdUserProfileWithDTODTO> save(MapsIdUserProfileWithDTODTO mapsIdUserProfileWithDTODTO) {
        log.debug("Request to save MapsIdUserProfileWithDTO : {}", mapsIdUserProfileWithDTODTO);
        return mapsIdUserProfileWithDTORepository
            .save(mapsIdUserProfileWithDTOMapper.toEntity(mapsIdUserProfileWithDTODTO))
            .map(mapsIdUserProfileWithDTOMapper::toDto);
    }

    @Override
    public Mono<MapsIdUserProfileWithDTODTO> partialUpdate(MapsIdUserProfileWithDTODTO mapsIdUserProfileWithDTODTO) {
        log.debug("Request to partially update MapsIdUserProfileWithDTO : {}", mapsIdUserProfileWithDTODTO);

        return mapsIdUserProfileWithDTORepository
            .findById(mapsIdUserProfileWithDTODTO.getId())
            .map(existingMapsIdUserProfileWithDTO -> {
                mapsIdUserProfileWithDTOMapper.partialUpdate(existingMapsIdUserProfileWithDTO, mapsIdUserProfileWithDTODTO);

                return existingMapsIdUserProfileWithDTO;
            })
            .flatMap(mapsIdUserProfileWithDTORepository::save)
            .map(mapsIdUserProfileWithDTOMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<MapsIdUserProfileWithDTODTO> findAll() {
        log.debug("Request to get all MapsIdUserProfileWithDTOS");
        return mapsIdUserProfileWithDTORepository.findAll().map(mapsIdUserProfileWithDTOMapper::toDto);
    }

    public Mono<Long> countAll() {
        return mapsIdUserProfileWithDTORepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<MapsIdUserProfileWithDTODTO> findOne(Long id) {
        log.debug("Request to get MapsIdUserProfileWithDTO : {}", id);
        return mapsIdUserProfileWithDTORepository.findById(id).map(mapsIdUserProfileWithDTOMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete MapsIdUserProfileWithDTO : {}", id);
        return mapsIdUserProfileWithDTORepository.deleteById(id);
    }
}
