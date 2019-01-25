package com.stackroute.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Music {
    @Id
    int trackId;
    String trackName;
    String trackComments;

}
