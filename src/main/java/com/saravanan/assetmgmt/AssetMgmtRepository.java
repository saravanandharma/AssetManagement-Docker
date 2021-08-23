package com.saravanan.assetmgmt;

import com.saravanan.assetmgmt.license.model.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetMgmtRepository extends CrudRepository<License, Long> {

    List<License> findByProductName(String name);
}
