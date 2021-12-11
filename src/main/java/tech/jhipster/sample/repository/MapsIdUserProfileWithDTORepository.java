package tech.jhipster.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.MapsIdUserProfileWithDTO;

/**
 * Spring Data SQL reactive repository for the MapsIdUserProfileWithDTO entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MapsIdUserProfileWithDTORepository
    extends R2dbcRepository<MapsIdUserProfileWithDTO, Long>, MapsIdUserProfileWithDTORepositoryInternal {
    @Query("SELECT * FROM maps_id_user_profile_withdto entity WHERE entity.user_id = :id")
    Flux<MapsIdUserProfileWithDTO> findByUser(Long id);

    @Query("SELECT * FROM maps_id_user_profile_withdto entity WHERE entity.user_id IS NULL")
    Flux<MapsIdUserProfileWithDTO> findAllWhereUserIsNull();

    // just to avoid having unambigous methods
    @Override
    Flux<MapsIdUserProfileWithDTO> findAll();

    @Override
    Mono<MapsIdUserProfileWithDTO> findById(Long id);

    @Override
    <S extends MapsIdUserProfileWithDTO> Mono<S> save(S entity);
}

interface MapsIdUserProfileWithDTORepositoryInternal {
    <S extends MapsIdUserProfileWithDTO> Mono<S> insert(S entity);
    <S extends MapsIdUserProfileWithDTO> Mono<S> save(S entity);
    Mono<Integer> update(MapsIdUserProfileWithDTO entity);

    Flux<MapsIdUserProfileWithDTO> findAll();
    Mono<MapsIdUserProfileWithDTO> findById(Long id);
    Flux<MapsIdUserProfileWithDTO> findAllBy(Pageable pageable);
    Flux<MapsIdUserProfileWithDTO> findAllBy(Pageable pageable, Criteria criteria);
}
