package tech.jhipster.sample.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.repository.EntityWithServiceClassPaginationAndDTORepository;
import tech.jhipster.sample.service.EntityWithServiceClassPaginationAndDTOService;
import tech.jhipster.sample.service.dto.EntityWithServiceClassPaginationAndDTODTO;
import tech.jhipster.sample.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.reactive.ResponseUtil;

/**
 * REST controller for managing {@link tech.jhipster.sample.domain.EntityWithServiceClassPaginationAndDTO}.
 */
@RestController
@RequestMapping("/api")
public class EntityWithServiceClassPaginationAndDTOResource {

    private final Logger log = LoggerFactory.getLogger(EntityWithServiceClassPaginationAndDTOResource.class);

    private static final String ENTITY_NAME = "entityWithServiceClassPaginationAndDTO";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EntityWithServiceClassPaginationAndDTOService entityWithServiceClassPaginationAndDTOService;

    private final EntityWithServiceClassPaginationAndDTORepository entityWithServiceClassPaginationAndDTORepository;

    public EntityWithServiceClassPaginationAndDTOResource(
        EntityWithServiceClassPaginationAndDTOService entityWithServiceClassPaginationAndDTOService,
        EntityWithServiceClassPaginationAndDTORepository entityWithServiceClassPaginationAndDTORepository
    ) {
        this.entityWithServiceClassPaginationAndDTOService = entityWithServiceClassPaginationAndDTOService;
        this.entityWithServiceClassPaginationAndDTORepository = entityWithServiceClassPaginationAndDTORepository;
    }

    /**
     * {@code POST  /entity-with-service-class-pagination-and-dtos} : Create a new entityWithServiceClassPaginationAndDTO.
     *
     * @param entityWithServiceClassPaginationAndDTODTO the entityWithServiceClassPaginationAndDTODTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new entityWithServiceClassPaginationAndDTODTO, or with status {@code 400 (Bad Request)} if the entityWithServiceClassPaginationAndDTO has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/entity-with-service-class-pagination-and-dtos")
    public Mono<ResponseEntity<EntityWithServiceClassPaginationAndDTODTO>> createEntityWithServiceClassPaginationAndDTO(
        @RequestBody EntityWithServiceClassPaginationAndDTODTO entityWithServiceClassPaginationAndDTODTO
    ) throws URISyntaxException {
        log.debug("REST request to save EntityWithServiceClassPaginationAndDTO : {}", entityWithServiceClassPaginationAndDTODTO);
        if (entityWithServiceClassPaginationAndDTODTO.getId() != null) {
            throw new BadRequestAlertException(
                "A new entityWithServiceClassPaginationAndDTO cannot already have an ID",
                ENTITY_NAME,
                "idexists"
            );
        }
        return entityWithServiceClassPaginationAndDTOService
            .save(entityWithServiceClassPaginationAndDTODTO)
            .map(result -> {
                try {
                    return ResponseEntity
                        .created(new URI("/api/entity-with-service-class-pagination-and-dtos/" + result.getId()))
                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /entity-with-service-class-pagination-and-dtos/:id} : Updates an existing entityWithServiceClassPaginationAndDTO.
     *
     * @param id the id of the entityWithServiceClassPaginationAndDTODTO to save.
     * @param entityWithServiceClassPaginationAndDTODTO the entityWithServiceClassPaginationAndDTODTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated entityWithServiceClassPaginationAndDTODTO,
     * or with status {@code 400 (Bad Request)} if the entityWithServiceClassPaginationAndDTODTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the entityWithServiceClassPaginationAndDTODTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/entity-with-service-class-pagination-and-dtos/{id}")
    public Mono<ResponseEntity<EntityWithServiceClassPaginationAndDTODTO>> updateEntityWithServiceClassPaginationAndDTO(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody EntityWithServiceClassPaginationAndDTODTO entityWithServiceClassPaginationAndDTODTO
    ) throws URISyntaxException {
        log.debug("REST request to update EntityWithServiceClassPaginationAndDTO : {}, {}", id, entityWithServiceClassPaginationAndDTODTO);
        if (entityWithServiceClassPaginationAndDTODTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, entityWithServiceClassPaginationAndDTODTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return entityWithServiceClassPaginationAndDTORepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return entityWithServiceClassPaginationAndDTOService
                    .save(entityWithServiceClassPaginationAndDTODTO)
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
     * {@code PATCH  /entity-with-service-class-pagination-and-dtos/:id} : Partial updates given fields of an existing entityWithServiceClassPaginationAndDTO, field will ignore if it is null
     *
     * @param id the id of the entityWithServiceClassPaginationAndDTODTO to save.
     * @param entityWithServiceClassPaginationAndDTODTO the entityWithServiceClassPaginationAndDTODTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated entityWithServiceClassPaginationAndDTODTO,
     * or with status {@code 400 (Bad Request)} if the entityWithServiceClassPaginationAndDTODTO is not valid,
     * or with status {@code 404 (Not Found)} if the entityWithServiceClassPaginationAndDTODTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the entityWithServiceClassPaginationAndDTODTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(
        value = "/entity-with-service-class-pagination-and-dtos/{id}",
        consumes = { "application/json", "application/merge-patch+json" }
    )
    public Mono<ResponseEntity<EntityWithServiceClassPaginationAndDTODTO>> partialUpdateEntityWithServiceClassPaginationAndDTO(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody EntityWithServiceClassPaginationAndDTODTO entityWithServiceClassPaginationAndDTODTO
    ) throws URISyntaxException {
        log.debug(
            "REST request to partial update EntityWithServiceClassPaginationAndDTO partially : {}, {}",
            id,
            entityWithServiceClassPaginationAndDTODTO
        );
        if (entityWithServiceClassPaginationAndDTODTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, entityWithServiceClassPaginationAndDTODTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return entityWithServiceClassPaginationAndDTORepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<EntityWithServiceClassPaginationAndDTODTO> result = entityWithServiceClassPaginationAndDTOService.partialUpdate(
                    entityWithServiceClassPaginationAndDTODTO
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
     * {@code GET  /entity-with-service-class-pagination-and-dtos} : get all the entityWithServiceClassPaginationAndDTOS.
     *
     * @param pageable the pagination information.
     * @param request a {@link ServerHttpRequest} request.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of entityWithServiceClassPaginationAndDTOS in body.
     */
    @GetMapping("/entity-with-service-class-pagination-and-dtos")
    public Mono<ResponseEntity<List<EntityWithServiceClassPaginationAndDTODTO>>> getAllEntityWithServiceClassPaginationAndDTOS(
        @org.springdoc.api.annotations.ParameterObject Pageable pageable,
        ServerHttpRequest request
    ) {
        log.debug("REST request to get a page of EntityWithServiceClassPaginationAndDTOS");
        return entityWithServiceClassPaginationAndDTOService
            .countAll()
            .zipWith(entityWithServiceClassPaginationAndDTOService.findAll(pageable).collectList())
            .map(countWithEntities -> {
                return ResponseEntity
                    .ok()
                    .headers(
                        PaginationUtil.generatePaginationHttpHeaders(
                            UriComponentsBuilder.fromHttpRequest(request),
                            new PageImpl<>(countWithEntities.getT2(), pageable, countWithEntities.getT1())
                        )
                    )
                    .body(countWithEntities.getT2());
            });
    }

