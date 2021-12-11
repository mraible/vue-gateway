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
import tech.jhipster.sample.repository.EntityWithServiceImplPaginationAndDTORepository;
import tech.jhipster.sample.service.EntityWithServiceImplPaginationAndDTOService;
import tech.jhipster.sample.service.dto.EntityWithServiceImplPaginationAndDTODTO;
import tech.jhipster.sample.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.reactive.ResponseUtil;

/**
 * REST controller for managing {@link tech.jhipster.sample.domain.EntityWithServiceImplPaginationAndDTO}.
 */
@RestController
@RequestMapping("/api")
public class EntityWithServiceImplPaginationAndDTOResource {

    private final Logger log = LoggerFactory.getLogger(EntityWithServiceImplPaginationAndDTOResource.class);

    private static final String ENTITY_NAME = "entityWithServiceImplPaginationAndDTO";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EntityWithServiceImplPaginationAndDTOService entityWithServiceImplPaginationAndDTOService;

    private final EntityWithServiceImplPaginationAndDTORepository entityWithServiceImplPaginationAndDTORepository;

    public EntityWithServiceImplPaginationAndDTOResource(
        EntityWithServiceImplPaginationAndDTOService entityWithServiceImplPaginationAndDTOService,
        EntityWithServiceImplPaginationAndDTORepository entityWithServiceImplPaginationAndDTORepository
    ) {
        this.entityWithServiceImplPaginationAndDTOService = entityWithServiceImplPaginationAndDTOService;
        this.entityWithServiceImplPaginationAndDTORepository = entityWithServiceImplPaginationAndDTORepository;
    }

