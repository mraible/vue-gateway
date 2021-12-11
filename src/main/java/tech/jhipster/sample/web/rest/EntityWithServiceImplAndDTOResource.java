package tech.jhipster.sample.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.repository.EntityWithServiceImplAndDTORepository;
import tech.jhipster.sample.service.EntityWithServiceImplAndDTOService;
import tech.jhipster.sample.service.dto.EntityWithServiceImplAndDTODTO;
import tech.jhipster.sample.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.reactive.ResponseUtil;

/**
 * REST controller for managing {@link tech.jhipster.sample.domain.EntityWithServiceImplAndDTO}.
 */
@RestController
@RequestMapping("/api")
public class EntityWithServiceImplAndDTOResource {

    private final Logger log = LoggerFactory.getLogger(EntityWithServiceImplAndDTOResource.class);

    private static final String ENTITY_NAME = "entityWithServiceImplAndDTO";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EntityWithServiceImplAndDTOService entityWithServiceImplAndDTOService;

    private final EntityWithServiceImplAndDTORepository entityWithServiceImplAndDTORepository;

    public EntityWithServiceImplAndDTOResource(
        EntityWithServiceImplAndDTOService entityWithServiceImplAndDTOService,
        EntityWithServiceImplAndDTORepository entityWithServiceImplAndDTORepository
    ) {
        this.entityWithServiceImplAndDTOService = entityWithServiceImplAndDTOService;
        this.entityWithServiceImplAndDTORepository = entityWithServiceImplAndDTORepository;
    }

    /**
     * {@code POST  /entity-with-service-impl-and-dtos} : Create a new entityWithServiceImplAndDTO.
     *
     * @param entityWithServiceImplAndDTODTO the entityWithServiceImplAndDTODTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new entityWithServiceImplAndDTODTO, or with status {@code 400 (Bad Request)} if the entityWithServiceImplAndDTO has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/entity-with-service-impl-and-dtos")
    public Mono<ResponseEntity<EntityWithServiceImplAndDTODTO>> createEntityWithServiceImplAndDTO(
        @RequestBody EntityWithServiceImplAndDTODTO entityWithServiceImplAndDTODTO
    ) throws URISyntaxException {
        log.debug("REST request to save EntityWithServiceImplAndDTO : {}", entityWithServiceImplAndDTODTO);
        if (entityWithServiceImplAndDTODTO.getId() != null) {
            throw new BadRequestAlertException("A new entityWithServiceImplAndDTO cannot already have an ID", ENTITY_NAME, "idexists");
        }
        return entityWithServiceImplAndDTOService
            .save(entityWithServiceImplAndDTODTO)
            .map(result -> {
                try {
                    return ResponseEntity
                        .created(new URI("/api/entity-with-service-impl-and-dtos/" + result.getId()))
                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /entity-with-service-impl-and-dtos/:id} : Updates an existing entityWithServiceImplAndDTO.
     *
     * @param id the id of the entityWithServiceImplAndDTODTO to save.
     * @param entityWithServiceImplAndDTODTO the entityWithServiceImplAndDTODTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated entityWithServiceImplAndDTODTO,
     * or with status {@code 400 (Bad Request)} if the entityWithServiceImplAndDTODTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the entityWithServiceImplAndDTODTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/entity-with-service-impl-and-dtos/{id}")
    public Mono<ResponseEntity<EntityWithServiceImplAndDTODTO>> updateEntityWithServiceImplAndDTO(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody EntityWithServiceImplAndDTODTO entityWithServiceImplAndDTODTO
    ) throws URISyntaxException {
        log.debug("REST request to update EntityWithServiceImplAndDTO : {}, {}", id, entityWithServiceImplAndDTODTO);
        if (entityWithServiceImplAndDTODTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, entityWithServiceImplAndDTODTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return entityWithServiceImplAndDTORepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return entityWithServiceImplAndDTOService
                    .save(entityWithServiceImplAndDTODTO)
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(result ->
                        ResponseEntity
                            .ok()
                            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                            .body(result)
                    );
            });
    }

    /**
     * {@code PATCH  /entity-with-service-impl-and-dtos/:id} : Partial updates given fields of an existing entityWithServiceImplAndDTO, field will ignore if it is null
     *
     * @param id the id of the entityWithServiceImplAndDTODTO to save.
     * @param entityWithServiceImplAndDTODTO the entityWithServiceImplAndDTODTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated entityWithServiceImplAndDTODTO,
     * or with status {@code 400 (Bad Request)} if the entityWithServiceImplAndDTODTO is not valid,
     * or with status {@code 404 (Not Found)} if the entityWithServiceImplAndDTODTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the entityWithServiceImplAndDTODTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/entity-with-service-impl-and-dtos/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public Mono<ResponseEntity<EntityWithServiceImplAndDTODTO>> partialUpdateEntityWithServiceImplAndDTO(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody EntityWithServiceImplAndDTODTO entityWithServiceImplAndDTODTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update EntityWithServiceImplAndDTO partially : {}, {}", id, entityWithServiceImplAndDTODTO);
        if (entityWithServiceImplAndDTODTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, entityWithServiceImplAndDTODTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return entityWithServiceImplAndDTORepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<EntityWithServiceImplAndDTODTO> result = entityWithServiceImplAndDTOService.partialUpdate(
                    entityWithServiceImplAndDTODTO
                );

                return result
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(res ->
                        ResponseEntity
                            .ok()
                            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, res.getId().toString()))
                            .body(res)
                    );
            });
    }

    /**
     * {@code GET  /entity-with-service-impl-and-dtos} : get all the entityWithServiceImplAndDTOS.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of entityWithServiceImplAndDTOS in body.
     */
    @GetMapping("/entity-with-service-impl-and-dtos")
    public Mono<List<EntityWithServiceImplAndDTODTO>> getAllEntityWithServiceImplAndDTOS() {
        log.debug("REST request to get all EntityWithServiceImplAndDTOS");
        return entityWithServiceImplAndDTOService.findAll().collectList();
    }

