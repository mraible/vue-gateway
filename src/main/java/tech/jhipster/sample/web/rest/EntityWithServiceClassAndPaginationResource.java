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
import tech.jhipster.sample.domain.EntityWithServiceClassAndPagination;
import tech.jhipster.sample.repository.EntityWithServiceClassAndPaginationRepository;
import tech.jhipster.sample.service.EntityWithServiceClassAndPaginationService;
import tech.jhipster.sample.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.reactive.ResponseUtil;

/**
 * REST controller for managing {@link tech.jhipster.sample.domain.EntityWithServiceClassAndPagination}.
 */
@RestController
@RequestMapping("/api")
public class EntityWithServiceClassAndPaginationResource {

    private final Logger log = LoggerFactory.getLogger(EntityWithServiceClassAndPaginationResource.class);

    private static final String ENTITY_NAME = "entityWithServiceClassAndPagination";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EntityWithServiceClassAndPaginationService entityWithServiceClassAndPaginationService;

    private final EntityWithServiceClassAndPaginationRepository entityWithServiceClassAndPaginationRepository;

    public EntityWithServiceClassAndPaginationResource(
        EntityWithServiceClassAndPaginationService entityWithServiceClassAndPaginationService,
        EntityWithServiceClassAndPaginationRepository entityWithServiceClassAndPaginationRepository
    ) {
        this.entityWithServiceClassAndPaginationService = entityWithServiceClassAndPaginationService;
        this.entityWithServiceClassAndPaginationRepository = entityWithServiceClassAndPaginationRepository;
    }

    /**
     * {@code POST  /entity-with-service-class-and-paginations} : Create a new entityWithServiceClassAndPagination.
     *
     * @param entityWithServiceClassAndPagination the entityWithServiceClassAndPagination to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new entityWithServiceClassAndPagination, or with status {@code 400 (Bad Request)} if the entityWithServiceClassAndPagination has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/entity-with-service-class-and-paginations")
    public Mono<ResponseEntity<EntityWithServiceClassAndPagination>> createEntityWithServiceClassAndPagination(
        @RequestBody EntityWithServiceClassAndPagination entityWithServiceClassAndPagination
    ) throws URISyntaxException {
        log.debug("REST request to save EntityWithServiceClassAndPagination : {}", entityWithServiceClassAndPagination);
        if (entityWithServiceClassAndPagination.getId() != null) {
            throw new BadRequestAlertException(
                "A new entityWithServiceClassAndPagination cannot already have an ID",
                ENTITY_NAME,
                "idexists"
            );
        }
        return entityWithServiceClassAndPaginationService
            .save(entityWithServiceClassAndPagination)
            .map(result -> {
                try {
                    return ResponseEntity
                        .created(new URI("/api/entity-with-service-class-and-paginations/" + result.getId()))
                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /entity-with-service-class-and-paginations/:id} : Updates an existing entityWithServiceClassAndPagination.
     *
     * @param id the id of the entityWithServiceClassAndPagination to save.
     * @param entityWithServiceClassAndPagination the entityWithServiceClassAndPagination to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated entityWithServiceClassAndPagination,
     * or with status {@code 400 (Bad Request)} if the entityWithServiceClassAndPagination is not valid,
     * or with status {@code 500 (Internal Server Error)} if the entityWithServiceClassAndPagination couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/entity-with-service-class-and-paginations/{id}")
    public Mono<ResponseEntity<EntityWithServiceClassAndPagination>> updateEntityWithServiceClassAndPagination(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody EntityWithServiceClassAndPagination entityWithServiceClassAndPagination
    ) throws URISyntaxException {
        log.debug("REST request to update EntityWithServiceClassAndPagination : {}, {}", id, entityWithServiceClassAndPagination);
        if (entityWithServiceClassAndPagination.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, entityWithServiceClassAndPagination.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return entityWithServiceClassAndPaginationRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return entityWithServiceClassAndPaginationService
                    .save(entityWithServiceClassAndPagination)
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
     * {@code PATCH  /entity-with-service-class-and-paginations/:id} : Partial updates given fields of an existing entityWithServiceClassAndPagination, field will ignore if it is null
     *
     * @param id the id of the entityWithServiceClassAndPagination to save.
     * @param entityWithServiceClassAndPagination the entityWithServiceClassAndPagination to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated entityWithServiceClassAndPagination,
     * or with status {@code 400 (Bad Request)} if the entityWithServiceClassAndPagination is not valid,
     * or with status {@code 404 (Not Found)} if the entityWithServiceClassAndPagination is not found,
     * or with status {@code 500 (Internal Server Error)} if the entityWithServiceClassAndPagination couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(
        value = "/entity-with-service-class-and-paginations/{id}",
        consumes = { "application/json", "application/merge-patch+json" }
    )
    public Mono<ResponseEntity<EntityWithServiceClassAndPagination>> partialUpdateEntityWithServiceClassAndPagination(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody EntityWithServiceClassAndPagination entityWithServiceClassAndPagination
    ) throws URISyntaxException {
        log.debug(
            "REST request to partial update EntityWithServiceClassAndPagination partially : {}, {}",
            id,
            entityWithServiceClassAndPagination
        );
        if (entityWithServiceClassAndPagination.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, entityWithServiceClassAndPagination.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return entityWithServiceClassAndPaginationRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<EntityWithServiceClassAndPagination> result = entityWithServiceClassAndPaginationService.partialUpdate(
                    entityWithServiceClassAndPagination
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
     * {@code GET  /entity-with-service-class-and-paginations} : get all the entityWithServiceClassAndPaginations.
     *
     * @param pageable the pagination information.
     * @param request a {@link ServerHttpRequest} request.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of entityWithServiceClassAndPaginations in body.
     */
    @GetMapping("/entity-with-service-class-and-paginations")
    public Mono<ResponseEntity<List<EntityWithServiceClassAndPagination>>> getAllEntityWithServiceClassAndPaginations(
        @org.springdoc.api.annotations.ParameterObject Pageable pageable,
        ServerHttpRequest request
    ) {
        log.debug("REST request to get a page of EntityWithServiceClassAndPaginations");
        return entityWithServiceClassAndPaginationService
            .countAll()
            .zipWith(entityWithServiceClassAndPaginationService.findAll(pageable).collectList())
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
     * {@code GET  /entity-with-service-class-and-paginations/:id} : get the "id" entityWithServiceClassAndPagination.
     *
     * @param id the id of the entityWithServiceClassAndPagination to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the entityWithServiceClassAndPagination, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/entity-with-service-class-and-paginations/{id}")
    public Mono<ResponseEntity<EntityWithServiceClassAndPagination>> getEntityWithServiceClassAndPagination(@PathVariable Long id) {
        log.debug("REST request to get EntityWithServiceClassAndPagination : {}", id);
        Mono<EntityWithServiceClassAndPagination> entityWithServiceClassAndPagination = entityWithServiceClassAndPaginationService.findOne(
            id
        );
        return ResponseUtil.wrapOrNotFound(entityWithServiceClassAndPagination);
    }

    /**
     * {@code DELETE  /entity-with-service-class-and-paginations/:id} : delete the "id" entityWithServiceClassAndPagination.
     *
     * @param id the id of the entityWithServiceClassAndPagination to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/entity-with-service-class-and-paginations/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>> deleteEntityWithServiceClassAndPagination(@PathVariable Long id) {
        log.debug("REST request to delete EntityWithServiceClassAndPagination : {}", id);
        return entityWithServiceClassAndPaginationService
            .delete(id)
            .map(result ->
                ResponseEntity
                    .noContent()
                    .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
                    .build()
            );
    }
}
