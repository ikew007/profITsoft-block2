package com.profIITsoft.block2.common.advisor;

import com.profIITsoft.block2.common.response.ApiError;
import com.profIITsoft.block2.common.response.ApiResponse;
import com.profIITsoft.block2.common.util.AdvisorUtils;
import com.profIITsoft.block2.controller.FlightController;
import com.profIITsoft.block2.exception.FlightScheduleException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * Flight advisor class to handle exceptions in the flight controller.
 */
@ControllerAdvice(assignableTypes = FlightController.class)
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class FlightAdvisor {

    /**
     * The AdvisorUtils object that contains utility methods.
     */
    private final AdvisorUtils advisorUtils;

    /**
     * Handle flight schedule exception that occurs when a flight schedule is invalid.
     *
     * @param e the exception object of type {@link FlightScheduleException}
     * @return the response entity with the list of errors
     */
    @ExceptionHandler(FlightScheduleException.class)
    public ResponseEntity<ApiResponse<List<ApiError>>> handleFlightScheduleException(FlightScheduleException e) {
        return advisorUtils.createErrorResponseEntity(e, HttpStatus.BAD_REQUEST);
    }
}