    /**
     * {@code POST  /entity-with-service-impl-pagination-and-dtos} : Create a new entityWithServiceImplPaginationAndDTO.
     *
     * @param entityWithServiceImplPaginationAndDTODTO the entityWithServiceImplPaginationAndDTODTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new entityWithServiceImplPaginationAndDTODTO, or with status {@code 400 (Bad Request)} if the entityWithServiceImplPaginationAndDTO has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/entity-with-service-impl-pagination-and-dtos")
    public Mono<ResponseEntity<EntityWithServiceImplPaginationAndDTODTO>> createEntityWithServiceImplPaginationAndDTO(
        @RequestBody EntityWithServiceImplPaginationAndDTODTO entityWithServiceImplPaginationAndDTODTO
    ) throws URISyntaxException {
        log.debug("REST request to save EntityWithServiceImplPaginationAndDTO : {}", entityWithServiceImplPaginationAndDTODTO);
        if (entityWithServiceImplPaginationAndDTODTO.getId() != null) {
            throw new BadRequestAlertException(
                "A new entityWithServiceImplPaginationAndDTO cannot already have an ID",
                ENTITY_NAME,
                "idexists"
            );
        }
        return entityWithServiceImplPaginationAndDTOService
            .save(entityWithServiceImplPaginationAndDTODTO)
            .map(result -> {
                try {
                    return ResponseEntity
                        .created(new URI("/api/entity-with-service-impl-pagination-and-dtos/" + result.getId()))
                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /entity-with-service-impl-pagination-and-dtos/:id} : Updates an existing entityWithServiceImplPaginationAndDTO.
     *
     * @param id the id of the entityWithServiceImplPaginationAndDTODTO to save.
     * @param entityWithServiceImplPaginationAndDTODTO the entityWithServiceImplPaginationAndDTODTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated entityWithServiceImplPaginationAndDTODTO,
     * or with status {@code 400 (Bad Request)} if the entityWithServiceImplPaginationAndDTODTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the entityWithServiceImplPaginationAndDTODTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/entity-with-service-impl-pagination-and-dtos/{id}")
    public Mono<ResponseEntity<EntityWithServiceImplPaginationAndDTODTO>> updateEntityWithServiceImplPaginationAndDTO(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody EntityWithServiceImplPaginationAndDTODTO entityWithServiceImplPaginationAndDTODTO
    ) throws URISyntaxException {
        log.debug("REST request to update EntityWithServiceImplPaginationAndDTO : {}, {}", id, entityWithServiceImplPaginationAndDTODTO);
        if (entityWithServiceImplPaginationAndDTODTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, entityWithServiceImplPaginationAndDTODTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return entityWithServiceImplPaginationAndDTORepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return entityWithServiceImplPaginationAndDTOService
                    .save(entityWithServiceImplPaginationAndDTODTO)
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
     * {@code PATCH  /entity-with-service-impl-pagination-and-dtos/:id} : Partial updates given fields of an existing entityWithServiceImplPaginationAndDTO, field will ignore if it is null
     *
     * @param id the id of the entityWithServiceImplPaginationAndDTODTO to save.
     * @param entityWithServiceImplPaginationAndDTODTO the entityWithServiceImplPaginationAndDTODTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated entityWithServiceImplPaginationAndDTODTO,
     * or with status {@code 400 (Bad Request)} if the entityWithServiceImplPaginationAndDTODTO is not valid,
     * or with status {@code 404 (Not Found)} if the entityWithServiceImplPaginationAndDTODTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the entityWithServiceImplPaginationAndDTODTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(
        value = "/entity-with-service-impl-pagination-and-dtos/{id}",
        consumes = { "application/json", "application/merge-patch+json" }
    )
    public Mono<ResponseEntity<EntityWithServiceImplPaginationAndDTODTO>> partialUpdateEntityWithServiceImplPaginationAndDTO(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody EntityWithServiceImplPaginationAndDTODTO entityWithServiceImplPaginationAndDTODTO
    ) throws URISyntaxException {
        log.debug(
            "REST request to partial update EntityWithServiceImplPaginationAndDTO partially : {}, {}",
            id,
            entityWithServiceImplPaginationAndDTODTO
        );
        if (entityWithServiceImplPaginationAndDTODTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, entityWithServiceImplPaginationAndDTODTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return entityWithServiceImplPaginationAndDTORepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<EntityWithServiceImplPaginationAndDTODTO> result = entityWithServiceImplPaginationAndDTOService.partialUpdate(
                    entityWithServiceImplPaginationAndDTODTO
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
     * {@code GET  /entity-with-service-impl-pagination-and-dtos} : get all the entityWithServiceImplPaginationAndDTOS.
     *
     * @param pageable the pagination information.
     * @param request a {@link ServerHttpRequest} request.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of entityWithServiceImplPaginationAndDTOS in body.
     */
    @GetMapping("/entity-with-service-impl-pagination-and-dtos")
    public Mono<ResponseEntity<List<EntityWithServiceImplPaginationAndDTODTO>>> getAllEntityWithServiceImplPaginationAndDTOS(
        @org.springdoc.api.annotations.ParameterObject Pageable pageable,
        ServerHttpRequest request
    ) {
        log.debug("REST request to get a page of EntityWithServiceImplPaginationAndDTOS");
        return entityWithServiceImplPaginationAndDTOService
            .countAll()
            .zipWith(entityWithServiceImplPaginationAndDTOService.findAll(pageable).collectList())
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
     * {@code GET  /entity-with-service-impl-pagination-and-dtos/:id} : get the "id" entityWithServiceImplPaginationAndDTO.
     *
     * @param id the id of the entityWithServiceImplPaginationAndDTODTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the entityWithServiceImplPaginationAndDTODTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/entity-with-service-impl-pagination-and-dtos/{id}")
    public Mono<ResponseEntity<EntityWithServiceImplPaginationAndDTODTO>> getEntityWithServiceImplPaginationAndDTO(@PathVariable Long id) {
        log.debug("REST request to get EntityWithServiceImplPaginationAndDTO : {}", id);
        Mono<EntityWithServiceImplPaginationAndDTODTO> entityWithServiceImplPaginationAndDTODTO = entityWithServiceImplPaginationAndDTOService.findOne(
            id
        );
        return ResponseUtil.wrapOrNotFound(entityWithServiceImplPaginationAndDTODTO);
    }

    /**
     * {@code DELETE  /entity-with-service-impl-pagination-and-dtos/:id} : delete the "id" entityWithServiceImplPaginationAndDTO.
     *
     * @param id the id of the entityWithServiceImplPaginationAndDTODTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/entity-with-service-impl-pagination-and-dtos/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>> deleteEntityWithServiceImplPaginationAndDTO(@PathVariable Long id) {
        log.debug("REST request to delete EntityWithServiceImplPaginationAndDTO : {}", id);
        return entityWithServiceImplPaginationAndDTOService
            .delete(id)
            .map(result ->
                ResponseEntity
                    .noContent()
                    .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
                    .build()
            );
    }
}
