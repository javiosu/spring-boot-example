package org.skh.repository.portal;

import org.skh.domain.portal.RegistrationDivisionMemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Spring Data  repository for the RegistrationDivisionMemo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RegistrationDivisionMemoRepository extends JpaRepository<RegistrationDivisionMemo, Long> {
    Optional<RegistrationDivisionMemo> findOneByDivisionId(String divisionId);
}
