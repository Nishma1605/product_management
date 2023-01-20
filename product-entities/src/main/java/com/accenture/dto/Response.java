package com.accenture.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
//generic
public class Response<T> implements Serializable {

    private int page;
    private int size;
    private long totalOfItems;
    private int totalOfPages;
    private List<T> dataResponse;
}

