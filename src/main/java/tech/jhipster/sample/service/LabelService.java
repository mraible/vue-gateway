package tech.jhipster.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.Label;
import tech.jhipster.sample.repository.LabelRepository;

/**
 * Service Implementation for managing {@link Label}.
 */
@Service
@Transactional
public class LabelService {

    private final Logger log = LoggerFactory.getLogger(LabelService.class);

    private final LabelRepository labelRepository;

    public LabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    /**
     * Save a label.
     *
     * @param label the entity to save.
     * @return the persisted entity.
     */
    public Mono<Label> save(Label label) {
        log.debug("Request to save Label : {}", label);
        return labelRepository.save(label);
    }

    /**
     * Partially update a label.
     *
     * @param label the entity to update partially.
     * @return the persisted entity.
     */
    public Mono<Label> partialUpdate(Label label) {
        log.debug("Request to partially update Label : {}", label);

        return labelRepository
            .findById(label.getId())
            .map(existingLabel -> {
                if (label.getLabelName() != null) {
                    existingLabel.setLabelName(label.getLabelName());
                }

                return existingLabel;
            })
            .flatMap(labelRepository::save);
    }

    /**
     * Get all the labels.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Flux<Label> findAll(Pageable pageable) {
        log.debug("Request to get all Labels");
        return labelRepository.findAllBy(pageable);
    }

    /**
     * Returns the number of labels available.
     * @return the number of entities in the database.
     *
     */
    public Mono<Long> countAll() {
        return labelRepository.count();
    }

    /**
     * Get one label by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Mono<Label> findOne(Long id) {
        log.debug("Request to get Label : {}", id);
        return labelRepository.findById(id);
    }

    /**
     * Delete the label by id.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete Label : {}", id);
        return labelRepository.deleteById(id);
    }
}
