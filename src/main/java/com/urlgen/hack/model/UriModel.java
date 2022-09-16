package com.urlgen.hack.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class UriModel {
    UUID id = UUID.randomUUID();
    String templateId;
    String targetId;
    String  salesUserId;
    String  generatedUrl;
}