    /**
     * {@code GET  /entity-with-service-class-pagination-and-dtos/:id} : get the "id" entityWithServiceClassPaginationAndDTO.
     *
     * @param id the id of the entityWithServiceClassPaginationAndDTODTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the entityWithServiceClassPaginationAndDTODTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/entity-with-service-class-pagination-and-dtos/{id}")
    public Mono<ResponseEntity<EntityWithServiceClassPaginationAndDTODTO>> getEntityWithServiceClassPaginationAndDTO(
        @PathVariable Long id
    ) {
        log.debug("REST request to get EntityWithServiceClassPaginationAndDTO : {}", id);
        Mono<EntityWithServiceClassPaginationAndDTODTO> entityWithServiceClassPaginationAndDTODTO = entityWithServiceClassPaginationAndDTOService.findOne(
            id
        );
        return ResponseUtil.wrapOrNotFound(entityWithServiceClassPaginationAndDTODTO);
    }

    /**
     * {@code DELETE  /entity-with-service-class-pagination-and-dtos/:id} : delete the "id" entityWithServiceClassPaginationAndDTO.
     *
     * @param id the id of the entityWithServiceClassPaginationAndDTODTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/entity-with-service-class-pagination-and-dtos/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>> deleteEntityWithServiceClassPaginationAndDTO(@PathVariable Long id) {
        log.debug("REST request to delete EntityWithServiceClassPaginationAndDTO : {}", id);
        return entityWithServiceClassPaginationAndDTOService
            .delete(id)
            .map(result ->
                ResponseEntity
                    .noContent()
                    .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
                    .build()
            );
    }
}
