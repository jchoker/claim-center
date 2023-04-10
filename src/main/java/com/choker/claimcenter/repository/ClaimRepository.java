package com.choker.claimcenter.repository;

import com.choker.claimcenter.model.Claim;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ClaimRepository extends ClaimCenterRepository<Claim, Long> {
//public interface ClaimRepository extends JpaRepository<Claim, Long> {

    /* when searching for a date range best to use >= & <= instead of between since if the column is indexed
     then the index isn't used and a full scan is done instead of the much more efficient range scan.*/
    @Query("SELECT c FROM Claim c INNER JOIN c.patient p INNER JOIN c.hospital h" +
            " WHERE (:admittedFrom is null or c.admissionDate >= :admittedFrom )" +
            " and (:admittedTill is null or c.admissionDate <= :admittedTill )" +
            " and (:cardNumber is null or p.cardNumber LIKE %:cardNumber%)" +
            " and (:hospitalId is null or h.id = :hospitalId)" +
            " ORDER BY c.admissionDate DESC")
    List<Claim> getClaimsByCustomCriteria(LocalDateTime admittedFrom, LocalDateTime admittedTill, Integer hospitalId, String cardNumber);
}
