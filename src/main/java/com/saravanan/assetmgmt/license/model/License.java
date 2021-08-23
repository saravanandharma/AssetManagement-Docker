package com.saravanan.assetmgmt.license.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
//@Table(name = "license")
@Entity @AllArgsConstructor @NoArgsConstructor
public class License extends RepresentationModel<License> implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String licenseId;
    private String description;
    private String orgonizationId;
    private String productName;
    private String licenseType;
}
