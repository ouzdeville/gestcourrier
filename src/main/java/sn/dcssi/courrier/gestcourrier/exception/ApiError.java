package sn.dcssi.courrier.gestcourrier.exception;

import java.time.Instant;

public record ApiError(
        int status,
        String message,
        Instant timestamp
) {
}