    /**
     * {@code GET  /entity-with-service-impl-and-dtos} : get all the entityWithServiceImplAndDTOS as a stream.
     * @return the {@link Flux} of entityWithServiceImplAndDTOS.
     */
    @GetMapping(value = "/entity-with-service-impl-and-dtos", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<EntityWithServiceImplAndDTODTO> getAllEntityWithServiceImplAndDTOSAsStream() {
        log.debug("REST request to get all EntityWithServiceImplAndDTOS as a stream");
        return entityWithServiceImplAndDTOService.findAll();
    }

    /**
     * {@code GET  /entity-with-service-impl-and-dtos/:id} : get the "id" entityWithServiceImplAndDTO.
     *
     * @param id the id of the entityWithServiceImplAndDTODTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the entityWithServiceImplAndDTODTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/entity-with-service-impl-and-dtos/{id}")
    public Mono<ResponseEntity<EntityWithServiceImplAndDTODTO>> getEntityWithServiceImplAndDTO(@PathVariable Long id) {
        log.debug("REST request to get EntityWithServiceImplAndDTO : {}", id);
        Mono<EntityWithServiceImplAndDTODTO> entityWithServiceImplAndDTODTO = entityWithServiceImplAndDTOService.findOne(id);
        return ResponseUtil.wrapOrNotFound(entityWithServiceImplAndDTODTO);
    }

    /**
     * {@code DELETE  /entity-with-service-impl-and-dtos/:id} : delete the "id" entityWithServiceImplAndDTO.
     *
     * @param id the id of the entityWithServiceImplAndDTODTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/entity-with-service-impl-and-dtos/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>> deleteEntityWithServiceImplAndDTO(@PathVariable Long id) {
        log.debug("REST request to delete EntityWithServiceImplAndDTO : {}", id);
        return entityWithServiceImplAndDTOService
            .delete(id)
            .map(result ->
                ResponseEntity
                    .noContent()
                    .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
                    .build()
            );
    }
}
