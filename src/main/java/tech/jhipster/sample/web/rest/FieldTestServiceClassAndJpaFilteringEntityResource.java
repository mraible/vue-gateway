package tech.jhipster.sample.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
import tech.jhipster.sample.domain.FieldTestServiceClassAndJpaFilteringEntity;
import tech.jhipster.sample.repository.FieldTestServiceClassAndJpaFilteringEntityRepository;
import tech.jhipster.sample.service.FieldTestServiceClassAndJpaFilteringEntityService;
import tech.jhipster.sample.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.reactive.ResponseUtil;

/**
 * REST controller for managing {@link tech.jhipster.sample.domain.FieldTestServiceClassAndJpaFilteringEntity}.
 */
@RestController
@RequestMapping("/api")
public class FieldTestServiceClassAndJpaFilteringEntityResource {

    private final Logger log = LoggerFactory.getLogger(FieldTestServiceClassAndJpaFilteringEntityResource.class);

    private static final String ENTITY_NAME = "fieldTestServiceClassAndJpaFilteringEntity";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FieldTestServiceClassAndJpaFilteringEntityService fieldTestServiceClassAndJpaFilteringEntityService;

    private final FieldTestServiceClassAndJpaFilteringEntityRepository fieldTestServiceClassAndJpaFilteringEntityRepository;

    public FieldTestServiceClassAndJpaFilteringEntityResource(
        FieldTestServiceClassAndJpaFilteringEntityService fieldTestServiceClassAndJpaFilteringEntityService,
        FieldTestServiceClassAndJpaFilteringEntityRepository fieldTestServiceClassAndJpaFilteringEntityRepository
    ) {
        this.fieldTestServiceClassAndJpaFilteringEntityService = fieldTestServiceClassAndJpaFilteringEntityService;
        this.fieldTestServiceClassAndJpaFilteringEntityRepository = fieldTestServiceClassAndJpaFilteringEntityRepository;
    }

    /**
     * {@code POST  /field-test-service-class-and-jpa-filtering-entities} : Create a new fieldTestServiceClassAndJpaFilteringEntity.
     *
     * @param fieldTestServiceClassAndJpaFilteringEntity the fieldTestServiceClassAndJpaFilteringEntity to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new fieldTestServiceClassAndJpaFilteringEntity, or with status {@code 400 (Bad Request)} if the fieldTestServiceClassAndJpaFilteringEntity has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/field-test-service-class-and-jpa-filtering-entities")
    public Mono<ResponseEntity<FieldTestServiceClassAndJpaFilteringEntity>> createFieldTestServiceClassAndJpaFilteringEntity(
        @Valid @RequestBody FieldTestServiceClassAndJpaFilteringEntity fieldTestServiceClassAndJpaFilteringEntity
    ) throws URISyntaxException {
        log.debug("REST request to save FieldTestServiceClassAndJpaFilteringEntity : {}", fieldTestServiceClassAndJpaFilteringEntity);
        if (fieldTestServiceClassAndJpaFilteringEntity.getId() != null) {
            throw new BadRequestAlertException(
                "A new fieldTestServiceClassAndJpaFilteringEntity cannot already have an ID",
                ENTITY_NAME,
                "idexists"
            );
        }
        return fieldTestServiceClassAndJpaFilteringEntityService
            .save(fieldTestServiceClassAndJpaFilteringEntity)
            .map(result -> {
                try {
                    return ResponseEntity
                        .created(new URI("/api/field-test-service-class-and-jpa-filtering-entities/" + result.getId()))
                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /field-test-service-class-and-jpa-filtering-entities/:id} : Updates an existing fieldTestServiceClassAndJpaFilteringEntity.
     *
     * @param id the id of the fieldTestServiceClassAndJpaFilteringEntity to save.
     * @param fieldTestServiceClassAndJpaFilteringEntity the fieldTestServiceClassAndJpaFilteringEntity to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated fieldTestServiceClassAndJpaFilteringEntity,
     * or with status {@code 400 (Bad Request)} if the fieldTestServiceClassAndJpaFilteringEntity is not valid,
     * or with status {@code 500 (Internal Server Error)} if the fieldTestServiceClassAndJpaFilteringEntity couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/field-test-service-class-and-jpa-filtering-entities/{id}")
    public Mono<ResponseEntity<FieldTestServiceClassAndJpaFilteringEntity>> updateFieldTestServiceClassAndJpaFilteringEntity(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody FieldTestServiceClassAndJpaFilteringEntity fieldTestServiceClassAndJpaFilteringEntity
    ) throws URISyntaxException {
        log.debug(
            "REST request to update FieldTestServiceClassAndJpaFilteringEntity : {}, {}",
            id,
            fieldTestServiceClassAndJpaFilteringEntity
        );
        if (fieldTestServiceClassAndJpaFilteringEntity.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, fieldTestServiceClassAndJpaFilteringEntity.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return fieldTestServiceClassAndJpaFilteringEntityRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return fieldTestServiceClassAndJpaFilteringEntityService
                    .save(fieldTestServiceClassAndJpaFilteringEntity)
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
     * {@code PATCH  /field-test-service-class-and-jpa-filtering-entities/:id} : Partial updates given fields of an existing fieldTestServiceClassAndJpaFilteringEntity, field will ignore if it is null
     *
     * @param id the id of the fieldTestServiceClassAndJpaFilteringEntity to save.
     * @param fieldTestServiceClassAndJpaFilteringEntity the fieldTestServiceClassAndJpaFilteringEntity to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated fieldTestServiceClassAndJpaFilteringEntity,
     * or with status {@code 400 (Bad Request)} if the fieldTestServiceClassAndJpaFilteringEntity is not valid,
     * or with status {@code 404 (Not Found)} if the fieldTestServiceClassAndJpaFilteringEntity is not found,
     * or with status {@code 500 (Internal Server Error)} if the fieldTestServiceClassAndJpaFilteringEntity couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(
        value = "/field-test-service-class-and-jpa-filtering-entities/{id}",
        consumes = { "application/json", "application/merge-patch+json" }
    )
    public Mono<ResponseEntity<FieldTestServiceClassAndJpaFilteringEntity>> partialUpdateFieldTestServiceClassAndJpaFilteringEntity(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody FieldTestServiceClassAndJpaFilteringEntity fieldTestServiceClassAndJpaFilteringEntity
    ) throws URISyntaxException {
        log.debug(
            "REST request to partial update FieldTestServiceClassAndJpaFilteringEntity partially : {}, {}",
            id,
            fieldTestServiceClassAndJpaFilteringEntity
        );
        if (fieldTestServiceClassAndJpaFilteringEntity.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, fieldTestServiceClassAndJpaFilteringEntity.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return fieldTestServiceClassAndJpaFilteringEntityRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<FieldTestServiceClassAndJpaFilteringEntity> result = fieldTestServiceClassAndJpaFilteringEntityService.partialUpdate(
                    fieldTestServiceClassAndJpaFilteringEntity
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
     * {@code GET  /field-test-service-class-and-jpa-filtering-entities} : get all the fieldTestServiceClassAndJpaFilteringEntities.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of fieldTestServiceClassAndJpaFilteringEntities in body.
     */
    @GetMapping("/field-test-service-class-and-jpa-filtering-entities")
    public Mono<List<FieldTestServiceClassAndJpaFilteringEntity>> getAllFieldTestServiceClassAndJpaFilteringEntities() {
        log.debug("REST request to get all FieldTestServiceClassAndJpaFilteringEntities");
        return fieldTestServiceClassAndJpaFilteringEntityService.findAll().collectList();
    }

