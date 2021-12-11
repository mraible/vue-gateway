package tech.jhipster.sample.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.Operation;
import tech.jhipster.sample.repository.OperationRepository;
import tech.jhipster.sample.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.reactive.ResponseUtil;

/**
 * REST controller for managing {@link tech.jhipster.sample.domain.Operation}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class OperationResource {

    private final Logger log = LoggerFactory.getLogger(OperationResource.class);

    private static final String ENTITY_NAME = "testRootOperation";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final OperationRepository operationRepository;

    public OperationResource(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    /**
     * {@code POST  /operations} : Create a new operation.
     *
     * @param operation the operation to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new operation, or with status {@code 400 (Bad Request)} if the operation has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/operations")
    public Mono<ResponseEntity<Operation>> createOperation(@Valid @RequestBody Operation operation) throws URISyntaxException {
        log.debug("REST request to save Operation : {}", operation);
        if (operation.getId() != null) {
            throw new BadRequestAlertException("A new operation cannot already have an ID", ENTITY_NAME, "idexists");
        }
        return operationRepository
            .save(operation)
            .map(result -> {
                try {
                    return ResponseEntity
                        .created(new URI("/api/operations/" + result.getId()))
                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /operations/:id} : Updates an existing operation.
     *
     * @param id the id of the operation to save.
     * @param operation the operation to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated operation,
     * or with status {@code 400 (Bad Request)} if the operation is not valid,
     * or with status {@code 500 (Internal Server Error)} if the operation couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/operations/{id}")
    public Mono<ResponseEntity<Operation>> updateOperation(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody Operation operation
    ) throws URISyntaxException {
        log.debug("REST request to update Operation : {}, {}", id, operation);
        if (operation.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, operation.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return operationRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return operationRepository
                    .save(operation)
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
     * {@code PATCH  /operations/:id} : Partial updates given fields of an existing operation, field will ignore if it is null
     *
     * @param id the id of the operation to save.
     * @param operation the operation to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated operation,
     * or with status {@code 400 (Bad Request)} if the operation is not valid,
     * or with status {@code 404 (Not Found)} if the operation is not found,
     * or with status {@code 500 (Internal Server Error)} if the operation couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/operations/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public Mono<ResponseEntity<Operation>> partialUpdateOperation(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody Operation operation
    ) throws URISyntaxException {
        log.debug("REST request to partial update Operation partially : {}, {}", id, operation);
        if (operation.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, operation.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return operationRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<Operation> result = operationRepository
                    .findById(operation.getId())
                    .map(existingOperation -> {
                        if (operation.getDate() != null) {
                            existingOperation.setDate(operation.getDate());
                        }
                        if (operation.getDescription() != null) {
                            existingOperation.setDescription(operation.getDescription());
                        }
                        if (operation.getAmount() != null) {
                            existingOperation.setAmount(operation.getAmount());
                        }

                        return existingOperation;
                    })
                    .flatMap(operationRepository::save);

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
     * {@code GET  /operations} : get all the operations.
     *
     * @param pageable the pagination information.
     * @param request a {@link ServerHttpRequest} request.
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of operations in body.
     */
    @GetMapping("/operations")
    public Mono<ResponseEntity<List<Operation>>> getAllOperations(
        @org.springdoc.api.annotations.ParameterObject Pageable pageable,
        ServerHttpRequest request,
        @RequestParam(required = false, defaultValue = "false") boolean eagerload
    ) {
        log.debug("REST request to get a page of Operations");
        return operationRepository
            .count()
            .zipWith(operationRepository.findAllBy(pageable).collectList())
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
     * {@code GET  /operations/:id} : get the "id" operation.
     *
     * @param id the id of the operation to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the operation, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/operations/{id}")
    public Mono<ResponseEntity<Operation>> getOperation(@PathVariable Long id) {
        log.debug("REST request to get Operation : {}", id);
        Mono<Operation> operation = operationRepository.findOneWithEagerRelationships(id);
        return ResponseUtil.wrapOrNotFound(operation);
    }

    /**
     * {@code DELETE  /operations/:id} : delete the "id" operation.
     *
     * @param id the id of the operation to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/operations/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>> deleteOperation(@PathVariable Long id) {
        log.debug("REST request to delete Operation : {}", id);
        return operationRepository
            .deleteById(id)
            .map(result ->
                ResponseEntity
                    .noContent()
                    .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
                    .build()
            );
    }
}
