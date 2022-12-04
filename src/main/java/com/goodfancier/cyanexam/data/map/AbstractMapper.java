package com.goodfancier.cyanexam.data.map;

import org.springframework.stereotype.Component;


public interface AbstractMapper<M, D> extends AbstractDtoMapper<M, D>, AbstractDomainMapper<M, D> {

}