    /**
     * {@code GET  /field-test-service-class-and-jpa-filtering-entities} : get all the fieldTestServiceClassAndJpaFilteringEntities as a stream.
     * @return the {@link Flux} of fieldTestServiceClassAndJpaFilteringEntities.
     */
    @GetMapping(value = "/field-test-service-class-and-jpa-filtering-entities", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<FieldTestServiceClassAndJpaFilteringEntity> getAllFieldTestServiceClassAndJpaFilteringEntitiesAsStream() {
        log.debug("REST request to get all FieldTestServiceClassAndJpaFilteringEntities as a stream");
        return fieldTestServiceClassAndJpaFilteringEntityService.findAll();
    }

    /**
     * {@code GET  /field-test-service-class-and-jpa-filtering-entities/:id} : get the "id" fieldTestServiceClassAndJpaFilteringEntity.
     *
     * @param id the id of the fieldTestServiceClassAndJpaFilteringEntity to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the fieldTestServiceClassAndJpaFilteringEntity, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/field-test-service-class-and-jpa-filtering-entities/{id}")
    public Mono<ResponseEntity<FieldTestServiceClassAndJpaFilteringEntity>> getFieldTestServiceClassAndJpaFilteringEntity(
        @PathVariable Long id
    ) {
        log.debug("REST request to get FieldTestServiceClassAndJpaFilteringEntity : {}", id);
        Mono<FieldTestServiceClassAndJpaFilteringEntity> fieldTestServiceClassAndJpaFilteringEntity = fieldTestServiceClassAndJpaFilteringEntityService.findOne(
            id
        );
        return ResponseUtil.wrapOrNotFound(fieldTestServiceClassAndJpaFilteringEntity);
    }

    /**
     * {@code DELETE  /field-test-service-class-and-jpa-filtering-entities/:id} : delete the "id" fieldTestServiceClassAndJpaFilteringEntity.
     *
     * @param id the id of the fieldTestServiceClassAndJpaFilteringEntity to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/field-test-service-class-and-jpa-filtering-entities/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>> deleteFieldTestServiceClassAndJpaFilteringEntity(@PathVariable Long id) {
        log.debug("REST request to delete FieldTestServiceClassAndJpaFilteringEntity : {}", id);
        return fieldTestServiceClassAndJpaFilteringEntityService
            .delete(id)
            .map(result ->
                ResponseEntity
                    .noContent()
                    .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
                    .build()
            );
    }
}
