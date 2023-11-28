package com.neotasker.model;

import jakarta.persistence.Embeddable;

@Embeddable
public enum TaskState {
    UNFINISHED,
    FINISHED,
    LATE,
}

